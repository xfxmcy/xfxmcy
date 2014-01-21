package com.xfxmcy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xfxmcy.dao.TaskDao;
import com.xfxmcy.pojo.Task;
import com.xfxmcy.service.TaskService;

/**
 * @author CY
 * @Date   31-05	
 * @description	implements service of named task 
 * @version	0.0.1-SNAPSHOT
 */
@Service
@Transactional
public class TaskServiceImpl implements TaskService {
	
	@Resource
	private TaskDao taskDaoImpl;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String persistence(Task task) {
		
		taskDaoImpl.persistence(task);
		
		return null;
	}
	@Override
	@Transactional(readOnly = true ,propagation = Propagation.NOT_SUPPORTED)
	public String findAllByType(String start, String count) {
		
		//List<Task> list = taskDaoImpl.findAllByType(start, count);
		
		
		return null;
	}
		
}
