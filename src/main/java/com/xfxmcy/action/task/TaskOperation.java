package com.xfxmcy.action.task;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.xfxmcy.action.base.XfxmcyBaseAction;
import com.xfxmcy.pojo.Task;
import com.xfxmcy.service.TaskService;

/**
 * @author CY
 * @Date   31-05	
 * @description  action for coping with task
 * @version		0.0.1-SNAPSHOT
 */

@ParentPackage("xfxmcyBasePackage") 
@Namespace("")	
@Action("taskOperation")	
public class TaskOperation extends XfxmcyBaseAction {
	
	@Resource
	private TaskService taskServiceImpl;
	
	private Task task;
	
	private static final long serialVersionUID = 1L;
	/**
	 *  persistence task
	 */
	public void persistenceTask(){
		
		taskServiceImpl.persistence(task);
	}
	
}
