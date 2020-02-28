package com.example.spring.msgraph.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties("app.microsoft.graph")
public class MsGraphConfig {
	String users = "https://graph.microsoft.com/beta/users";
	String usersId = "https://graph.microsoft.com/beta/users/{id}";
	String usersDelta = "https://graph.microsoft.com/beta/users/delta";
	String usersCalendars = "https://graph.microsoft.com/beta/users/{id}/calendars";
}
