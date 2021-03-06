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

    private User systemUser;


    private TcManager()
    {
        TcManager._TcManager = this;

        init();
    }

    public static TcManager get()
    {
        if (TcManager._TcManager == null)
        {
            TcManager._TcManager = new TcManager();
        }

        return TcManager._TcManager;
    }

    private void init()
    {
        systemUser = new User()
                .setUserName("TC Manager System")
                .addRole(Roles.ADMIN);
        systemUser.setId(1).setEmail("tcmanager@tcmanager.com");
    }


    public User getSystemUser()
    {
        return systemUser;
    }

}
