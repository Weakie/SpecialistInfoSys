/**
 * 
 */
package com.weakie.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import com.weakie.dao.SelectionDAO;
import com.weakie.service.SelectionService;
import com.weakie.util.ReadOnlyMap;

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
	public ReadOnlyMap<Integer, String> getProvince(boolean isAbroad) {
		return new ReadOnlyMap<Integer, String>(dao.getProvinceMap(isAbroad));
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

	public void setDao(SelectionDAO dao) {
		this.dao = dao;
	}
}
