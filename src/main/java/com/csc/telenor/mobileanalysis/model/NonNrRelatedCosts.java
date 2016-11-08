package com.csc.telenor.mobileanalysis.model;

public class NonNrRelatedCosts extends AbstractIdPojo {
  private String periodicCost;
  private String oneOfCost;
  private String callCost;
  private String credit;

  public String getPeriodicCost() {
    return periodicCost;
  }

  public void setPeriodicCost(String periodicCost) {
    this.periodicCost = periodicCost;
  }

  public String getOneOfCost() {
    return oneOfCost;
  }

  public void setOneOfCost(String oneOfCost) {
    this.oneOfCost = oneOfCost;
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

}
