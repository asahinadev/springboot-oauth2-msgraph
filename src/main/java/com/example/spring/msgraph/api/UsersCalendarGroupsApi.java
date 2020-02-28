package com.example.spring.msgraph.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.spring.msgraph.config.MsGraphConfig;
import com.example.spring.msgraph.response.CalendarGroupsResponse;

@Service
public class UsersCalendarGroupsApi extends GraphApi {

	@Autowired
	public UsersCalendarGroupsApi(MsGraphConfig config, OAuth2AuthorizedClientService clientService) {
		super(config, clientService);
	}

	public CalendarGroupsResponse read(String id) {
		switch (id) {
		case "me": {
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(config.getMeCalendarGroups());
			return this.get(builder.build().toUri(), ParameterizedTypeReference.forType(CalendarGroupsResponse.class));
		}
		default:
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(config.getUsersCalendarGroups());
			return this.get(builder.build(id), ParameterizedTypeReference.forType(CalendarGroupsResponse.class));
		}
	}

}
