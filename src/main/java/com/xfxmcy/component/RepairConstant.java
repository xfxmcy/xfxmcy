package com.xfxmcy.component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.xfxmcy.pojo.Administrator;
import com.xfxmcy.pojo.Menu;
import com.xfxmcy.pojo.Person;
import com.xfxmcy.util.Role;

/**
 * @author CY
 * @Date 20-07
 * @description impove constant to repairService  
 * @version 0.0.1-SNAPSHOT
 */
@Component
public class RepairConstant {
	/*
	 *  --- xfxmcy
		------- 系统管理
		------------- 菜单管理
		------------- 权限管理
		------- 任务管理
		------------- 任务信息管理
		------- 用户管理
		------------- 管理员信息管理
		------------- 工作人员信息管理
		------- 日志管理
		------------- 登录系统日志管理
		------------- 任务完成日志管理
		------- 个人管理
		------------- 个人信息管理
		------------- 个人任务管理
		--------资料管理
		------------- 资料查看
		------------- 资料更新
	 * */
	
	/*xfxmcy*/
	public  Menu xfxmcy = new Menu("0","xfmxcy",null,null,Role.commonEmployer,null,new BigDecimal(0.00));
	/*	系统管理*/
	public  Menu symanage = new Menu("1","系统管理",null,null,Role.advancedAdministrator,xfxmcy,new BigDecimal(0.00));
	/*		菜单管理*/
	public  Menu memanage = new Menu("2","菜单管理","manage/menuManage.jsp",null,Role.root,symanage,new BigDecimal(0.00));
	/*		权限管理*/
	public  Menu aumanage = new Menu("3","权限管理",null,null,Role.advancedAdministrator,symanage,new BigDecimal(1.00));
	/*	任务管理*/
	public  Menu tamanage = new Menu("4","任务管理",null,null,Role.administrator,xfxmcy,new BigDecimal(1.00));
	/*		任务信息管理*/
	public  Menu tainmanage = new Menu("5","任务信息管理",null,null,Role.administrator,tamanage,new BigDecimal(0.00));
	/*	人员管理*/
	public  Menu permanage = new Menu("6","用户管理",null,null,Role.administrator,xfxmcy,new BigDecimal(2.00));
	/*		管理员信息管理*/
	public  Menu admanage = new Menu("7","管理员信息管理",null,null,Role.root,permanage,new BigDecimal(0.00));
	/*		工作人员信息管理*/
	public  Menu emmanage = new Menu("8","工作人员信息管理","manage/manageEmployer.jsp",null,Role.administrator,permanage,new BigDecimal(1.00));
	/*	日志管理*/
	public  Menu logmanage = new Menu("9","日志管理",null,null,Role.administrator,xfxmcy,new BigDecimal(3.00));
	/*		登录系统日志管理*/
	public  Menu lolomanage = new Menu("10","登录系统日志管理",null,null,Role.advancedAdministrator,logmanage,new BigDecimal(0.00));
	/*		任务完成日志管理*/
	public  Menu tdmanage = new Menu("11","任务完成日志管理",null,null,Role.administrator,logmanage,new BigDecimal(1.00));
	/*	个人管理*/
	public  Menu pemanage = new Menu("12","个人管理",null,null,Role.commonEmployer,xfxmcy,new BigDecimal(4.00));
	/*		个人信息管理*/
	public  Menu peinmanage = new Menu("13","个人信息管理",null,null,Role.commonEmployer,pemanage,new BigDecimal(0.00));
	/*		个人任务管理*/
	public  Menu petamanage = new Menu("14","个人任务管理",null,null,Role.commonEmployer,pemanage,new BigDecimal(1.00));
	/*	资料*/
	public  Menu material = new Menu("15","资料",null,null,Role.commonEmployer,xfxmcy,new BigDecimal(5.00));
	/*		共享资料*/
	public Menu maCommon = new Menu("16","共享资料",null,null,Role.advancedEmployer,material,new BigDecimal(1.00));
	/*		我的资料*/
	public Menu mMaterial = new Menu("17","我的资料",null,null,Role.commonEmployer,material,new BigDecimal(0.00));
	/*			链接*/
	public Menu mMaterialLink = new Menu("37","链接","material/link/manageLinkMaterial.jsp",null,Role.commonEmployer,mMaterial,new BigDecimal(0.00));
	/*			笔记*/
	public Menu mMaterialNote = new Menu("38","笔记","material/note/manageNoteMaterial.jsp",null,Role.commonEmployer,mMaterial,new BigDecimal(1.00));
	/*			文档*/
	public Menu mMaterialDocument = new Menu("39","文档","material/document/manageDocumentMaterial.jsp",null,Role.commonEmployer,mMaterial,new BigDecimal(2.00));
	/*		资料更新*/
	public Menu maupdate = new Menu("18","资料更新",null,null,Role.advancedEmployer,material,new BigDecimal(2.00));
	/*		资料管理*/
	public Menu materialManage = new Menu("19","资料管理",null,null,Role.administrator,material,new BigDecimal(3.00));
	/*	亲友*/
	public  Menu friendFamily = new Menu("20","亲友",null,null,Role.commonEmployer,xfxmcy,new BigDecimal(6.00));
	/*		亲人管理*/
	public Menu relativeManage = new Menu("21","亲人管理",null,null,Role.commonEmployer,friendFamily,new BigDecimal(0.00));
	/*		同学&&朋友*/
	public Menu friendManage = new Menu("22","同学&&朋友",null,null,Role.commonEmployer,friendFamily,new BigDecimal(1.00));
	/*		陌生人管理*/
	public Menu strangerManage = new Menu("23","陌生人管理",null,null,Role.advancedEmployer,friendFamily,new BigDecimal(2.00));
	/*		亲友管理*/
	public Menu fFManage= new Menu("24","亲友管理",null,null,Role.administrator,friendFamily,new BigDecimal(3.00));
	/*	相册*/
	public  Menu photoAlbum = new Menu("25","相册",null,null,Role.commonEmployer,xfxmcy,new BigDecimal(7.00));
	/*		相册管理*/
	public Menu photoAlbumManage = new Menu("26","相册管理",null,null,Role.commonEmployer,photoAlbum,new BigDecimal(0.00));
	/*		其他人相册*/
	public Menu othersPhotAlbum = new Menu("27","其他人相册",null,null,Role.advancedEmployer,photoAlbum,new BigDecimal(1.00));
	/*		相册相片管理*/
	public Menu photoManage= new Menu("28","相册相片管理",null,null,Role.advancedAdministrator,photoAlbum,new BigDecimal(2.00));

	/*	说说*/
	public  Menu mood = new Menu("29","说说",null,null,Role.commonEmployer,xfxmcy,new BigDecimal(8.00));
	/*		我的说说*/
	public Menu myMood = new Menu("30","我的说说",null,null,Role.commonEmployer,mood,new BigDecimal(0.00));
	/*		其他人的说说*/
	public Menu otherMood = new Menu("31","其他人的说说",null,null,Role.advancedEmployer,mood,new BigDecimal(1.00));
	/*		说说管理*/
	public Menu moodManage = new Menu("32","说说管理",null,null,Role.administrator,mood,new BigDecimal(2.00));
	
	/*	日记*/
	public  Menu diary = new Menu("33","日记",null,null,Role.commonEmployer,xfxmcy,new BigDecimal(9.00));
	/*		心灵日记*/
	public Menu soulDiary = new Menu("34","心灵日记",null,null,Role.commonEmployer,diary,new BigDecimal(0.00));
	/*		死亡日记*/
	public Menu deathDiary = new Menu("35","死亡日记",null,null,Role.advancedEmployer,diary,new BigDecimal(1.00));
	/*		日记管理*/
	public Menu diaryManage = new Menu("36","日记管理",null,null,Role.advancedAdministrator,diary,new BigDecimal(2.00));

	public  List<Menu> getMenuList(){
		List<Menu> list = new ArrayList<Menu>();
		list.add(xfxmcy);
		list.add(symanage);
		list.add(memanage);
		list.add(aumanage);
		list.add(tamanage);
		list.add(tainmanage);
		list.add(permanage);
		list.add(admanage);
		list.add(emmanage);
		list.add(logmanage);
		list.add(lolomanage);
		list.add(tdmanage);
		list.add(pemanage);
		list.add(peinmanage);
		list.add(petamanage);
		list.add(material);
		list.add(maCommon);
		list.add(mMaterial);
		list.add(mMaterialLink);
		list.add(mMaterialDocument);
		list.add(mMaterialNote);
		list.add(maupdate);
		list.add(materialManage);
		list.add(friendFamily);
		list.add(relativeManage);
		list.add(friendManage);
		list.add(strangerManage);
		list.add(fFManage);
		list.add(photoAlbum);
		list.add(photoAlbumManage);
		list.add(othersPhotAlbum);
		list.add(photoManage);
		list.add(mood);
		list.add(myMood);
		list.add(otherMood);
		list.add(moodManage);
		list.add(diary);
		list.add(soulDiary);
		list.add(deathDiary);
		list.add(diaryManage);
		return list;
	}
	
	/**
	 *  Administrator
	 */
	/*root*/
	public  Administrator admin= new Administrator();


	public  List<Person> getAdminList() {
		List<Person> list = new ArrayList<Person>();
		list.add(admin);
		return list;
	} 
}
