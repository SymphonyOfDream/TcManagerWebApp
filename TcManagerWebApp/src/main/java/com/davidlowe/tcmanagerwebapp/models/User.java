package com.davidlowe.tcmanagerwebapp.models;


import com.davidlowe.tcmanagerwebapp.models.formhelpers.UserProfileInfo;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class User extends Person implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String userName;
    transient private String password;
    transient private String salt;
    private Boolean isAccountLocked;
    private List<Roles> roles = new ArrayList<>();
    transient private LocalDateTime userCreationDate;

    
    public void updateFrom(UserProfileInfo userProfileInfo)
    {
        if (!StringUtils.isBlank(userProfileInfo.getNewPassword1()))
        {
            password = userProfileInfo.getNewPassword1();
        }

        if (!StringUtils.equals(getFirstName(), userProfileInfo.getFirstName()))
        {
            setFirstName(userProfileInfo.getFirstName());
        }
        if (!StringUtils.equals(getLastName(), userProfileInfo.getLastName()))
        {
            setLastName(userProfileInfo.getLastName());
        }
        if (!StringUtils.equals(getMiddleInitial(), userProfileInfo.getMiddleInitial()))
        {
            setMiddleInitial(userProfileInfo.getMiddleInitial());
        }
        if (!StringUtils.equals(getEmail(), userProfileInfo.getEmail()))
        {
            setEmail(userProfileInfo.getEmail());
        }
        if (!StringUtils.equals(getPhone(), userProfileInfo.getPhone()))
        {
            setPhone(userProfileInfo.getPhone());
        }
        if (isPhoneCell() != userProfileInfo.isPhoneIsCell())
        {
            isPhoneCell(userProfileInfo.isPhoneIsCell());
        }

        if (userProfileInfo.hasAddress())
        {
            if (getAddress() == null)
            {
                setAddress(new Address());
            }
            Address address = getAddress();
            address.setStreet1(userProfileInfo.getStreet1());
            address.setStreet2(userProfileInfo.getStreet2());
            address.setCity(userProfileInfo.getCity());
            address.setState(userProfileInfo.getState());
            address.setZip(userProfileInfo.getZip());
        }
        else
        {
            setAddress(null);
        }
    }


    public String getUserName()
    {
        return userName;
    }

    public User setUserName(String userName)
    {
        this.userName = userName;
        return this;
    }


    public String getPassword()
    {
        return password;
    }

    public User setPassword(String password)
    {
        this.password = password;
        return this;
    }


    public String getSalt()
    {
        return salt;
    }

    public User setSalt(String salt)
    {
        this.salt = salt;
        return this;
    }


    public Boolean isAccountLocked()
    {
        return isAccountLocked;
    }

    public User setIsAccountLocked(Boolean isAccountLocked)
    {
        this.isAccountLocked = isAccountLocked;
        return this;
    }


    public List<Roles> getRoles()
    {
        return roles;
    }

    public User setRoles(List<Roles> roles)
    {
        this.roles = roles;
        return this;
    }

    public User addRole(Roles role)
    {
        roles.add(role);
        return this;
    }

    public LocalDateTime getUserCreationDate()
    {
        return userCreationDate;
    }

    public User setUserCreationDate(LocalDateTime userCreationDate)
    {
        this.userCreationDate = userCreationDate;
        return this;
    }


    @Override
    public String toString()
    {
        return "User{" +
                "userName='" + userName + '\'' +
                ", hashedPassword='" + password + '\'' +
                ", hashedPasswordSalt='" + salt + '\'' +
                ", isAccountLocked=" + isAccountLocked +
                ", roles=" + roles +
                ", creationDate=" + userCreationDate +
                '}';
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        if (!super.equals(o))
        {
            return false;
        }

        User user = (User) o;

        if (!Objects.equals(userName, user.userName))
        {
            return false;
        }
        if (!Objects.equals(password, user.password))
        {
            return false;
        }
        if (!Objects.equals(salt, user.salt))
        {
            return false;
        }
        if (!Objects.equals(isAccountLocked, user.isAccountLocked))
        {
            return false;
        }
        if (!Objects.equals(roles, user.roles))
        {
            return false;
        }
        return Objects.equals(userCreationDate, user.userCreationDate);
    }

    @Override
    public int hashCode()
    {
        int result = super.hashCode();
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (salt != null ? salt.hashCode() : 0);
        result = 31 * result + (isAccountLocked != null ? isAccountLocked.hashCode() : 0);
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        result = 31 * result + (userCreationDate != null ? userCreationDate.hashCode() : 0);
        return result;
    }
}
