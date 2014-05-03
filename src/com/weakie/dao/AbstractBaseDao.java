package com.weakie.dao;

import org.apache.ibatis.session.SqlSession;

import com.weakie.factory.SqlSessionFactoryBean;

public class AbstractBaseDao {

	protected SqlSession getSession(){
		return SqlSessionFactoryBean.getSqlSessionFactory().openSession();
	}
}
