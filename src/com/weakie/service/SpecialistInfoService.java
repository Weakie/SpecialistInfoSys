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
}
