package corp.sam.jpa.h2.h2persistance.util;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import corp.sam.jpa.h2.h2persistance.bean.ProjectBean;

public interface ProjectRepository extends JpaRepository<ProjectBean,Long> {
	
	List<ProjectBean> findByProjectManagerId(long projectManagerId);
	List<ProjectBean> findByProjectLeadId(long projectLeadId);

	
}
