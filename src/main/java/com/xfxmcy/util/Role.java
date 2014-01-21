package com.xfxmcy.util;
/**
 * @author CY
 * @Date   05-06	
 * @description  the enum role for  menu 
 * @version 0.0.1-SNAPSHOT
 */
public enum Role {
	
	commonEmployer {  //commonEmployer
		@Override
		public String getDirection() {
		
			return "普通员工";
		}

		@Override
		public String getId() {
			// TODO Auto-generated method stub
			return "0";
		}
	},advancedEmployer {	//	advancedEmployer
		@Override
		public String getDirection() {
			// TODO Auto-generated method stub
			return "高级员工";
		}

		@Override
		public String getId() {
			// TODO Auto-generated method stub
			return "1";
		}
	},administrator {	//	administrator
		@Override
		public String getDirection() {
			// TODO Auto-generated method stub
			return "管理员";
		}

		@Override
		public String getId() {
			// TODO Auto-generated method stub
			return "2";
		}
	},advancedAdministrator {	//	advancedAdministrator
		@Override
		public String getDirection() {
			// TODO Auto-generated method stub
			return "高级管理员";
		}

		@Override
		public String getId() {
			// TODO Auto-generated method stub
			return "3";
		}
	},root {	//	root
		@Override
		public String getDirection() {
			// TODO Auto-generated method stub
			return "超级管理员";
		}

		@Override
		public String getId() {
			// TODO Auto-generated method stub
			return "4";
		}
	};
	
		Role(){
					
		}
		
		public abstract String getDirection();
		
		public abstract String getId();
}
