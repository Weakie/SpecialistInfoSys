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
        orgTypeMap.put(1, "����");
        orgTypeMap.put(2, "��ѧ");
        orgTypeMap.put(3, "�о���");
        orgTypeMap.put(4, "��ҵ");
        orgTypeMap.put(5, "����");
        
        provinceMap = new HashMap<Integer,String>();
        provinceMap.put(1, "�㽭");
        provinceMap.put(4, "����");
        provinceMap.put(2, "�Ϻ�");
        provinceMap.put(3, "����");
        provinceMap.put(5, "����");
        
        cityMap = new HashMap<Integer,String>();
        cityMap.put(1, "����");
        cityMap.put(2, "����");
        cityMap.put(3, "����");
        
        qualificationMap = new HashMap<Integer,String>();
        qualificationMap.put(1, "ע��滮ʦ");
        qualificationMap.put(2, "����ʦ");
        qualificationMap.put(3, "һ������ʦ");
        qualificationMap.put(4, "����");
        
        titleMap = new HashMap<Integer,String>();
        titleMap.put(1, "�м�");
        titleMap.put(2, "�߼�");
        
        majorClassMap = new HashMap<Integer,String>();
        majorClassMap.put(1, "����");
        majorClassMap.put(2, "�滮");
        majorClassMap.put(3, "����");
        majorClassMap.put(5, "����");
        
        majorMap = new HashMap<Integer,String>();
        majorMap.put(1, "��������");
        majorMap.put(2, "����");
        majorMap.put(3, "סլ");
        majorMap.put(4, "��ҵ����");
        majorMap.put(5, "����");
        
        return SUCCESS;
    }
    
	public String executeUpdate() throws Exception{
    	
    	//LogUtil.debug("exits: "+personBean.getUserName());
    	if(item.equals("orgPlace")){
    		//index first,seperate by ;
    		LogUtil.debug(item+" "+itemID);
    		String result = ""+index+";1:�Ϻ���;2:������";
    		this.inputStream = new ByteArrayInputStream(result.getBytes("UTF-8"));
    	}else if(item.equals("province")){
    		LogUtil.debug(item+" "+itemID);
    		String result = ""+index+";1:����;2:����";
    		this.inputStream = new ByteArrayInputStream(result.getBytes("UTF-8"));
    	}else if(item.equals("majorClass")){
    		LogUtil.debug(item+" "+itemID);
    		String result = "1:��������;2:����";
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