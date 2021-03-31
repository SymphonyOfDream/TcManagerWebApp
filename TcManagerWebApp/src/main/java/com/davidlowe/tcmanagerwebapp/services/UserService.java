package com.davidlowe.tcmanagerwebapp.services;


import com.davidlowe.tcmanagerwebapp.models.User;


public interface UserService extends CrudService<User, Long>
{
    /**
     * Authenticates the user using their typed-in user name and clear text password.
     * @param userName           User name typed in by the user.
     * @param clearTextPassword  Password as typed in by the user.
     * @param remoteAddress      IP address or host name user is calling us from.
     * @return User object if authenticated, otherwise null. Returned User object
     *         will have its password and salt fields cleared out.
     */
    User getUserForLogin(String userName, String clearTextPassword, String remoteAddress);

}
