package com.weakie.service;

import java.util.List;

import com.weakie.bean.ApplyInfo;

public interface ApplyInfoService {

	/**
	 * 得到申请信息,未排序
	 * @param staffId
	 * @param status
	 * @return
	 */
	public List<ApplyInfo> getApplyInfos(String staffId, int status, int pageIndex);
	
	/**
	 * 抢占新的申请
	 * @param staffId
	 * @param applyId
	 * @return
	 * @throws Exception
	 */
	public ApplyInfo acceptNewApply(String staffId, int applyId) throws Exception;
	
	/**
	 * 确认专家信息
	 * @param staffId
	 * @param applyId
	 * @return
	 */
	public String confirmApply(String staffId, int applyId);
}
