package com.davidlowe.tcmanagerwebapp.models;


public class DocumentComplianceStatus
{

  private long id;
  private String name;
  private long sortOrderVal;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getSortOrderVal() {
    return sortOrderVal;
  }

  public void setSortOrderVal(long sortOrderVal) {
    this.sortOrderVal = sortOrderVal;
  }

}
