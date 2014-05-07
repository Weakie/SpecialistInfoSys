package com.weakie.action.precheck;

import com.opensymphony.xwork2.ActionSupport;
import com.weakie.util.log.LogUtil;

/**
 * 页面重定向
 * @author dell
 *
 */
public class SpecialistInfoAddPreparePreCheckAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	//request
	private String userName;
	private int applyInfoId;	//for staff check
	private String staffId;		//for staff check
	
	//response
	
	public String executeCheck() throws Exception {
		LogUtil.info("userName="+userName+" ,ApplyId="+applyInfoId+" ,staffId="+staffId);
		//TODO check authority
		
		return SUCCESS;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getApplyInfoId() {
		return applyInfoId;
	}
	public void setApplyInfoId(int applyInfoId) {
		this.applyInfoId = applyInfoId;
	}
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

}