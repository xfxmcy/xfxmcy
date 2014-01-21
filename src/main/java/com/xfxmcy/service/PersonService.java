package com.xfxmcy.service;

import com.xfxmcy.page.pojo.Folks;
import com.xfxmcy.pojo.Employer;
import com.xfxmcy.pojo.Person;
import com.xfxmcy.util.XfxmcyDataGrid;

/**
 * @author CY
 * @Date 23-07
 * @description services for person
 * @version 0.0.1-SNAPSHOT
 */
public interface PersonService {
	
	/**
	 * query persons
	 * @param tableName table  name
	 * @param page		current page
	 * @param pageSize  pageSize
	 * @return dataGrid for  list person
	 */
	public XfxmcyDataGrid queryPersons(String tableName,String page ,String pageSize);
	/**
	 * query persons
	 * @param tableName table  name
	 * @param page		current page
	 * @param pageSize  pageSize
	 * @param folk		query condition	
	 * @return dataGrid for  list person
	 */
	public XfxmcyDataGrid queryPersons(String tableName, String page, String pageSize,
			Folks flok);
	
}
