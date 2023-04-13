package com.researchspace.dmptool.client;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URI;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpEntity;
import java.util.Collections;
import org.springframework.http.MediaType;

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
		String path = "plans?scope=" + scope.name().toLowerCase();
		return restTemplate.exchange(
			new URL(this.apiUrlBase, path).toURI(),
			HttpMethod.GET,
			new HttpEntity<>(getHttpHeaders(accessToken)),
			DMPList.class
		).getBody();
	}

	public DMP getPlanById(
		String dmpId,
		String accessToken
	 ) throws MalformedURLException, URISyntaxException {
		String path = "plans/" + dmpId;
		return restTemplate.exchange(
			new URL(this.apiUrlBase, path).toURI(),
			HttpMethod.GET,
			new HttpEntity<>(getHttpHeaders(accessToken)),
			DMPList.class
		).getBody().getItems().get(0);
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
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", String.format("Bearer %s", accessToken));
		return headers;
	}

}
