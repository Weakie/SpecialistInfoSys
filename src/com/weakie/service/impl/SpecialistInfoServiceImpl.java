package com.weakie.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.weakie.bean.SpecialistInfoBean;
import com.weakie.dao.SpecInfoDAO;
import com.weakie.service.SpecialistInfoService;

/**
 * @author weakie E-mail:weakielin@gmail.com
 * 2014年4月29日下午5:54:53
 */
public class SpecialistInfoServiceImpl implements SpecialistInfoService {

	private SpecInfoDAO dao;
	/* (non-Javadoc)
	 * @see com.weakie.service.SpecialistInfoService#getSpecialistInfoByUsername(java.lang.String)
	 */
	@Override
	public SpecialistInfoBean getSpecialistInfoByUsername(String userName) {
		return dao.selectSpecInfo(userName);
	}

	/* (non-Javadoc)
	 * @see com.weakie.service.SpecialistInfoService#updateSpecialistInfo(com.weakie.bean.SpecialistInfoBean)
	 */
	@Override
	public int updateSpecialistInfo(SpecialistInfoBean bean) {
		return dao.updateSpecInfo(bean);
	}

	@Override
	public int insertNewSpecialistInfo(String userName) {
		return dao.insertSpecInfo(new SpecialistInfoBean(userName));
	}
	
	@Override
	public int getSpecialistInfoState(String userName) {
		return dao.getSpecInfoState(userName);
	}
	
	@Override
	public int updateSpecialistInfoState(String userName, int state) {
		return dao.updateSpecInfoState(userName, state);
	}

	public void setDao(SpecInfoDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<SpecialistInfoBean> searchByValue(String[] values) {
		Map<String,SpecialistInfoBean> result = new HashMap<String,SpecialistInfoBean>();
		for(String value:values){
			List<SpecialistInfoBean> list = dao.search("%"+value+"%");
			for(SpecialistInfoBean bean:list){
				result.put(bean.getUserName(), bean);
			}
		}
		return new ArrayList<SpecialistInfoBean>(result.values());
	}

	

}
