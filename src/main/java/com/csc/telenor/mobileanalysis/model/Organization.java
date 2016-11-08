package com.csc.telenor.mobileanalysis.model;

import java.util.List;

public class Organization extends AbstractIdPojo {
  private String name;
  private List<UserGroup> userGroups;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<UserGroup> getUserGroups() {
    return userGroups;
  }

  public void setUserGroups(List<UserGroup> userGroups) {
    this.userGroups = userGroups;
  }

}
