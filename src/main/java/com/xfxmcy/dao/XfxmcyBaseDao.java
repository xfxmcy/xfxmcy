package com.xfxmcy.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.xfxmcy.pojo.Menu;
import com.xfxmcy.pojo.Person;

/**
 * @author CY
 * @Date   29-05
 * @description	 the  baseDao in this project
 * @version	 0.0.1 SNAPSHOT
 */
public interface XfxmcyBaseDao<Y> {
	/**
	 * 
	 * @param object transient object //Detached Persistent
	 * @description  transient object is stored
	 * @return result	
	 */
	 boolean persistence (Y object);
	 /**
	 * provide a method for getting session to subclass
	 * @return session
	 */
     Session getCurrentSessionByXfxmcyBase();
     /**
      * Person query
      * @param person person
      * @return result for operator
      */
	 Person personQueryByHql(String hql);
	 
	 /**
	  * query person by account
	  * @param person
	  * @return	result person
	  
	 Person queryPersonByPaccount(Person person);
	*/
	 /**
	  * query Y by hql
	  * @param hql  hql
	  * @param param query condition and value
	  * @return Y
	  */
	 Y queryByHql(String hql,Map<String,Object> param);
	 /**
	  * delete  Y
	  * @param y is deleted
	  * 
	  */
	 void deleteY(Y y);
	 /**
	  * saveOrUpdate
	  * @param y be updated
	  * 
	  */
	 void saveOrUpdate(Y y);
	 /**
	  * merge  Y
	  * @param y is merged
	  * @return  result
	  */
	 Object mergeY(Y y);
	 /**
	  * query list of y
	  * @param hql hql
	  * @return list
	  */
	 List<Y> queryYs(String hql);
	 /**
	  * query list of y acquire param
	  * @param hql  hql
	  * @param param param
	  * @return list
	  */
	 List<Y> queryYs(String hql,Map<String,Object> param);
	 /**
	  * pageing list of Y
	  * @param hql hql
	  * @param param param 
	  * @param page  current page
	  * @param pageSize rows for every page
	  * @return list list
	  */
	 List<Y> queryYsByPaging(String hql,Map<String,Object> param, Integer page ,Integer pageSize);
	 /**
	  * query count
	  * @param hql   hql
	  * @param param param
	  * @return count 
	  */
	 Long queryCountByHql(String hql ,Map<String,Object> param);
	 /**
	  * create query assume param of Map
	  * @param hql  sql
	  * @param param param
	  * @return  query
	  */
	 Query createQueryByMap(String hql, Map<String, Object> param);
	 /**
	  * create query assume param of Map by paging
	  * @param hql sql
	  * @param param param
	  * @param page current page
	  * @param pageSize pageSize
	  * @return  query
	  */
	 Query createQueryByMapPaging(String hql, Map<String, Object> param,Integer page ,Integer pageSize);
}
