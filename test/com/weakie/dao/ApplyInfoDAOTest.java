package com.weakie.dao;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.weakie.bean.ApplyInfo;

public class ApplyInfoDAOTest {

	@Test
	public void testInsertApplyInfo() {
		ApplyInfoDAO dao = new ApplyInfoDAO();
		dao.insertApplyInfo(new ApplyInfo("hahaha","hehehe",new Date()));
		
		dao.acceptApplyInfo(11, "aaa");
		dao.insertApplyInfo(new ApplyInfo("hahaha","hehehe",new Date()));
		dao.acceptApplyInfo(12, "aaa");
		dao.disposeApplyInfo(12, "aaa");
	}

}
