package com.davidlowe.tcmanagerwebapp.services;


import com.davidlowe.tcmanagerwebapp.models.Roles;
import com.davidlowe.tcmanagerwebapp.models.State;
import com.davidlowe.tcmanagerwebapp.models.User;

import java.util.List;


public interface RoleService extends ReadOnlyService<Roles, Integer>
{
    List<Roles> getRolesForUser(User user);
}
