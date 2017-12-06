package com.nyx.ssm_demo.constants;

/**
 * 接口请求状态码常量
 * 作用1: 配合MsgConstants使用
 * 作用2: 用于前端判断，根据不同的值来与用户进行选择性交互
 * */
public class StatusConstants {
	/* 通用状态码：成功 */
	public static final int  SUCCESS = 1;
	/* 通用状态码：失败 */
	public static final int  FAIL = 0;
	/* 通用状态码：登录认证失败 */
	public static final int  LOGIN_AUTH_FAIL = 9;
	
	/**
	 * 业务层状态码
	 * */
	
	/**
	 * 持久层状态码
	 * 
	 * */
}
