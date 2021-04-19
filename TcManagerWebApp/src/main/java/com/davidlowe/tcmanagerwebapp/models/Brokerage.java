package com.davidlowe.tcmanagerwebapp.models;


import java.util.List;
import java.util.Objects;


public class Brokerage
{

  private int id;
  private String name;
  private Realtor broker;
  private List<Realtor> realtors;
  private User creatorUser;
  private java.sql.Timestamp creationDate;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public Realtor getBroker() {
    return broker;
  }

  public void setBroker(Realtor broker) {
    this.broker = broker;
  }


  public List<Realtor> getRealtors()
  {
    return realtors;
  }

  public void setRealtors(List<Realtor> realtors)
  {
    this.realtors = realtors;
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
    return "Brokerage{" +
            "brokerageId=" + id +
            ", name='" + name + '\'' +
            ", broker=" + broker +
            ", realtors=" + realtors +
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

    Brokerage brokerage = (Brokerage) o;

    if (id != brokerage.id)
    {
      return false;
    }
    if (!Objects.equals(name, brokerage.name))
    {
      return false;
    }
    if (!Objects.equals(broker, brokerage.broker))
    {
      return false;
    }
    if (!Objects.equals(realtors, brokerage.realtors))
    {
      return false;
    }
    if (!Objects.equals(creatorUser, brokerage.creatorUser))
    {
      return false;
    }
    return Objects.equals(creationDate, brokerage.creationDate);
  }

  @Override
  public int hashCode()
  {
    int result = (int) (id ^ (id >>> 32));
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (broker != null ? broker.hashCode() : 0);
    result = 31 * result + (realtors != null ? realtors.hashCode() : 0);
    result = 31 * result + (creatorUser != null ? creatorUser.hashCode() : 0);
    result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
    return result;
  }
}
