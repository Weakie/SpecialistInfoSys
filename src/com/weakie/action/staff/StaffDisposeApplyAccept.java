package com.weakie.action.staff;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.weakie.bean.ApplyInfo;
import com.weakie.constant.SpecInfoConstant;
import com.weakie.constant.SystemConstant;
import com.weakie.service.ApplyInfoService;
import com.weakie.service.SpecialistInfoService;
import com.weakie.service.UserAccountService;
import com.weakie.util.log.LogUtil;

public class StaffDisposeApplyAccept extends ActionSupport {
 
    private static final long serialVersionUID = 1L;
 
    //request
    private int applyInfoId;
    private String staffId;
    
    //response
    private InputStream inputStream;
    
    //spring
    private ApplyInfoService applyInfoService;
    private UserAccountService userAccountService;
    private SpecialistInfoService specInfoService;
    
    //method
	public String execute() throws Exception{
		LogUtil.info("applyId: "+applyInfoId+" ,staffId: "+staffId);
    	ApplyInfo info = this.applyInfoService.acceptNewApply(staffId, applyInfoId);
    	String result = null;
    	if(StringUtils.equals(staffId, info.getStaffID())){
    		//若成功接收,修改专家信息状态
    		this.specInfoService.updateSpecialistInfoState(info.getUserName(), SpecInfoConstant.SPECINFO_CONFIRMING);
    		result = SystemConstant.SUCCESS+";"+applyInfoId+";"+staffId+";"+info.getUserName();
    	}else{
    		String nickName=this.userAccountService.getStaffNicmName(info.getStaffID());
    		result = SystemConstant.FAIL+";"+applyInfoId+";"+nickName;
    	}
    	LogUtil.info(result);
		this.inputStream = new ByteArrayInputStream(result.getBytes("UTF-8"));
        return SUCCESS;
    }

	
	public InputStream getInputStream() {
		return inputStream;
	}

	public void setApplyInfoId(int applyInfoId) {
		this.applyInfoId = applyInfoId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	
	public void setApplyInfoService(ApplyInfoService applyInfoService) {
		this.applyInfoService = applyInfoService;
	}

	public void setUserAccountService(UserAccountService userAccountService) {
		this.userAccountService = userAccountService;
	}

	public void setSpecInfoService(SpecialistInfoService specInfoService) {
		this.specInfoService = specInfoService;
	}

}
