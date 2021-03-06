package com.weakie.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.weakie.bean.ApplyInfo;
import com.weakie.constant.ApplyConstant;
import com.weakie.dao.ApplyInfoDAO;
import com.weakie.service.ApplyInfoService;

public class ApplyInfoServiceImpl implements ApplyInfoService {

	private ApplyInfoDAO dao;
	
	@Override
	public int addNewApply(String userName, String specName,String comment) {
		if(StringUtils.isEmpty(userName)){
			return 0;
		}
		ApplyInfo apply = new ApplyInfo(userName,specName,new Date(), comment);
		return dao.insertApplyInfo(apply);
	}

	@Override
	public List<ApplyInfo> getApplyInfos(String staffId, int status, int pageIndex) {
		//pageIndex can not < 0;
		pageIndex = Math.max(1, pageIndex);
		//calculate the begin index for DB
		int begin = ( pageIndex - 1 ) * ApplyConstant.PAGE_NUMS;
		//switch
		List<ApplyInfo> infos = null;
		switch(status){
		case 0:
			infos = dao.selectApplyInfo(begin, ApplyConstant.PAGE_NUMS);
			break;
		case 1:
			infos = dao.selectApplyInfoOfNew(begin, ApplyConstant.PAGE_NUMS);
			break;
		case 3:
			infos = dao.selectApplyInfoOfAccepted(staffId, begin, ApplyConstant.PAGE_NUMS);
			break;
		case 4:
			infos = dao.selectApplyInfoOfDisposed(staffId, begin, ApplyConstant.PAGE_NUMS);
			break;
		default:
			infos = Collections.emptyList();
		}
		return infos;
	}

	@Override
	public ApplyInfo acceptNewApply(String staffId, int applyId)
			throws Exception {
		return dao.acceptApplyInfo(applyId, staffId);
	}
	
	@Override
	public String confirmApply(String staffId, int applyId) {
		return this.dao.disposeApplyInfo(applyId, staffId);
	}

	public void setDao(ApplyInfoDAO dao) {
		this.dao = dao;
	}

	@Override
	public ApplyInfo getApplyInfoById(int id) {
		return dao.getApplyInfoById(id);
	}

	
}
