package com.nexxi.userapplication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexxi.userapplication.models.User;
import com.nexxi.userapplication.services.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService service;

	@RequestMapping("/user/add")
	public String addUser(@RequestBody User user) {
		return service.addingUser(user);

	}
	@RequestMapping("/users")
	public List<User> getListinfo(){
		return service.listofUsers();
	}
	@RequestMapping("/userupdate{id}")
	public String updateUser(@PathVariable("id") Long id,@RequestBody User user) {
		return service.updatingUser(id,user);
		
	}
	@RequestMapping("/userdelete{id}")
	public String deleteUser(@PathVariable("id") Long id,@RequestBody User user) {
		return service.deletingUser(id,user);
		
	}

}
