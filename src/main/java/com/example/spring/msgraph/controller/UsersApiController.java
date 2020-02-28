package com.example.spring.msgraph.controller;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.example.spring.msgraph.GraphApi;
import com.example.spring.msgraph.request.UserRequest;
import com.example.spring.msgraph.response.UserResponse;
import com.example.spring.msgraph.response.UsersResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/users")
public class UsersApiController {

	GraphApi api;

	@Autowired
	public UsersApiController(GraphApi api) {
		this.api = api;
	}

	@GetMapping
	public ResponseEntity<UsersResponse> index() {
		return ResponseEntity.ok(api.users());
	}

	@GetMapping("{id}")
	public ResponseEntity<UserResponse> get(@PathVariable String id) {
		return ResponseEntity.ok(api.user(id));
	}

	@PostMapping("")
	public ResponseEntity<UserResponse> create(@RequestBody UserRequest jso) {
		throw new UnsupportedOperationException();
	}

	@PostMapping("{id}")
	public ResponseEntity<UserResponse> modify(@PathVariable String id, @RequestBody UserRequest user) {
		return ResponseEntity.ok(api.update(id, user));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		return ResponseEntity.ok(api.delete(id));
	}

	@ExceptionHandler(UnsupportedOperationException.class)
	public ResponseEntity<String> exception(UnsupportedOperationException e) {
		log.warn(e.getMessage(), e);
		return ResponseEntity.badRequest().body("サポートされていません。");
	}

	@ExceptionHandler(HttpClientErrorException.BadRequest.class)
	public ResponseEntity<String> exception(HttpClientErrorException.BadRequest e) {
		log.warn(e.getMessage(), e);
		return ResponseEntity.badRequest().body(e.getResponseBodyAsString(StandardCharsets.UTF_8));
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> exception(Exception e) {
		log.error(e.getMessage(), e);
		return ResponseEntity.badRequest().body(e.getMessage());
	}
}
