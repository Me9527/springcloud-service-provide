package com.zzp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zzp.dao.UserInfoMapper;
import com.zzp.pojo.UserInfo;

/**
 * Created by zhuzhengping on 2017/4/22.
 */
@Service
public class UserService {

    @Autowired
    UserInfoMapper userInfoMapper;

    public void createUser(String tel,String pwd) {
        userInfoMapper.createUser(tel,pwd);
    }

//	@HystrixCommand(fallbackMethod = "fallback")	//熔断测试 http://localhost:8000/spring4study/modules/module01/ActionOne/testHystrix.do?uid=999&param=abc
    public UserInfo getUser(Integer uid) {
//    	if(uid >= 99) throw new RuntimeException("uid-99-error");	//For test HystrixCommand
    	if(uid >= 99) {
    		try {
				Thread.sleep(6000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
        return userInfoMapper.getUser(uid);
    }

    public void updateUser(String user_id, String nickName) {
        userInfoMapper.updateUser(user_id,nickName);
    }

    public void deleteUserByUserId(Integer id) {
        userInfoMapper.deleteUserByUserId(id);
    }
    
	public UserInfo fallback(Integer uid) {
		UserInfo t = new UserInfo();
		t.setNickName("fallbck123：" + uid);
		return t;
	}
}
