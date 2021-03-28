package com.davidlowe.tcmanagerwebapp;


import com.davidlowe.tcmanagerwebapp.services.DbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TcManager
{
    private static final Logger logger = LoggerFactory.getLogger(TcManager.class);

    // Singleton.
    private static TcManager _TcManager;


    public TcManager()
    {
        TcManager._TcManager = this;

        init();
    }

    public static TcManager get()
    {
        if (TcManager._TcManager == null)
        {
            new TcManager();
        }

        return TcManager._TcManager;
    }

    private void init()
    {
    }

}
