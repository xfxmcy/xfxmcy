package com.xfxmcy.action.person;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.xfxmcy.action.base.XfxmcyBaseAction;
import com.xfxmcy.page.pojo.Folks;
import com.xfxmcy.pojo.Employer;
import com.xfxmcy.service.PersonService;
import com.xfxmcy.service.XfxmcyMutualService;
import com.xfxmcy.util.InformationXfxmcy;
import com.xfxmcy.util.XfxmcyDataGrid;

/**
 * @author CY
 * @Date   23-07	
 * @description  action for coping with person
 * @version		 0.0.1-SNAPSHOT
 */

@ParentPackage("xfxmcyBasePackage") 
@Namespace("")	
@Action("personOperation")	
public class PersonOperation extends XfxmcyBaseAction {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(PersonOperation.class);
	
	private String rows,page;
	
	private Employer employer;
	
	private Folks  folk;
	
	
	public Folks getFolk() {
		return folk;
	}

	public void setFolk(Folks folk) {
		this.folk = folk;
	}

	@Resource
	private XfxmcyMutualService xfxmcyMutualServiceImpl;

	
	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getRows() {
		return rows;
	}

	public String getPage() {
		return page;
	}

	private static final long serialVersionUID = -2493322151939269897L;
	
	@Resource
	private PersonService  personServiceImpl;
	/* query employer*/
	public String browseEmployer(){
		XfxmcyDataGrid dataGrid = null;
		try{
			if(null == folk){
				dataGrid  = personServiceImpl.queryPersons("Employer",page, rows);
			}
			else{
				dataGrid  = personServiceImpl.queryPersons("Employer",page, rows , folk);
			}
			super.writeJson(dataGrid);
		}catch(Exception e){
			logger.error("browseEmployer  error  " +  e.getMessage());
		}
		 
		releaseResource(dataGrid,personServiceImpl,page,rows);
		return null;
	}
	/* persist employer*/
	public String persistEmployer() throws Exception{

			logger.info("persist begin" + employer);
			try{
				List<String> messageList = xfxmcyMutualServiceImpl.persistencePerson(employer);
				//注册成功
				if(1 < messageList.size()){
					super.writeJson(new InformationXfxmcy(true,"添加成功!",messageList.get(1)));
				}
				//注册失败
				else{
					super.writeJson(new InformationXfxmcy(false,messageList.get(0),null));
				}	
				
			}catch(Exception e){
				
				logger.error("persist failure" + e.getMessage());
				
				super.writeJson(new InformationXfxmcy(false,"操作错误!!",null));
			}	
			return null;
		}
	/* merge employer*/
	public String mergeEmployer() throws Exception{

		logger.info("merge begin" + employer);
		try{
			String  message = null;
			//注册成功
			if(null == message){
				super.writeJson(new InformationXfxmcy(true,"添加成功!",null));
			}
			//注册失败
			else{
				super.writeJson(new InformationXfxmcy(false,message,null));
			}	
			
		}catch(Exception e){
			
			logger.error("persist failure" + e.getMessage());
			
			super.writeJson(new InformationXfxmcy(false,"操作错误!!",null));
		}	
		return null;
	}
	/* remove employer*/
	public String removeEmployer() throws Exception{

		logger.info("merge begin" + employer);
		try{
			String  message = null;
			//注册成功
			if(null == message){
				super.writeJson(new InformationXfxmcy(true,"添加成功!",null));
			}
			//注册失败
			else{
				super.writeJson(new InformationXfxmcy(false,message,null));
			}	
			
		}catch(Exception e){
			
			logger.error("persist failure" + e.getMessage());
			
			super.writeJson(new InformationXfxmcy(false,"操作错误!!",null));
		}	
		return null;
	}
}
