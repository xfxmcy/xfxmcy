package com.xfxmcy.pojo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.xfxmcy.util.CaseAdmin;



/**
 * @author CY
 * @Date   09-06
 * @description  Administrator extends Person
 * @version 0.0.1-SNAPSHOT
 */
@Entity

public class Administrator extends Person implements Serializable {
	
	public Administrator() {
		// TODO Auto-generated constructor stub
	}
	public Administrator(String account , String pwd) {
		super.setPpwd(pwd);
		super.setPaccount(account);
	}
	
	private CaseAdmin caseAdmin; //等级
	
	@Enumerated(EnumType.STRING)
	public CaseAdmin getCaseAdmin() {
		return caseAdmin;
	}

	public void setCaseAdmin(CaseAdmin caseAdmin) {
		this.caseAdmin = caseAdmin;
	}
	
	private Set<Task> tasks;
	
	@OneToMany(mappedBy = "administrator")
	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}
	
}
