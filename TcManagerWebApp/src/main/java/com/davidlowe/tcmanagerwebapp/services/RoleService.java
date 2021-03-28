package com.davidlowe.tcmanagerwebapp.services;


import com.davidlowe.tcmanagerwebapp.models.Role;
import com.davidlowe.tcmanagerwebapp.models.User;

import java.util.List;


public interface RoleService extends ReadOnlyService<Role, Long>
{
    List<Role> getRolesForUser(User user);
}
