package com.weakie.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.weakie.bean.SpecialistInfoBean;

public class SpecInfoDAOTest {

	@Test
	public void testUpdateSpecInfo() {
		SpecInfoDAO dao = new SpecInfoDAO();
		/*List<Integer> l = new ArrayList<Integer>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		SpecialistInfoBean bean = new SpecialistInfoBean("������2","haha", false,"1991-07","weakielin@gmail.com","z","z","z","z"
				,"a","a","a","a","a","a","a", 1,1,1,1,l,1);
		
		//dao.insertSpecInfo(bean);
		bean = dao.selectSpecInfo("������");
		System.out.println(bean.getWorkPositionId());
		bean.setWorkPositionId(l);
		
		dao.updateSpecInfo(bean);
		dao.updateSpecInfoState("������", 10);
		bean = dao.selectSpecInfo("������");
		System.out.println(bean.getWorkPositionId());*/
		List<SpecialistInfoBean> result = dao.search("%�ձ�%");
		for(SpecialistInfoBean bean:result){
			System.out.println(bean.getUserName());
		}
		
	}

}
