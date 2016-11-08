package com.csc.telenor.mobileanalysis.readers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import javax.ejb.Singleton;
import javax.inject.Inject;

import com.csc.telenor.mobileanalysis.model.Organization;
import com.csc.telenor.mobileanalysis.providers.ObjectMapperContextResolver;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Singleton
public class JsonReader {

  @Inject
  private ObjectMapperContextResolver objectMapperCtx;

  public List<Organization> readOrganizations(String filePath)
      throws JsonParseException, JsonMappingException, IOException {
    InputStream is = JsonReader.class.getResourceAsStream(filePath);
    return Arrays.asList(objectMapperCtx.getContext(null).readValue(is, Organization[].class));
  }

}
