package com.nyx.ssm_demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.nyx.ssm_demo.constants.CodeConstants;
import com.nyx.ssm_demo.constants.MsgConstants;
import com.nyx.ssm_demo.constants.StatusConstants;
import com.nyx.ssm_demo.domain.Example;
import com.nyx.ssm_demo.exception.AuthException;
import com.nyx.ssm_demo.util.JwtUtil;

/**
 * 登录认证的拦截器
 */
public class ExampleLoginInterceptor implements HandlerInterceptor {

	/**
	 * Handler执行完成之后调用这个方法
	 */
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception e)
			throws Exception {

	}

	/**
	 * Handler执行之后，ModelAndView返回之前调用这个方法
	 */
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	/**
	 * Handler执行之前调用这个方法
	 */
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		/**
		 * 用户登录状态验证
		 * */
		String token = request.getParameter("token");
		if (null != token) {
			Example example = JwtUtil.unsign(token, Example.class);
			String loginId = request.getParameter("loginId");
			// 解密token后的loginId与用户传来的loginId不一致，一般都是token过期
			if (null != loginId && null != example) {
				if (Integer.parseInt(loginId) == example.getId()) {
					return true;
				}
			}
		}
		throw new AuthException(StatusConstants.LOGIN_AUTH_FAIL,
				CodeConstants.LOGIN_AUTH_ERROR, MsgConstants.LOGIN_AUTH_FAIL);
	}
}
