package com.xfxmcy.util;

/**
 * @author CY
 * @Date   09-06
 * @description  the tool for task status
 * @version 0.0.1-SNAPSHOT
 */

public enum TaskStatus {
	
	release {  //已发布
		@Override
		public String getDirection() {
		
			return "已发布";
		}

		@Override
		public String getId() {
			// TODO Auto-generated method stub
			return "0";
		}
	},receive {	//已接受
		@Override
		public String getDirection() {
			// TODO Auto-generated method stub
			return "已接受";
		}

		@Override
		public String getId() {
			// TODO Auto-generated method stub
			return "1";
		}
	},submit { //已完成
		@Override
		public String getDirection() {
			// TODO Auto-generated method stub
			return "已完成";
		}

		@Override
		public String getId() {
			// TODO Auto-generated method stub
			return "2";
		}
	},end { //已结束
		@Override
		public String getDirection() {
			// TODO Auto-generated method stub
			return "已结束";
		}

		@Override
		public String getId() {
			// TODO Auto-generated method stub
			return "3";
		}
	};
	
	
	TaskStatus(){
				
	}
	
	public abstract String getDirection();
	
	public abstract String getId();
	
}
