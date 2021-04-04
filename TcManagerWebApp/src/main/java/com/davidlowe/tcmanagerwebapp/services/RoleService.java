package com.davidlowe.tcmanagerwebapp.services;


import com.davidlowe.tcmanagerwebapp.models.Roles;
import com.davidlowe.tcmanagerwebapp.models.User;

import java.util.List;


public interface RoleService extends ReadOnlyService<Roles, Integer>
{
    List<Roles> getRolesForUser(User user);

    /**
     * Will update the users-roles associative DB table with all of the roles
     * in the 'user' object. The code will guarantee that at least the USER role
     * is used.
     * @param user User whose role(s) is being updated.
     * @param creator User to updated the 'user' roles.
     */
    void setRolesForUser(User user, User creator);
}
