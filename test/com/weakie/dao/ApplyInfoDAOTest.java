package com.weakie.dao;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.weakie.bean.ApplyInfo;

public class ApplyInfoDAOTest {

	@Test
	public void testInsertApplyInfo() {
		ApplyInfoDAO dao = new ApplyInfoDAO();
		/*dao.insertApplyInfo(new ApplyInfo("hahaha","hehehe",new Date()));
		
		dao.acceptApplyInfo(13, "aaa");
		dao.insertApplyInfo(new ApplyInfo("hahaha","hehehe",new Date()));
		dao.acceptApplyInfo(14, "aaa");
		dao.disposeApplyInfo(14, "aaa");
		*/
		for(ApplyInfo info:dao.selectApplyInfoOfDisposed("aaa", 0, 5)){
			System.out.println(info);
		}
	}

}
