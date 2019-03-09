package corp.sam.jpa.h2.h2persistance.bean;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProjectBean {
    @Id
    private long projectId;
    private String projectName;
    private long projectManagerId;
    private String projectMangerName;
    private long projectLeadId;
    private String projectLeadName;
    private int teamMembers;
    private int openRequiremnts;
    private int taskCount;
    private boolean active;
    private String lastUpdated;

}