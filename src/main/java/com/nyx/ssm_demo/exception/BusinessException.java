package com.nyx.ssm_demo.exception;

/**
 * 系统业务异常
 * service层计算结果和预计有误，则在对应controller中抛出该异常
 */
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	/**
	 * 业务状态码：区别业务执行的不同状态
	 * 方便前端ui控制显示用户提示文本
	 * 
	 * */
	private int biz_status;
	/**
	 * 业务码：不同的业务开头的编码不同
	 * */
	private String biz_code;
	private String biz_class;

	public BusinessException() {
		super();
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(int biz_status, String biz_code, String biz_class, String message) {
		super(message);
		this.biz_status = biz_status;
		this.biz_code = biz_code;
		this.biz_class = biz_class;
	}

	public int getBiz_status() {
		return biz_status;
	}

	public void setBiz_status(int biz_status) {
		this.biz_status = biz_status;
	}

	public String getBiz_code() {
		return biz_code;
	}

	public void setBiz_code(String biz_code) {
		this.biz_code = biz_code;
	}

	public String getBiz_class() {
		return biz_class;
	}

	public void setBiz_class(String biz_class) {
		this.biz_class = biz_class;
	}

}
