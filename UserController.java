package com.monocept.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.dto.response.UserDetail;
import com.monocept.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	@Autowired
	public UserServiceImpl userService;
	
	@GetMapping("/details")
	public UserDetail getUserDetail(Principal principal) {
		return userService.getUserDetail(principal.getName());
	}
}
