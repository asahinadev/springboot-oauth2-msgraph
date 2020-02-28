package com.example.spring.msgraph.response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.example.spring.msgraph.response.extensions.Attendee;
import com.example.spring.msgraph.response.extensions.Body;
import com.example.spring.msgraph.response.extensions.DateTime;
import com.example.spring.msgraph.response.extensions.Location;
import com.example.spring.msgraph.response.extensions.Recurrence;
import com.example.spring.msgraph.response.extensions.Status;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CalendarResponse {

	String id;
	LocalDateTime createdDateTime;
	LocalDateTime lastModifiedDateTime;
	String changeKey;
	List<Object> categories;
	String originalStartTimeZone;
	String originalEndTimeZone;
	String iCalUId;
	Long reminderMinutesBeforeStart;
	boolean isReminderOn;
	boolean hasAttachments;
	String subject;
	String bodyPreview;
	String importance;
	String sensitivity;
	boolean isAllDay;
	boolean isCancelled;
	boolean isOrganizer;
	boolean responseRequested;
	String seriesMasterId;
	String showAs;
	String type;
	String webLink;
	String onlineMeetingUrl;
	Status responseStatus;
	Body body;
	DateTime start;
	DateTime end;
	Location location;
	Recurrence recurrence;
	List<Attendee> attendees;
	Attendee organizer;

	@JsonAnySetter
	Map<String, Object> ext;
}
