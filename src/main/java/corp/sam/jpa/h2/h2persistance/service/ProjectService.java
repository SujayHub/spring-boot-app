package corp.sam.jpa.h2.h2persistance.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import corp.sam.jpa.h2.h2persistance.bean.ProjectBean;
import corp.sam.jpa.h2.h2persistance.transaction.ProjectTransaction;;

@Service
public class ProjectService {
	
	@Autowired
	ProjectTransaction transaction;

	//create one
	public void addProject(ProjectBean entity) {
		
		transaction.addProject(entity);
	
		
	}
	
	//read all
	public List<ProjectBean> getAllProjects() {
		
		return transaction.getAllProjects();
	}

	//read one by Id
	public Optional<ProjectBean> getOneProject(long projectId) {
		
		return transaction.getOneProject(projectId); 
	}
	
	public List<ProjectBean> getAllProjectsByPGM(long projectManagerId){
		
		return transaction.getAllProjectsByPGM(projectManagerId);
	}
	
	public List<ProjectBean> getAllProjectsByPL(long projectLeadId){

		return transaction.getAllProjectsByPL(projectLeadId);
	}
	
	public void updateOneProject(long projectId, ProjectBean projectBean) {
		
		transaction.updateOneProject(projectId, projectBean);
	}

	public void deleteOneProject(long projectId) {
		
		transaction.deleteOneProject(projectId);
		
	}

	
}
