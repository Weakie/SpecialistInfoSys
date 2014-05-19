package com.weakie.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.weakie.bean.SpecialistInfoBean;
import com.weakie.service.SelectionService;
import com.weakie.service.SpecialistInfoService;
import com.weakie.util.SpecInfoBeanUtil;
import com.weakie.util.log.LogUtil;

public class SearchSpecInfoAction extends ActionSupport {
 
    private static final long serialVersionUID = 1L;
 
    //request
    private String searchValue;
    //response
    private List<SpecialistInfoBean> specInfoBeans;
    private List<SpecInfoBeanUtil> specInfos;
    
    //advance search prepare
    private Map<Integer,String> orgTypeMap;
    private Map<Integer,String> qualificationMap;
    private Map<Integer,String> titleMap;
    private Map<Integer,String> provinceMap;
    private Map<Integer,String> majorClassMap;
    //advance search request
    private int orgType;
    private int qualification;
    private int title;
    private int majorClass;
    private int major;
    private int province;
    private int city;
    
    //spring
    private SpecialistInfoService specInfoService;
    private SelectionService selectService;
    
	public String execute() throws Exception{
		//for staff display, specialist display is not needed
    	LogUtil.info("search value = "+searchValue);
    	if(StringUtils.isEmpty(searchValue)){
    		this.specInfoBeans = Collections.emptyList();
    		return SUCCESS;
    	}
    	this.specInfoBeans = this.specInfoService.searchByValue(searchValue.split(" "));
    	this.initSpecialistBeanDisplayData();
		LogUtil.info("display spec info:"+this.specInfoBeans.size());
		//for display
		this.specInfos = new ArrayList<SpecInfoBeanUtil>();
		for(SpecialistInfoBean bean:this.specInfoBeans){
			this.specInfos.add(new SpecInfoBeanUtil(bean,searchValue.split(" ")));
		}
        return SUCCESS;
    }
	
	public String executeAdvanceSearchPrepare(){
		this.orgTypeMap = this.selectService.getOrgType();
		this.orgTypeMap.put(-1, "--«Î—°‘Ò--");
        this.qualificationMap = this.selectService.getQualification();
        this.qualificationMap.put(-1, "--«Î—°‘Ò--");
        this.titleMap = this.selectService.getTitle();
        this.titleMap.put(-1, "--«Î—°‘Ò--");
    	this.provinceMap = this.selectService.getProvince(true);
    	this.provinceMap.put(-1, "--«Î—°‘Ò--");
        this.majorClassMap = this.selectService.getMajorClass();
        this.majorClassMap.put(-1, "--«Î—°‘Ò--");
       
    	return SUCCESS;
	}
	
	public String executeAdvanceSearch(){
		//for staff display, specialist display is not needed
    	LogUtil.info("search value = "+orgType+";"+ qualification+";"+ title+";"+ majorClass+";"+ major+";"+ province+";"+ city);
    	this.specInfoBeans = this.specInfoService.advancedSearch(orgType, qualification, title, majorClass, major, province, city);
    	this.initSpecialistBeanDisplayData();
		LogUtil.info("display spec info:"+this.specInfoBeans.size());
		//for display
		this.specInfos = new ArrayList<SpecInfoBeanUtil>();
		for(SpecialistInfoBean bean:this.specInfoBeans){
			this.specInfos.add(new SpecInfoBeanUtil(bean));
		}
        return SUCCESS;
	}
	
	private void initSpecialistBeanDisplayData(){
		Map<Integer,String> orgTypeMap = this.selectService.getOrgType();
		Map<Integer,String> qualificationMap = this.selectService.getQualification();
		Map<Integer,String> titleMap = this.selectService.getTitle();
		
		Map<Integer,String> majorClassMap = this.selectService.getMajorClass();
		Map<Integer,String> majorMap = new HashMap<Integer,String>();
		Map<Integer,Integer> majorIdMajorClassIdMap = new HashMap<Integer,Integer>();
		for(Integer majorClassId:majorClassMap.keySet()){
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
		for(SpecialistInfoBean bean:this.specInfoBeans){
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
	
	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public List<SpecInfoBeanUtil> getSpecInfos() {
		return specInfos;
	}

	//-------------------
	public Map<Integer, String> getOrgTypeMap() {
		return orgTypeMap;
	}

	public Map<Integer, String> getQualificationMap() {
		return qualificationMap;
	}

	public Map<Integer, String> getTitleMap() {
		return titleMap;
	}

	public Map<Integer, String> getProvinceMap() {
		return provinceMap;
	}

	public Map<Integer, String> getMajorClassMap() {
		return majorClassMap;
	}

	//---------------------
	public void setOrgType(int orgType) {
		this.orgType = orgType;
	}

	public void setQualification(int qualification) {
		this.qualification = qualification;
	}

	public void setTitle(int title) {
		this.title = title;
	}

	public void setMajorClass(int majorClass) {
		this.majorClass = majorClass;
	}

	public void setMajor(int major) {
		this.major = major;
	}

	public void setProvince(int province) {
		this.province = province;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public void setSpecInfoService(SpecialistInfoService specInfoService) {
		this.specInfoService = specInfoService;
	}

	public void setSelectService(SelectionService selectService) {
		this.selectService = selectService;
	}
}
