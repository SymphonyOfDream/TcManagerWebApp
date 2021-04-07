package com.davidlowe.tcmanagerwebapp.models.formhelpers;


import com.davidlowe.tcmanagerwebapp.models.State;
import com.davidlowe.tcmanagerwebapp.models.User;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class UserProfileInfo extends FormHelper implements Serializable
{
    private String userName;
    transient private String currentPassword;
    transient private String newPassword1;
    transient private String newPassword2;
    private String firstName;
    private String lastName;
    private String middleInitial;
    private String email;
    transient private String phone;
    transient private Boolean phoneIsCell;
    private String street1;
    private String street2;
    private String city;
    private State state;
    private String zip;

    private List<String> errors = new ArrayList<>();

    public UserProfileInfo(User user)
    {
        userName = user.getUserName();
        currentPassword = user.getPassword();
        newPassword1 = "";
        newPassword2 = "";
        firstName = user.getFirstName();
        lastName = user.getLastName();
        middleInitial = user.getMiddleInitial();
        email = user.getEmail();
        phone = user.getPhone();
        phoneIsCell = user.isPhoneCell();
        street1 = user.getAddress().getStreet1();
        street2 = user.getAddress().getStreet2();
        city = user.getAddress().getCity();
        state = user.getAddress().getState();
        zip = user.getAddress().getZip();
    }
    
    
    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getCurrentPassword()
    {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword)
    {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword1()
    {
        return newPassword1;
    }

    public void setNewPassword1(String newPassword1)
    {
        this.newPassword1 = newPassword1;
    }

    public String getNewPassword2()
    {
        return newPassword2;
    }

    public void setNewPassword2(String newPassword2)
    {
        this.newPassword2 = newPassword2;
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

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public boolean isPhoneIsCell()
    {
        return phoneIsCell;
    }

    public void setPhoneIsCell(boolean phoneIsCell)
    {
        this.phoneIsCell = phoneIsCell;
    }


    public boolean hasAddress()
    {
        return !StringUtils.isBlank(street1)
                || !StringUtils.isBlank(street2)
                || !StringUtils.isBlank(city)
                || state != null
                || !StringUtils.isBlank(zip);
    }


    public String getStreet1()
    {
        return street1;
    }

    public void setStreet1(String street1)
    {
        this.street1 = street1;
    }

    public String getStreet2()
    {
        return street2;
    }

    public void setStreet2(String street2)
    {
        this.street2 = street2;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public State getState()
    {
        return state;
    }

    public void setState(State state)
    {
        this.state = state;
    }

    public String getZip()
    {
        return zip;
    }

    public void setZip(String zip)
    {
        this.zip = zip;
    }
}
