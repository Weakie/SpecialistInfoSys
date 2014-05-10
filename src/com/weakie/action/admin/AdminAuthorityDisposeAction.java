package com.weakie.action.admin;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import com.opensymphony.xwork2.ActionSupport;
import com.weakie.constant.UserAccountConstant;
import com.weakie.service.UserAccountService;
import com.weakie.util.log.LogUtil;

public class AdminAuthorityDisposeAction extends ActionSupport {
 
    private static final long serialVersionUID = 1L;
 
    //request
    private String userName;
    private int authority;
    //result
    private InputStream inputStream;
    //spring
    private UserAccountService accountService;
    
    public String executeDisposeAuthority(){
    	if(authority>0){
    		authority = UserAccountConstant.SEARCH_AUTHORITY;
    	}else{
    		authority = UserAccountConstant.NOSEARCH_AUTHORITY;
    	}
    	try {
    		int result = this.accountService.updateUserAuthority(userName, authority);
    		String resultString = null;
    		if(result == 1){
    			resultString = "1:"+userName+":"+authority+":³É¹¦";
    			
    		}else{
    			resultString = "0:"+userName+":"+authority+":Ê§°Ü";
    			
    		}
    		inputStream = new ByteArrayInputStream(resultString.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			LogUtil.error(e);
		}
    	return SUCCESS;
    }
    
    public InputStream getInputStream() {
        return inputStream;
    }
   
	public void setAuthority(int authority) {
		this.authority = authority;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setAccountService(UserAccountService accountService) {
		this.accountService = accountService;
	}

}
