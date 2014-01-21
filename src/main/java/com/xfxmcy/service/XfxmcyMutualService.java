package com.xfxmcy.service;

import java.util.List;

import com.xfxmcy.pojo.Employer;
import com.xfxmcy.pojo.Person;

/**
 * @author CY
 * @Date   31-05	
 * @description	common services for all the roles
 * @version	0.0.1-SNAPSHOT
 */

public interface XfxmcyMutualService {
	/**
	 * person login
	 * @param person
	 * @return 登陆后的person,登陆失败返回null
	 */
	Person isPersonLogin(Person person);
	/**
	 * whether employer's paccount is  existed
	 * @param employer
	 * @return result information if exists return true, not exist return false 
	 */
	boolean isExists(Person employer);
	/**
	 * persistence person
	 * @param person
	 * @return	result information. If success then return list include id 
	 */
	List<String> persistencePerson(Person person);
	
	
}
