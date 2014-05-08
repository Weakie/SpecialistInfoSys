package com.weakie.action.spec;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import com.opensymphony.xwork2.ActionSupport;
import com.weakie.constant.SpecInfoConstant;
import com.weakie.service.ApplyInfoService;
import com.weakie.service.SpecialistInfoService;
import com.weakie.util.log.LogUtil;

public class SpecAddNewApply extends ActionSupport {
 
    private static final long serialVersionUID = 1L;
 
    //request
    private String userName;
    private String name;
    //response
    private InputStream inputStream;
    
    //spring
    private ApplyInfoService applyInfoService;
    private SpecialistInfoService specInfoService;
    
    //method
	public String execute(){
		LogUtil.info("name: "+name+" ,userName: "+userName);
		int result1 = this.applyInfoService.addNewApply(userName, name);
    	int result2 = 0;
		if(result1!=0){
			result2 = this.specInfoService.updateSpecialistInfoState(userName, SpecInfoConstant.SPECINFO_CONFIRMING);
    	}
		String result = null;
    	if(result1 == 0){
    		result = "0:提交申请失败";
    	}else if(result2 != 1){
    		result = "1:提交申请成功,信息未更新";
    	}else{
    		result = "2:提交申请成功,正在等工作人员确认";
    	}
		try {
			this.inputStream = new ByteArrayInputStream(result.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			LogUtil.error(e);
		}
		LogUtil.info(result);
        return SUCCESS;
    }

	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setName(String name) {
		try {
			this.name =  java.net.URLDecoder.decode(name,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			LogUtil.error(e);
		}
	}
	
	public InputStream getInputStream() {
		return inputStream;
	}

	
	public void setApplyInfoService(ApplyInfoService applyInfoService) {
		this.applyInfoService = applyInfoService;
	}

	public void setSpecInfoService(SpecialistInfoService specInfoService) {
		this.specInfoService = specInfoService;
	}
}
