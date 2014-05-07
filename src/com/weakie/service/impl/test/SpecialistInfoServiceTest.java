/**
 * 
 */
package com.weakie.service.impl.test;

import java.util.HashMap;
import java.util.Map;

import com.weakie.bean.SpecialistInfoBean;
import com.weakie.service.SpecialistInfoService;

/**
 * @author weakie E-mail:weakielin@gmail.com
 * 2014年4月29日下午5:54:53
 */
public class SpecialistInfoServiceTest implements SpecialistInfoService {

	private Map<String,SpecialistInfoBean> bean = new HashMap<String,SpecialistInfoBean>();
	
	/* (non-Javadoc)
	 * @see com.weakie.service.SpecialistInfoService#getSpecialistInfoByUsername(java.lang.String)
	 */
	@Override
	public SpecialistInfoBean getSpecialistInfoByUsername(String userName) {
		return bean.get(userName);
		/*SpecialistInfoBean bean = new SpecialistInfoBean();
		bean.setName("天才");
    	bean.setSex(true);
    	bean.setBirthday("2001-03");
    	bean.setContact("kate:12345;Lili:12312;haha:21312412;");
    	bean.setOrgTypeId(3);
    	bean.setMajorId(3);
    	bean.setWorkPositionId(Arrays.asList(1,4,7,10,13,16,19)); 
		return bean;*/
	}

	/* (non-Javadoc)
	 * @see com.weakie.service.SpecialistInfoService#updateSpecialistInfo(com.weakie.bean.SpecialistInfoBean)
	 */
	@Override
	public int updateSpecialistInfo(SpecialistInfoBean bean) {
		// TODO Auto-generated method stub
		this.bean.put(bean.getUserName(), bean);
		return 0;
	}

	@Override
	public int insertNewSpecialistInfo(String userName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateSpecialistInfoState(String userName, int state) {
		// TODO Auto-generated method stub
		return 0;
	}

}
