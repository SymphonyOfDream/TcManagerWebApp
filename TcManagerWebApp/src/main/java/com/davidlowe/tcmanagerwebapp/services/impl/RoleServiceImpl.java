package com.davidlowe.tcmanagerwebapp.services.impl;


import com.davidlowe.tcmanagerwebapp.models.Role;
import com.davidlowe.tcmanagerwebapp.models.User;
import com.davidlowe.tcmanagerwebapp.services.DbService;
import com.davidlowe.tcmanagerwebapp.services.RoleService;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class RoleServiceImpl implements RoleService
{
    private List<Role> roles = new ArrayList<>();

    private final DbService<Role> _dbService;

    public RoleServiceImpl(DbService<Role> dbService)
    {
        _dbService = dbService;
        init();
    }

    private void init()
    {
        roles = _dbService.selectList("map.Role.list");
    }

    @Override
    public List<Role> getAll()
    {
        return roles;
    }

    @Override
    public Optional<Role> get(Long roleId)
    {
        return roles.stream().filter(r -> r.getId() == roleId).findFirst();
    }



    @Override
    public List<Role> getRolesForUser(User user)
    {
        if (user != null)
        {
            return _dbService.selectList("map.Role.getRolesForUser", user.getId());
        }

        return null;
    }

}
