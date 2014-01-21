package com.xfxmcy.action.base;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author CY
 * @Date   30-05	
 * @description	 the parent for all the action bussiness class
 * @version   0.0.1-SNAPSHOT
 */
@ParentPackage("xfxmcyBasePackage")
@Namespace("/")
public class XfxmcyBaseAction extends ActionSupport{
	
	private static final Logger logger = Logger.getLogger(XfxmcyBaseAction.class);
	/**
	 *  automatic construction	by MyEclipse 
	 */
	 private static final long serialVersionUID = 1L;
	 
	 public XfxmcyBaseAction() {
		// TODO Auto-generated constructor stub
	 }
	 /**
		 * 将对象转换成JSON字符串，并响应回前台
		 * 
		 * @param object
		 * @throws IOException
		 */
		public void writeJson(Object object) {
			try {
				// SerializeConfig serializeConfig = new SerializeConfig();
				// serializeConfig.setAsmEnable(false);
				// String json = JSON.toJSONString(object);
				// String json = JSON.toJSONString(object, serializeConfig, SerializerFeature.PrettyFormat);
				String json = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd");
				logger.info("json  is  "+ json);
				// String json = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss", SerializerFeature.PrettyFormat);
				ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
				ServletActionContext.getResponse().getWriter().write(json);
				ServletActionContext.getResponse().getWriter().flush();
				ServletActionContext.getResponse().getWriter().close();
			} catch (IOException e) {
				e.printStackTrace();
				logger.info("write json error" + e.getMessage());
			}
		}
		/**
		 * released resource
		 * @param object object[]  be released
		 */
		public  void releaseResource(Object... object){
			if(null != object){
				
				for (int i  = 0 ;i<object.length ; i++){
					 
					object[i] = null;
				}
				System.gc();
			}
			
		}
		/**
		 * 返回treeGrid
		 * "_parentId"  替换        "parentId"  
		 * @param object
		 */
		public void writeTreeGridJson(Object object) {
			try {
				// SerializeConfig serializeConfig = new SerializeConfig();
				// serializeConfig.setAsmEnable(false);
				// String json = JSON.toJSONString(object);
				// String json = JSON.toJSONString(object, serializeConfig, SerializerFeature.PrettyFormat);
				   String json = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd");
				
				 json = json.replace("parentId", "_parentId");
				 logger.info("json  is  "+ json);
				// String json = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss", SerializerFeature.PrettyFormat);
				ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
				ServletActionContext.getResponse().getWriter().write(json);
				ServletActionContext.getResponse().getWriter().flush();
				ServletActionContext.getResponse().getWriter().close();
			} catch (IOException e) {
				e.printStackTrace();
				logger.info("write json error" + e.getMessage());
			}
		}
}
