package com.example.spring.msgraph.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties("app.microsoft.graph")
public class MsGraphConfig {
	/** ENDPOINT PREFIX */
	String prefix = "https://graph.microsoft.com/v1.0";

	String usersEndPoint = "/users";
	String usersIdEndPoint = "/users/{id}";
	String usersDeltaEndPoint = "/users/delta";

	String usersCalendarsEndPoint = "/users/{id}/calendars";
	String meCalendarsEndPoint = "/me/calendars";

	String usersCalendarGroupsEndPoint = "/users/{id}/calendarGroups";
	String meCalendarGroupsEndPoint = "/me/calendarGroups";

	protected String url(String path) {
		return UriComponentsBuilder.fromHttpUrl(prefix).path(path).build().toUriString();

	}

	public String getUsers() {
		return url(usersEndPoint);
	}

	public String getUsersDelta() {
		return url(usersDeltaEndPoint);
	}

	public String getUsersId() {
		return url(usersIdEndPoint);
	}

	public String getUsersCalendars() {
		return url(usersCalendarsEndPoint);
	}

	public String getUsersCalendarGroups() {
		return url(usersCalendarGroupsEndPoint);
	}

	public String getMeCalendars() {
		return url(meCalendarsEndPoint);
	}

	public String getMeCalendarGroups() {
		return url(meCalendarGroupsEndPoint);
	}

}
