package com.weakie.service;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author weakie E-mail:weakielin@gmail.com
 * 2014��4��29������5:44:37
 */
public interface SelectionService {

	/**
	 * �����Ƿ��ǹ�����ʡ��id-nameӳ��
	 * @param isAbroad true �ڹ���
	 * @return
	 */
	public Map<Integer,String> getProvince(boolean isAbroad);
	
	/**
	 * ����ʡ��id�����Ӧ���г��е�id-nameӳ��
	 * @param provinceId
	 * @return
	 */
	public Map<Integer,String> getCity(int provinceId);
	
	/**
	 * ���רҵ����id-nameӳ��
	 * @return
	 */
	public Map<Integer,String> getMajorClass();
	
	/**
	 * ����רҵ��������Ӧ����רҵ��id-nameӳ��
	 * @param majorClassId
	 * @return
	 */
	public Map<Integer,String> getMajor(int majorClassId);
	
	/**
	 * ����רҵ������������רҵ����id
	 * @return
	 */
	public int getMajorClassIdByMajorId(int majorId);
	
	public Map<Integer,String> getOrgType();
	public Map<Integer,String> getQualification();
	public Map<Integer,String> getTitle();
	
	/**
	 * ���ݳ��л�ó��ж�Ӧ��ʡ��id
	 * @param cityList
	 * @return map:key-city value-province
	 */
	public Map<Integer,Integer> getCityProvinceMap(List<Integer> cityList);
	
	/**
	 * ����ʡ�����id�ж��Ƿ��ڹ���
	 * @param provinceList
	 * @return key-province value-isAbroad
	 */
	public Map<Integer,Boolean> getAbroadProvinceMap(List<Integer> provinceList);
	
	/**
	 * ���ݳ��л���Ӧ����id-name��ӳ��
	 * @param cityList
	 * @return
	 */
	public Map<Integer,String> getCityNameMap(List<Integer> cityList);
	
	/**
	 * ���ݳ���id��øó������ڵ�ʡ��id-nameӳ��
	 * @param cityList
	 * @return
	 */
	public Map<Integer,String> getProvNameMap(List<Integer> cityList);
}
