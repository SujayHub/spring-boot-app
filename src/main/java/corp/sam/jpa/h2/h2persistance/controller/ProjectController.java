package corp.sam.jpa.h2.h2persistance.controller;

import corp.sam.jpa.h2.h2persistance.bean.ProjectBean;
import corp.sam.jpa.h2.h2persistance.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

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


@Api(tags="Projects Service")
@RestController
@RequestMapping(path="/projects/")
public class ProjectController {

    @Autowired
    private ProjectService service;
    
    //create one
    @ApiOperation("Add a project")
    @PostMapping("/addProject")
    public ResponseEntity<Object>addProject(@RequestBody ProjectBean entity){
    	
    	service.addProject(entity);
    	
    	return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/allProjects")
    public ResponseEntity<Object> getAllProjects(){
    	
    	List<ProjectBean> allProjects = service.getAllProjects();
    	
        return new ResponseEntity<>(allProjects, HttpStatus.ACCEPTED);

    }
    
    @GetMapping("/projects/{projectId}")
    public ResponseEntity<Object> getOneProject(@PathVariable long projectId){
    	
    	Optional<ProjectBean> project = service.getOneProject(projectId);
    	
        return new ResponseEntity<>(project, HttpStatus.FOUND);

    }
    
    @GetMapping("/pgm/projects/{projectManagerId}")
    public ResponseEntity<Object> getAllProjectsByPGM(@PathVariable long projectManagerId){
    	
    	List<ProjectBean> projectsByPGM = service.getAllProjectsByPGM(projectManagerId);
    	
        return new ResponseEntity<>(projectsByPGM, HttpStatus.FOUND);

    }
    
    @GetMapping("/pl/projects/{projectLeadId}")
    public ResponseEntity<Object> getAllProjectsByPL(@PathVariable long projectLeadId){
    	
    	List<ProjectBean> projectsByPGM = service.getAllProjectsByPL(projectLeadId);
    	
        return new ResponseEntity<>(projectsByPGM, HttpStatus.FOUND);

    }
    
    @PutMapping("/projects/{projectId}")
    public ResponseEntity<Object> updateOneProject(@RequestBody ProjectBean entity, @PathVariable long projectId){
    	
    	service.updateOneProject(projectId, entity);
    	
        return new ResponseEntity<>(HttpStatus.OK);

    }
    
    @DeleteMapping("/projects/{projectId}")
    public ResponseEntity<Object> deleteOneProject(@PathVariable long projectId){
    	
    	service.deleteOneProject(projectId);
    	
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
