package com.example.spring.msgraph.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.msgraph.GraphApi;
import com.example.spring.msgraph.request.UserRequest;
import com.example.spring.msgraph.response.UserResponse;

@RestController
@RequestMapping("/api/users")
public class UsersApiController {

	GraphApi api;

	@Autowired
	public UsersApiController(GraphApi api) {
		this.api = api;
	}

	@GetMapping
	public ResponseEntity<?> index() {
		return ResponseEntity.ok(api.users());
	}

	@GetMapping("{id}")
	public ResponseEntity<?> get(@PathVariable String id) {
		return ResponseEntity.ok(api.user(id));
	}

	@PostMapping("")
	public ResponseEntity<?> create(@RequestBody UserRequest jso) {
		return ResponseEntity.badRequest().body("サポートされていません。");
	}

	@PostMapping("{id}")
	public ResponseEntity<?> modify(@PathVariable String id, @RequestBody UserRequest user) {
		return ResponseEntity.ok(api.update(id, user));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		return ResponseEntity.badRequest().body("サポートされていません。");
	}
}
