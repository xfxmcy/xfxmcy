package com.xfxmcy.dao.impl;

import org.apache.log4j.Logger;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xfxmcy.dao.TaskDao;
import com.xfxmcy.pojo.Task;
/**
 * @author CY
 * @Date   31-05	
 * @description	implements TaskDao's operation 
 * @version	0.0.1-SNAPSHOT
 */
@Repository
public class TaskDaoImpl extends XfxmcyBaseDaoImpl<Task> implements TaskDao {
	
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(TaskDaoImpl.class);
	
	public TaskDaoImpl() {
		
	}

	@Override
	public List<Task> findAllByType(int start, int end) {
		logger.info(null == getCurrentSessionByXfxmcyBase());
		return null;
	}
	
}
