package com.example.spring.msgraph.api;

import java.net.URI;
import java.time.Instant;
import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizationContext;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.RefreshTokenOAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.spring.msgraph.config.MsGraphConfig;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GraphApi {

	public static final ResponseEntity<Map<String, String>> ok(String message) {
		return ResponseEntity.ok(Collections.singletonMap("message", message));
	}

	public static final ResponseEntity<Map<String, String>> badRequest(String message) {
		return ResponseEntity.badRequest().body(Collections.singletonMap("message", message));
	}

	public static final ResponseEntity<Map<String, String>> internalServerError(String message) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonMap("message", message));
	}

	final MsGraphConfig config;
	final OAuth2AuthorizedClientService clientService;
	final RestTemplate restTemplate = new RestTemplate();
	final ObjectMapper om;

	@Autowired
	public GraphApi(MsGraphConfig config, OAuth2AuthorizedClientService clientService) {
		this.config = config;
		this.clientService = clientService;
		this.om = new ObjectMapper();
	}

	<T> T get(URI url, ParameterizedTypeReference<T> typeReference) {
		log.debug("URL => {}", url);
		RequestEntity<?> requestEntity = new RequestEntity<>(headers(), HttpMethod.GET, url);
		return restTemplate.exchange(requestEntity, typeReference).getBody();
	}

	@SneakyThrows
	<T> T postJson(URI url, ParameterizedTypeReference<T> typeReference, Object json) {
		log.debug("URL => {}", url);
		RequestEntity<?> requestEntity = new RequestEntity<>(om.writeValueAsString(json), headers(), HttpMethod.POST, url);
		return restTemplate.exchange(requestEntity, typeReference).getBody();
	}

	<T> T delete(URI url, ParameterizedTypeReference<T> typeReference) {
		log.debug("URL => {}", url);
		RequestEntity<?> requestEntity = new RequestEntity<>(headers(), HttpMethod.DELETE, url);
		return restTemplate.exchange(requestEntity, typeReference).getBody();
	}

	protected HttpHeaders headers() {
		OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

		OAuth2AuthorizedClient client = clientService.loadAuthorizedClient(oauthToken.getAuthorizedClientRegistrationId(), oauthToken.getName());

		log.debug("clientId => {}, name => {}, client => {}", oauthToken.getAuthorizedClientRegistrationId(), oauthToken.getName(), client);

		if (client == null) {
			log.debug("error");
			throw new OAuth2AuthenticationException(new OAuth2Error("0000"));
		} else if (Instant.now().isAfter(client.getAccessToken().getExpiresAt())) {
			log.debug("refresh");
			// リフレッシュトークン
			OAuth2AuthorizationContext context = OAuth2AuthorizationContext.withAuthorizedClient(client).principal(oauthToken).build();
			OAuth2AuthorizedClient refreshedClient = new RefreshTokenOAuth2AuthorizedClientProvider().authorize(context);
			clientService.saveAuthorizedClient(refreshedClient, oauthToken);
			return headers();
		} else {
			log.debug("default");
		}

		HttpHeaders headers = new HttpHeaders();

		headers.setBearerAuth(client.getAccessToken().getTokenValue());
		return headers;

	}
}
