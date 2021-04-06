package com.davidlowe.tcmanagerwebapp.models.formhelpers;


import java.io.Serializable;


public class LoginInfo extends FormHelper implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;

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

}
