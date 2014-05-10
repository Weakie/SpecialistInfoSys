package com.weakie.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.weakie.bean.MessageStore;
import com.weakie.bean.Person;
import com.weakie.constant.SystemConstant;
import com.weakie.constant.UserAccountConstant;
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
    	LogUtil.debug("reset password,userName="+userName);
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
    
    public String updateNickName(){
    	//decode first, for chinese
    	try {
			this.password =  java.net.URLDecoder.decode(this.password,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			LogUtil.error(e);
		}
    	LogUtil.debug("updateNickName-userName: "+userName+",nickName="+password);
    	
    	int result = 0;
		try {
			//password represent for nickname at this action
			result = accountService.updateNickName(userName, password);
			if(result!=0){
	    		Person p = (Person) ActionContext.getContext().getSession().get(SystemConstant.USER);
	    		p.setNickName(password);
	    		ActionContext.getContext().getSession().put(SystemConstant.USER, p);
	    		inputStream = new ByteArrayInputStream("1:–ﬁ∏ƒ≥…π¶".getBytes("UTF-8"));
	    	}else{
	    		inputStream = new ByteArrayInputStream("0:–ﬁ∏ƒ ß∞‹".getBytes("UTF-8"));
	    	}
		} catch (Exception e) {
			LogUtil.error(e);
			try {
				inputStream = new ByteArrayInputStream("0:Í«≥∆÷ÿ÷√:œµÕ≥¥ÌŒÛ".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				LogUtil.error(e1);
			}
		}
		return SUCCESS;
    }
 
    public String executeApplyAuthority(){
    	int result = this.accountService.updateUserAuthority(userName, UserAccountConstant.APPLY_AUTHORITY);
    	try {
    		if(result == 1){
    			inputStream = new ByteArrayInputStream("1:…Í«Î≥…π¶".getBytes("UTF-8"));
    		}else{
    			inputStream = new ByteArrayInputStream("0:…Í«Î ß∞‹".getBytes("UTF-8"));
    		}
		} catch (UnsupportedEncodingException e) {
			LogUtil.error(e);
			try {
				inputStream = new ByteArrayInputStream("0:…Í«Î ß∞‹:œµÕ≥¥ÌŒÛ".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				LogUtil.error(e1);
			}
		}
    	return SUCCESS;
    }
    public String executeLogout() {
    	HttpServletRequest request = ServletActionContext.getRequest();
    	request.getSession().invalidate();
    	return SUCCESS;
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
