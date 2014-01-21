package com.xfxmcy.pojo;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author CY
 * @Date   14-07
 * @description  middle table for CompetitiveTask and Employer
 * @version 0.0.1-SNAPSHOT
 */
@Entity
//@Embeddable
public class CompetitiveMapping {
	
	private Integer competitiveId;
	
	@Id
	@GeneratedValue
	public Integer getCompetitiveId() {
		return competitiveId;
	}
	public void setCompetitiveId(Integer competitiveId) {
		this.competitiveId = competitiveId;
	}

	private Employer competitiveEmployer;
	
	private CompetitiveTask competitiveTask;
	
	private Date receive;
	
	public CompetitiveMapping() {
		// TODO Auto-generated constructor stub
	}
	//@Id
	//@EmbeddedId
	@ManyToOne
	public Employer getCompetitiveEmployer() {
		return competitiveEmployer;
	}

	public void setCompetitiveEmployer(Employer competitiveEmployer) {
		this.competitiveEmployer = competitiveEmployer;
	}
	//@Id
	//@EmbeddedId
	@ManyToOne
	public CompetitiveTask getCompetitiveTask() {
		return competitiveTask;
	}

	public void setCompetitiveTask(CompetitiveTask competitiveTask) {
		this.competitiveTask = competitiveTask;
	}

	public Date getReceive() {
		return receive;
	}

	public void setReceive(Date receive) {
		this.receive = receive;
	}
	
	
}
