package com.nyx.ssm_demo.constants;

/**
 * 接口请求提示信息常量
 * 作用1: 所有的返回信息都定义为常量，方便统一修改
 * 作用2: 由于统一了返回数据格式，该信息对应的属性为ResponseData->Meta->msg
 * 		有时候方便前端无需判断就直接显示，作为给用户的提示信息
 * 		有时候也只需要前端根据不同的status，选择性显示该信息
 * */
public class MsgConstants {
	
	public static final String LOGIN_AUTH_FAIL = "登录过期，请重新登录。";
	
	/**
	 * 业务层
	 * */
	
	/**
	 * 持久层
	 * 
	 * */
}
