package com.nyx.ssm_demo.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nyx.ssm_demo.constants.StatusConstants;
import com.nyx.ssm_demo.domain.Example;
import com.nyx.ssm_demo.exception.BusinessException;
import com.nyx.ssm_demo.service.ExampleService;
import com.nyx.ssm_demo.standard.ResponseData;
import com.nyx.ssm_demo.util.JwtUtil;

@Controller
@ResponseBody
public class ExampleController {
	@Resource
	private ExampleService exampleService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseData example(@Validated Example example) {
		/**
		 * spring mvc传参原理:和前端的对象名无关，和请求参数中参数名有关，参数名和java对象中属性名对应进行赋值
		 */
		/**
		 * 参数验证使用了spring4.x的方法验证
		 * */
		/**
		 * service层只有一个dao层的操作，因此无需验证service层的返回值
		 * service层已经做了异常判断，在此无需再做异常判断
		 * 如果service层操作较多，则在此需要做一个BusinessException的判断
		 * */
		exampleService.addExample(example);
		ResponseData responseData = new ResponseData();
		responseData.success("添加example成功");
		return responseData;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ResponseData login(@Validated Example example) {
		/**
		 * 登录验证成功，生成token
		 * */
		// 先到数据库验证
		long id = exampleService.checkExample(example);
		example.setId(id);
		// 给用户jwt加密生成token
		// 过期时间为当前时间+30分钟(60*1000ms*30)
		// 生成token的参数example对象包括(用户名+密码+用户id(数据库自增的id值))
		String token = JwtUtil.sign(example, 60L * 1000L * 30L);
		ResponseData responseData = new ResponseData();
		responseData.putDataValue("token", token);
		responseData.putDataValue("loginId", id);
		responseData.success("登录成功");
		return responseData;
	}

	@RequestMapping(value = "/checkToken", method = RequestMethod.GET)
	public ResponseData checkToken() {
		ResponseData responseData = new ResponseData();
		responseData.success("token验证成功");
		return responseData;
	}
}