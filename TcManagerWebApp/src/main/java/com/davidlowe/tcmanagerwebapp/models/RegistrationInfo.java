package com.davidlowe.tcmanagerwebapp.models;


import java.io.Serializable;


public class RegistrationInfo implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String desiredUsername;
    private String email;
    private String firstName;
    private String lastName;
    private String middleInitial;
    private String phone;
    private boolean isPhoneCell;
    private String password1;
    private String password2;
    private boolean error;


    public static long getSerialVersionUID()
    {
        return serialVersionUID;
    }

    public String getDesiredUsername()
    {
        return desiredUsername;
    }

    public void setDesiredUsername(String desiredUsername)
    {
        this.desiredUsername = desiredUsername;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getMiddleInitial()
    {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial)
    {
        this.middleInitial = middleInitial;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public boolean isPhoneCell()
    {
        return isPhoneCell;
    }

    public void isPhoneCell(boolean phoneCell)
    {
        isPhoneCell = phoneCell;
    }

    public String getPassword1()
    {
        return password1;
    }

    public void setPassword1(String password1)
    {
        this.password1 = password1;
    }

    public String getPassword2()
    {
        return password2;
    }

    public void setPassword2(String password2)
    {
        this.password2 = password2;
    }

    public boolean isError()
    {
        return error;
    }

    public RegistrationInfo setError(boolean error)
    {
        this.error = error;
        return this;
    }
}
