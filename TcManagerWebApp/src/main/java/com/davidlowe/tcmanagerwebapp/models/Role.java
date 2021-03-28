package com.davidlowe.tcmanagerwebapp.models;


import java.io.Serializable;
import java.util.Objects;


public class Role implements Serializable
{
  private static final long serialVersionUID = 1L;


  private int id;
  private String name;
  transient private String description;


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


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public String toString()
  {
    return "Role{" +
            "id=" + id +
            ", name='" + name + '\'' +
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

    Role role = (Role) o;

    if (id != role.id)
    {
      return false;
    }
    if (!Objects.equals(name, role.name))
    {
      return false;
    }
    return Objects.equals(description, role.description);
  }

  @Override
  public int hashCode()
  {
    int result = (int) (id ^ (id >>> 32));
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (description != null ? description.hashCode() : 0);
    return result;
  }
}
