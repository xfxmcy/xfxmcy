package com.xfxmcy.service;

import java.util.List;

import com.xfxmcy.page.pojo.TreeNode;
import com.xfxmcy.pojo.Menu;



/**
 * @author CY
 * @Date 05-06
 * @description services for menu
 * @version 0.0.1-SNAPSHOT
 */
public interface MenuService {
	/**
	 * @description  create menuTree and show it
	 * @return   	 treeNodes 
	 */
	List<TreeNode> ctrlMenuTree(String treeId);
}