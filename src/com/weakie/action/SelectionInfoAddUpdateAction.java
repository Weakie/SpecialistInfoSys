package com.weakie.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.weakie.service.SelectionService;
import com.weakie.util.log.LogUtil;

public class SelectionInfoAddUpdateAction extends ActionSupport {
 
    private static final long serialVersionUID = 1L;
 
    //for prepare-add
    private Map<Integer,String> orgTypeMap;
    private Map<Integer,String> qualificationMap;
    private Map<Integer,String> titleMap;
    private Map<Integer,String> provinceMap;
    private Map<Integer,String> cityMap;	
    private Map<Integer,String> majorClassMap;
    private Map<Integer,String> majorMap;	
    
    
    //for ajax:dynamic update
    private String ope;		//操作:A,U
    private int key;		//种类:SystemConstant.key_*
    private String value;	//值
    private int item;		//所属ID
    private int id;			//数据id, update用
    
    //response
	private InputStream inputStream;
    
    //service
    private SelectionService selectService;
        
    //prepare
    public String executePrepare(){
    	this.orgTypeMap = this.selectService.getOrgType();
        this.qualificationMap = this.selectService.getQualification();
        this.titleMap = this.selectService.getTitle();
       
        //
    	this.provinceMap = this.selectService.getProvince(true);
    	//这里参数应该与provinceMap第一个值对应的数据有关
    	int firstProvinceId = this.provinceMap.keySet().iterator().next();
        this.cityMap = this.selectService.getCity(firstProvinceId);
        LogUtil.debug("firstprovinceId: "+firstProvinceId);
       
        //
        this.majorClassMap = this.selectService.getMajorClass();
        //这里参数应该与majorClassMap第一个值对应的数据有关
        int firstMajorId = (this.majorClassMap.keySet().iterator().hasNext()?this.majorClassMap.keySet().iterator().next():2);
        this.majorMap = this.selectService.getMajor(firstMajorId);
        LogUtil.debug("firstMajorId: "+firstMajorId);
    	return SUCCESS;
    }
    
    //ajax
	public String executeUpdate(){
		LogUtil.info("ope="+this.ope+",value="+this.value+ ",key="+this.key+ ",item="+this.item+",id="+this.id);
		StringBuilder sb = new StringBuilder();
		try{
			Map<Integer,String> resultMap = null;
			if(StringUtils.equals(this.ope, "A")){
				resultMap = this.selectService.insertValues(value, key, item);
			}else if(StringUtils.equals(this.ope, "U")){
				resultMap = this.selectService.updateValues(value, key, item, id);
			}
			sb.append("1:"+key);
			for(int i:resultMap.keySet()){
				sb.append(";"+i+":"+resultMap.get(i));
			}
		}catch(Exception e){
			sb.append("0:"+key);
			LogUtil.error(e);
		}
		String result = sb.toString();	
		try {
			this.inputStream = new ByteArrayInputStream(result.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			LogUtil.error(e);
		}
		LogUtil.info("result="+result);
        return SUCCESS;
    }

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

	public Map<Integer, String> getCityMap() {
		return cityMap;
	}

	public Map<Integer, String> getMajorClassMap() {
		return majorClassMap;
	}

	public Map<Integer, String> getMajorMap() {
		return majorMap;
	}

	public void setOpe(String ope) {
		this.ope = ope;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public void setValue(String value) {
		try {
			this.value =  java.net.URLDecoder.decode(value,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			LogUtil.error(e);
		}
	}

	public void setItem(int item) {
		this.item = item;
	}

	public void setId(int id) {
		this.id = id;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setSelectService(SelectionService selectService) {
		this.selectService = selectService;
	}

	
	
}