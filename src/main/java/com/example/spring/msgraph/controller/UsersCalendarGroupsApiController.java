package com.example.spring.msgraph.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.msgraph.api.UsersCalendarGroupsApi;
import com.example.spring.msgraph.response.CalendarGroupsResponse;

@RequestMapping("/api/users/{id}/calendarGroups")
@RestController
public class UsersCalendarGroupsApiController extends ApiController {

	UsersCalendarGroupsApi api;

	@Autowired
	public UsersCalendarGroupsApiController(UsersCalendarGroupsApi api) {
		this.api = api;
	}

	@GetMapping
	public ResponseEntity<CalendarGroupsResponse> index(@PathVariable String id) {
		return ResponseEntity.ok(api.read(id));
	}

}
