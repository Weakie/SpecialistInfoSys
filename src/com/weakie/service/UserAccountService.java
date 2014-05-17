package com.weakie.service;

import java.util.List;
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
	 * 添加新的工作人员
	 * @param userName
	 * @return
	 */
	public boolean addNewStaff(String userName);
	/**
	 * 重置密码
	 * @param userName
	 * @param password
	 * @return
	 */
	public Person resetPassword(String userName,String password,String newPassword) throws Exception;
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
	
	/**
	 * 更新用户nickName
	 * @param userName
	 * @param nickName
	 * @return
	 */
	public int updateNickName(String userName,String nickName);
	
	/**
	 * 修改用户权限
	 * @param username
	 * @param authority
	 * @return
	 */
	public int updateUserAuthority(String username,int authority);
	/**
	 * 得到用户
	 */
	public List<Person> getPersonInfos(int authority, int pageIndex);
}
