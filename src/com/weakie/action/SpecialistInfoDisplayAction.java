package com.weakie.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.weakie.bean.SpecialistInfoBean;
import com.weakie.service.SelectionService;
import com.weakie.service.SpecialistInfoService;
import com.weakie.util.log.LogUtil;

public class SpecialistInfoDisplayAction extends ActionSupport {
 
    private static final long serialVersionUID = 1L;
 
    //request
    private String userName;
   
    //response
    private SpecialistInfoBean specInfoBean;
    
    //spring
    private SpecialistInfoService specInfoService;
    private SelectionService selectService;
    
	public String execute() throws Exception{
    	LogUtil.info("display info action, userName: " + userName);
    	this.specInfoBean = this.specInfoService.getSpecialistInfoByUsername(userName);
    	if(this.specInfoBean!=null){
	    	this.initSpecialistBeanDisplayData();
    	}
		LogUtil.info("display spec info:"+specInfoBean);
        return SUCCESS;
    }
	
	private void initSpecialistBeanDisplayData(){
		Map<Integer,String> orgTypeMap = this.selectService.getOrgType();
		this.specInfoBean.setOrgType(orgTypeMap.get(this.specInfoBean.getOrgTypeId()));
		
		Map<Integer,String> qualificationMap = this.selectService.getQualification();
		this.specInfoBean.setQualification(qualificationMap.get(this.specInfoBean.getQualificationId()));
		
		Map<Integer,String> titleMap = this.selectService.getTitle();
		this.specInfoBean.setTitle(titleMap.get(this.specInfoBean.getTitleId())); 
		
		//set Major
		Object id = this.selectService.getMajorClassIdByMajorId((this.specInfoBean.getMajorId()==null?0:this.specInfoBean.getMajorId()));
		if(id != null){
			int majorClassId = (Integer)id;
			Map<Integer,String> majorMap = this.selectService.getMajor(majorClassId);
			Map<Integer,String> majorClassMap = this.selectService.getMajorClass();
			String major = majorClassMap.get(majorClassId)+"-"+majorMap.get(this.specInfoBean.getMajorId());
			this.specInfoBean.setMajor(major);
		}
		
		//set working position
		if(this.specInfoBean.getWorkPositionId().size() !=0){
			Map<Integer,Integer> cityProvMap = this.selectService.getCityProvinceMap(this.specInfoBean.getWorkPositionId()); 
			Map<Integer,String> cityNameMap = this.selectService.getCityNameMap(this.specInfoBean.getWorkPositionId());
			Map<Integer,String> provNameMap = this.selectService.getProvNameMap(this.specInfoBean.getWorkPositionId());
			
			StringBuilder workPos = new StringBuilder();
			for(int cityId : this.specInfoBean.getWorkPositionId()){
				String position = provNameMap.get(cityProvMap.get(cityId))+"-"+cityNameMap.get(cityId);
				workPos.append(position+"\n");
			}
			this.specInfoBean.setWorkPosition(workPos.toString());
		}
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

	public void setSelectService(SelectionService selectService) {
		this.selectService = selectService;
	}
	
}
