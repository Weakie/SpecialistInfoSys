package com.weakie.service;

import java.util.Set;

import com.weakie.bean.Person;
import com.weakie.util.ReadOnlyMap;
/**
 * 处理用户账户情况
 * @author weakie E-mail:weakielin@gmail.com
 * 2014年5月1日下午11:19:29
 */
public interface UserAccountService {

	/**
	 * 登录，登录不成功返回null
	 * @param userName
	 * @param password
	 * @return
	 */
	public Person login(String userName,String password) throws Exception;
	
	/**
	 * 检查账户是否存在，存在则返回true
	 * @param userName
	 * @return
	 */
	public boolean checkAccount(String userName);
	
	/**
	 * 注册
	 * @param userName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public boolean register(String userName,String password) throws Exception;
	
	/**
	 * 返回staff的nickname
	 * @param staffId
	 * @return
	 */
	public ReadOnlyMap<String,String> getStaffNiceNameMap(Set<String> staffId);
	
	/**
	 * 返回syaff的nickname
	 */
	public String getStaffNicmName(String staffId);
}
