package com.xfxmcy.pojo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.IndexColumn;


/**
 * @author CY
 * @Date   09-06
 * @description  personalTask extends Task
 * @version 0.0.1-SNAPSHOT
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class CompetitiveTask extends Task {
	
	public CompetitiveTask() {
		// TODO Auto-generated constructor stub
	}
	private Administrator administrator;//发布者
	private List<CompetitiveMapping> competMapping ; // 接受者
	
	@OneToMany(mappedBy = "competitiveTask")
	@IndexColumn(name = "competMappingId" , base = 1)
	public List<CompetitiveMapping> getCompetMapping() {
		return competMapping;
	}

	public void setCompetMapping(List<CompetitiveMapping> competMapping) {
		this.competMapping = competMapping;
	}
	
	
 		
 	
}
