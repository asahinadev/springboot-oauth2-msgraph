package com.example.spring.msgraph.response.extensions;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Recurrence {
	Pattern pattern;
	Range range;

	@JsonAnySetter
	Map<String, Object> ext;
}
