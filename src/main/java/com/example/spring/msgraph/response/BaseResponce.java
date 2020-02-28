package com.example.spring.msgraph.response;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseResponce {

	@JsonProperty("@odata.context")
	String odata_context;

	@JsonAnySetter
	Map<String, Object> ext = new HashMap<>();
}
