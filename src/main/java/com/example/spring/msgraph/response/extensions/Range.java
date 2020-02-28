package com.example.spring.msgraph.response.extensions;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_EMPTY)
public class Range {
	String type;
	LocalDate startDate;
	LocalDate endDate;
	String recurrenceTimeZone;
	Long numberOfOccurrences;

	@JsonAnySetter
	Map<String, Object> ext = new HashMap<>();
}
