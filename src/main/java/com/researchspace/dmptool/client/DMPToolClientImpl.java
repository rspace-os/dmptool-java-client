package com.researchspace.dmptool.client;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import com.researchspace.dmptool.model.DMPList;
import com.researchspace.dmptool.model.DMP;
import com.researchspace.dmptool.model.DMPPlanScope;
import com.researchspace.dmptool.model.DMPIdPost;
import com.researchspace.dmptool.model.RelatedIdentifier;

public class DMPToolClientImpl implements DMPToolClient {

  public DMPList listPlans(
    DMPPlanScope scope,
    String accessToken
   ) throws MalformedURLException, URISyntaxException {
    return null;
  }

  public DMP getPlanById(
    String dmpId,
    String accessToken
   ) throws MalformedURLException, URISyntaxException {
    return null;
  }

  public byte[] getPdfBytes(
    Integer id,
    String accessToken
   ) throws URISyntaxException, MalformedURLException {
    return null;
  }

  public Boolean postRelatedIdentifiers(
    DMPIdPost dmpId,
    RelatedIdentifier relatedIdentifier,
    String accessToken
   ) throws URISyntaxException, MalformedURLException {
    return null;
  }

}
