package com.nyx.ssm_demo.exception;

import javax.validation.ConstraintViolationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.nyx.ssm_demo.constants.CodeConstants;
import com.nyx.ssm_demo.constants.StatusConstants;
import com.nyx.ssm_demo.standard.ResponseData;

/**
 * 全局异常统一处理
 * 各层抛出的异常以及其他系统异常抛出后由此格式化返回数据并进行日志操作
 * 
 * */
@ControllerAdvice
@ResponseBody
public class ExceptionAdvice {

	private static Logger logger = LogManager.getLogger(ExceptionAdvice.class
			.getName());

	/**
	 * 400 - Bad Request
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseData handleHttpMessageNotReadableException(
			HttpMessageNotReadableException e) {
		logger.error("参数解析失败", e);
		return new ResponseData().failure(StatusConstants.FAIL,
				"could_not_read_json", CodeConstants.COULD_NOT_READ_JSON,
				e.getMessage());
	}

	/**
	 * 405 - Method Not Allowed
	 */
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseData handleHttpRequestMethodNotSupportedException(
			HttpRequestMethodNotSupportedException e) {
		logger.error("不支持当前请求方法", e);
		return new ResponseData().failure(StatusConstants.FAIL,
				"request_method_not_supported",
				CodeConstants.REQUEST_METHOD_NOT_SUPPORTED, e.getMessage());
	}

	/**
	 * 415 - Unsupported Media Type
	 */
	@ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public ResponseData handleHttpMediaTypeNotSupportedException(
			HttpMediaTypeNotSupportedException e) {
		logger.error("不支持当前媒体类型", e);
		return new ResponseData().failure(StatusConstants.FAIL,
				"content_type_not_supported",
				CodeConstants.CONTENT_TYPE_NOT_SUPPORTED, e.getMessage());
	}

	/**
	 * 500 - Param Error
	 */
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(AuthException.class)
	public ResponseData HandleAuthException(AuthException e) {
		logger.error("认证错误", e);
		return new ResponseData().failure(e.getAuth_status(), e.getMessage(),
				e.getAuth_code(), "auth_error:" + e.getMessage());
	}

	/**
	 * 500 - Param Error
	 */
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(BindException.class)
	public ResponseData HandleParamException(BindException e) {
		logger.error("参数错误", e);
		return new ResponseData().failure(StatusConstants.FAIL, "参数"
				+ e.getFieldError().getField() + "错误",
				CodeConstants.REQUEST_PARAM_ERROR,
				"param_error:" + e.getMessage());
	}

	/**
	 * 500 - Param Error
	 */
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseData HandleParamException(ConstraintViolationException e) {
		logger.error("参数错误", e);
		return new ResponseData().failure(StatusConstants.FAIL, "参数"
				+ e.getConstraintViolations().iterator().next()
						.getInvalidValue() + "错误",
				CodeConstants.REQUEST_PARAM_ERROR,
				"param_error:" + e.getMessage());
	}

	/**
	 * 500 - Persistence Error
	 */
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(PersistenceException.class)
	public ResponseData handlePersistenceException(PersistenceException e) {
		logger.error("持久层执行异常", e);
		return new ResponseData().failure(e.getPers_status(), e.getMessage(),
				e.getPers_code(), "persistence_error:" + e.getPers_class());
	}

	/**
	 * 500 - Business Error
	 */
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(BusinessException.class)
	public ResponseData handleBusinessException(BusinessException e) {
		logger.error("业务执行异常", e);
		return new ResponseData().failure(e.getBiz_status(), e.getMessage(),
				e.getBiz_code(), "business_error:" + e.getBiz_class());
	}

	/**
	 * 500 - Internal Server Error
	 */
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public ResponseData handleException(Exception e) {
		logger.error("服务运行异常", e);
		return new ResponseData().failure(StatusConstants.FAIL, "server_error",
				CodeConstants.SERVER_ERROR, e.getMessage());
	}
}
