package com.davidlowe.tcmanagerwebapp.models.formhelpers;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class RegistrationInfo implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String desiredUsername;
    private String email;
    private String firstName;
    private String lastName;
    private String middleInitial;
    private String phone;
    private boolean phoneIsCell;
    private String password1;
    private String password2;

    private String facebook;
    private String twitter;
    private String instagram;
    private String linkedIn;
    private String snapChat;
    private String youTube;
    private String wordPress;
    private String tumblr;
    private String medium;
    private String goodReads;

    private List<String> errors = new ArrayList<>();


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

    public boolean isPhoneIsCell()
    {
        return phoneIsCell;
    }

    public void setPhoneIsCell(boolean global)
    {
        this.phoneIsCell = global;
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


    public String getFacebook()
    {
        return facebook;
    }

    public void setFacebook(String facebook)
    {
        this.facebook = facebook;
    }

    public String getTwitter()
    {
        return twitter;
    }

    public void setTwitter(String twitter)
    {
        this.twitter = twitter;
    }

    public String getInstagram()
    {
        return instagram;
    }

    public void setInstagram(String instagram)
    {
        this.instagram = instagram;
    }

    public String getLinkedIn()
    {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn)
    {
        this.linkedIn = linkedIn;
    }

    public String getSnapChat()
    {
        return snapChat;
    }

    public void setSnapChat(String snapChat)
    {
        this.snapChat = snapChat;
    }

    public String getYouTube()
    {
        return youTube;
    }

    public void setYouTube(String youTube)
    {
        this.youTube = youTube;
    }

    public String getWordPress()
    {
        return wordPress;
    }

    public void setWordPress(String wordPress)
    {
        this.wordPress = wordPress;
    }

    public String getTumblr()
    {
        return tumblr;
    }

    public void setTumblr(String tumblr)
    {
        this.tumblr = tumblr;
    }

    public String getMedium()
    {
        return medium;
    }

    public void setMedium(String medium)
    {
        this.medium = medium;
    }

    public String getGoodReads()
    {
        return goodReads;
    }

    public void setGoodReads(String goodReads)
    {
        this.goodReads = goodReads;
    }

    public List<String> errors()
    {
        return errors;
    }


    public List<String> getErrors()
    {
        return errors;
    }

    public void setErrors(List<String> errors)
    {
        this.errors = errors;
    }

    public RegistrationInfo addError(String error)
    {
        errors.add(error);
        return this;
    }

}
