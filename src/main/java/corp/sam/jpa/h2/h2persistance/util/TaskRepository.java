package corp.sam.jpa.h2.h2persistance.util;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import corp.sam.jpa.h2.h2persistance.bean.TaskBean;

public interface TaskRepository extends JpaRepository<TaskBean, Long>{
	
	List<TaskBean> findByProjectManagerId(long projectManagerId);
	List<TaskBean> findByProjectLeadId(long projectLeadId);

}
