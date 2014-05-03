package com.weakie.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.weakie.bean.Person;
import com.weakie.util.log.LogUtil;

public class PersonDAO extends AbstractBaseDao {

	public int addNewPerson(Person p){
		SqlSession session = getSession();
		int result=0;
		try {
			result = session.insert("com.weakie.dao.PersonDAO.insertPerson", p);
			session.commit();
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		return result;
	}
	
	public Person checkPassword(String userName,String password){
		SqlSession session = getSession();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("username_in", userName);
		param.put("password_in", password);
		param.put("login_time_in", new Date());
		Person p = null;
		try {
			p = session.selectOne("com.weakie.dao.PersonDAO.checkPassword", param);
			session.commit();
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		return p;
	}
	
	public int checkUsernameExist(String userName){
		SqlSession session = getSession();
		int result=0;
		try {
			result = session.selectOne("com.weakie.dao.PersonDAO.checkUsernameExist", userName);
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		return result;
	}
	
	public int updatePassword(String userName,String oldPassword,String newPassword){
		SqlSession session = getSession();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("userName", userName);
		param.put("oldPassword", oldPassword);
		param.put("newPassword", newPassword);
		int result=0;
		try {
			result = session.update("com.weakie.dao.PersonDAO.updatePassword", param);
			session.commit();
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		return result;	
	}
	
	public int updateNickName(String userName,String nickname){
		SqlSession session = getSession();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("userName", userName);
		param.put("nickName", nickname);
		int result=0;
		try {
			result = session.update("com.weakie.dao.PersonDAO.updateNickName", param);
			session.commit();
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		return result;	
	}
}
