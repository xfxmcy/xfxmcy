package com.xfxmcy.util;

import java.io.Serializable;
/**
 * 
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class InformationXfxmcy implements Serializable {

		private boolean success = false;// 是否成功
		private String message = "";// 提示信息
		private Object otherMessage= null;// 其他信息
		
		public InformationXfxmcy() {
			// TODO Auto-generated constructor stub
		}
		
		public InformationXfxmcy(boolean success, String message,
				Object otherMessage) {
			super();
			this.success = success;
			this.message = message;
			this.otherMessage = otherMessage;
		}

		public boolean isSuccess() {
			return success;
		}
		public void setSuccess(boolean success) {
			this.success = success;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public Object getOtherMessage() {
			return otherMessage;
		}
		public void setOtherMessage(Object otherMessage) {
			this.otherMessage = otherMessage;
		}

	}
