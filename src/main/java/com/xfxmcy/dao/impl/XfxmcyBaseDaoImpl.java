package com.xfxmcy.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.xfxmcy.dao.XfxmcyBaseDao;
import com.xfxmcy.pojo.Person;


/**
 * @author CY
 * @Date   29-05	
 * @description	baseDaoImpl in this project
 * @version	0.0.1 SNAPSHOT
 */
@Repository
public class XfxmcyBaseDaoImpl<Y> implements XfxmcyBaseDao<Y>{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(XfxmcyBaseDaoImpl.class);
	
	@Resource
	SessionFactory sessionFactory;
	
	Session session = null;
	
	@Override
	public Session getCurrentSessionByXfxmcyBase(){
		 session = sessionFactory.getCurrentSession();
		 return session;
	};
	
	public XfxmcyBaseDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean persistence(Y object) {
		
		logger.info("persistence begin");
		try{
			getCurrentSessionByXfxmcyBase().persist(object);
		}catch(Exception exception){
			
			logger.info("persistence exception" + exception.getMessage());
			return false;
		}
		return true;
		
	}

	@Override
	public Person personQueryByHql(String hql) {
		List<Person> list  = null;
		try{
			this.getCurrentSessionByXfxmcyBase();
			list = session.createQuery(hql).list();
		}catch(Exception e){
			e.printStackTrace();
			logger.info("list ??" + e.getMessage());
		}
		
		if(null != list && 0 != list.size())
			return list.get(0);
		return null;
	}

	@Override
	public Y queryByHql(String hql, Map<String, Object> param) {
		List<Y> list  = null;
		list =this.createQueryByMap(hql,param).list(); 
		if(null != list && 0 != list.size())
			return list.get(0);
		return null;
	}
	@Override
	public Query createQueryByMap(String hql, Map<String, Object> param) {
		
		Query query = this.getCurrentSessionByXfxmcyBase().createQuery(hql);
		if(null != param){
			for (Map.Entry<String, Object> mapEntry : param.entrySet()) {
				query.setParameter(mapEntry.getKey(), mapEntry.getValue());
			}
		}		
		return query;
	}
	@Override
	public Query createQueryByMapPaging(String hql, Map<String, Object> param,Integer page ,Integer pagesize) {
		Query query = this.getCurrentSessionByXfxmcyBase().createQuery(hql);
		if(null != param){
			for (Map.Entry<String, Object> mapEntry : param.entrySet()) {
				query.setParameter(mapEntry.getKey(), mapEntry.getValue());
			}
		}
		query.setFirstResult((page-1)*pagesize);
		query.setMaxResults(pagesize);
		return query;
	}
	@Override
	public void deleteY(Y y) {
		this.getCurrentSessionByXfxmcyBase().delete(y);
	}

	@Override
	public Object mergeY(Y y) {
		return this.getCurrentSessionByXfxmcyBase().merge(y); 
	}

	@Override
	public List<Y> queryYs(String hql) {
		logger.info("List<Y> queryYs");
		return this.getCurrentSessionByXfxmcyBase().createQuery(hql).list();
	}

	@Override
	public List<Y> queryYs(String hql, Map<String, Object> param) {
		// TODO Auto-generated method stub
		return this.createQueryByMap(hql, param).list();
	}

	@Override
	public List<Y> queryYsByPaging(String hql, Map<String, Object> param,
			Integer page, Integer pageSize) {
		return createQueryByMapPaging(hql, param, page, pageSize).list();
	}

	@Override
	public Long queryCountByHql(String hql ,Map<String,Object> param) {
		return (Long) this.createQueryByMap(hql, param).uniqueResult();
	}

	@Override
	public void saveOrUpdate(Y y) {
		this.getCurrentSessionByXfxmcyBase().saveOrUpdate(y);
		
	}
	
	
}
