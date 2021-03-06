package com.weakie.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.weakie.constant.UserAccountConstant;
/**
 * 账户信息类
 * @author weakie E-mail:weakielin@gmail.com
 * 2014年5月1日下午9:10:21
 */
public class Person implements java.io.Serializable
{
	private static SimpleDateFormat dateformat = new SimpleDateFormat("yyyy年M月d日 a h点m分s秒"); 
	private static final long serialVersionUID = 1L;
	
	private String userName;//用户名
	private String password;
	
	private String nickName;//昵称,工作人员可设置
	private int role;		//角色：spec:1 staff:2 admin:3
	private int authority;	//权限：二进制编码 搜索：1
	private Date registerTime;
	private Date loginTime;	//上次登录时间
	
	public Person(){}
	
	/**
	 * for register. insert into DB
	 * @param userName
	 * @param password
	 * @param role
	 * @param authority
	 * @param registerTime
	 */
	public Person(String userName, String password, int role, int authority,
			Date registerTime) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.authority = authority;
		this.registerTime = registerTime;
		this.loginTime = registerTime;
		this.nickName = UserAccountConstant.DEFAULT_NICKNAME;
	}

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
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	public String getRegisterTimeString(){
		return dateformat.format(registerTime);
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public String getLoginTimeString(){
		return dateformat.format(loginTime);
	}

	@Override
	public String toString() {
		return "Person [userName=" + userName + ", nickName=" + nickName
				+ ", role=" + role + ", authority=" + authority
				+ ", registerTime=" + registerTime + ", loginTime=" + loginTime
				+ "]";
	}
	
}