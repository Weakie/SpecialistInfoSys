package com.weakie.service;

import java.util.List;

import com.weakie.bean.SpecialistInfoBean;

/**
 * 
 * @author weakie
 *
 */
public interface SpecialistInfoService {
	
	public SpecialistInfoBean getSpecialistInfoByUsername(String UserName);

	public int updateSpecialistInfo(SpecialistInfoBean bean);
	
	public int insertNewSpecialistInfo(String userName);
	
	public int getSpecialistInfoState(String userName);
	
	public int updateSpecialistInfoState(String userName,int state);
	
	public List<SpecialistInfoBean> searchByValue(String[] values);
	
	public List<SpecialistInfoBean> advancedSearch(int orgType,int qualification,int title,int majorClass,int major,int province,int city);
}
