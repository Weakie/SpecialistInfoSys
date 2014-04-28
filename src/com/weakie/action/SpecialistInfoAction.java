package com.weakie.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.weakie.bean.MessageStore;
import com.weakie.bean.SpecialistInfoBean;
import com.weakie.util.log.LogUtil;

public class SpecialistInfoAction extends ActionSupport {
 
    private static final long serialVersionUID = 1L;
 
    private SpecialistInfoBean specInfoBean;
  
    private int year;
    private int month;
   
    private MessageStore messageStore;
    
	public String executeAddInfo() throws Exception{
    	LogUtil.info("add info: " + specInfoBean);
    	LogUtil.info("year:"+year+";month:"+month);
    	Map<String,String> contact = new HashMap<String,String>();
		HttpServletRequest request = ServletActionContext.getRequest();
		for(int i=1;i<20;i++){
			String name = request.getParameter("contactName-"+i);
			String method = request.getParameter("contactMethod-"+i);
			if(StringUtils.isNotEmpty(name)&&StringUtils.isNotEmpty(method))
				contact.put(name, method);
		}
		LogUtil.info("user:"+specInfoBean.getUserName()+";contact:"+contact);
		
		specInfoBean.setBirthday(year+"-"+StringUtils.rightPad(""+month, 2, '0'));
		specInfoBean.setContact(contact);
		
		LogUtil.info("finish set info:"+specInfoBean);
		/**
		 * database stored
		 */
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