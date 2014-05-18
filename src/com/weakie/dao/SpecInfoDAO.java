package com.weakie.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.weakie.bean.SpecialistInfoBean;
import com.weakie.util.log.LogUtil;

public class SpecInfoDAO extends AbstractBaseDao {

	public SpecialistInfoBean selectSpecInfo(String userName){
		SqlSession session = getSession();
		SpecialistInfoBean p = null;
		try {
			p = session.selectOne("com.weakie.dao.SpecInfoDAO.selectSpecInfo", userName);
			if(p!=null){
				List<Integer> pos = session.selectList("com.weakie.dao.SpecInfoDAO.selectPositionForSpecInfo", userName);
				p.setWorkPositionId(pos);
			}
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		return p;
	}
	
	public int insertSpecInfo(SpecialistInfoBean specInfo){
		SqlSession session = getSession();
		int result=0;
		try {
			result = session.insert("com.weakie.dao.SpecInfoDAO.insertSpecInfo", specInfo);
			session.commit();
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		return result;
	}
	
	public int getSpecInfoState(String userName){
		SqlSession session = getSession();
		int result = 0;
		try {
			result = session.selectOne("com.weakie.dao.SpecInfoDAO.selectSpecInfoState", userName);
			
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		return result;
	}
	
	public int updateSpecInfo(SpecialistInfoBean specInfo){
		SqlSession session = getSession();
		Map<String,Object> param = specInfo.getMapValues();
		int result = 0;
		try {
			session.update("com.weakie.dao.SpecInfoDAO.updateSpecInfo", param);
			session.commit();
			result = 1;
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		return result;
	}
	
	public int updateSpecInfoState(String userName,int state){
		SqlSession session = getSession();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("userName", userName);
		param.put("state", state);
		int result=0;
		try {
			result = session.update("com.weakie.dao.SpecInfoDAO.updateState", param);
			session.commit();
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		return result;	
	}
	
	public List<SpecialistInfoBean> search(String value){
		List<SpecialistInfoBean> result = null;
		SqlSession session = getSession();
		try {
			result = session.selectList("com.weakie.dao.SpecInfoDAO.selectSpecInfoByValue", value);
			for(SpecialistInfoBean p:result){
					List<Integer> pos = session.selectList("com.weakie.dao.SpecInfoDAO.selectPositionForSpecInfo", p.getUserName());
					p.setWorkPositionId(pos);
			}
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		return result;
	}
	
	public List<SpecialistInfoBean> searchAdvance(int orgType,
			int qualification, int title, int majorClass, int major,
			int province, int city){
		List<SpecialistInfoBean> result = null;
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("orgType", orgType);
		param.put("qualification", qualification);
		param.put("title", title);
		param.put("majorClass", majorClass);
		param.put("major", major);
		param.put("province", province);
		param.put("city", city);
		SqlSession session = getSession();
		try {
			result = session.selectList("com.weakie.dao.SpecInfoDAO.selectSpecInfoByAdvance", param);
			for(SpecialistInfoBean p:result){
				List<Integer> pos = session.selectList("com.weakie.dao.SpecInfoDAO.selectPositionForSpecInfo", p.getUserName());
				p.setWorkPositionId(pos);
			}
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		return result;
	}
}
