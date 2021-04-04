package com.davidlowe.tcmanagerwebapp.services.impl;


import com.davidlowe.tcmanagerwebapp.models.Roles;
import com.davidlowe.tcmanagerwebapp.models.User;
import com.davidlowe.tcmanagerwebapp.services.DbService;
import com.davidlowe.tcmanagerwebapp.services.RoleService;
import org.apache.commons.collections4.ListUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class RoleServiceImpl implements RoleService
{
    private final DbService<Roles> _dbService;

    public RoleServiceImpl(DbService<Roles> dbService)
    {
        _dbService = dbService;
    }

    @Override
    public List<Roles> getAll()
    {
        return Roles.getAll();
    }

    @Override
    public Optional<Roles> get(Integer id)
    {
        return Optional.ofNullable(Roles.get(id));
    }


    @Override
    public List<Roles> getRolesForUser(User user)
    {
        return _dbService.selectList("map.Role.getRolesForUser", user);
    }


    @Override
    public void setRolesForUser(User user, User creator)
    {
        // Users will ALWAYS have at least USER role.
        if (ListUtils.indexOf(user.getRoles(), role -> role.getId() == Roles.USER.getId()) < 0)
        {
            user.getRoles().add(Roles.USER);
        }

        _dbService.delete("map.Role.deleteAllRolesForUser", user);

        for (Roles role : user.getRoles())
        {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("userId", user.getId());
            params.put("roleId", role.getId());
            _dbService.insert("map.Role.insertRoleForUser", params);
        }

    }
}
