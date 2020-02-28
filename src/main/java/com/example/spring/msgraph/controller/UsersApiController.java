package com.example.spring.msgraph.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.example.spring.msgraph.api.GraphApi;
import com.example.spring.msgraph.api.UsersApi;
import com.example.spring.msgraph.request.UserRequest;
import com.example.spring.msgraph.response.UserResponse;
import com.example.spring.msgraph.response.UsersResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/users")
public class UsersApiController {

	UsersApi api;

	@Autowired
	public UsersApiController(UsersApi api) {
		this.api = api;
	}

	@GetMapping
	public ResponseEntity<UsersResponse> index() {
		return ResponseEntity.ok(api.read());
	}

	@GetMapping("delta")
	public ResponseEntity<UsersResponse> delta(
			@RequestParam LinkedMultiValueMap<String, String> parameters) {
		return ResponseEntity.ok(api.delta(parameters));
	}

	@GetMapping("{id}")
	public ResponseEntity<UserResponse> get(@PathVariable String id) {
		return ResponseEntity.ok(api.read(id));
	}

	@PostMapping("")
	public ResponseEntity<?> create(@RequestBody UserRequest user) {
		api.create(user);
		return GraphApi.ok("success");
	}

	@PostMapping("{id}")
	public ResponseEntity<?> modify(@PathVariable String id, @RequestBody UserRequest user) {
		api.update(id, user);
		return GraphApi.ok("success");
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		api.delete(id);
		return GraphApi.ok("success");
	}

	@ExceptionHandler(HttpClientErrorException.BadRequest.class)
	public ResponseEntity<?> exception(HttpClientErrorException.BadRequest e) {
		log.warn(e.getMessage(), e);
		return ResponseEntity.badRequest().body(e.getResponseBodyAsString());
	}

	@ExceptionHandler(OAuth2AuthenticationException.class)
	public ResponseEntity<?> exception(OAuth2AuthenticationException e) {
		throw e;
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> exception(Exception e) {
		log.error(e.getMessage(), e);
		return GraphApi.internalServerError(e.getMessage());
	}
}
