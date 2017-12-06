package com.nyx.ssm_demo.standard;

import java.util.HashMap;
import java.util.Map;

/**
 * 标准化返回数据，接口返回的数据都按照该类来实例化
 * 前后端分离开发，方便前端准确获取数据
 * 
 * */

public class ResponseData {

	private static final String OK = "ok";
	private static final String ERROR = "error";

	private Meta meta;
	private Map<String, Object> data;

	public ResponseData() {
		this.meta = new Meta();
		this.data = new HashMap<String, Object>();
	}

	public ResponseData putDataValue(String key, Object value) {
		this.data.put(key, value);
		return this;
	}

	public ResponseData success() {
		this.meta = new Meta(true, OK);
		return this;
	}

	public ResponseData success(String msg) {
		this.meta = new Meta(true, msg);
		return this;
	}

	public ResponseData success(String msg, Map<String, Object> data) {
		this.meta = new Meta(true, msg);
		this.data = data;
		return this;
	}

	public ResponseData failure() {
		this.meta = new Meta(false, ERROR);
		return this;
	}

	public ResponseData failure(int status, String msg, String code,
			String devMsg) {
		this.meta = new Meta(false, status, msg, code, devMsg);
		return this;
	}

	public class Meta {

		private boolean success;
		// 用于前端区别不同的异常信息
		// 方便前端针对不同的status的值采取不同的操作
		private int status;
		// 简短的提示信息
		private String msg;
		// 异常编码
		private String code;
		// 开发人员查看的开发信息
		private String devMsg;

		public Meta() {
		}

		public Meta(boolean success) {
			this.success = success;
		}

		public Meta(boolean success, String msg) {
			this.success = success;
			this.msg = msg;
		}

		public Meta(boolean success, int status, String msg, String code,
				String devMsg) {
			this.success = success;
			this.status = status;
			this.msg = msg;
			this.code = code;
			this.devMsg = devMsg;
		}

		public boolean isSuccess() {
			return success;
		}

		public int getStatus() {
			return status;
		}

		public String getmsg() {
			return msg;
		}

		public String getCode() {
			return code;
		}

		public String getDevMsg() {
			return devMsg;
		}
	}

	public Meta getMeta() {
		return meta;
	}

	public Map<String, Object> getData() {
		return data;
	}
}
