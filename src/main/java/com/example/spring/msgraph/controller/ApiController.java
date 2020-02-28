package com.example.spring.msgraph.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import com.example.spring.msgraph.api.GraphApi;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApiController {

	@ExceptionHandler(HttpClientErrorException.BadRequest.class)
	public ResponseEntity<?> exception(HttpClientErrorException.BadRequest e) {
		log.warn(e.getMessage(), e);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getResponseBodyAsString());
	}

	@ExceptionHandler(HttpClientErrorException.Forbidden.class)
	public ResponseEntity<?> exception(HttpClientErrorException.Forbidden e) {
		log.warn(e.getMessage(), e);
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getResponseBodyAsString());
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
