package com.csc.telenor.mobileanalysis.providers;

import java.util.List;

import com.csc.telenor.mobileanalysis.model.Call;
import com.csc.telenor.mobileanalysis.model.Organization;
import com.csc.telenor.mobileanalysis.model.User;
import com.csc.telenor.mobileanalysis.model.UserGroup;

public interface DataProvider {

  Organization getOrganization(Long id);

  List<UserGroup> getOrganizationUserGroups(Long orgId);

  UserGroup getUserGroup(Long id);

  List<User> getGroupUsers(Long groupId);

  Object getUserCalls(Long id, Long from, Long to);

  Call getCall(Long id);

}
