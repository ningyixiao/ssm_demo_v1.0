package com.nyx.ssm_demo.exception;

/**
 * 授权异常
 * 授权失败抛出状态码-9
 * 暂时只有登录状态验证
 * 
 * */
public class AuthException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	/**
	 * 认证状态码：认证失败会显示
	 * 方便前端ui控制显示认证失败信息
	 * 
	 * */
	private int auth_status;
	/**
	 * 业务码：不同的业务开头的编码不同
	 * */
	private String auth_code;

	public AuthException() {
		super();
	}

	public AuthException(String message) {
		super(message);
	}

	public AuthException(int auth_status, String auth_code, String message) {
		super(message);
		this.auth_status = auth_status;
		this.auth_code = auth_code;
	}

	public int getAuth_status() {
		return auth_status;
	}

	public void setAuth_status(int auth_status) {
		this.auth_status = auth_status;
	}

	public String getAuth_code() {
		return auth_code;
	}

	public void setAuth_code(String auth_code) {
		this.auth_code = auth_code;
	}

	
}
