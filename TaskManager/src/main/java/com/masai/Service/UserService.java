package com.masai.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.Exception.UserException;
import com.masai.model.Task;
import com.masai.model.User;

@Service
public interface UserService {
	public User createUser(User user);

	public List<Task> getAllTaskByUser(Long userId) throws UserException;
}
