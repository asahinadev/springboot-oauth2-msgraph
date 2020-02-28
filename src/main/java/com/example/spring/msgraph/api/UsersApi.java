package com.example.spring.msgraph.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.spring.msgraph.config.MsGraphConfig;
import com.example.spring.msgraph.request.UserRequest;
import com.example.spring.msgraph.response.UserResponse;
import com.example.spring.msgraph.response.UsersResponse;

@Service
public class UsersApi extends GraphApi {

	@Autowired
	public UsersApi(MsGraphConfig config, OAuth2AuthorizedClientService clientService) {
		super(config, clientService);
	}

	public UsersResponse read() {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(config.getUsers());
		return this.get(builder.build().toUri(), ParameterizedTypeReference.forType(UsersResponse.class));
	}

	public UsersResponse delta(LinkedMultiValueMap<String, String> parameters) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(config.getUsersDelta());
		return this.get(builder.queryParams(parameters).build().toUri(), ParameterizedTypeReference.forType(UsersResponse.class));
	}

	public UserResponse read(String id) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(config.getUsersId());
		return this.get(builder.build(id), ParameterizedTypeReference.forType(UserResponse.class));
	}

	public void create(UserRequest json) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(config.getUsers());
		this.postJson(builder.build().toUri(), ParameterizedTypeReference.forType(UserResponse.class), json);
	}

	public void update(String id, UserRequest json) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(config.getUsersId());
		this.postJson(builder.build(id), ParameterizedTypeReference.forType(UserResponse.class), json);
	}

	public void delete(String id) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(config.getUsersId());
		this.delete(builder.build(id), ParameterizedTypeReference.forType(UserResponse.class));
	}

}
