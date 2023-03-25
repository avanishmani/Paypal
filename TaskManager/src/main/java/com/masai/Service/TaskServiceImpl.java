package com.masai.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Dao.SprintDao;
import com.masai.Dao.TaskDao;
import com.masai.Dao.UserDao;
import com.masai.Enums.TaskStatus;
import com.masai.Exception.SprintException;
import com.masai.Exception.TaskException;
import com.masai.Exception.UserException;
import com.masai.model.Sprint;
import com.masai.model.Task;
import com.masai.model.User;
@Service
public class TaskServiceImpl implements TaskService {
	@Autowired
	private SprintDao sDao;
	
	@Autowired
	private TaskDao tDao;
	
	@Autowired
	private UserDao uDao;

	@Override
	public Sprint createSprint(Sprint sprint) {
		// TODO Auto-generated method stub
		
		return sDao.save(sprint);
		
	}
	


	@Override
	public Task createTask(Long sprintId,Long UserID, Task task) throws SprintException, UserException
	{
		Sprint sprint = sDao.findById(sprintId).orElseThrow(() -> new SprintException("sprint not found"));

//	     sprint.getTasks().add(task);
		sprint.getTasks().add(task);
		task.setSprint(sprint);
		
		List<User> userslist = uDao.findAll().stream().filter(s -> s.getId() == UserID).collect(Collectors.toList());

		if (userslist.isEmpty())
		{
			throw new UserException("User Not FOund");
		}
		task.setAssignee(userslist.get(0));

		

		return tDao.save(task);
	}
	
	@Override
	public Task changeTaskAssignee(Long taskid, Long userid) throws UserException, TaskException{
		
		Task task = tDao.findById(taskid).orElseThrow(()->new TaskException("Task not found"));
		
		List<User> userList = uDao.findAll().stream().filter(s->s.getId()==userid).collect(Collectors.toList());
		
		if(userList.isEmpty()) {
			throw new UserException("user not found");
		}
		task.setAssignee(userList.get(0));
		return tDao.save(task);
		
	}

	
	@Override
	public Task changeTaskStatus(Long taskId, TaskStatus status) throws TaskException
	{
		Task task = tDao.findById(taskId).orElseThrow(() -> new TaskException("Task not found"));
		task.setStatus(status);

		return tDao.save(task);
	}

	@Override
	public List<Task> getTasksInSprint(Long sprintId) throws SprintException
	{

		return sDao.findById(sprintId).orElseThrow(() -> new SprintException("Sprint not found")).getTasks();
	}


}
