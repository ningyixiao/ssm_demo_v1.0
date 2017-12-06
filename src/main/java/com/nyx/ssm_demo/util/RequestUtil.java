package com.nyx.ssm_demo.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

/**
 * 解析HttpServletRequest参数
 * 将所有参数放入由HashMap<String,String>类实例化的一个对象中
 * 
 * @author nyx
 * @version 1.0
 */
public class RequestUtil {

    /**
     * 获取所有request请求参数key-value
     * 
     * @param request
     * @return
     */
    @SuppressWarnings("unchecked")
	public static Map<String, String> getRequestParams(HttpServletRequest request){
        
        Map<String, String> params = new HashMap<String, String>();
        if(null != request){
            Set<String> paramsKey = request.getParameterMap().keySet();
            for(String key : paramsKey){
                params.put(key, request.getParameter(key));
            }
        }
        return params;
    }
}
