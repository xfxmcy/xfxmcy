package com.xfxmcy.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * @author CY
 * @Date   09-06
 * @description  personalTask extends Task
 * @version 0.0.1-SNAPSHOT
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PersonalTask extends Task{
	
	public PersonalTask() {
		// TODO Auto-generated constructor stub
	}
	
	private Employer employer ; // 接受者
	
 	private Date receive;		// 接受时间
 	
 	@ManyToOne(optional = true)
	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
	@Temporal(TemporalType.DATE)
	public Date getReceive() {
		return receive;
	}

	public void setReceive(Date receive) {
		this.receive = receive;
	}
 	
}
