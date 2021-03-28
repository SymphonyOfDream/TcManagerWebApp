package com.davidlowe.tcmanagerwebapp.models;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;


public class Person implements Serializable
{
  private static final long serialVersionUID = 1L;

  private int id;
  private String firstName;
  private String lastName;
  private String middleInitial;
  private String email;
  transient private String phone;
  transient private String isPhoneCell;
  transient private Address address;
  transient private User creatorUser;
  transient private LocalDateTime creationDate;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


  public String getMiddleInitial() {
    return middleInitial;
  }

  public void setMiddleInitial(String middleInitial) {
    this.middleInitial = middleInitial;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String isPhoneCell() {
    return isPhoneCell;
  }

  public void isPhoneCell(String phoneIsCell) {
    this.isPhoneCell = phoneIsCell;
  }


  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }


  public User getCreatorUser() {
    return creatorUser;
  }

  public void setCreatorUser(User creatorUser) {
    this.creatorUser = creatorUser;
  }


  public LocalDateTime getUserCreationDate() {
    return creationDate;
  }

  public void setUserCreationDate(LocalDateTime userCreationDate) {
    this.creationDate = userCreationDate;
  }


  @Override
  public String toString()
  {
    return "Person{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", middleInitial='" + middleInitial + '\'' +
            ", emailTx='" + email + '\'' +
            ", phoneTx='" + phone + '\'' +
            ", isPhoneCell='" + isPhoneCell + '\'' +
            ", address=" + address +
            ", creatorUser=" + creatorUser +
            ", creationDate=" + creationDate +
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

    Person person = (Person) o;

    if (id != person.id)
    {
      return false;
    }
    if (!Objects.equals(firstName, person.firstName))
    {
      return false;
    }
    if (!Objects.equals(lastName, person.lastName))
    {
      return false;
    }
    if (!Objects.equals(middleInitial, person.middleInitial))
    {
      return false;
    }
    if (!Objects.equals(email, person.email))
    {
      return false;
    }
    if (!Objects.equals(phone, person.phone))
    {
      return false;
    }
    if (!Objects.equals(isPhoneCell, person.isPhoneCell))
    {
      return false;
    }
    if (!Objects.equals(address, person.address))
    {
      return false;
    }
    if (!Objects.equals(creatorUser, person.creatorUser))
    {
      return false;
    }
    return Objects.equals(creationDate, person.creationDate);
  }

  @Override
  public int hashCode()
  {
    int result = (int) (id ^ (id >>> 32));
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 31 * result + (middleInitial != null ? middleInitial.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + (phone != null ? phone.hashCode() : 0);
    result = 31 * result + (isPhoneCell != null ? isPhoneCell.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + (creatorUser != null ? creatorUser.hashCode() : 0);
    result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
    return result;
  }
}
