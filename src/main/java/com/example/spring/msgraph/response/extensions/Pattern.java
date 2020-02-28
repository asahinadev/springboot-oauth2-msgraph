package com.example.spring.msgraph.response.extensions;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pattern {
	String type;
	Long interval;
	Long month;
	Long dayOfMonth;
	List<String> daysOfWeek;
	String firstDayOfWeek;
	String index;

	@JsonAnySetter
	Map<String, Object> ext;
}
