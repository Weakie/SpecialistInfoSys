package com.weakie.service;

import java.util.List;

import com.weakie.bean.ApplyInfo;

public interface ApplyInfoService {

	public int addNewApply(String userName,String specName,String comment);
	/**
	 * �õ�������Ϣ,δ����
	 * @param staffId
	 * @param status
	 * @return
	 */
	public List<ApplyInfo> getApplyInfos(String staffId, int status, int pageIndex);
	
	/**
	 * ��ռ�µ�����
	 * @param staffId
	 * @param applyId
	 * @return
	 * @throws Exception
	 */
	public ApplyInfo acceptNewApply(String staffId, int applyId) throws Exception;
	
	/**
	 * ����id���apply
	 * @param id
	 * @return
	 */
	public ApplyInfo getApplyInfoById(int id);
	/**
	 * ȷ��ר����Ϣ
	 * @param staffId
	 * @param applyId
	 * @return
	 */
	public String confirmApply(String staffId, int applyId);
	
}
