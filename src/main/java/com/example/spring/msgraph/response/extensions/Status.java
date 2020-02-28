package com.example.spring.msgraph.response.extensions;

import java.time.LocalDateTime;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Status {
	String response;
	LocalDateTime time;

	@JsonAnySetter
	Map<String, Object> ext;
}
