package com.davidlowe.tcmanagerwebapp.services.impl;


import com.davidlowe.tcmanagerwebapp.TcManager;
import com.davidlowe.tcmanagerwebapp.models.Roles;
import com.davidlowe.tcmanagerwebapp.models.User;
import com.davidlowe.tcmanagerwebapp.services.DbService;
import com.davidlowe.tcmanagerwebapp.services.PersonService;
import com.davidlowe.tcmanagerwebapp.services.RoleService;
import com.davidlowe.tcmanagerwebapp.services.UserService;
import com.davidlowe.tcmanagerwebapp.utils.Security;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService
{
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final DbService<User> _dbService;
    private final PersonService personService;
    private final RoleService roleService;

    public UserServiceImpl(DbService<User> dbService, PersonService personService, RoleService roleService)
    {
        _dbService = dbService;
        this.personService = personService;
        this.roleService = roleService;
    }


    @Override
    public List<User> getAll()
    {
        return _dbService.selectList("map.User.list");
    }


    @Override
    public Optional<User> get(Long userId)
    {
        return _dbService.selectOne("map.User.get", userId);
    }


    @Override
    public User getUserForLogin(String userName, String clearTextPassword, String remoteAddress)
    {
        Optional<User> foundUser = _dbService.selectOne("map.User.getForLogon", userName);

        if (foundUser.isPresent())
        {
            // User having the specified username exists, now we check the password.
            try
            {
                final String calculatedHashedPassword = Security.getHashedPassword(clearTextPassword, foundUser.get().getSalt());

                if (StringUtils.equalsIgnoreCase(calculatedHashedPassword, foundUser.get().getPassword()))
                {
                    // Good logon, get full User object, including privileges.
                    foundUser = _dbService.selectOne("map.User.get", foundUser.get().getId());
                    // SQL should not return password or salt, but here we are just extra careful
                    foundUser.get().setPassword("").setSalt("");

                    // Get the user's roles
                    List<Roles> rolesForUser = roleService.getRolesForUser(foundUser.get());
                    foundUser.get().setRoles(rolesForUser);
                }
                else
                {
                    // Password does not match for username. We do NOT allow logon.
                    foundUser = Optional.empty();
                }
            }
            catch (Exception ex)
            {
                // Security library exception. System is dead in the water at this point,
                // users will not be able to logon.
                logger.error("Error in security subsystem.", ex);
            }
        }

        createLoginAttempt(userName, remoteAddress, foundUser != null);

        return foundUser.orElse(null);
    }


    private void createLoginAttempt(String userName, String remoteAddress, boolean goodLogin)
    {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userName", userName);
        params.put("ipAddress", remoteAddress);
        params.put("isSuccessful", goodLogin);

        _dbService.insert("map.User.createLoginAttempt", params);
    }


    @Override
    public void insert(User user)
            throws Exception
    {
        if (user.getId() < 1)
        {
            user.setCreatorUser(TcManager.get().getSystemUser());
            // Users ARE Persons. Person has auto-incrementing PK that Users use.
            personService.insert(user);
            user.addRole(Roles.USER);
            try
            {
                _dbService.insert("map.User.create", user);
            }
            catch (Exception ex)
            {
                // User was NOT created so we need to delete the person that was created for them
                personService.delete(user);
                user.setId(0);
                throw ex;
            }
            try
            {
                roleService.setRolesForUser(user, TcManager.get().getSystemUser());
            }
            catch (Exception ex)
            {
                // Role(s) could not be set for user, so we fail the whole transaction.
                _dbService.delete("map.User.delete", user);
                personService.delete(user);
                user.setId(0);
                throw ex;
            }
        }
        else
        {
            throw new Exception("User already has a primary key and cannot be inserted.");
        }
    }


    @Override
    public void update(User user)
            throws Exception
    {
        if (user.getId() > 0)
        {
            personService.update(user);
            _dbService.update("map.User.update", user);
        }
        else
        {
            throw new Exception("User does not have a primary key and cannot be updated.");
        }
    }


    @Override
    public void delete(User user)
    {
        _dbService.delete("map.User.delete", user);
        user.setId(0);
    }

}
