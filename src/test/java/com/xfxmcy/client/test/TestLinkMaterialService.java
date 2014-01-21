/**
 * TestLinkMaterialService.java
 * com.xfxmcy.client.test
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2013-9-9 		Administrator
 *
 * Copyright (c) 2013, XFXMCY All Rights Reserved.
*/

package com.xfxmcy.client.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xfxmcy.service.LinkMaterialService;
import com.xfxmcy.service.impl.LinkMaterialServiceImpl;
import com.xfxmcy.service.impl.TaskServiceImpl;
import com.xfxmcy.util.XfxmcyDataGrid;

/**
 * ClassName:TestLinkMaterialService
 * Function: 测试 LinkMaterialService
 * Reason:	 TODO ADD REASON
 *
 * @author   CY
 * @version  
 * @since    Ver 1.1
 * @Date	 2013-9-9		下午2:55:23
 *
 * @see 	 
 *  
 */
@RunWith(SpringJUnit4ClassRunner.class)  // command instrument is been functioned
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:spring-hibernate.xml"})
public class TestLinkMaterialService {

	@Resource
	private LinkMaterialService xf; 
	
	@Test
	public void testQuery(){
		XfxmcyDataGrid result = xf.ctrlTreeGridLinkMaterial("1", "1");
		
		System.out.println(result.getRows());
	}
	
	
}

