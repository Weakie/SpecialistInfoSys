package com.weakie.action;

import java.io.InputStream;
import java.io.StringBufferInputStream;

import com.opensymphony.xwork2.ActionSupport;
import com.weakie.bean.MessageStore;
import com.weakie.bean.Person;
import com.weakie.util.log.LogUtil;

@SuppressWarnings("deprecation")
public class UserLoginRegisterAction extends ActionSupport {
 
    private static final long serialVersionUID = 1L;
 
    private Person personBean;
    private MessageStore messageStore;
    private InputStream inputStream;
   
    public InputStream getInputStream() {
        return inputStream;
    }
   
	public String executeUserNameExists() throws Exception{
    	
    	LogUtil.debug("exits: "+personBean.getUserName());
    	if(personBean.getUserName().equals("qwe")){
    		inputStream = new StringBufferInputStream("NOTEXIST");
    	}else{
    		inputStream = new StringBufferInputStream("EXIST");
    	}
        return SUCCESS;
    }
    
    public String executeRegister() throws Exception {
    	LogUtil.debug("register: "+personBean.getUserName());
        messageStore = new MessageStore() ;
        return SUCCESS;
    }
    
    public String executeLogin() throws Exception {
    	LogUtil.debug(personBean.getUserName());
    	LogUtil.debug(personBean.getPassword());
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
    
    public Person getPersonBean() {
		
		return personBean;
		
	}
	
	public void setPersonBean(Person person) {
		
		personBean = person;
		
	}

}
