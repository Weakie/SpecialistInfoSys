package com.weakie.dao;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.weakie.bean.Person;

public class PersonDAOTest {

	@Test
	public void test() {
		PersonDAO dao = new PersonDAO();
		Person p = new Person("aaaa2a",1,1,new Date(),new Date());
		p.setPassword("haha");
		//dao.addNewPerson(p);
		
		//Person q1 = dao.checkPassword("aaaa", "haha");
		//System.out.println(q1);
		
		//Person q2 = dao.checkPassword("aaaa", "a");
		//System.out.println(q2);
		
		//System.out.println(dao.checkUsernameExist("aaaa"));
		
		System.out.println(dao.updatePassword("aaaa", "ha", "haga"));
		
		System.out.println(dao.updateNickName("aaaa", "haha"));
	}

}
