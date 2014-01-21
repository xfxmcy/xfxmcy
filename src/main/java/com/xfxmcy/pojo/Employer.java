package com.xfxmcy.pojo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * @author CY
 * @Date   09-06
 * @description  Employer extends Person
 * @version 0.0.1-SNAPSHOT
 */
@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Employer extends Person  implements Serializable {
	@Override
	public String toString() {
		
		return ReflectionToStringBuilder.toString(this, ToStringStyle.SIMPLE_STYLE);}

	public Employer() {
		// TODO Auto-generated constructor stub
	}
	
	private String pzfb; // 支付宝
	
	@Column(length = 40)
	public String getPzfb() {
		return pzfb;
	}

	public void setPzfb(String pzfb) {
		this.pzfb = pzfb;
	}
	
	private Set<PersonalTask> personalTask;
	
	@OneToMany(mappedBy = "employer" ,fetch = FetchType.LAZY)	
	public Set<PersonalTask> getPersonalTask() {
		return personalTask;
	}

	public void setPersonalTask(Set<PersonalTask> personalTask) {
		this.personalTask = personalTask;
	}
	
	private Set<CompetitiveMapping> competitiveTask;
	
	@OneToMany(mappedBy = "competitiveEmployer")
	public Set<CompetitiveMapping> getCompetitiveTask() {
		return competitiveTask;
	}

	public void setCompetitiveTask(Set<CompetitiveMapping> competitiveTask) {
		this.competitiveTask = competitiveTask;
	}
	
}
