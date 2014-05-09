package com.weakie.action;

import java.io.InputStream;
import java.io.StringBufferInputStream;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.weakie.bean.MessageStore;
import com.weakie.bean.Person;
import com.weakie.constant.SystemConstant;
import com.weakie.service.SpecialistInfoService;
import com.weakie.service.UserAccountService;
import com.weakie.util.log.LogUtil;

@SuppressWarnings("deprecation")
public class UserLoginRegisterAction extends ActionSupport {
 
    private static final long serialVersionUID = 1L;
 
    //request
    private String userName;
    private String password;
    private String newPassword;
    //result
    private InputStream inputStream;
    private MessageStore messageStore;
    //spring
    private UserAccountService accountService;
    private SpecialistInfoService specInfoService;
    
    public InputStream getInputStream() {
        return inputStream;
    }
   
	public String executeUserNameExists(){
    	LogUtil.debug("exits: "+userName);
    	if(accountService.checkAccount(userName)){
    		inputStream = new StringBufferInputStream(SystemConstant.EXIST);
    	}else{
    		inputStream = new StringBufferInputStream(SystemConstant.NOTEXIST);
    	}
        return SUCCESS;
    }
    
    public String executeRegister(){
    	LogUtil.debug("register: "+userName);
    	try {
			if(accountService.register(userName, password)){
				this.specInfoService.insertNewSpecialistInfo(userName);
				return SUCCESS;
			}else{
				messageStore = new MessageStore("◊¢≤· ß∞‹") ;
			}
		} catch (Exception e) {
			LogUtil.error(e);
			messageStore = new MessageStore("◊¢≤· ß∞‹:œµÕ≥¥ÌŒÛ") ;
		}
        return INPUT;
    }
    
    public String executeLogin() {
    	LogUtil.debug(userName);
    	Person p = null;
		try {
			p = accountService.login(userName, password);
			if(p!=null){
	    		ActionContext.getContext().getSession().put(SystemConstant.USER, p);
	    		return SUCCESS;
	    	}else{
	    		messageStore=new MessageStore("µ«¬º ß∞‹"); 
	    	}
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.error(e);
			messageStore = new MessageStore("µ«¬º ß∞‹:œµÕ≥¥ÌŒÛ") ;
		}
		return INPUT;
    }
    
    public String executeResetPassword() {
    	LogUtil.debug(userName);
    	if(StringUtils.isEmpty(userName)){
    		messageStore=new MessageStore("«Îœ»µ«¬º"); 
    		return INPUT;
    	}
    	Person p = null;
		try {
			p = accountService.resetPassword(userName, password, newPassword);
			if(p!=null){
	    		ActionContext.getContext().getSession().put(SystemConstant.USER, p);
	    		messageStore=new MessageStore("√‹¬Î–ﬁ∏ƒ≥…π¶"); 
	    		return SUCCESS;
	    	}else{
	    		messageStore=new MessageStore("√‹¬Î÷ÿ÷√ ß∞‹"); 
	    	}
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.error(e);
			messageStore = new MessageStore("√‹¬Î÷ÿ÷√:œµÕ≥¥ÌŒÛ") ;
		}
		return INPUT;
    }
 
    public MessageStore getMessageStore() {
        return messageStore;
    }
 
    public void setMessageStore(MessageStore messageStore) {
        this.messageStore = messageStore;
    }

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public void setAccountService(UserAccountService accountService) {
		this.accountService = accountService;
	}

	public void setSpecInfoService(SpecialistInfoService specInfoService) {
		this.specInfoService = specInfoService;
	}
    
}
