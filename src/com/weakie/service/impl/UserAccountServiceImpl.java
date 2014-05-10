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
import com.weakie.util.log.LogUtil;

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

	@Override
	public Person resetPassword(String userName, String password,
			String newPassword) throws Exception {
		Person p = this.personDAO.checkPassword(userName, password);
		if(p==null){
			LogUtil.info("user:"+userName+",fail to check password before reset password");
			return null;
		}
		this.personDAO.updatePassword(userName, password, newPassword);
		p = this.personDAO.checkPassword(userName, newPassword);
		if(p == null){
			LogUtil.info("user:"+userName+",fail to check password after reset password");
		}
		return p;
	}

	@Override
	public int updateNickName(String userName, String nickName) {
		return this.personDAO.updateNickName(userName, nickName);
	}

}
