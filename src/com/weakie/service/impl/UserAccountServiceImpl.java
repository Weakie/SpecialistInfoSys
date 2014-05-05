package com.weakie.service.impl;

import java.util.Date;
import java.util.Set;

import com.weakie.bean.Person;
import com.weakie.constant.UserAccountConstant;
import com.weakie.dao.PersonDAO;
import com.weakie.service.UserAccountService;
import com.weakie.util.ReadOnlyMap;

public class UserAccountServiceImpl implements UserAccountService {

	private PersonDAO personDAO;
	@Override
	public Person login(String userName, String password) throws Exception {
		//TODO 解密加密算法
		return this.personDAO.checkPassword(userName, password);
	}

	@Override
	public boolean checkAccount(String userName) {
		return this.personDAO.checkUsernameExist(userName) >= 1;
	}

	@Override
	public boolean register(String userName, String password) throws Exception {
		//TODO 解密加密算法
		if(this.personDAO.checkUsernameExist(userName) >= 1){
			return false;
		}
		int result = this.personDAO.addNewPerson(new Person(userName,password,UserAccountConstant.ROLE_SPEC,UserAccountConstant.DEFAULT_AUTHORITY,new Date()));
		return result == 1;
	}

	@Override
	public ReadOnlyMap<String, String> getStaffNiceNameMap(Set<String> staffId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getStaffNicmName(String staffId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

}
