package com.xfxmcy.action.menu;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.xfxmcy.action.base.XfxmcyBaseAction;
import com.xfxmcy.page.pojo.TreeNode;
import com.xfxmcy.service.MenuService;

/**
 * @author CY
 * @Date   05-06	
 * @description  action for coping with menu
 * @version		 0.0.1-SNAPSHOT
 */

@ParentPackage("xfxmcyBasePackage") 
@Namespace("")	
@Action("menuOperation")	

public class MenuOperation extends XfxmcyBaseAction {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MenuOperation.class);
	
	
	private MenuService menuServiceImpl;

	private String id;
	
	public void setId(String treeId) {
		this.id = treeId;
	}

	@Resource
	public void setMenuServiceImpl(MenuService menuServiceImpl) {
		this.menuServiceImpl = menuServiceImpl;
	}

	private static final long serialVersionUID = 1L;
	
	public String ctrlTree() throws Exception{		
		logger.info("structure menu tree");
		List<TreeNode> menus = menuServiceImpl.ctrlMenuTree(id);
		super.writeJson(menus);
		super.releaseResource(menuServiceImpl ,id);
		return null;
	}
}
