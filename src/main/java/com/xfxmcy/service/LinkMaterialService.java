package com.xfxmcy.service;

import java.util.List;

import com.xfxmcy.page.pojo.TreeLinkMaterialNode;
import com.xfxmcy.pojo.LinkMaterial;
import com.xfxmcy.util.XfxmcyDataGrid;

/**
 * @author CY
 * @Date 14-08
 * @description services for link material
 * @version 0.0.1-SNAPSHOT
 */
public interface LinkMaterialService {
	/**
	 * control treegrid to show link material 
	 * @param page  current page string
	 * @param count count in every page
	 * @return dataGrid for entityPaged
	 */
	public XfxmcyDataGrid ctrlTreeGridLinkMaterial(String page, String count);
	/**
	 * persistence linkMaterial
	 * @param linkMaterial
	 * @return object be persistenced if success
	 */
	public LinkMaterial persistenceLinkMaterial(LinkMaterial linkMaterial);
	/**
	 * merge linkMaterial
	 * @param linkMaterial linkMaterial
	 * @return result if  success return true
	 */
	public boolean mergeLinkMaterial(LinkMaterial linkMaterial);
	/**
	 * delete linkMaterial
	 * @param linkMaterial  linkMaterial
	 */
	public void deleteLinkMaterial(LinkMaterial linkMaterial);
}
