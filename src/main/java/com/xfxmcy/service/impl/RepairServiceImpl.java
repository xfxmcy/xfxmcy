package com.xfxmcy.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xfxmcy.component.RepairConstant;
import com.xfxmcy.dao.MenuDao;
import com.xfxmcy.pojo.Menu;
import com.xfxmcy.pojo.Person;
import com.xfxmcy.service.RepairService;


/**
 * @author CY
 * @Date 20-07
 * @description implements repairService for database  
 * @version 0.0.1-SNAPSHOT
 */
@Service
@Transactional
public class RepairServiceImpl implements RepairService{
	
	@Resource
	private RepairConstant repairConstant;
	
	@Resource
	private MenuDao  menuDaoImpl;
	//private PersonDao personDaoImpl;
	@Override
	public void repair() {		
		repairMenu(); 
	//	repairPerson();
	}

	private void repairPerson() {
		List<Person> list = repairConstant.getAdminList();
		if(null != list){
	//		for(Person person : list)
	//			menuDaoImpl.saveOrUpdate(person);
		}
		
	}

	private void repairMenu() {
		List<Menu> list = repairConstant.getMenuList();
		if(null != list){
			for(Menu menu : list)
				menuDaoImpl.saveOrUpdate(menu);
		}
		
	}

}
