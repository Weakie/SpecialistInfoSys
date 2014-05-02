package com.weakie.bean;

import java.util.Date;
/**
 * �˻���Ϣ��
 * @author weakie E-mail:weakielin@gmail.com
 * 2014��5��1������9:10:21
 */
public class Person
{
	private String userName;//�û���

	private String nickName;//�ǳ�,������Ա������
	private int role;		//��ɫ��spec:1 staff:2 admin:3
	private int authority;	//Ȩ�ޣ������Ʊ��� ������1
	private Date registerTime;
	private Date loginTime;	//�ϴε�¼ʱ��
	
	
	public Person(String userName, int role, int authority, Date registerTime,
			Date loginTime) {
		this.userName = userName;
		this.role = role;
		this.authority = authority;
		this.registerTime = registerTime;
		this.loginTime = loginTime;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public int getAuthority() {
		return authority;
	}
	public void setAuthority(int authority) {
		this.authority = authority;
	}
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	
}