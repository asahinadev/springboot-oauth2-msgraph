package com.example.spring.msgraph.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties("app.microsoft.graph")
public class MsGraphConfig {
	String users = "https://graph.microsoft.com/v1.0/users";
	String user = "https://graph.microsoft.com/v1.0/users/{id}";
}
