package com.xfxmcy.action.material;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.xfxmcy.action.base.XfxmcyBaseAction;
import com.xfxmcy.pojo.LinkMaterial;
import com.xfxmcy.service.LinkMaterialService;
import com.xfxmcy.util.InformationXfxmcy;
import com.xfxmcy.util.XfxmcyDataGrid;

/**
 * @author CY
 * @Date   14-08	
 * @description  action for coping with linkMaterial
 * @version		 0.0.1-SNAPSHOT
 */

@ParentPackage("xfxmcyBasePackage") 
@Namespace("")	
@Action("linkOperation")	
public class LinkMaterialOperation extends XfxmcyBaseAction{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(LinkMaterialOperation.class);
	
	private LinkMaterial linkMaterial;
	
	private String parentId;
	
	private String mid;
	
	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public LinkMaterial getLinkMaterial() {
		return linkMaterial;
	}

	public void setLinkMaterial(LinkMaterial linkMaterial) {
		this.linkMaterial = linkMaterial;
	}

	private LinkMaterialService linkMaterialServiceImpl;
	
	private String rows,page;
	
	private String id;
	
	public void setId(String treeId) {
		this.id = treeId;
	}
	
	public String getRows() {
		return rows;
	}


	public void setRows(String rows) {
		this.rows = rows;
	}


	public String getPage() {
		return page;
	}


	public void setPage(String page) {
		this.page = page;
	}

	private static final long serialVersionUID = 1L;
	@Resource
	public void setLinkMaterialServiceImpl(
			LinkMaterialService linkMaterialServiceImpl) {
		this.linkMaterialServiceImpl = linkMaterialServiceImpl;
	}
	
	/**
	 * query by  paged
	 */
	public void queryLinkMaterial(){
		XfxmcyDataGrid materialsDG  = null;
		try{
			/*无条件的*/
			materialsDG = linkMaterialServiceImpl.ctrlTreeGridLinkMaterial(page, rows);
			/*过滤条件的*/
			super.writeTreeGridJson(materialsDG);
		}catch(Exception e){
			logger.error(e.getMessage());
		}finally{
			super.releaseResource(linkMaterialServiceImpl ,id,materialsDG);
		}	
	}
	
	/**
	 * save linkMaterial
	 */
	public void persistLinkMaterial(){
		InformationXfxmcy xfxmcy = null;
		try{
			xfxmcy = new InformationXfxmcy();
			linkMaterial.setMaterial(new LinkMaterial(parentId));
			LinkMaterial material = linkMaterialServiceImpl.persistenceLinkMaterial(linkMaterial);
			if(null != material){
				xfxmcy.setSuccess(true);
				xfxmcy.setMessage("成功");
				xfxmcy.setOtherMessage(material);
			}else{
				xfxmcy.setSuccess(false);
				xfxmcy.setMessage("操作失败,请您稍后进行");
			}
			super.writeJson(xfxmcy);			
		}catch(Exception e){
			logger.error(e.getMessage());
			xfxmcy.setSuccess(false);
			xfxmcy.setMessage("操作失败,请您稍后进行");
		}finally{
			super.releaseResource(linkMaterialServiceImpl);
		}	
	}
	
	/**
	 * delete linkMaterial
	 */
	public void deleteLinkMaterial(){
		InformationXfxmcy xfxmcy = null;
		xfxmcy = new InformationXfxmcy();
		
		try{
			linkMaterialServiceImpl.deleteLinkMaterial(linkMaterial);
			xfxmcy.setSuccess(true);
			xfxmcy.setMessage("成功");
		}catch(Exception e){
			logger.error(e.getMessage());
			xfxmcy.setSuccess(false);
			xfxmcy.setMessage("操作失败,请您稍后进行");
			
		}	
		finally{
			super.writeJson(xfxmcy);
			super.releaseResource(linkMaterialServiceImpl);
		}	
	}	
	
	/**
	 * update linkMaterial
	 */
	public void mergeLinkMaterial(){
		InformationXfxmcy xfxmcy = null;
		try{
			xfxmcy = new InformationXfxmcy();
			linkMaterial.setMid(mid);
			linkMaterial.setMaterial(new LinkMaterial(parentId));
			linkMaterial.setPersistDate(new Date());
			if(true == linkMaterialServiceImpl.mergeLinkMaterial(linkMaterial)){
				xfxmcy.setSuccess(true);
				xfxmcy.setMessage("成功");
			}else{
				xfxmcy.setSuccess(false);
				xfxmcy.setMessage("操作失败,请您稍后进行");
			}
			super.writeJson(xfxmcy);			
		}catch(Exception e){
			logger.error(e.getMessage());
			xfxmcy.setSuccess(false);
			xfxmcy.setMessage("操作失败,请您稍后进行");
		}finally{
			super.releaseResource(linkMaterialServiceImpl);
		}	
	}
}
