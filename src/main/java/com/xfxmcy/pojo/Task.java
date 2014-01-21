package com.xfxmcy.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.xfxmcy.util.TaskStatus;

/**
 * @author CY
 * @Date   31-05	
 * @description  the entity for  announcing task
 * @version 0.0.1-SNAPSHOT
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class  Task  implements Serializable  {
		
	private String tid = UUID.randomUUID().toString() ;
								 // 采用UUID 随机产生36位字符串
	private String ttitle;       // title
	private String tcontent;     // content	
	private Administrator administrator;//发布者
//	private Person[] employer;	 //接受者
	private Date announce;       //发布时间
//	private Date receive;
	private Date submit;		 //提交时间
	private Date deadline;		 //截止时间
	private TaskStatus status = TaskStatus.release;
						         //任务状态  
	
	private String attachmentFileName;	 //附件
	
	private String assignmentFileName;     //作品
	@Column(length = 60)
	public String getAttachmentFileName() {
		return attachmentFileName;
	}

	public void setAttachmentFileName(String attachmentFileName) {
		this.attachmentFileName = attachmentFileName;
	}
	@Column(length = 40)
	public String getAssignmentFileName() {
		return assignmentFileName;
	}

	public void setAssignmentFileName(String assignmentFileName) {
		this.assignmentFileName = assignmentFileName;
	}

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	
	
	/**
	 * 
	 * @hibernate.id
	 */
	@Id 
	@Column(length = 40)
	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}
	
	
	
	public Task() {
		
	}
	@Column(length = 50 , nullable = false)
	public String getTtitle() {
		return ttitle;
	}
	
	public void setTtitle(String ttitle) {
		this.ttitle = ttitle;
	}
	@Column(columnDefinition="TEXT" , nullable =false)
	public String getTcontent() {
		return tcontent;
	}

	public void setTcontent(String tcontent) {
		this.tcontent = tcontent;
	}
	@ManyToOne(optional = false)	
	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	public Date getAnnounce() {
		return announce;
	}

	public void setAnnounce(Date announce) {
		this.announce = announce;
	}
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	public Date getSubmit() {
		return submit;
	}

	public void setSubmit(Date submit) {
		this.submit = submit;
	}
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}
}
