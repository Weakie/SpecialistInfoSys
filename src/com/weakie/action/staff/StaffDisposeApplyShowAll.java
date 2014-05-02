package com.weakie.action.staff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;
import com.weakie.bean.ApplyInfo;
import com.weakie.service.ApplyInfoService;
import com.weakie.service.UserAccountService;

public class StaffDisposeApplyShowAll extends ActionSupport {
 
    private static final long serialVersionUID = 1L;
 
    //request
    private int pageIndex;	//50 per page
    private int status;
    private String staffId;
    //reponse
    private List<ApplyInfo> applyInfo;
    private List<Integer> pages;
    private Map<String,String> staffIdNameMap;
    //spring
    private ApplyInfoService applyInfoService;
    private UserAccountService userAccountService;
    
    //method
	public String execute() throws Exception{
    	this.applyInfo = this.applyInfoService.getApplyInfos(staffId, status, pageIndex);
    	Collections.sort(this.applyInfo);
    	Set<String> staffIdSet = new HashSet<String>();
    	for(ApplyInfo info:applyInfo){
    		staffIdSet.add(info.getStaffID());
    	}
    	this.staffIdNameMap = this.userAccountService.getStaffNiceNameMap(staffIdSet);
        return SUCCESS;
    }

	public List<ApplyInfo> getApplyInfo() {
		return applyInfo;
	}
	
	public List<Integer> getPages() {
		this.pages = new ArrayList<Integer>();
		if(this.pageIndex==1){
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
		}
		return pages;
	}
	
	public Map<String, String> getStaffIdNameMap() {
		return staffIdNameMap;
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

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	

	public void setApplyInfoService(ApplyInfoService applyInfoService) {
		this.applyInfoService = applyInfoService;
	}

	public void setUserAccountService(UserAccountService userAccountService) {
		this.userAccountService = userAccountService;
	}

 
}
