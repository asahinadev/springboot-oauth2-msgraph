package com.example.spring.msgraph.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.msgraph.api.UsersCalendarsApi;
import com.example.spring.msgraph.response.CalendarsResponse;

@RequestMapping("/api/users/{id}/calendars")
@RestController
public class UsersCalendarApiController extends ApiController {

	UsersCalendarsApi api;

	@Autowired
	public UsersCalendarApiController(UsersCalendarsApi api) {
		this.api = api;
	}

	@GetMapping
	public ResponseEntity<CalendarsResponse> index(@PathVariable String id) {
		return ResponseEntity.ok(api.read(id));
	}

}
