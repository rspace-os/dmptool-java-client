package com.researchspace.dmptool.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.researchspace.dmptool.model.DMPList;
import com.researchspace.dmptool.model.DMPPlanScope;
import com.researchspace.dmptool.model.DMPToolDMP;
import com.researchspace.dmptool.model.RelatedIdentifier;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import org.springframework.web.client.RestClientException;

/**
 * API Client wrapper for making calls to DMP API.
 */
public interface DMPToolClient {

	/**
	 * Retrieves 1 page of DMPs of given scope.
	 */
	DMPList listPlans(
		DMPPlanScope scope,
		String accessToken
	 ) throws MalformedURLException, URISyntaxException;

	/**
	 * Gets details of an individual DMP by its ID.
	 */
	DMPToolDMP getPlanById(
		String dmpId,
		String accessToken
	 ) throws MalformedURLException, URISyntaxException;

	/**
	 * Downloads a PDF of the DMP.
	 */
	String getJson(
		DMPToolDMP dmp,
		String accessToken
	 ) throws URISyntaxException, MalformedURLException;

	/**
	 * Posts an additional related identifier, such as a DOI, to the DMP.
	 */
	void postRelatedIdentifiers(
		String dmpId,
		RelatedIdentifier relatedIdentifier,
		String accessToken
	 ) throws URISyntaxException, MalformedURLException, RestClientException, JsonProcessingException;

	URL getApiUrlBase();

}
