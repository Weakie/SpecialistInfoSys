package com.weakie.service;

import java.util.List;

import com.weakie.util.ReadOnlyMap;

/**
 * �ӻ��������������
 * @author weakie E-mail:weakielin@gmail.com
 * 2014��4��29������5:44:37
 */
public interface SelectionService {

	/**
	 * �����Ƿ��ǹ�����ʡ��id-nameӳ��
	 * @param isAbroad true �ڹ���
	 * @return
	 */
	public ReadOnlyMap<Integer,String> getProvince(boolean isAbroad);
	
	/**
	 * ����ʡ��id�����Ӧ���г��е�id-nameӳ��
	 * @param provinceId
	 * @return
	 */
	public ReadOnlyMap<Integer,String> getCity(int provinceId);
	
	/**
	 * ���רҵ����id-nameӳ��
	 * @return
	 */
	public ReadOnlyMap<Integer,String> getMajorClass();
	
	/**
	 * ����רҵ��������Ӧ����רҵ��id-nameӳ��
	 * @param majorClassId
	 * @return
	 */
	public ReadOnlyMap<Integer,String> getMajor(int majorClassId);
	
	/**
	 * ����רҵ������������רҵ����id
	 * @return
	 */
	public int getMajorClassIdByMajorId(int majorId);
	
	public ReadOnlyMap<Integer,String> getOrgType();
	public ReadOnlyMap<Integer,String> getQualification();
	public ReadOnlyMap<Integer,String> getTitle();
	
	/**
	 * ���ݳ��л�ó��ж�Ӧ��ʡ��id
	 * @param cityList
	 * @return map:key-city value-province
	 */
	public ReadOnlyMap<Integer,Integer> getCityProvinceMap(List<Integer> cityList);
	
	/**
	 * ����ʡ�����id�ж��Ƿ��ڹ���
	 * @param provinceList
	 * @return key-province value-isAbroad
	 */
	public ReadOnlyMap<Integer,Boolean> getAbroadProvinceMap(List<Integer> provinceList);
	
	/**
	 * ���ݳ��л���Ӧ����id-name��ӳ��
	 * @param cityList
	 * @return
	 */
	public ReadOnlyMap<Integer,String> getCityNameMap(List<Integer> cityList);
	
	/**
	 * ���ݳ���id��øó������ڵ�ʡ��id-nameӳ��
	 * @param cityList
	 * @return
	 */
	public ReadOnlyMap<Integer,String> getProvNameMap(List<Integer> cityList);
}
