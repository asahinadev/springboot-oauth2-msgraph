package com.example.spring.msgraph.response.extensions;

import java.time.LocalDate;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Range {
	String type;
	LocalDate startDate;
	LocalDate endDate;
	String recurrenceTimeZone;
	Long numberOfOccurrences;

	@JsonAnySetter
	Map<String, Object> ext;
}
