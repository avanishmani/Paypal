package com.masai.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.Enums.TaskStatus;
import com.masai.Exception.SprintException;
import com.masai.Exception.TaskException;
import com.masai.Exception.UserException;
import com.masai.model.Sprint;
import com.masai.model.Task;
@Service
public interface TaskService {
	public Sprint createSprint(Sprint sprint);
	
	
	 public Task createTask( Long sprintId,Long userID,  Task task)throws SprintException, UserException;
	 
	 public Task changeTaskAssignee(Long taskid, Long userid) throws UserException, TaskException;
	 
	 public Task changeTaskStatus(Long taskId, TaskStatus status) throws TaskException;
	 
	 public List<Task> getTasksInSprint(Long sprintId) throws SprintException;
}
