package com.example.spring.msgraph.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("{id}")
	public String edit(@PathVariable String id, @ModelAttribute("form") UserForm form) {
		return "users/form";
	}

}
