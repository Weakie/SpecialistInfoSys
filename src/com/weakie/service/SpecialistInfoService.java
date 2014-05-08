package com.weakie.service;

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
}
