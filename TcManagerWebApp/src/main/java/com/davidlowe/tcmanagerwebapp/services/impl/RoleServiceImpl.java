package com.davidlowe.tcmanagerwebapp.services.impl;


import com.davidlowe.tcmanagerwebapp.models.Roles;
import com.davidlowe.tcmanagerwebapp.models.User;
import com.davidlowe.tcmanagerwebapp.services.DbService;
import com.davidlowe.tcmanagerwebapp.services.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
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

}
