package com.researchspace.dmptool.client;

import com.researchspace.dmptool.model.DMPList;
import com.researchspace.dmptool.model.DMPPlanScope;
import com.researchspace.dmptool.model.DMPToolDMP;
import com.researchspace.dmptool.model.RelatedIdentifier;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import com.researchspace.rda.model.DmpId;

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

	public DMPToolDMP getPlanById(
		String dmpId,
		String accessToken
	 ) throws MalformedURLException, URISyntaxException {
		String path = "plans/" + dmpId;
		return restTemplate.exchange(
			new URL(this.apiUrlBase, path).toURI(),
			HttpMethod.GET,
			new HttpEntity<>(getHttpHeaders(accessToken)),
			DMPList.class
		).getBody().getItems().get(0).getDmp();
	}

	public byte[] getPdfBytes(
		DMPToolDMP dmp,
		String accessToken
	 ) throws URISyntaxException, MalformedURLException {
		String path = "plans/" + dmp.getId() + ".pdf";
		return restTemplate.exchange(
			new URL(this.apiUrlBase, path).toURI(),
			HttpMethod.GET,
			new HttpEntity<>(getHttpHeaders(accessToken)),
			byte[].class
		).getBody();
	}

	@Data
	private class RelatedIdentifierRequest {
		@Data
		@AllArgsConstructor
		private class RelatedIdentifierDmpRequest {
			List<RelatedIdentifier> dmproadmap_related_identifiers;
			DmpId dmp_id;
		}

		RelatedIdentifierDmpRequest dmp;

		public RelatedIdentifierRequest(
				RelatedIdentifier relatedIdentifier,
				String dmpId
			) {
			this.dmp = new RelatedIdentifierDmpRequest(
					List.of(relatedIdentifier),
					new DmpId(dmpId, DmpId.DmpIdType.URL)
				);
		}
	}

	public void postRelatedIdentifiers(
		String dmpId,
		RelatedIdentifier relatedIdentifier,
		String accessToken
	 ) throws URISyntaxException, MalformedURLException, RestClientException {

		RelatedIdentifierRequest body = new RelatedIdentifierRequest(
			relatedIdentifier,
			dmpId
		);

		HttpHeaders headers = getHttpHeaders(accessToken);
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		restTemplate.exchange(
			new URL(this.apiUrlBase, "related_identifiers").toURI(),
			HttpMethod.POST,
			new HttpEntity<>(body, headers),
			String.class
		);
	}

	private HttpHeaders getHttpHeaders(String accessToken) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", String.format("Bearer %s", accessToken));
		return headers;
	}

}
