package com.weakie.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.weakie.bean.ApplyInfo;
import com.weakie.util.log.LogUtil;

public class ApplyInfoDAO extends AbstractBaseDao {

	public List<ApplyInfo> selectApplyInfo(int begin,int number){
		SqlSession session = getSession();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("begin", begin);
		param.put("number", number);
		List<ApplyInfo> list = null;
		try {
			list = session.selectList("com.weakie.dao.ApplyInfoDAO.selectApplyInfo", param);
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		return list;
	}
	
	public List<ApplyInfo> selectApplyInfoOfNew(int begin,int number){
		SqlSession session = getSession();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("begin", begin);
		param.put("number", number);
		List<ApplyInfo> list = null;
		try {
			list = session.selectList("com.weakie.dao.ApplyInfoDAO.selectApplyInfoNew", param);
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		return list;
	}
	
	public List<ApplyInfo> selectApplyInfoOfAccepted(String staffID,int begin,int number){
		SqlSession session = getSession();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("begin", begin);
		param.put("number", number);
		param.put("staffID", staffID);
		List<ApplyInfo> list = null;
		try {
			list = session.selectList("com.weakie.dao.ApplyInfoDAO.selectApplyInfoACCEPTED", param);
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		return list;
	}
	
	public List<ApplyInfo> selectApplyInfoOfDisposed(String staffID,int begin,int number){
		SqlSession session = getSession();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("begin", begin);
		param.put("number", number);
		param.put("staffID", staffID);
		List<ApplyInfo> list = null;
		try {
			list = session.selectList("com.weakie.dao.ApplyInfoDAO.selectApplyInfoDISPOSED", param);
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		return list;
	}
	
	public int insertApplyInfo(ApplyInfo applyInfo){
		SqlSession session = getSession();
		int result=0;
		try {
			//update old applyInfo status to overtime if not disposed
			session.update("com.weakie.dao.ApplyInfoDAO.updateStatusOvertime", applyInfo.getUserName());
			//insert new applyInfo
			result = session.insert("com.weakie.dao.ApplyInfoDAO.insertApplyInfo", applyInfo);
			//commit session
			session.commit();
		} catch(Exception e){
			session.rollback();
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		return result;
	}
	
	public ApplyInfo acceptApplyInfo(int id,String staffId){
		SqlSession session = getSession();
		
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("id", id);
		param.put("staffId", staffId);
		param.put("acceptTime", new Date());
		
		ApplyInfo applyInfo = null;
		try {
			session.update("com.weakie.dao.ApplyInfoDAO.updateApplyInfoForAccept", param);
			session.commit();
			//get result
			applyInfo = session.selectOne("com.weakie.dao.ApplyInfoDAO.selectApplyInfoForAccept", param);
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		return applyInfo;
	}
	
	public int disposeApplyInfo(int id,String staffId){
		SqlSession session = getSession();
		
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("id", id);
		param.put("staffId", staffId);
		param.put("disposeTime", new Date());
		int result = 0;
		try {
			result = session.update("com.weakie.dao.ApplyInfoDAO.updateApplyInfoForDisposed", param);
			session.commit();
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		return result;
	}
}
