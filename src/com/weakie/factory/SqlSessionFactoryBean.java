package com.weakie.factory;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.weakie.util.log.LogUtil;

public class SqlSessionFactoryBean {
	
	private static final String resource = "mybatis-config.xml";
	
	private static SqlSessionFactory sqlSessionFactory;
	
	public static SqlSessionFactory getSqlSessionFactory() {
		if(sqlSessionFactory==null){
			synchronized(SqlSessionFactoryBean.class){
				if(sqlSessionFactory==null){
					LogUtil.info("Init SqlSessionFactory.");
					try {
						InputStream inputStream = Resources.getResourceAsStream(resource);
						sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
					} catch (IOException e) {
						LogUtil.error(e);
					}
				}
			}
		}
		return sqlSessionFactory;
	}
	
}
