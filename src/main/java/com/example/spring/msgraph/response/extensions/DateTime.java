package com.example.spring.msgraph.response.extensions;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.TimeZone;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DateTime {
	LocalDateTime dateTime;
	TimeZone timeZone;

	@JsonAnySetter
	Map<String, Object> ext;
}
