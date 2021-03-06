package com.weakie.service;

import java.util.List;

import com.weakie.util.ReadOnlyMap;

/**
 * 加缓存可以提升性能
 * @author weakie E-mail:weakielin@gmail.com
 * 2014年4月29日下午5:44:37
 */
public interface SelectionService {

	/**
	 * 根据是否是国外获得省的id-name映射
	 * @param abroad true 在国内
	 * @return
	 */
	public ReadOnlyMap<Integer,String> getProvince(boolean abroad);
	
	/**
	 * 根据省的id获得相应所有城市的id-name映射
	 * @param provinceId
	 * @return
	 */
	public ReadOnlyMap<Integer,String> getCity(int provinceId);
	
	/**
	 * 获得专业大类id-name映射
	 * @return
	 */
	public ReadOnlyMap<Integer,String> getMajorClass();
	
	/**
	 * 根据专业大类获得相应所有专业的id-name映射
	 * @param majorClassId
	 * @return
	 */
	public ReadOnlyMap<Integer,String> getMajor(int majorClassId);
	
	/**
	 * 根据专业方向获得所属的专业大类id
	 * @return null if not exist
	 */
	public Integer getMajorClassIdByMajorId(Integer majorId);
	
	public ReadOnlyMap<Integer,String> getOrgType();
	public ReadOnlyMap<Integer,String> getQualification();
	public ReadOnlyMap<Integer,String> getTitle();
	
	/**
	 * 根据城市获得城市对应的省的id
	 * @param cityList
	 * @return map:key-city value-province
	 */
	public ReadOnlyMap<Integer,Integer> getCityProvinceMap(List<Integer> cityList);
	
	/**
	 * 根据省或国家id判断是否在国内
	 * @param provinceList
	 * @return key-province value-isAbroad
	 */
	public ReadOnlyMap<Integer,Boolean> getProvinceAbroadMap(List<Integer> provinceList);
	
	/**
	 * 根据城市获相应城市id-name的映射
	 * @param cityList
	 * @return
	 */
	public ReadOnlyMap<Integer,String> getCityNameMap(List<Integer> cityList);
	
	/**
	 * 根据城市id获得该城市所在的省的id-name映射
	 * @param cityList
	 * @return
	 */
	public ReadOnlyMap<Integer,String> getProvNameMap(List<Integer> cityList);
	
	public ReadOnlyMap<Integer,String> insertValues(String value,int key,int item) throws Exception;
	public ReadOnlyMap<Integer,String> updateValues(String value,int key,int item,int id) throws Exception;
}
