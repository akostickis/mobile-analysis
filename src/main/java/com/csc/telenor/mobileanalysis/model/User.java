package com.csc.telenor.mobileanalysis.model;

import java.util.List;

public class User extends AbstractIdPojo {
  private String name;
  private String telNo;
  private String totalCalls;
  private String periodicCost;
  private String oneOffCost;
  private String callCost;
  private String credit;
  private List<Call> calls;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTelNo() {
    return telNo;
  }

  public void setTelNo(String telNo) {
    this.telNo = telNo;
  }

  public String getTotalCalls() {
    return totalCalls;
  }

  public void setTotalCalls(String totalCalls) {
    this.totalCalls = totalCalls;
  }

  public String getPeriodicCost() {
    return periodicCost;
  }

  public void setPeriodicCost(String periodicCost) {
    this.periodicCost = periodicCost;
  }

  public String getOneOffCost() {
    return oneOffCost;
  }

  public void setOneOffCost(String oneOffCost) {
    this.oneOffCost = oneOffCost;
  }

  public String getCallCost() {
    return callCost;
  }

  public void setCallCost(String callCost) {
    this.callCost = callCost;
  }

  public String getCredit() {
    return credit;
  }

  public void setCredit(String credit) {
    this.credit = credit;
  }

  public List<Call> getCalls() {
    return calls;
  }

  public void setCalls(List<Call> calls) {
    this.calls = calls;
  }

}
