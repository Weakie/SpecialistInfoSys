package com.weakie.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.Map;
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
		//TODO ���ܼ����㷨
		return this.personDAO.checkPassword(userName, password);
	}

	@Override
	public boolean checkAccount(String userName) {
		return this.personDAO.checkUsernameExist(userName) >= 1;
	}

	@Override
	public boolean register(String userName, String password) throws Exception {
		//TODO ���ܼ����㷨
		if(this.personDAO.checkUsernameExist(userName) >= 1){
			return false;
		}
		int result = this.personDAO.addNewPerson(new Person(userName,password,UserAccountConstant.ROLE_SPEC,UserAccountConstant.DEFAULT_AUTHORITY,new Date()));
		return result == 1;
	}

	@Override
	public ReadOnlyMap<String, String> getStaffNiceNameMap(Set<String> staffId) {
		if(staffId.isEmpty()){
			Map<String,String> tmp = Collections.emptyMap();
			return new ReadOnlyMap<String,String>(tmp);
		}
		return new ReadOnlyMap<String,String>(this.personDAO.getStuffNickName(staffId));
	}

	@Override
	public String getStaffNicmName(String staffId) {
		return this.personDAO.getStuffNickName(staffId);
	}

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

}