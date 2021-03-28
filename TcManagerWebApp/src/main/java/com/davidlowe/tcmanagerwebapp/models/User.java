package com.davidlowe.tcmanagerwebapp.models;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;


public class User extends Person implements Serializable
{
  private static final long serialVersionUID = 1L;

  private String userName;
  transient private String password;
  transient private String salt;
  private Boolean isAccountLocked;
  private List<Role> roles;
  transient private LocalDateTime userCreationDate;


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getPassword() {
    return password;
  }

  public User setPassword(String password) {
    this.password = password;
    return this;
  }


  public String getSalt() {
    return salt;
  }

  public User setSalt(String salt) {
    this.salt = salt;
    return this;
  }


  public Boolean isAccountLocked() {
    return isAccountLocked;
  }

  public void isAccountLocked(Boolean isAccountLocked) {
    this.isAccountLocked = isAccountLocked;
  }


  public List<Role> getRoles()
  {
    return roles;
  }

  public void setRoles(List<Role> roles)
  {
    this.roles = roles;
  }


  public LocalDateTime getUserCreationDate() {
    return userCreationDate;
  }

  public void setUserCreationDate(LocalDateTime userCreationDate) {
    this.userCreationDate = userCreationDate;
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
