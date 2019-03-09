package corp.sam.jpa.h2.h2persistance.transaction;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import corp.sam.jpa.h2.h2persistance.bean.ProjectBean;
import corp.sam.jpa.h2.h2persistance.util.ProjectRepository;

@Transactional
@Repository
public class ProjectTransaction {

	@Autowired
	private ProjectRepository repository;

	//create one
	public void addProject(ProjectBean entity) {

		repository.save(entity);
		

	}

	//read all
	public List<ProjectBean> getAllProjects() {

		return  repository.findAll();

	}

	//read one by Id
	public Optional<ProjectBean> getOneProject(long projectId) {

		return repository.findById(projectId);
	}



	//read all by projectManager
	public List<ProjectBean> getAllProjectsByPGM(long projectManagerId){

		return repository.findByProjectManagerId(projectManagerId);
	}

	//read all by projectLead
	public List<ProjectBean> getAllProjectsByPL(long projectLeadId){

		return repository.findByProjectLeadId(projectLeadId);
	}

	//update one
	public void updateOneProject(long projectId,ProjectBean projectBean) {
		
		projectBean.setProjectId(projectId);
		repository.save(projectBean);
	}

	//delete one by Id
	public void deleteOneProject(long projectId) {
		
		repository.deleteById(projectId);
		
	}
	

	//delete all
	//delete all by projectLead
	//delete all by projectManger


}
