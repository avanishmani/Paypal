package com.masai.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.UserException;
import com.masai.Service.UserService;
import com.masai.model.Task;
import com.masai.model.User;

import jakarta.validation.Valid;

@RestController
public class UserController {
	@Autowired
	private UserService uService;

	@PostMapping("/adduser")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) throws UserException
	{
		return new ResponseEntity<User>(uService.createUser(user), HttpStatus.CREATED);
	}
	
	@GetMapping("/all/task")
	public ResponseEntity<List<Task>> getAllTaskByUser(@Valid  @RequestParam("uid") Long userid) throws UserException
	{
		return new ResponseEntity<>(uService.getAllTaskByUser(userid), HttpStatus.CREATED);
	}
}
