package com.weakie.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.weakie.bean.SpecialistInfoBean;
import com.weakie.service.SelectionService;
import com.weakie.service.SpecialistInfoService;
import com.weakie.util.log.LogUtil;

public class SearchSpecInfoAction extends ActionSupport {
 
    private static final long serialVersionUID = 1L;
 
    //request
    private String value;
   
    //response
    private List<SpecialistInfoBean> specInfos;
    
    //spring
    private SpecialistInfoService specInfoService;
    private SelectionService selectService;
    
	public String execute() throws Exception{
		//for staff display, specialist display is not needed
    	LogUtil.info("search value = "+value);
    	this.specInfos = this.specInfoService.searchByValue(value.split(" "));
    	this.initSpecialistBeanDisplayData();
		LogUtil.info("display spec info:"+this.specInfos.size());
        return SUCCESS;
    }
	
	private void initSpecialistBeanDisplayData(){
		Map<Integer,String> orgTypeMap = this.selectService.getOrgType();
		Map<Integer,String> qualificationMap = this.selectService.getQualification();
		Map<Integer,String> titleMap = this.selectService.getTitle();
		
		Map<Integer,String> majorClassMap = this.selectService.getMajorClass();
		Map<Integer,String> majorMap = new HashMap<Integer,String>();
		Map<Integer,Integer> majorIdMajorClassIdMap = new HashMap<Integer,Integer>();
		for(Integer majorClassId:majorMap.keySet()){
			Map<Integer,String> major = this.selectService.getMajor(majorClassId);
			for(Integer id:major.keySet()){
				majorIdMajorClassIdMap.put(id, majorClassId);
			}
			majorMap.putAll(major);
		}

		Map<Integer,String> provNameMap = new HashMap<Integer,String>();
		provNameMap.putAll(this.selectService.getProvince(true));
		provNameMap.putAll(this.selectService.getProvince(false));
		Map<Integer,String> cityNameMap = new HashMap<Integer,String>();
		Map<Integer,Integer> cityProvMap = new HashMap<Integer,Integer>();
		for(Integer provId:provNameMap.keySet()){
			Map<Integer,String> city = this.selectService.getCity(provId);
			for(Integer id:city.keySet()){
				cityProvMap.put(id, provId);
			}
			cityNameMap.putAll(city);
		}
		//update the specInfoBean
		for(SpecialistInfoBean bean:this.specInfos){
			bean.setOrgType(orgTypeMap.get(bean.getOrgTypeId()));
			bean.setQualification(qualificationMap.get(bean.getQualificationId()));
			bean.setTitle(titleMap.get(bean.getTitleId())); 
			
			Integer id = majorIdMajorClassIdMap.get(bean.getMajorId());
			if(id != null){
				String major = majorClassMap.get(id)+"-"+majorMap.get(bean.getMajorId());
				bean.setMajor(major);
			}
			
			if(bean.getWorkPositionId().size() !=0){
				StringBuilder workPos = new StringBuilder();
				for(int cityId : bean.getWorkPositionId()){
					String position = provNameMap.get(cityProvMap.get(cityId))+"-"+cityNameMap.get(cityId);
					workPos.append(position+";");
				}
				bean.setWorkPosition(workPos.toString());
			}
		}
	}
	public void setSpecInfoService(SpecialistInfoService specInfoService) {
		this.specInfoService = specInfoService;
	}

	public void setSelectService(SelectionService selectService) {
		this.selectService = selectService;
	}
}
