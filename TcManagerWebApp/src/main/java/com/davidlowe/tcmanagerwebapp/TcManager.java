package com.davidlowe.tcmanagerwebapp;


import com.davidlowe.tcmanagerwebapp.models.Roles;
import com.davidlowe.tcmanagerwebapp.models.User;
import com.davidlowe.tcmanagerwebapp.services.DbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TcManager
{
    private static final Logger logger = LoggerFactory.getLogger(TcManager.class);

    // Singleton.
    private static TcManager _TcManager;

    private static User systemUser;


    private TcManager()
    {
        TcManager._TcManager = this;

        init();
    }

    public static TcManager get()
    {
        if (TcManager._TcManager == null)
        {
            systemUser = new User()
                .setUserName("TC Manager System")
                .addRole(Roles.ADMIN);
            systemUser.setEmail("tcmanager@tcmanager.com");

            TcManager._TcManager = new TcManager();
        }

        return TcManager._TcManager;
    }

    private void init()
    {
    }


    public static User getSystemUser()
    {
        return TcManager.systemUser;
    }

}
