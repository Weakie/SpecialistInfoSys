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
     * Ajax,����û����Ƿ����
     * @return
     */
	public String executeUserNameExists(){
    	LogUtil.debug("exits: "+userName);
    	//�Ϸ��Լ��
    	if(StringUtils.isEmpty(userName)){
    		inputStream = new StringBufferInputStream(SystemConstant.INVALID+":1");
    		return SUCCESS;
    	}
    	//���������5-12λ��ĸ�����������
    	if(!StringUtils.isAlphanumeric(userName) || StringUtils.length(userName)<5 || StringUtils.length(userName)>12){
    		inputStream = new StringBufferInputStream(SystemConstant.INVALID+":2");
    		return SUCCESS;
    	}
    	//����û����Ƿ����
    	if(accountService.checkAccount(userName)){
    		inputStream = new StringBufferInputStream(SystemConstant.EXIST);
    	}else{
    		inputStream = new StringBufferInputStream(SystemConstant.NOTEXIST);
    	}
        return SUCCESS;
    }
    
	/**
	 * ע��-ҳ���ύ
	 * @return
	 */
    public String executeRegister(){
    	LogUtil.debug("register: "+userName);
    	//�Ϸ��Լ��
    	if(StringUtils.isEmpty(userName)||StringUtils.isEmpty(password)){
    		messageStore = new MessageStore("�û��������벻��Ϊ��") ;
    		return INPUT;
    	}
    	//���������5-12λ��ĸ�����������
    	if(!StringUtils.isAlphanumeric(userName) 
    			|| StringUtils.length(userName)<5 || StringUtils.length(userName)>12
    			|| StringUtils.length(password)<8 || StringUtils.length(password)>12){
    		messageStore = new MessageStore("�û����������ʽ����") ;
    		return INPUT;
    	}
    	//ע��-��������û����Ƿ����
    	try {
			if(accountService.register(userName, password)){
				this.specInfoService.insertNewSpecialistInfo(userName);
				return SUCCESS;
			}else{
				messageStore = new MessageStore("ע��ʧ��-�û����Ѵ���") ;
			}
		} catch (Exception e) {
			LogUtil.error(e);
			messageStore = new MessageStore("ע��ʧ��:ϵͳ����") ;
		}
        return INPUT;
    }
    
    /**
     * ����µĹ�����Ա�˻�
     * @return
     */
    public String executeAddNewStaff(){
    	LogUtil.debug("add staff: "+userName);
    	//�Ϸ��Լ��
    	if(StringUtils.isEmpty(userName)){
    		messageStore = new MessageStore("�û�������Ϊ��") ;
    		return INPUT;
    	}
    	//����û���������5-12λ��ĸ�����������
    	if(!StringUtils.isAlphanumeric(userName) 
    			|| StringUtils.length(userName)<5 || StringUtils.length(userName)>12){
    		messageStore = new MessageStore("�û�����5-12λ��ĸ�����������") ;
    		return INPUT;
    	}
    	//ע��-��������û����Ƿ����
    	try {
			if(accountService.addNewStaff(userName)){
				messageStore = new MessageStore("��ӳɹ�") ;
				return SUCCESS;
			}else{
				messageStore = new MessageStore("���ʧ��-�û����Ѵ���") ;
			}
		} catch (Exception e) {
			LogUtil.error(e);
			messageStore = new MessageStore("ע��ʧ��:ϵͳ����") ;
		}
        return INPUT;
    }
    
    /**
     * ��¼
     * @return
     */
    public String executeLogin() {
    	LogUtil.info(userName);
    	//�Ϸ��Լ��
    	if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)){
    		messageStore = new MessageStore("�û��������벻��Ϊ��") ;
    		return INPUT;
    	}
    	//��¼-����sessionScope
    	Person p = null;
		try {
			p = accountService.login(userName, password);
			if(p!=null){
	    		ActionContext.getContext().getSession().put(SystemConstant.USER, p);
	    		return SUCCESS;
	    	}else{
	    		messageStore=new MessageStore("��¼ʧ��"); 
	    	}
		} catch (Exception e) {
			LogUtil.error(e);
			messageStore = new MessageStore("��¼ʧ��:ϵͳ����") ;
		}
		return INPUT;
    }
    
    /**
     * �û���������
     * @return
     */
    public String executeResetPassword() {
    	LogUtil.debug("reset password,userName="+userName);
    	//�Ϸ��Լ��
    	if(StringUtils.isEmpty(userName)){
    		messageStore=new MessageStore("���ȵ�¼"); 
    		return INPUT;
    	}
    	//���볤�ȼ��
    	if(StringUtils.length(password)<8 || StringUtils.length(password)>12
    			|| StringUtils.length(newPassword)<8 || StringUtils.length(newPassword)>12){
    		messageStore=new MessageStore("������8-12λ�ַ����"); 
    		return INPUT;
    	}
    	//�¾������Ƿ���ͬ
    	if(StringUtils.equals(password, newPassword)){
    		messageStore=new MessageStore("ԭʼ����������벻����ͬ"); 
    		return INPUT;
    	}
    	//�޸�����
    	Person p = null;
		try {
			p = accountService.resetPassword(userName, password, newPassword);
			if(p!=null){
	    		ActionContext.getContext().getSession().put(SystemConstant.USER, p);
	    		messageStore=new MessageStore("�����޸ĳɹ�"); 
	    		return SUCCESS;
	    	}else{
	    		messageStore=new MessageStore("��������ʧ��"); 
	    	}
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.error(e);
			messageStore = new MessageStore("��������:ϵͳ����") ;
		}
		return INPUT;
    }
    
    /**
     * �û��޸��ǳ�
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
	    		inputStream = new ByteArrayInputStream("1:�޸ĳɹ�".getBytes("UTF-8"));
	    	}else{
	    		inputStream = new ByteArrayInputStream("0:�޸�ʧ��".getBytes("UTF-8"));
	    	}
		} catch (Exception e) {
			LogUtil.error(e);
			try {
				inputStream = new ByteArrayInputStream("0:�ǳ�����:ϵͳ����".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				LogUtil.error(e1);
			}
		}
		return SUCCESS;
    }
 
    /**
     * �û���������Ȩ��
     * @return
     */
    public String executeApplyAuthority(){
    	int result = this.accountService.updateUserAuthority(userName, UserAccountConstant.APPLY_AUTHORITY);
    	try {
    		if(result == 1){
    			inputStream = new ByteArrayInputStream("1:����ɹ�".getBytes("UTF-8"));
    		}else{
    			inputStream = new ByteArrayInputStream("0:����ʧ��".getBytes("UTF-8"));
    		}
		} catch (UnsupportedEncodingException e) {
			LogUtil.error(e);
			try {
				inputStream = new ByteArrayInputStream("0:����ʧ��-ϵͳ����".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				LogUtil.error(e1);
			}
		}
    	return SUCCESS;
    }
    
    /**
     * �ǳ�
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
