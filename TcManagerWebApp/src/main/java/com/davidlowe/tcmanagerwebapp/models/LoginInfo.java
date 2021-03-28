package com.davidlowe.tcmanagerwebapp.models;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class LoginInfo implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private boolean error;

    public String getUsername()
    {
        return username;
    }

    public LoginInfo setUsername(String username)
    {
        this.username = username;
        return this;
    }

    public String getPassword()
    {
        return password;
    }

    public LoginInfo setPassword(String password)
    {
        this.password = password;
        return this;
    }

    public boolean getError()
    {
        return error;
    }

    public LoginInfo setError(boolean error)
    {
        this.error = error;
        return this;
    }
}
