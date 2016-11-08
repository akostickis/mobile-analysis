package com.csc.telenor.mobileanalysis.providers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import com.csc.telenor.mobileanalysis.model.Call;
import com.csc.telenor.mobileanalysis.model.Organization;
import com.csc.telenor.mobileanalysis.model.User;
import com.csc.telenor.mobileanalysis.model.UserGroup;
import com.csc.telenor.mobileanalysis.readers.JsonReader;
import com.csc.telenor.mobileanalysis.utils.CallUtil;
import com.csc.telenor.mobileanalysis.utils.DateUtil;

@Startup
@Singleton
public class DataProviderImpl implements DataProvider {
  private static final String ORGANIZATION_DATA_PATH = "/data.json";

  @Inject
  private JsonReader jsonReader;

  private List<Organization> organizations;

  @PostConstruct
  public void init() {
    try {
      organizations = jsonReader.readOrganizations(ORGANIZATION_DATA_PATH);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Organization getOrganization(Long id) {
    Optional<Organization> opt = organizations.stream().filter(o -> id.equals(o.getId())).findAny();
    return opt.isPresent() ? opt.get() : null;
  }

  @Override
  public List<UserGroup> getOrganizationUserGroups(Long orgId) {
    Organization org = getOrganization(orgId);
    return org != null ? org.getUserGroups() : null;
  }

  @Override
  public UserGroup getUserGroup(Long id) {
    Optional<UserGroup> opt = getUserGroupStream().filter(ug -> id.equals(ug.getId())).findAny();
    return opt.isPresent() ? opt.get() : null;
  }

  private Stream<UserGroup> getUserGroupStream() {
    return organizations.stream().flatMap(o -> o.getUserGroups().stream());
  }

  @Override
  public List<User> getGroupUsers(Long groupId) {
    UserGroup group = getUserGroup(groupId);
    return group != null ? group.getUsers() : null;
  }

  @Override
  public List<Call> getUserCalls(Long userId, Long from, Long to) {
    List<Call> calls = getUserCalls(userId);
    return calls != null ? filterAndOrderAsc(calls, from, to) : null;
  }

  public List<Call> getUserCalls(Long userId) {
    Optional<User> opt = getUserStream().filter(u -> userId.equals(u.getId())).findAny();
    return opt.isPresent() ? opt.get().getCalls() : null;
  }

  private Stream<User> getUserStream() {
    return getUserGroupStream().flatMap(ug -> ug.getUsers().stream());
  }

  private List<Call> filterAndOrderAsc(List<Call> calls, Long from, Long to) {
    List<Call> filteredCalls = filter(calls, from, to);
    CallUtil.sortByDateAsc(filteredCalls);
    return filteredCalls;
  }

  private List<Call> filter(List<Call> calls, Long from, Long to) {
    LocalDate fromDate = null, toDate = null;
    if (from != null)
      fromDate = DateUtil.convertToLocalDateFromMillis(from);
    if (to != null)
      toDate = DateUtil.convertToLocalDateFromMillis(to);
    List<Call> filteredCalls = CallUtil.getFilteredCalls(calls, fromDate, toDate);
    return filteredCalls;
  }

  @Override
  public Call getCall(Long id) {
    Optional<Call> opt = getCallStream().filter(c -> id.equals(c.getId())).findAny();
    return opt.isPresent() ? opt.get() : null;
  }

  private Stream<Call> getCallStream() {
    return getUserStream().flatMap(u -> u.getCalls().stream());
  }

}
