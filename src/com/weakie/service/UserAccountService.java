package com.weakie.service;

import com.weakie.bean.Person;
/**
 * �����û��˻����
 * @author weakie E-mail:weakielin@gmail.com
 * 2014��5��1������11:19:29
 */
public interface UserAccountService {

	/**
	 * ��¼����¼���ɹ�����null
	 * @param userName
	 * @param password
	 * @return
	 */
	public Person login(String userName,String password) throws Exception;
	
	/**
	 * ����˻��Ƿ���ڣ������򷵻�true
	 * @param userName
	 * @return
	 */
	public boolean checkAccount(String userName);
	
	public boolean register(String userName,String password) throws Exception;
}
