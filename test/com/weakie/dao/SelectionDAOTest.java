package com.weakie.dao;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.junit.Test;

public class SelectionDAOTest {

	@Test
	public void test() {
		SelectionDAO dao = new SelectionDAO();
		//System.out.println(dao.getCityNameMap(Arrays.asList(1,2,3)));
		Map map = new HashMap();
		map.put("111", "qq");
		Object o = map.get(null);
		System.out.println(o+""+map.containsKey(null));
	}

}
