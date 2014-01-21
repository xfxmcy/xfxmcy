package com.xfxmcy.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xfxmcy.dao.MenuDao;
import com.xfxmcy.page.pojo.TreeNode;
import com.xfxmcy.pojo.Menu;
import com.xfxmcy.service.MenuService;

/**
 * @author CY
 * @Date   05-06	
 * @description	implements service of named menu
 * @version	0.0.1-SNAPSHOT
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService {
	
	private Logger logger = Logger.getLogger(MenuServiceImpl.class);
	
	@Resource
	private MenuDao menuDaoImpl;
	
	@Override
	public List<TreeNode> ctrlMenuTree(String treeId) {
		List<Menu> xfxmcy = null;
		String  hql = null; 
		if (null != treeId && !treeId.trim().equals("")) {
			hql = "from Menu m where m.menu.id = :pid order by m.seq";
			Map<String, Object> param = new HashMap<String,Object>();
			param.put("pid", treeId);
			xfxmcy = menuDaoImpl.queryYs(hql, param);
		}
		else{
			hql = "from Menu m where m.menu is null order by m.seq";
			xfxmcy = menuDaoImpl.queryYs(hql);
		}	
		List<TreeNode> tree = new ArrayList<TreeNode>();
		if(null != xfxmcy){
			for (Menu xfxmcyMenu : xfxmcy) {
				tree.add(buildTree(xfxmcyMenu, false));
			}
		}
		return tree;
	}
		
    /**
     * create tree  for node 
     * @param xfxmcy
     * @param recursive
     * @return
     */
	private TreeNode buildTree(Menu xfxmcy, boolean recursive) {
		TreeNode node = new TreeNode();
		node.setId(xfxmcy.getId());
		node.setText(xfxmcy.getText());
		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("url", xfxmcy.getUrl());
		node.setAttributes(attributes);
		if (null != xfxmcy.getCiconcls()) {
			node.setIconCls(xfxmcy.getCiconcls());
		} else {
			node.setIconCls("");
		}  
		String  hql = "from Menu m where m.menu.id = :pid order by m.seq";
		Map<String, Object> param = new HashMap<String,Object>();
		param.put("pid", xfxmcy.getId());
		List<Menu> xfxmcyList = menuDaoImpl.queryYs(hql, param);
		if(xfxmcyList == null || 0 == xfxmcyList.size()){
			/*无子菜单*/
			node.setState("open");		
		}		
		
		return node;
	}
}
