package com.csc.telenor.mobileanalysis.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public final class DateUtil {

  private DateUtil() {}

  public static LocalDate convertToLocalDateFromMillis(long dateMillis) {
    return Instant.ofEpochMilli(dateMillis).atZone(ZoneId.systemDefault()).toLocalDate();
  }

}
