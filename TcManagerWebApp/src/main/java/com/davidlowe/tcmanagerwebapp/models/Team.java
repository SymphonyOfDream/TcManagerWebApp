package com.davidlowe.tcmanagerwebapp.models;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;


public class Team
{

  private int id;
  private String name;
  private List<Realtor> realtors;
  private User creatorUser;
  private LocalDateTime creationDt;


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


  public LocalDateTime getCreationDt() {
    return creationDt;
  }

  public void setCreationDt(LocalDateTime creationDt) {
    this.creationDt = creationDt;
  }


  @Override
  public String toString()
  {
    return "Team{" +
            "teamId=" + id +
            ", name='" + name + '\'' +
            ", realtors=" + realtors +
            ", creatorUser=" + creatorUser +
            ", creationDt=" + creationDt +
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

    Team team = (Team) o;

    if (id != team.id)
    {
      return false;
    }
    if (!Objects.equals(name, team.name))
    {
      return false;
    }
    if (!Objects.equals(realtors, team.realtors))
    {
      return false;
    }
    if (!Objects.equals(creatorUser, team.creatorUser))
    {
      return false;
    }
    return Objects.equals(creationDt, team.creationDt);
  }

  @Override
  public int hashCode()
  {
    int result = (int) (id ^ (id >>> 32));
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (realtors != null ? realtors.hashCode() : 0);
    result = 31 * result + (creatorUser != null ? creatorUser.hashCode() : 0);
    result = 31 * result + (creationDt != null ? creationDt.hashCode() : 0);
    return result;
  }
}
