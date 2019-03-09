package corp.sam.jpa.h2.h2persistance.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import corp.sam.jpa.h2.h2persistance.bean.TaskBean;
import corp.sam.jpa.h2.h2persistance.service.TaskService;
import io.swagger.annotations.Api;


@Api(tags="Task Service")
@RestController
@RequestMapping(path="/tasks/")
public class TaskController {

	@Autowired
	private TaskService service;

	//create one
	@PostMapping("/addTask")
	public ResponseEntity<Object> addTask (@RequestBody TaskBean bean){

		service.addOneTask(bean);

		return new ResponseEntity<>(HttpStatus.CREATED);

	}

	//read all
	@GetMapping("/allTasks")
	public ResponseEntity<Object> getAllTasks (){

		List<TaskBean> tasks = service.getAllTasks();

		return new ResponseEntity<>(tasks,HttpStatus.OK);
	}

	@GetMapping("pgm/allTasks/{projectManagerId}")
	public ResponseEntity<Object> getAllTasksByPgm (@PathVariable long projectManagerId){

		List<TaskBean> tasks = service.getAllTasksByPgm(projectManagerId);

		return new ResponseEntity<>(tasks,HttpStatus.OK);
	}

	@GetMapping("pl/allTasks/{projectLeadId}")
	public ResponseEntity<Object> getAllTasksByPl (@PathVariable long projectLeadId){

		List<TaskBean> tasks = service.getAllTasksByPl(projectLeadId);

		return new ResponseEntity<>(tasks,HttpStatus.OK);
	}

	//read one
	@GetMapping("/tasks/{taskId}")
	public ResponseEntity<Object> getOneTask(@PathVariable long taskId){

		Optional<TaskBean> task = service.getOneTask(taskId);

		return new ResponseEntity<Object>(task, HttpStatus.OK);
	}

	//update one
	@PutMapping("/tasks/{taskId}")
	public ResponseEntity<Object> updateOneTask(@PathVariable long taskId, @RequestBody TaskBean bean) {

		service.updateOneTask(taskId, bean);

		return new ResponseEntity<>(HttpStatus.ACCEPTED);		

	}

	//delete one
	@DeleteMapping("/tasks/{taskId}")
	public ResponseEntity<Object> deleteOneTask(@PathVariable long taskId){

		service.deleteOneTask(taskId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}


}
