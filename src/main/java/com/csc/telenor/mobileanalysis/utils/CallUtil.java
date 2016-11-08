package com.csc.telenor.mobileanalysis.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.csc.telenor.mobileanalysis.model.Call;

public final class CallUtil {

  private CallUtil() {}

  public static List<Call> getFilteredCalls(List<Call> calls, LocalDate from, LocalDate to) {
    List<Call> filteredCalls = new ArrayList<>(calls);
    if (from != null)
      filteredCalls = filteredCalls.stream().filter(c -> isAfterOrEquals(c.getDate(), from))
          .collect(Collectors.toList());
    if (to != null)
      filteredCalls = filteredCalls.stream().filter(c -> isBeforeOrEquals(c.getDate(), to))
          .collect(Collectors.toList());
    return filteredCalls;
  }

  private static boolean isAfterOrEquals(LocalDate after, LocalDate before) {
    return before.isBefore(after) || before.isEqual(after);
  }

  private static boolean isBeforeOrEquals(LocalDate before, LocalDate after) {
    return after.isAfter(before) || after.isEqual(before);
  }

  public static void sortByDateAsc(List<Call> calls) {
    calls.sort(Comparator.comparing(Call::getDate));
  }

}
