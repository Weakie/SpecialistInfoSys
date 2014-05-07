package com.weakie.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.weakie.service.SelectionService;
import com.weakie.util.log.LogUtil;

public class SpecialistInfoAddUpdateAction extends ActionSupport {
 
    private static final long serialVersionUID = 1L;
 
    //for ajax:dynamic update
    private int index;
    private String item;
    private String itemID;
    private InputStream inputStream;
    
    //service
    private SelectionService selectService;
        
	public String executeUpdate() throws Exception{
    	
    	if(item.equals("orgPlace")){
    		//index first, separate by ;
    		LogUtil.debug(item+" "+itemID);
    		Map<Integer,String> proMap = this.selectService.getProvince(!Boolean.parseBoolean(itemID));
    		StringBuilder sb = new StringBuilder();
    		sb.append(index);
    		for(int i:proMap.keySet()){
    			sb.append(";"+i+":"+proMap.get(i));
    		}
    		String result = sb.toString();//""+index+";1:上海市;2:北京市"
    		this.inputStream = new ByteArrayInputStream(result.getBytes("UTF-8"));
    	}else if(item.equals("province")){
    		LogUtil.debug(item+" "+itemID);
    		Map<Integer,String> cityMap = this.selectService.getCity(Integer.parseInt(itemID));
    		StringBuilder sb = new StringBuilder();
    		sb.append(index);
    		for(int i:cityMap.keySet()){
    			sb.append(";"+i+":"+cityMap.get(i));
    		}
    		String result = sb.toString();//""+index+";1:杭州;2:溫州"
    		this.inputStream = new ByteArrayInputStream(result.getBytes("UTF-8"));
    	}else if(item.equals("majorClass")){
    		LogUtil.debug(item+" "+itemID);
    		Map<Integer,String> majorMap = this.selectService.getMajor(Integer.parseInt(itemID));
    		StringBuilder sb = new StringBuilder();
    		for(int i:majorMap.keySet()){
    			sb.append(i+":"+majorMap.get(i)+";");
    		}
    		String result = "";
    		if(sb.length()>0){
    			result = sb.substring(0, sb.length()-1);//"1:公共建筑;2:别墅"
    		}
    		this.inputStream = new ByteArrayInputStream(result.getBytes("UTF-8"));
    	}
        return SUCCESS;
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

	public void setSelectService(SelectionService selectService) {
		this.selectService = selectService;
	}

}