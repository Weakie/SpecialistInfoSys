package com.weakie.action;

import com.opensymphony.xwork2.ActionSupport;
import com.weakie.bean.MessageStore;
import com.weakie.bean.SpecialistInfoBean;

public class SpecialistInfoAction extends ActionSupport {
 
    private static final long serialVersionUID = 1L;
 
    private SpecialistInfoBean specInfoBean;
    private MessageStore messageStore;
 
    private int year;
    private int month;
   
    
    
	public String executeAddInfo() throws Exception{
    	
    	//LogUtil.debug("exits: "+personBean.getUserName());
    	
        return SUCCESS;
    }
    
   
    
    public String executeLogin() throws Exception {
    	
        messageStore = new MessageStore();
        if(true){
        	messageStore.setMessage("µÇÂ¼Ê§°Ü"); 
        }
        return SUCCESS;
    }
 
    public MessageStore getMessageStore() {
        return messageStore;
    }
 
    public void setMessageStore(MessageStore messageStore) {
        this.messageStore = messageStore;
    }

	public SpecialistInfoBean getSpecInfoBean() {
		return specInfoBean;
	}

	public void setSpecInfoBean(SpecialistInfoBean specInfoBean) {
		this.specInfoBean = specInfoBean;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
    
}