package com.weakie.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.weakie.util.log.LogUtil;

public class SpecialistInfoAddPrepareAction extends ActionSupport {
 
    private static final long serialVersionUID = 1L;
 
    //for prepare
    private String userName;
    private Map<Integer,String> orgTypeMap;
    private Map<Integer,String> provinceMap;
    private Map<Integer,String> cityMap;
    private Map<Integer,String> qualificationMap;
    private Map<Integer,String> titleMap;
    private Map<Integer,String> majorClassMap;
    private Map<Integer,String> majorMap;
    
    //for ajax
    private int index;
    private String item;
    private String itemID;
    private InputStream inputStream;
    
    public String executePrepare() throws Exception {
    	userName="hahaha";
    	
        orgTypeMap = new HashMap<Integer,String>();
        orgTypeMap.put(1, "政府");
        orgTypeMap.put(2, "大学");
        orgTypeMap.put(3, "研究所");
        orgTypeMap.put(4, "企业");
        orgTypeMap.put(5, "其他");
        
        provinceMap = new HashMap<Integer,String>();
        provinceMap.put(1, "浙江");
        provinceMap.put(4, "北京");
        provinceMap.put(2, "上海");
        provinceMap.put(3, "广州");
        provinceMap.put(5, "江苏");
        
        cityMap = new HashMap<Integer,String>();
        cityMap.put(1, "杭州");
        cityMap.put(2, "温州");
        cityMap.put(3, "宁波");
        
        qualificationMap = new HashMap<Integer,String>();
        qualificationMap.put(1, "注册规划师");
        qualificationMap.put(2, "建造师");
        qualificationMap.put(3, "一级建筑师");
        qualificationMap.put(4, "其他");
        
        titleMap = new HashMap<Integer,String>();
        titleMap.put(1, "中级");
        titleMap.put(2, "高级");
        
        majorClassMap = new HashMap<Integer,String>();
        majorClassMap.put(1, "建筑");
        majorClassMap.put(2, "规划");
        majorClassMap.put(3, "景观");
        majorClassMap.put(5, "其他");
        
        majorMap = new HashMap<Integer,String>();
        majorMap.put(1, "公共建筑");
        majorMap.put(2, "别墅");
        majorMap.put(3, "住宅");
        majorMap.put(4, "工业建筑");
        majorMap.put(5, "其他");
        
        return SUCCESS;
    }
    
	public String executeUpdate() throws Exception{
    	
    	//LogUtil.debug("exits: "+personBean.getUserName());
    	if(item.equals("orgPlace")){
    		//index first,seperate by ;
    		LogUtil.debug(item+" "+itemID);
    		String result = ""+index+";1:上海市;2:北京市";
    		this.inputStream = new ByteArrayInputStream(result.getBytes("UTF-8"));
    	}else if(item.equals("province")){
    		LogUtil.debug(item+" "+itemID);
    		String result = ""+index+";1:杭州;2:溫州";
    		this.inputStream = new ByteArrayInputStream(result.getBytes("UTF-8"));
    	}else if(item.equals("majorClass")){
    		LogUtil.debug(item+" "+itemID);
    		String result = "1:公共建筑;2:别墅";
    		this.inputStream = new ByteArrayInputStream(result.getBytes("UTF-8"));
    	}
        return SUCCESS;
    }
    
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Map<Integer, String> getOrgTypeMap() {
		return orgTypeMap;
	}


	public Map<Integer, String> getProvinceMap() {
		return provinceMap;
	}


	public Map<Integer, String> getCityMap() {
		return cityMap;
	}

	public Map<Integer, String> getQualificationMap() {
		return qualificationMap;
	}

	public Map<Integer, String> getTitleMap() {
		return titleMap;
	}

	public Map<Integer, String> getMajorClassMap() {
		return majorClassMap;
	}

	public Map<Integer, String> getMajorMap() {
		return majorMap;
	}

	public void setIndex(int index){
		this.index = index;
	}
	
	public void setItem(String item) {
		this.item = item;
	}

	public void setItemID(String itemid) {
		this.itemID = itemid;
	}
	
	public InputStream getInputStream() {
	    return inputStream;
	}

}