package com.example.spring.msgraph.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.spring.msgraph.form.UserForm;

@Controller
@RequestMapping("/users")
public class UsersController {

	@GetMapping
	public String index() {
		return "users/index";
	}

	@GetMapping("add")
	public String form(@ModelAttribute("form") UserForm form) {
		return "users/form";
	}

	@PostMapping("add")
	public String add(@Valid @ModelAttribute("form") UserForm form, BindingResult result) {
		if (result.hasErrors()) {
			return "users/form";
		}
		return "redirect:/users";
	}

	@GetMapping("{id}")
	public String edit(
			@PathVariable String id,
			@ModelAttribute("form") UserForm form) {
		return "users/form";
	}

	@PostMapping("{id}")
	public String edit(
			@PathVariable String id, @Valid @ModelAttribute("form") UserForm form, BindingResult result) {
		if (result.hasErrors()) {
			return "users/form";
		}
		return "redirect:/users";
	}

	@DeleteMapping("{id}")
	public String edit(@PathVariable String id) {
		return "redirect:/users";
	}

	@GetMapping("api")
	public ResponseEntity<?> json() {
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
	}

	@PostMapping("api/create")
	public ResponseEntity<?> create(@Valid @ModelAttribute("form") UserForm form, BindingResult result) {
		if (result.hasErrors()) {
			return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("api/{id}")
	public String read(@PathVariable String id) {
		return "users/form";
	}

	@PostMapping("{id}")
	public ResponseEntity<?> update(
			@PathVariable String id, @Valid @ModelAttribute("form") UserForm form, BindingResult result) {
		if (result.hasErrors()) {
			return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
