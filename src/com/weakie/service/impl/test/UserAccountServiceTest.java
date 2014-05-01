package com.weakie.service.impl.test;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.weakie.bean.Person;
import com.weakie.service.UserAccountService;

public class UserAccountServiceTest implements UserAccountService {

	@Override
	public Person login(String userName, String password) {
		if(StringUtils.isEmpty(userName)||StringUtils.isEmpty(password)){
			return null;
		}
		if(userName.equals("hahaha")&&password.equals("hahaha")){
			return new Person("hahaha",1,1,new Date(),new Date());
		}
		return null;
	}

	@Override
	public boolean checkAccount(String userName) {
		if(StringUtils.isEmpty(userName)){
			return false;
		}
		if(StringUtils.equals(userName, "hahaha")){
			return true;
		}
		return false;
	}

	@Override
	public boolean register(String userName, String password) throws Exception{
		if(StringUtils.isEmpty(userName)||StringUtils.isEmpty(password)){
			return false;
		}
		if(userName.equals("hahaha")&&password.equals("hahaha")){
			return true;
		}
		return true;
	}

}
