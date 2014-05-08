package com.weakie.action.staff;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.commons.lang.StringUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.weakie.constant.SpecInfoConstant;
import com.weakie.service.ApplyInfoService;
import com.weakie.service.SpecialistInfoService;
import com.weakie.util.log.LogUtil;

public class StaffDisposeApplyConfirm extends ActionSupport {
 
    private static final long serialVersionUID = 1L;
 
    //request
    private int applyInfoId;	//for confirm applyInfo
    private String staffId;
    //response
    private InputStream inputStream;
    
    //spring
    private ApplyInfoService applyInfoService;
    private SpecialistInfoService specInfoService;
    
   
    //������Ա�����ȷ�ϡ�
	public String executeConfirm(){
		LogUtil.info("applyId: "+applyInfoId+" ,staffId: "+staffId);
		String userName = this.applyInfoService.confirmApply(staffId, applyInfoId);
    	int result2 = 0;
		if(StringUtils.isNotEmpty(userName)){
			result2 = this.specInfoService.updateSpecialistInfoState(userName, SpecInfoConstant.SPECINFO_CONFIRMED);
    	}
		String result = null;
    	if(StringUtils.isEmpty(userName)){
    		result = "0:������Ϣ�޸�ʧ��";
    	}else if(result2!=1){
    		result = "1:������Ϣ�޸ĳɹ�,ר����Ϣȷ��ʧ��,���ٴ�ȷ��";
    	}else{
    		result = "2:ȷ�ϳɹ�";
    	}
		try {
			this.inputStream = new ByteArrayInputStream(result.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			LogUtil.error(e);
		}
		LogUtil.info(result);
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

	public void setSpecInfoService(SpecialistInfoService specInfoService) {
		this.specInfoService = specInfoService;
	}


}
