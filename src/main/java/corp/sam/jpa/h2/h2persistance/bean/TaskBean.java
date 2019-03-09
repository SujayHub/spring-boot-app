package corp.sam.jpa.h2.h2persistance.bean;


import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TaskBean {
	
	@Id
	private long taskId;
	private String taskName;
	private String taskDescription;
	private boolean taskActive;
	private long initiatedById;
	private String initiatedByName;
	private String lastUpdated;
	private long projectId;
	private String projectName;
	private long projectManagerId;	
	private String projectManagerName;
	private long projectLeadId;
	private String projectLeadName;
	private boolean taskCompletd;
}


