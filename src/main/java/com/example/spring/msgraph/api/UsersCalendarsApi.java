package com.example.spring.msgraph.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.spring.msgraph.config.MsGraphConfig;
import com.example.spring.msgraph.response.CalendarsResponse;

@Service
public class UsersCalendarsApi extends GraphApi {

	@Autowired
	public UsersCalendarsApi(MsGraphConfig config, OAuth2AuthorizedClientService clientService) {
		super(config, clientService);
	}

	public CalendarsResponse read(String id) {
		switch (id) {
		case "me": {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(config.getMeCalendars());
			return this.get(builder.build().toUri(), ParameterizedTypeReference.forType(CalendarsResponse.class));
		}
		default:
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(config.getUsersCalendars());
			return this.get(builder.build(id), ParameterizedTypeReference.forType(CalendarsResponse.class));
		}
	}

}
