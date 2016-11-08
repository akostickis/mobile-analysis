package com.csc.telenor.mobileanalysis.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.csc.telenor.mobileanalysis.providers.DataProvider;

@Path("/mobileAnalysis")
@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
public class MobileAnalysisEndpoint {

  @Inject
  private DataProvider provider;

  @GET
  @Path("/org/{id}")
  public Response getOrganization(@PathParam("id") Long id) {
    return Response.ok(provider.getOrganization(id)).build();
  }

  @GET
  @Path("/org/{id}/group")
  public Response getOrganizationUserGroups(@PathParam("id") Long id) {
    return Response.ok(provider.getOrganizationUserGroups(id)).build();
  }

  @GET
  @Path("/userGroup/{id}")
  public Response getUserGroup(@PathParam("id") Long id) {
    return Response.ok(provider.getUserGroup(id)).build();
  }

  @GET
  @Path("/userGroup/{id}/user")
  public Response getGroupUsers(@PathParam("id") Long id) {
    return Response.ok(provider.getGroupUsers(id)).build();
  }

  @GET
  @Path("/user/{id}/call")
  public Response getUserCalls(@PathParam("id") Long id, @QueryParam("from") Long from,
      @QueryParam("to") Long to) {
    return Response.ok(provider.getUserCalls(id, from, to)).build();
  }

  @GET
  @Path("/call/{id}")
  public Response getCall(@PathParam("id") Long id) {
    return Response.ok(provider.getCall(id)).build();
  }

}
