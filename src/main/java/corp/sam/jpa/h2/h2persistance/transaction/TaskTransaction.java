package corp.sam.jpa.h2.h2persistance.transaction;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import corp.sam.jpa.h2.h2persistance.bean.TaskBean;
import corp.sam.jpa.h2.h2persistance.util.TaskRepository;

@Repository
@Transactional
public class TaskTransaction {

	@Autowired
	private TaskRepository repository;

	public void addOneTask(TaskBean bean) {

		repository.save(bean);
	}

	public List<TaskBean> getAllTasks() {

		return repository.findAll();

	}
	
	public Optional<TaskBean> getOneTask(long taskId) {
		
		return repository.findById(taskId);
	}
	
	public List<TaskBean> getAllTasksByPgm(long projectManagerId) {

		return repository.findByProjectManagerId(projectManagerId);

	}
	
	public List<TaskBean> getAllTasksByPl(long projectLeadId) {

		return repository.findByProjectLeadId(projectLeadId);

	}
	
	public void updateOneTask(long taskId, TaskBean bean) {
		
		bean.setTaskId(taskId);
		repository.save(bean);
	}
	
	public void deleteOneTask(long taskId) {
		
		repository.deleteById(taskId);
	}


}
