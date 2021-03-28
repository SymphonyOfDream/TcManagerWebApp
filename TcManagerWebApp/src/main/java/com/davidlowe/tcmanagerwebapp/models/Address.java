package com.davidlowe.tcmanagerwebapp.models;


import java.util.Objects;


public class Address
{

  private long id;
  private String street1;
  private String street2;
  private String city;
  private State state;
  private String zip;
  private User creatorUser;
  private java.sql.Timestamp creationDate;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getStreet1() {
    return street1;
  }

  public void setStreet1(String street1) {
    this.street1 = street1;
  }


  public String getStreet2() {
    return street2;
  }

  public void setStreet2(String street2) {
    this.street2 = street2;
  }


  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }


  public State getState() {
    return state;
  }

  public void setState(State state) {
    this.state = state;
  }


  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }


  public User getCreatorUser() {
    return creatorUser;
  }

  public void setCreatorUser(User creatorUser) {
    this.creatorUser = creatorUser;
  }


  public java.sql.Timestamp getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(java.sql.Timestamp creationDate) {
    this.creationDate = creationDate;
  }


  @Override
  public String toString()
  {
    return "Address{" +
            "addressId=" + id +
            ", street1='" + street1 + '\'' +
            ", street2='" + street2 + '\'' +
            ", city='" + city + '\'' +
            ", state=" + state +
            ", zip='" + zip + '\'' +
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

    Address address = (Address) o;

    if (id != address.id)
    {
      return false;
    }
    if (!Objects.equals(street1, address.street1))
    {
      return false;
    }
    if (!Objects.equals(street2, address.street2))
    {
      return false;
    }
    if (!Objects.equals(city, address.city))
    {
      return false;
    }
    if (!Objects.equals(state, address.state))
    {
      return false;
    }
    if (!Objects.equals(zip, address.zip))
    {
      return false;
    }
    if (!Objects.equals(creatorUser, address.creatorUser))
    {
      return false;
    }
    return Objects.equals(creationDate, address.creationDate);
  }

  @Override
  public int hashCode()
  {
    int result = (int) (id ^ (id >>> 32));
    result = 31 * result + (street1 != null ? street1.hashCode() : 0);
    result = 31 * result + (street2 != null ? street2.hashCode() : 0);
    result = 31 * result + (city != null ? city.hashCode() : 0);
    result = 31 * result + (state != null ? state.hashCode() : 0);
    result = 31 * result + (zip != null ? zip.hashCode() : 0);
    result = 31 * result + (creatorUser != null ? creatorUser.hashCode() : 0);
    result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
    return result;
  }
}
