package com.xfxmcy.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.xfxmcy.service.impl.PersonServiceImpl;



/**
 * @author CY
 * @date   27-7
 * @description  This util be used  by cy .
 */
public class XfxmcyUtil {
	
	private static final Logger logger = Logger
			.getLogger(PersonServiceImpl.class);
	
	public static List<Integer> getPagedNumber(String page, String pageSize){
		Integer pageNum = new  Integer(1),pageSizeNum  = new Integer(10);
		try{
			if(null !=  page){
				pageNum = Integer.parseInt(page);
			}
			if(null !=  pageSize){
				pageSizeNum = Integer.parseInt(pageSize);
			}
		}catch(RuntimeException e){
			logger.error(e.getMessage()+"  queryPersons");
		}	
		List<Integer> list = new ArrayList<Integer>();
		list.add(pageNum);
		list.add(pageSizeNum);
		return list;
	}
}
