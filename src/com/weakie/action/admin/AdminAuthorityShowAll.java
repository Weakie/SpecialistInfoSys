package com.weakie.action.admin;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.weakie.bean.Person;
import com.weakie.service.UserAccountService;
import com.weakie.util.log.LogUtil;

public class AdminAuthorityShowAll extends ActionSupport {
 
    private static final long serialVersionUID = 1L;
 
    //request
    private int pageIndex;	//50 per page
    private int status;		//1:yes
    //reponse
    private List<Person> userInfo;
    private List<Integer> pages;
    //spring
    private UserAccountService userAccountService;
    
    //method
	public String execute() throws Exception{
		LogUtil.info("pageIndex:"+pageIndex+" ,status:"+status);
    	this.userInfo = this.userAccountService.getPersonInfos(status==1? 1:0, pageIndex);
    	this.generatePages();
        return SUCCESS;
    }

	public List<Person> getUserInfo() {
		return userInfo;
	}
	
	public List<Integer> getPages() {
		return pages;
	}
	
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}
	
	public void setUserAccountService(UserAccountService userAccountService) {
		this.userAccountService = userAccountService;
	}
 
	private void generatePages(){
		this.pages = new ArrayList<Integer>();
		if(this.pageIndex<=1){
			this.pages.add(1);
			for(int i=0;i<6;i++){
				this.pages.add(i+this.pageIndex);
			}
		} else if(this.pageIndex%5==0){
			for(int i=-5;i<2;i++){
				this.pages.add(i+this.pageIndex);
			}
		} else if(this.pageIndex%5==1){
			for(int i=-1;i<6;i++){
				this.pages.add(i+this.pageIndex);
			}
		} else {
			int begin = this.pageIndex-this.pageIndex%5;
			for(int i=0;i<7;i++){
				this.pages.add(i+begin);
			}
		}
		LogUtil.debug("pageIndex:"+pageIndex+" ,Pahes: "+pages);
	}
}
