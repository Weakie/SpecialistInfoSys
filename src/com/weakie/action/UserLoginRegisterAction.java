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
   
    /**
     * Ajax,检查用户名是否存在
     * @return
     */
	public String executeUserNameExists(){
    	LogUtil.debug("exits: "+userName);
    	//合法性检查
    	if(StringUtils.isEmpty(userName)){
    		inputStream = new StringBufferInputStream(SystemConstant.INVALID+":1");
    		return SUCCESS;
    	}
    	//如果不是由5-12位字母或者数字组成
    	if(!StringUtils.isAlphanumeric(userName) || StringUtils.length(userName)<5 || StringUtils.length(userName)>12){
    		inputStream = new StringBufferInputStream(SystemConstant.INVALID+":2");
    		return SUCCESS;
    	}
    	//检查用户名是否存在
    	if(accountService.checkAccount(userName)){
    		inputStream = new StringBufferInputStream(SystemConstant.EXIST);
    	}else{
    		inputStream = new StringBufferInputStream(SystemConstant.NOTEXIST);
    	}
        return SUCCESS;
    }
    
	/**
	 * 注册-页面提交
	 * @return
	 */
    public String executeRegister(){
    	LogUtil.debug("register: "+userName);
    	//合法性检查
    	if(StringUtils.isEmpty(userName)||StringUtils.isEmpty(password)){
    		messageStore = new MessageStore("用户名或密码不能为空") ;
    		return INPUT;
    	}
    	//如果不是由5-12位字母或者数字组成
    	if(!StringUtils.isAlphanumeric(userName) 
    			|| StringUtils.length(userName)<5 || StringUtils.length(userName)>12
    			|| StringUtils.length(password)<8 || StringUtils.length(password)>12){
    		messageStore = new MessageStore("用户名或密码格式不对") ;
    		return INPUT;
    	}
    	//注册-包含检查用户名是否存在
    	try {
			if(accountService.register(userName, password)){
				this.specInfoService.insertNewSpecialistInfo(userName);
				return SUCCESS;
			}else{
				messageStore = new MessageStore("注册失败-用户名已存在") ;
			}
		} catch (Exception e) {
			LogUtil.error(e);
			messageStore = new MessageStore("注册失败:系统错误") ;
		}
        return INPUT;
    }
    
    /**
     * 添加新的工作人员账户
     * @return
     */
    public String executeAddNewStaff(){
    	LogUtil.debug("add staff: "+userName);
    	//合法性检查
    	if(StringUtils.isEmpty(userName)){
    		messageStore = new MessageStore("用户名不能为空") ;
    		return INPUT;
    	}
    	//如果用户名不是由5-12位字母或者数字组成
    	if(!StringUtils.isAlphanumeric(userName) 
    			|| StringUtils.length(userName)<5 || StringUtils.length(userName)>12){
    		messageStore = new MessageStore("用户名由5-12位字母或者数字组成") ;
    		return INPUT;
    	}
    	//注册-包含检查用户名是否存在
    	try {
			if(accountService.addNewStaff(userName)){
				messageStore = new MessageStore("添加成功") ;
				return SUCCESS;
			}else{
				messageStore = new MessageStore("添加失败-用户名已存在") ;
			}
		} catch (Exception e) {
			LogUtil.error(e);
			messageStore = new MessageStore("注册失败:系统错误") ;
		}
        return INPUT;
    }
    
    /**
     * 登录
     * @return
     */
    public String executeLogin() {
    	LogUtil.info(userName);
    	//合法性检查
    	if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)){
    		messageStore = new MessageStore("用户名或密码不能为空") ;
    		return INPUT;
    	}
    	//登录-加入sessionScope
    	Person p = null;
		try {
			p = accountService.login(userName, password);
			if(p!=null){
	    		ActionContext.getContext().getSession().put(SystemConstant.USER, p);
	    		return SUCCESS;
	    	}else{
	    		messageStore=new MessageStore("登录失败"); 
	    	}
		} catch (Exception e) {
			LogUtil.error(e);
			messageStore = new MessageStore("登录失败:系统错误") ;
		}
		return INPUT;
    }
    
    /**
     * 用户重置密码
     * @return
     */
    public String executeResetPassword() {
    	LogUtil.debug("reset password,userName="+userName);
    	//合法性检查
    	if(StringUtils.isEmpty(userName)){
    		messageStore=new MessageStore("请先登录"); 
    		return INPUT;
    	}
    	//密码长度检查
    	if(StringUtils.length(password)<8 || StringUtils.length(password)>12
    			|| StringUtils.length(newPassword)<8 || StringUtils.length(newPassword)>12){
    		messageStore=new MessageStore("密码由8-12位字符组成"); 
    		return INPUT;
    	}
    	//新旧密码是否相同
    	if(StringUtils.equals(password, newPassword)){
    		messageStore=new MessageStore("原始密码和新密码不能相同"); 
    		return INPUT;
    	}
    	//修改密码
    	Person p = null;
		try {
			p = accountService.resetPassword(userName, password, newPassword);
			if(p!=null){
	    		ActionContext.getContext().getSession().put(SystemConstant.USER, p);
	    		messageStore=new MessageStore("密码修改成功"); 
	    		return SUCCESS;
	    	}else{
	    		messageStore=new MessageStore("密码重置失败"); 
	    	}
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.error(e);
			messageStore = new MessageStore("密码重置:系统错误") ;
		}
		return INPUT;
    }
    
    /**
     * 用户修改昵称
     * @return
     */
    public String updateNickName(){
    	//decode first, for Chinese.
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
	    		inputStream = new ByteArrayInputStream("1:修改成功".getBytes("UTF-8"));
	    	}else{
	    		inputStream = new ByteArrayInputStream("0:修改失败".getBytes("UTF-8"));
	    	}
		} catch (Exception e) {
			LogUtil.error(e);
			try {
				inputStream = new ByteArrayInputStream("0:昵称重置:系统错误".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				LogUtil.error(e1);
			}
		}
		return SUCCESS;
    }
 
    /**
     * 用户申请搜索权限
     * @return
     */
    public String executeApplyAuthority(){
    	int result = this.accountService.updateUserAuthority(userName, UserAccountConstant.APPLY_AUTHORITY);
    	try {
    		if(result == 1){
    			inputStream = new ByteArrayInputStream("1:申请成功".getBytes("UTF-8"));
    		}else{
    			inputStream = new ByteArrayInputStream("0:申请失败".getBytes("UTF-8"));
    		}
		} catch (UnsupportedEncodingException e) {
			LogUtil.error(e);
			try {
				inputStream = new ByteArrayInputStream("0:申请失败-系统错误".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				LogUtil.error(e1);
			}
		}
    	return SUCCESS;
    }
    
    /**
     * 登出
     * @return
     */
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
