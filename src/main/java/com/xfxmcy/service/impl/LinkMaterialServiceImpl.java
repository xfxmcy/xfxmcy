package com.xfxmcy.service.impl;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xfxmcy.dao.LinkMaterialDao;
import com.xfxmcy.page.pojo.TreeLinkMaterialNode;
import com.xfxmcy.pojo.LinkMaterial;
import com.xfxmcy.service.LinkMaterialService;
import com.xfxmcy.util.XfxmcyDataGrid;
import com.xfxmcy.util.XfxmcyUtil;
/**
 * @author CY
 * @Date   14-08	
 * @description	implements service of named linkMaterial
 * @version	0.0.1-SNAPSHOT
 */
@Service
@Transactional
public class LinkMaterialServiceImpl implements LinkMaterialService {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(LinkMaterialServiceImpl.class);
	
	@Resource
	private LinkMaterialDao linkMaterialDaoImpl;
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
	@Override
	public XfxmcyDataGrid ctrlTreeGridLinkMaterial(String page,
			String rows) {
		
		List<Integer> list = XfxmcyUtil.getPagedNumber(page , rows);
	//	String hql = "from LinkMaterial";
	//	List<LinkMaterial> listLinkMaterial = linkMaterialDaoImpl.queryYsByPaging(hql, null, list.get(0), list.get(1));
	//  06/9   分页显示改为每页显示   xfxmcy 下的一个直接子节点
		String hql = "from LinkMaterial as link where link.material.mid =1";
		List<LinkMaterial> listLinkMaterial = linkMaterialDaoImpl.queryYsByPaging(hql, null, list.get(0), list.get(1));
		/*null  只显示 root*/
		if(null == listLinkMaterial || 0 == listLinkMaterial.size()){
			hql = "from LinkMaterial as link where link.mid =1";
			listLinkMaterial = linkMaterialDaoImpl.queryYs(hql);
		}	
		/* 遍历 */
		else{	
			Integer cy = listLinkMaterial.size();
			for (int i = 0; i < cy; i++) {
				listLinkMaterial = appendFooter(listLinkMaterial , listLinkMaterial.get(i));
			}
			
			listLinkMaterial = appendHeader(listLinkMaterial);
		}
		return convertDataGrid(convertLinkMaterialGrid(listLinkMaterial) , linkMaterialDaoImpl.queryCountByHql("select count(*) "+ hql, null).intValue());
	}
	
	private XfxmcyDataGrid convertDataGrid(
			List<TreeLinkMaterialNode> convertLinkMaterialGrid , Integer page) {
		
		return new XfxmcyDataGrid(page.longValue() , convertLinkMaterialGrid);
	}
	/**
	 * 转换treegrid
	 * @param listLinkMaterial listLinkMaterial
	 * @return treegrid
	 */
	private List<TreeLinkMaterialNode> convertLinkMaterialGrid(
			List<LinkMaterial> listLinkMaterial) {
		List<TreeLinkMaterialNode> listTreeGrid = new ArrayList<TreeLinkMaterialNode>();
		TreeLinkMaterialNode node = null;
		for (LinkMaterial lMaterial : listLinkMaterial) {
			node = new TreeLinkMaterialNode();
			BeanUtils.copyProperties(lMaterial, node);
			node.setId(lMaterial.getMid());
			if(null != lMaterial.getMaterial()){
				node.setParentId((lMaterial.getMaterial().getMid()));
			}
			listTreeGrid.add(node);
		}
		return listTreeGrid;
	}
	/**
	 * 遍历父节点
	 * @param listLinkMaterial	listLinkMaterial
	 * @return 完整的link tree
	 */
	private List<LinkMaterial> appendHeader(List<LinkMaterial> listLinkMaterial) {
			
		if(null == listLinkMaterial||0 == listLinkMaterial.size())
		{
			return null;
		}
		else{
			/*root*/
			if(null == listLinkMaterial.get(0).getMaterial()){
				return listLinkMaterial;
			}
			/*非root*/
			else{
				String hql = "from LinkMaterial as linkMater where linkMater.mid = '" + listLinkMaterial.get(0).getMaterial().getMid() +"'";
				List<LinkMaterial> listMaterial = linkMaterialDaoImpl.queryYs(hql);
				if(null == listMaterial || 0 == listMaterial.size()){
					return listLinkMaterial;
				}else{
					listLinkMaterial.add(0, listMaterial.get(0));
					appendHeader(listLinkMaterial);
				}
				
			}
		}
		return listLinkMaterial;
	}
	/**
	 * 遍历子节点
	 * @param listLinkStore     store
	 * @param listLinkMaterial	listLinkMaterial
	 * @return 完整的link tree
	 */
	private List<LinkMaterial> appendFooter(List<LinkMaterial> listLinkStore , LinkMaterial material) {
		if(null == material)  
			return null;
		/*查找子节点 长度为0 return list*/
		String hql = "from LinkMaterial as linkMater where linkMater.material.mid = '" + material.getMid() +"'";
		List<LinkMaterial> listMaterial = linkMaterialDaoImpl.queryYs(hql);
		if(null == listMaterial || 0 == listMaterial.size()){
			return listLinkStore;
		}else{
			for(int i = 0 ; i < listMaterial.size(); i++ ){
				listLinkStore.add(listMaterial.get(i));
				appendFooter(listLinkStore, listMaterial.get(i));
				
			}

			/*查找子节点 长度大于0 return appendFooter(listStore,list)*/
			
		}
				return listLinkStore;
	}
	
	@Override
	public LinkMaterial persistenceLinkMaterial(LinkMaterial linkMaterial) {
		String uuid = UUID.randomUUID().toString();
		linkMaterial.setPersistDate(new Date());
		linkMaterial.setMid(uuid);
		if(linkMaterialDaoImpl.persistence(linkMaterial)){
			return linkMaterial;
		}else{
			return null;
		}
		
	}

	@Override
	public boolean mergeLinkMaterial(LinkMaterial linkMaterial) {
		return linkMaterialDaoImpl.mergeY(linkMaterial) != null ;
	}

	@Override
	public void deleteLinkMaterial(LinkMaterial linkMaterial) {
		linkMaterialDaoImpl.deleteY(linkMaterial);
	}
}
