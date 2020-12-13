package com.itau.twitter.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.common.net.HttpHeaders;

@Component
public class TwitterService {
	private String tokenTwitter = "AAAAAAAAAAAAAAAAAAAAAErpKQEAAAAAk%2B48U6u6SsskBYKGLL%2BG8bLUITQ%3DRZ8DCFSYNwmSly4Wz3zZyTR5DqheGpZtMzRpcRMh44FtHi41Cd";
	
	private RestTemplate template = new RestTemplate();
	
	public HttpEntity<String> searchByHastag(String hastag) {
		UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme("https")
				.host("api.twitter.com")
				.path("2/tweets/search/recent")
				.queryParam("tweet.fields", "author_id,created_at,entities")
				.queryParam("max_results", "15")
				.queryParam("query", hastag)
				.build();

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		
		headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + tokenTwitter);
		
		HttpEntity<?> entity = new HttpEntity<>(headers);
		
		HttpEntity<String> response = template.exchange(uri.toUriString(), HttpMethod.GET, entity, String.class);
		
		return response;
	}
}
