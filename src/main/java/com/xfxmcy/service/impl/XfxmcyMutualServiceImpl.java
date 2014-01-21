package com.xfxmcy.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xfxmcy.dao.XfxmcyBaseDao;
import com.xfxmcy.pojo.Person;
import com.xfxmcy.service.XfxmcyMutualService;
import com.xfxmcy.util.Encrypt;

/**
 * @author CY
 * @Date   15-07	
 * @description	serviceImpl  implements common services for all the roles
 * @version	0.0.1-SNAPSHOT
 */
@Service
@Transactional
public class XfxmcyMutualServiceImpl implements XfxmcyMutualService {
	
	private XfxmcyBaseDao<Person> xfxmcyBaseDaoImpl;
	@Resource
	public void setXfxmcyBaseDaoImpl(XfxmcyBaseDao<Person> xfxmcyBaseDaoImpl) {
		this.xfxmcyBaseDaoImpl = xfxmcyBaseDaoImpl;
	}

	@Override
	@Transactional(readOnly = true ,propagation = Propagation.NOT_SUPPORTED)
	public Person isPersonLogin(Person person) {		
		return xfxmcyBaseDaoImpl.personQueryByHql("from "+person.getClass().getSimpleName()+"  where paccount= '"+person.getPaccount()+"' and ppwd = '"+person.getPpwd()+"'");
	}
	
	@Override
	@Transactional(readOnly = true ,propagation = Propagation.NOT_SUPPORTED)
	public boolean isExists(Person employer) {
		
		if(null == xfxmcyBaseDaoImpl.personQueryByHql("from  Employer where paccount= '"+employer.getPaccount()+"'")){	
			if(null == xfxmcyBaseDaoImpl.personQueryByHql("from Administrator  where paccount= '"+employer.getPaccount()+"'"))				
				return false;
			return true;
		}
		return true;
	}

	@Override
	public List<String> persistencePerson(Person employer) {
		List<String> list = new ArrayList<String>();
		String uuid = null;
		boolean flag = false;
		//用户名不存在
		if(false ==this.isExists(employer)){
			uuid = UUID.randomUUID().toString();
			employer.setPid(uuid);
			employer.setPpwd(Encrypt.sha(employer.getPpwd())); 
			flag = xfxmcyBaseDaoImpl.persistence(employer);
			//注册失败
			if(false == flag){
				list.add("操作失败,请重新操作");
				return list;
			}//注册成功
			 else{
				list.add("success");
				list.add(uuid);
				return list;
			}
		}
		//用户名已经存在
		else{
			list.add("操作失败,账号已经存在");
			return list;
		}
		 
	}

}
