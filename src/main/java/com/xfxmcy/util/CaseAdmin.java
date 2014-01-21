package com.xfxmcy.util;
/**
 * @author CY
 * @Date   13-07
 * @description  enum CaseAdmin for Administrator
 * @version 0.0.1-SNAPSHOT
 */
public enum CaseAdmin {
	All{
		String getName(){
			
			return "All";
		}
		
	},Low{
		String getName(){
			
			return "Low";
		}
		
	};
	
	abstract String getName();
	
	
}