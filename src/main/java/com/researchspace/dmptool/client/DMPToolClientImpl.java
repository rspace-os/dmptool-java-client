package com.researchspace.dmptool.client;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpEntity;

import com.researchspace.dmptool.model.DMPList;
import com.researchspace.dmptool.model.DMP;
import com.researchspace.dmptool.model.DMPPlanScope;
import com.researchspace.dmptool.model.DMPIdPost;
import com.researchspace.dmptool.model.RelatedIdentifier;

public class DMPToolClientImpl implements DMPToolClient {

	private URL apiUrlBase;
	private RestTemplate restTemplate;

	public DMPToolClientImpl(URL apiUrlBase) {
			this.apiUrlBase = apiUrlBase;
			this.restTemplate = new RestTemplate();
	}

  public DMPList listPlans(
    DMPPlanScope scope,
    String accessToken
   ) throws MalformedURLException, URISyntaxException {
		return restTemplate.exchange(
				this.apiUrlBase + "plans?scope" + scope.name().toLowerCase(),
				HttpMethod.GET,
				new HttpEntity<>(getHttpHeaders(accessToken)),
				DMPList.class
		).getBody();
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

	private HttpHeaders getHttpHeaders(String accessToken) {
			HttpHeaders headers = new HttpHeaders();
			headers.add("Content-Type", "application/json");
      headers.add("Authorization", String.format("Bearer %s", accessToken));
			return headers;
	}

}
