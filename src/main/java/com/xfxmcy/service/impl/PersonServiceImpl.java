package com.xfxmcy.service.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xfxmcy.dao.PersonDao;
import com.xfxmcy.page.pojo.Folks;
import com.xfxmcy.service.PersonService;
import com.xfxmcy.util.XfxmcyDataGrid;
import com.xfxmcy.util.XfxmcyUtil;


/**
 * @author CY
 * @Date 20-07
 * @description implements personService   
 * @version 0.0.1-SNAPSHOT
 */
@Service
@Transactional
public class PersonServiceImpl implements PersonService {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(PersonServiceImpl.class);

	@Resource
	private PersonDao personDaoImpl;

	private XfxmcyDataGrid xfxmcyDataGrid;
	
	@Override
	public XfxmcyDataGrid queryPersons(String tableName ,String page, String pageSize) {
		List<Integer> list = XfxmcyUtil.getPagedNumber(page , pageSize);
		String hql = "from "+tableName;
		return constructDataGrid(tableName, list, hql);
	}
	

	@Override
	public XfxmcyDataGrid queryPersons(String tableName, String page, String rows,
			Folks flok) {
		List<Integer> list = XfxmcyUtil.getPagedNumber(page , rows);
		String hql = "from " + tableName;
		hql = reflectConstructCondition(hql , flok);
		return constructDataGrid(tableName, list, hql);
	}
	/**
	 * construct hql by reflect 
	 * @param hql	hql
	 * @param folk  condition
	 * @return	final hql condition
	 */
	/* pause ... have a problem ,then a complex method instead of it transient*/
	private String reflectConstructCondition(String hql, Folks folk) {
		/*
		Field[] fields = flok.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			
		}
		*/
		boolean andSign = false;
		if(null == folk)
			return hql;
		else{
			hql = hql + " where ";		
			if(null != folk.getPname() && !"".equals(folk.getPname().trim())){
				hql	 = hql + "pname like '%%"+folk.getPname()+"%%'";
				andSign = true;
			}
			if(true == andSign)
				hql = hql + " and ";
			
				if(null != folk.getPrebirthday() && !"".equals(folk.getPrebirthday()) && null != folk.getEndbirthday() && !"".equals(folk.getEndbirthday())){
					andSign = false;
					if(folk.getPrebirthday().compareTo(folk.getEndbirthday()) < 0){
						hql	 = hql + "pbirthday between '" + folk.getPrebirthday() + "' and '" +folk.getEndbirthday()+"'" ;
					}
					else if(folk.getPrebirthday().compareTo(folk.getEndbirthday()) == 0){
						hql	 = hql + "pbirthday = '"+folk.getEndbirthday()+"'";
					}
					else{
						hql	 = hql + "pbirthday between '" + folk.getEndbirthday() + "' and '" +folk.getPrebirthday()+"'" ;
					}
				}
				else if(null != folk.getPrebirthday() && !"".equals(folk.getPrebirthday())){
					andSign = false;
					hql	 = hql + "pbirthday  > '" + folk.getPrebirthday() +"'";
				}
					else if(null != folk.getEndbirthday() && !"".equals(folk.getEndbirthday())){
						andSign = false;
						hql	 = hql + "pbirthday  < '" + folk.getEndbirthday() +"'";
					}
			
			if(true == andSign)
				hql = hql.substring(0, hql.indexOf("and"));
			logger.info("reflectConstructCondition have constructed hql : " + hql);
			return hql;
		}
	}

	/**
	 * 构造 datdagrid
	 * @param tableName	tableName
	 * @param list		paged description
	 * @param hql		hql
	 * @return datagrid	
	 */
	private XfxmcyDataGrid constructDataGrid(String tableName,
			List<Integer> list, String hql) {
		xfxmcyDataGrid = new XfxmcyDataGrid();
		xfxmcyDataGrid.setRows(personDaoImpl.queryYsByPaging(hql, null, list.get(0), list.get(1)));
		xfxmcyDataGrid.setTotal(personDaoImpl.queryCountByHql("select count(*) " + hql  , null));
		return xfxmcyDataGrid;
	}
		

}
