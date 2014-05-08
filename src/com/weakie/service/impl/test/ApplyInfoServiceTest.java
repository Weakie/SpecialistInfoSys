package com.weakie.service.impl.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.weakie.bean.ApplyInfo;
import com.weakie.service.ApplyInfoService;

public class ApplyInfoServiceTest implements ApplyInfoService {

	@Override
	public List<ApplyInfo> getApplyInfos(String staffId, int status,
			int pageIndex) {
		List<ApplyInfo> infos = new ArrayList<ApplyInfo>();
		for(int i=0;i<20;i++){
			infos.add(new ApplyInfo(i,"111","hahaha",new Date(),new Date(),new Date(),(i%4)+1,"222"));
		}
		return infos;
	}

	@Override
	public ApplyInfo acceptNewApply(String staffId, int applyId)
			throws Exception {
		// TODO Auto-generated method stub
		return new ApplyInfo(1,"hahaha","hahaha",new Date(),new Date(),new Date(),1,"hahaha");
	}

	@Override
	public String confirmApply(String staffId, int applyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addNewApply(String userName, String specName) {
		// TODO Auto-generated method stub
		return 0;
	}

}
