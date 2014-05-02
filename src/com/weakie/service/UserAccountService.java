package com.weakie.service;

import java.util.Set;

import com.weakie.bean.Person;
import com.weakie.util.ReadOnlyMap;
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
	
	/**
	 * ע��
	 * @param userName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public boolean register(String userName,String password) throws Exception;
	
	/**
	 * ����staff��nickname
	 * @param staffId
	 * @return
	 */
	public ReadOnlyMap<String,String> getStaffNiceNameMap(Set<String> staffId);
	
	/**
	 * ����syaff��nickname
	 */
	public String getStaffNicmName(String staffId);
}
