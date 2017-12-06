package com.nyx.ssm_demo.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nyx.ssm_demo.dao.ExampleDao;
import com.nyx.ssm_demo.domain.Example;
import com.nyx.ssm_demo.exception.PersistenceException;

@Service
public class ExampleService{
	@Resource
    private ExampleDao userDao;
	
	public int addExample(Example u) {
		//判断持久层操作是否成功，失败则抛出异常
		if(userDao.addExample(u) != 1){
			throw new PersistenceException("1101",ExampleService.class.getName(),"添加失败");
		}else{
			return 1;
		}	
	}
	
	public long checkExample(Example u) {
		Example example = userDao.checkExample(u);
		//判断持久层操作是否成功，失败则抛出异常
		if( null == example ){
			throw new PersistenceException("1102",ExampleService.class.getName(),"用户不存在");
		}else{
			return example.getId();
		}	
	}
}
