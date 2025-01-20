package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class Userontroller {
	@Autowired
	UserService userService;
	
	@PostMapping("/login")
	public String Userlogin(@RequestParam(name = "UserName") String u, @RequestParam(name = "UserPassword") String p) {
		return userService.loginu(u,p);
	}
	
	@PostMapping("/register")
	public String RegisterUser(@RequestParam(name = "UserName") String u, @RequestParam(name = "UserPassword") String p, @RequestParam(name = "Role") String r) {
		userService.registeru(u,p,r);
		return "User created";
	}
	
}
