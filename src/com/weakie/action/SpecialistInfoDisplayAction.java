package com.weakie.action;

import com.opensymphony.xwork2.ActionSupport;
import com.weakie.bean.SpecialistInfoBean;
import com.weakie.service.SpecialistInfoService;
import com.weakie.util.log.LogUtil;

public class SpecialistInfoDisplayAction extends ActionSupport {
 
    private static final long serialVersionUID = 1L;
 
    private String userName;
   
    private SpecialistInfoBean specInfoBean;
    private SpecialistInfoService specInfoService;
    
	public String execute() throws Exception{
    	LogUtil.info("display info action, userName: " + userName);
    	this.specInfoBean = this.specInfoService.getSpecialistInfoByUsername(userName);
    	this.specInfoBean.setOrgType("大学");
    	this.specInfoBean.setWorkPosition("上海");
    	this.specInfoBean.setQualification("高级");
    	this.specInfoBean.setTitle("高级");
    	this.specInfoBean.setMajor("建筑"); 
		LogUtil.info("display spec info:"+specInfoBean);
        return SUCCESS;
    }
 
	public void setUserName(String userName){
		this.userName = userName;
	}

	public SpecialistInfoBean getSpecInfoBean() {
		return specInfoBean;
	}

	public void setSpecInfoService(SpecialistInfoService specInfoService) {
		this.specInfoService = specInfoService;
	}
	
}
