package com.nyx.ssm_demo.exception;

/**
 * 持久层异常
 * dao层操作结果和预计有误，则在对应service层中抛出该异常
 * 
 * */
public class PersistenceException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	/**
	 * 持久层操作状态码：区别持久层操作执行的不同状态
	 * 方便前端ui控制显示用户提示文本
	 * 
	 * */
	private int pers_status;
	/**
	 * 持久层操作码：不同的持久层操作开头的编码不同
	 * */
	private String pers_code;
	private String pers_class;

	public PersistenceException() {
		super();
	}

	public PersistenceException(String message) {
		super(message);
	}

	public PersistenceException(String pers_code, String pers_class, String message) {
		super(message);
		this.pers_code = pers_code;
		this.pers_class = pers_class;
	}

	public int getPers_status() {
		return pers_status;
	}

	public void setPers_status(int pers_status) {
		this.pers_status = pers_status;
	}

	public String getPers_code() {
		return pers_code;
	}

	public void setPers_code(String pers_code) {
		this.pers_code = pers_code;
	}

	public String getPers_class() {
		return pers_class;
	}

	public void setPers_class(String pers_class) {
		this.pers_class = pers_class;
	}

}
