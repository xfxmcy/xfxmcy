package com.xfxmcy.client.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xfxmcy.dao.TaskDao;
import com.xfxmcy.pojo.Menu;
import com.xfxmcy.pojo.Task;
import com.xfxmcy.service.TaskService;
import com.xfxmcy.service.impl.TaskServiceImpl;

/**
 * @author CY
 * @Date   29-05	
 * @description test all operations in xfxmcyBaseDaoImpl 
 * @version		0.0.1 SNAPSHOT
 */
@RunWith(SpringJUnit4ClassRunner.class)  // command instrument is been functioned
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:spring-hibernate.xml"})
public class TestXfxmcyBaseDaoImpl extends AbstractJUnit4SpringContextTests{
	
	@Resource
	private TaskService xf; // xf 变量名不固定
	
	@Test
	public void testPersistence(){
		
		System.out.println(xf instanceof TaskServiceImpl);
	}
	
	@Test
	public void testSemantic(){

			
	}
	
	
}
