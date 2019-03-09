package corp.sam.jpa.h2.h2persistance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import corp.sam.jpa.h2.h2persistance.bean.TaskBean;
import corp.sam.jpa.h2.h2persistance.transaction.TaskTransaction;

@Service
public class TaskService {

	@Autowired
	private TaskTransaction transaction;

	public void addOneTask(TaskBean bean) {

		transaction.addOneTask(bean);
	}

	public List<TaskBean> getAllTasks() {

		return transaction.getAllTasks();

	}

	public Optional<TaskBean> getOneTask (long taskId) {

		return transaction.getOneTask(taskId);
	}

	public List<TaskBean> getAllTasksByPgm (long projectManagerId) {

		return transaction.getAllTasksByPgm(projectManagerId);
	}

	public List<TaskBean> getAllTasksByPl (long projectLeadId) {

		return transaction.getAllTasksByPl(projectLeadId);
	}

	public void updateOneTask(long taskId, TaskBean bean) {

		transaction.updateOneTask(taskId, bean);
	}

	public void deleteOneTask(long taskId) {

		transaction.deleteOneTask(taskId);
	}

}
