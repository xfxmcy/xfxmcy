package com.xfxmcy.action.base;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;

import com.xfxmcy.service.RepairService;

/**
 * @author CY
 * @Date   21-07	
 * @description	 repair data 
 * @version   0.0.1-SNAPSHOT
 */
@Action("repairAction")
public class RepairAction extends XfxmcyBaseAction {

	private static final long serialVersionUID = -8262437783888315134L;
	
	@Resource
	RepairService repairServiceImpl;
	
	public String init() throws Exception {
		
		repairServiceImpl.repair();
		
		return null;
	}
	
	
}
