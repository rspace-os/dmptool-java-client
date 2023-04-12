package com.researchspace.dmptool.client;

import com.researchspace.model.User;
import com.researchspace.model.dmps.DMPUser;
import com.researchspace.model.views.ServiceOperationResult;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

/**
 * API Client wrapper for making calls to DMP API.
 *
 *
 * Each method has two variants; one that takes a User object and the other
 * which takes an accessToken. If the user is not authenticated then the former
 * will error. In most cases the User object variant will call the accessToken
 * variant but this should not be relied on to always be true. The accessToken
 * variants are primarily public as they are easy to write automated test
 * against.
 *
 * All of the methods return their respective values wrapped in a
 * ServiceOperationResult so that errors are reported in a consistent manner.
 * One likely error is the aforementioned case of the user not being
 * authenticated.
 */
public interface DMPToolClient {

  /**
   * Retrieves 1 page of DMPs of given scope.
   */
  ServiceOperationResult<ApiDMPlanList> listPlans(
    DMPPlanScope scope,
    String accessToken
   ) throws MalformedURLException, URISyntaxException;
  ServiceOperationResult<ApiDMPlanList> listPlans(
    DMPPlanScope scope,
    User user
   ) throws MalformedURLException, URISyntaxException;

  /**
   * Gets details of an individual DMP by its ID.
   */
  ServiceOperationResult<ApiDMPlanList.ApiDMPlan> getPlanById(
    String dmpId,
    User user
   ) throws MalformedURLException, URISyntaxException;
  ServiceOperationResult<ApiDMPlanList.ApiDMPlan> getPlanById(
    String dmpId,
    String accessToken
   ) throws MalformedURLException, URISyntaxException;

  /**
   * Downloads a PDF of the DMP.
   */
  ServiceOperationResult<byte[]> getPdfBytes(
    Integer id,
    String accessToken
   ) throws URISyntaxException, MalformedURLException;
  ServiceOperationResult<byte[]> getPdfBytes(
    Integer id,
    User user
   ) throws URISyntaxException, MalformedURLException;

  /**
   * Posts an additional related identifier, such as a DOI, to the DMP.
   */
  ServiceOperationResult<Boolean> postRelatedIdentifiers(
    DMPIdPost dmpId,
    RelatedIdentifier relatedIdentifier,
    String accessToken
   ) throws URISyntaxException, MalformedURLException;
  ServiceOperationResult<Boolean> postRelatedIdentifiers(
    DMPIdPost dmpId,
    RelatedIdentifier relatedIdentifier,
    User user
   ) throws URISyntaxException, MalformedURLException;

}
