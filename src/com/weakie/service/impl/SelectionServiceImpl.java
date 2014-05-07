/**
 * 
 */
package com.weakie.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import com.weakie.constant.SystemConstant;
import com.weakie.dao.SelectionDAO;
import com.weakie.service.SelectionService;
import com.weakie.util.ReadOnlyMap;
import com.weakie.util.log.LogUtil;

/**
 * @author weakie E-mail:weakielin@gmail.com 2014年5月6日上午1:40:27
 */
public class SelectionServiceImpl implements SelectionService {

	private SelectionDAO dao;
	
	@Override
	public ReadOnlyMap<Integer, String> getOrgType() {
		return new ReadOnlyMap<Integer, String>(dao.getOrganizationTypeMap());
	}

	@Override
	public ReadOnlyMap<Integer, String> getProvince(boolean abroad) {
		return new ReadOnlyMap<Integer, String>(dao.getProvinceMap(abroad));
	}

	@Override
	public ReadOnlyMap<Integer, String> getCity(int provinceId) {
		return new ReadOnlyMap<Integer, String>(dao.getCityMap(provinceId));
	}

	@Override
	public ReadOnlyMap<Integer, String> getQualification() {
		return new ReadOnlyMap<Integer, String>(dao.getQualificationMap());
	}

	@Override
	public ReadOnlyMap<Integer, String> getTitle() {
		return new ReadOnlyMap<Integer, String>(dao.getTitleMap());
	}

	@Override
	public ReadOnlyMap<Integer, String> getMajorClass() {
		return new ReadOnlyMap<Integer, String>(dao.getMajorFieldCatMap());
	}

	@Override
	public ReadOnlyMap<Integer, String> getMajor(int majorClassId) {
		return new ReadOnlyMap<Integer, String>(dao.getMajorFieldMap(majorClassId));
	}

	@Override
	public Integer getMajorClassIdByMajorId(Integer majorId) {
		Map<Integer,Integer> map = dao.getMajorFieldMajorFieldCatMap();
		if(map.containsKey(majorId)){
			return map.get(majorId);
		}
		return null;
	}

	@Override
	public ReadOnlyMap<Integer, Integer> getCityProvinceMap(List<Integer> cityList) {
		if(cityList==null || cityList.size()==0){
			Map<Integer, Integer> tmp = Collections.emptyMap();
			return new ReadOnlyMap<Integer, Integer>(tmp);
		}
		//remove the duplicated value
		cityList = new ArrayList<Integer>(new TreeSet<Integer>(cityList));
		return new ReadOnlyMap<Integer, Integer>(dao.getCityProvinceMap(cityList));
	}

	@Override
	public ReadOnlyMap<Integer, Boolean> getProvinceAbroadMap(List<Integer> provinceList) {
		if(provinceList==null || provinceList.size()==0){
			Map<Integer, Boolean> tmp = Collections.emptyMap();
			return new ReadOnlyMap<Integer, Boolean>(tmp);
		}
		//remove the duplicated value
		provinceList = new ArrayList<Integer>(new TreeSet<Integer>(provinceList));
		return new ReadOnlyMap<Integer, Boolean>(dao.getProvinceAbroadMap(provinceList));
	}

	@Override
	public ReadOnlyMap<Integer, String> getCityNameMap(List<Integer> cityList) {
		if(cityList==null || cityList.size()==0){
			Map<Integer, String> tmp = Collections.emptyMap();
			return new ReadOnlyMap<Integer, String>(tmp);
		}
		//remove the duplicated value
		cityList = new ArrayList<Integer>(new TreeSet<Integer>(cityList));
		return new ReadOnlyMap<Integer, String>(dao.getCityNameMap(cityList));
	}

	@Override
	public ReadOnlyMap<Integer, String> getProvNameMap(List<Integer> cityList) {
		if(cityList==null || cityList.size()==0){
			Map<Integer, String> tmp = Collections.emptyMap();
			return new ReadOnlyMap<Integer, String>(tmp);
		}
		//remove the duplicated value
		cityList = new ArrayList<Integer>(new TreeSet<Integer>(cityList));
		return new ReadOnlyMap<Integer, String>(dao.getProvinceNameMap(cityList));
	}

	@Override
	public ReadOnlyMap<Integer, String> insertValues(String value, int key,
			int item) throws Exception {
		LogUtil.info("value="+value+",key="+key+",item="+item);
		Map<Integer, String> result = null;
		int flag = 0;
		switch(key){
		case SystemConstant.KEY_ORGTYPE:
			flag = dao.insertOrganizationType(value);
			result = dao.getOrganizationTypeMap();
			break;
		case SystemConstant.KEY_QUALIFICATION:
			flag = dao.insertQualificationType(value);
			result = dao.getQualificationMap();
			break;
		case SystemConstant.KEY_TITLE:
			flag = dao.insertTitleType(value);
			result = dao.getTitleMap();
			break;
		case SystemConstant.KEY_MAJORCLASS:
			flag = dao.insertMajorFieldCatType(value);
			result = dao.getMajorFieldCatMap();
			break;
		case SystemConstant.KEY_MAJOR:
			flag = dao.insertMajorFieldType(value, item);
			result = dao.getMajorFieldMap(item);
			break;
		case SystemConstant.KEY_PROVINCE:
			flag = dao.insertProvince(value, item);
			result = dao.getProvinceMap((item==0?false:true));
			break;
		case SystemConstant.KEY_CITY:
			flag = dao.insertCity(value, item);
			result = dao.getCityMap(item);
			break;
		default:
			flag = 1;
			result = Collections.emptyMap();
		}
		if(flag == 0){
			throw new Exception("插入数据失败");
		}
		return new ReadOnlyMap<Integer, String>(result);
	}

	@Override
	public ReadOnlyMap<Integer, String> updateValues(String value, int key,
			int item, int id) throws Exception {
		LogUtil.info("value="+value+",key="+key+",item="+item+",id="+id);
		Map<Integer, String> result = null;
		int flag = 0;
		switch(key){
		case SystemConstant.KEY_ORGTYPE:
			flag = dao.updateOrganizationType(value,id);
			result = dao.getOrganizationTypeMap();
			break;
		case SystemConstant.KEY_QUALIFICATION:
			flag = dao.updateQualificationType(value,id);
			result = dao.getQualificationMap();
			break;
		case SystemConstant.KEY_TITLE:
			flag = dao.updateTitleType(value,id);
			result = dao.getTitleMap();
			break;
		case SystemConstant.KEY_MAJORCLASS:
			flag = dao.updateMajorFieldCatType(value,id);
			result = dao.getMajorFieldCatMap();
			break;
		case SystemConstant.KEY_MAJOR:
			flag = dao.updateMajorFieldType(value, item, id);
			result = dao.getMajorFieldMap(item);
			break;
		case SystemConstant.KEY_PROVINCE:
			flag = dao.updateProvince(value, item, id);
			result = dao.getProvinceMap((item==0?false:true));
			break;
		case SystemConstant.KEY_CITY:
			flag = dao.updateCity(value, item, id);
			result = dao.getCityMap(item);
			break;
		default:
			flag = 1;
			result = Collections.emptyMap();
		}
		if(flag == 0){
			throw new Exception("更新数据失败");
		}
		return new ReadOnlyMap<Integer, String>(result);
	}
	
	public void setDao(SelectionDAO dao) {
		this.dao = dao;
	}

}
