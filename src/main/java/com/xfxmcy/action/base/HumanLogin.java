package com.xfxmcy.action.base;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.xfxmcy.pojo.Administrator;
import com.xfxmcy.pojo.Employer;
import com.xfxmcy.pojo.Person;
import com.xfxmcy.service.XfxmcyMutualService;
import com.xfxmcy.util.Encrypt;
import com.xfxmcy.util.InformationXfxmcy;
import com.xfxmcy.util.IpUtil;
import com.xfxmcy.util.ResourceUtil;
import com.xfxmcy.util.SessionInfo;
/**
 * @author CY
 * @Date   30-05	
 * @description  login operation by all the user
 * @version		0.0.1-SNAPSHOT
 */

@ParentPackage("xfxmcyBasePackage") //because extends XfxmcyBaseAction
@Namespace("")	
@Action("humanLogin")	
//this class will be added into spring's context  by this annotation if  struts-plugin.jar is existing in area named classPath  
public class HumanLogin extends XfxmcyBaseAction {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(HumanLogin.class);
	
	private HttpServletRequest request; //request
	/**
	 *  automatic construction	by MyEclipse 
	 */
	private static final long serialVersionUID = 1L;
	
	private Employer employer ;  //index.jsp employer 
	
	private String role  ;		//index.jsp role
	private String rePassword;  // no using avoid warning for not setter 
	
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setEmployer(Employer employer) {
		this.employer = employer;
	}
	private Administrator administrator;
	
	public Administrator getAdministrator() {
		return administrator;
	}
	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}
	public HumanLogin() {
		
	}

	@Resource
	private XfxmcyMutualService xfxmcyMutualServiceImpl;
	//@Action("humanLogin")	 action is there  that  is equality for <action  name=""   class="" method=""/>
	public String loginMutual() throws Exception{
			//工作人员登录
		if("Employer".equals(role)){
			employer.setPpwd(Encrypt.sha(employer.getPpwd()));
			personLogin(employer);
				
		}//管理员登陆
		else if("Admin".equals(role)){	
			administrator.setPpwd(Encrypt.sha(administrator.getPpwd()));
			personLogin(administrator);	
		}//error
		else{
			super.writeJson(new InformationXfxmcy(false,"网络延迟,请重新登陆!",null));
			logger.info("request error");
		}
		super.releaseResource(employer , administrator , role);
		return null;
	}
	/**
	 * person login
	 * @param person person
	 */
	private void personLogin(Person person) {
		try{
			Person employerLogined = xfxmcyMutualServiceImpl.isPersonLogin(person);
			//登陆成功
			if(null != employerLogined){
				//request = ServletActionContext.getRequest();
				//request.getSession().setAttribute("personLogined", employerLogined);
				//request.getSession().setAttribute("personRole", person.getClass().getSimpleName());
				SessionInfo sessionInfo = saveInSession(employerLogined);
				super.writeJson(new InformationXfxmcy(true,"登陆成功!",sessionInfo));
			}
			else{
				super.writeJson(new InformationXfxmcy(false,"信息错误,登陆失败!",null));
			}
		}catch(RuntimeException run){
			logger.error("personLogin  " +  run.getMessage());
			super.writeJson(new InformationXfxmcy(false,"信息或网络异常,登陆失败!",null));
		}
	}
	/**
	 * 保存登录人信息到session
	 * @param employerLogined
	 * @return SessionInfo 
	 */
	private SessionInfo saveInSession(Person employerLogined) {
		SessionInfo sessionInfo = new SessionInfo();
		sessionInfo.setUserId(employerLogined.getPid());
		sessionInfo.setLoginName(employerLogined.getPaccount());
		sessionInfo.setLoginPassword(employerLogined.getPpwd());
		sessionInfo.setIp(IpUtil.getIpAddr(ServletActionContext.getRequest()));
		ServletActionContext.getRequest().getSession().setAttribute(ResourceUtil.getSessionInfoName(), sessionInfo);
		//sessionInfo.setAuthIds(u.getAuthIds());
		//sessionInfo.setAuthNames(u.getAuthNames());
		//sessionInfo.setRoleIds(u.getRoleIds());
		//sessionInfo.setRoleNames(u.getRoleNames());
		//sessionInfo.setAuthUrls(u.getAuthUrls());
		return sessionInfo;
	}
	public Employer getEmployer() {
		return employer;
	}
	public void setXfxmcyMutualServiceImpl(
			XfxmcyMutualService xfxmcyMutualServiceImpl) {
		this.xfxmcyMutualServiceImpl = xfxmcyMutualServiceImpl;
	}
	
	
	/**
	 * register for  employer
	 * @return	view
	 * @throws Exception
	 */
	
	public String registerEmployer() throws Exception{
	
		logger.info("persist begin" + employer);
		try{
			List<String> messageList = xfxmcyMutualServiceImpl.persistencePerson(employer);
			//注册成功
			if(1 < messageList.size()){
				super.writeJson(new InformationXfxmcy(true,"添加成功!",null));
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
}
