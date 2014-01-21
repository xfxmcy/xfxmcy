package com.xfxmcy.service;

import com.xfxmcy.pojo.Task;

/**
 * @author CY
 * @Date 31-05
 * @description services for task
 * @version 0.0.1-SNAPSHOT
 */
public interface TaskService {
	/**
	 * @description persistence object 
	 * 
	 * @param task   transient object

	 * @return result
	 */
	String persistence(Task task);
	/***
	 * @description persistence object 
	 * @param start		start record (not a constant)
	 * @param count		query count	 (not a constant)
	 * @return list to convert  easyUI's json 
	 */
	String findAllByType(String start,String count);
}