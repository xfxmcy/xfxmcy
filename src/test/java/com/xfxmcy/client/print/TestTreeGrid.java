package com.xfxmcy.client.print;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.JSON;
import com.xfxmcy.page.pojo.TreeLinkMaterialNode;
import com.xfxmcy.pojo.LinkMaterial;

public class TestTreeGrid {
	
	@Test
	public void testTreeGridCascade(){
		LinkMaterial material = new LinkMaterial();
		material.setLinkStr("111");
		TreeLinkMaterialNode node = new TreeLinkMaterialNode();
		BeanUtils.copyProperties(material, node);
		node.setId("111"); 
		node.setParentId("22");
		System.out.println(JSON.toJSON(node));
	}
	
	@Test
	public void toJSONString(){
		String json = " [{\"id\":\"1\",\"linkStr\":\"www.baidu.com\",\"mtitle\":\"收藏夹\"},{\"id\":\"2\",\"linkStr\":\"www.google.com\",\"mtitle\":\"Java\",\"parentId\":\"1\",\"persistDate\":1372780800000}]";
		json = json.replace("parentId", "_parentId");
		System.out.println(JSON.toJSON(json));
	}
	
}
