package com.csc.telenor.mobileanalysis.model;

import java.time.LocalDate;

public class Call extends AbstractIdPojo {
  private LocalDate date;
  private String duration;

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

}
