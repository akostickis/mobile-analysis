package com.csc.telenor.mobileanalysis.model;

import java.util.List;

public class UserGroup extends AbstractIdPojo {
  private String name;
  private NonNrRelatedCosts nonNrRelatedCosts;
  private List<User> users;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public NonNrRelatedCosts getNonNrRelatedCosts() {
    return nonNrRelatedCosts;
  }

  public void setNonNrRelatedCosts(NonNrRelatedCosts nonNrRelatedCosts) {
    this.nonNrRelatedCosts = nonNrRelatedCosts;
  }

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }

}
