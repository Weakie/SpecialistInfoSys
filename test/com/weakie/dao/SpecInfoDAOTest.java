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
		SpecialistInfoBean bean = new SpecialistInfoBean("林威建2","haha", false,"1991-07","weakielin@gmail.com","z","z","z","z"
				,"a","a","a","a","a","a","a", 1,1,1,1,l,1);
		
		//dao.insertSpecInfo(bean);
		bean = dao.selectSpecInfo("林威建");
		System.out.println(bean.getWorkPositionId());
		bean.setWorkPositionId(l);
		
		dao.updateSpecInfo(bean);
		dao.updateSpecInfoState("林威建", 10);
		bean = dao.selectSpecInfo("林威建");
		System.out.println(bean.getWorkPositionId());*/
		List<SpecialistInfoBean> result = dao.search("%日本%");
		for(SpecialistInfoBean bean:result){
			System.out.println(bean.getUserName());
		}
		
	}

}
