package com.xfxmcy.dao;

import java.util.List;

import com.xfxmcy.pojo.Task;

/**
 * @author CY
 * @Date   31-05	
 * @description	operation for task
 * @version	0.0.1-SNAPSHOT
 */
public interface TaskDao extends XfxmcyBaseDao<Task> {
	/**
	 * @description 	according find all tasks by paing 
	 * @param start		start record
	 * @param count		query count
	 * @return			the tasks for querying
	 */
	List<Task> findAllByType(int start,int count);
}