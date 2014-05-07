package com.weakie.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.weakie.bean.KeyValuePair;
import com.weakie.util.log.LogUtil;

public class SelectionDAO extends AbstractBaseDao {
	
	public Map<Integer,String> getOrganizationTypeMap(){
		SqlSession session = getSession();
		Map<Integer,String> result = new HashMap<Integer,String>();
		List<KeyValuePair> list = null;
		try {
			list = session.selectList("com.weakie.dao.SelectionDAO.getOrganizationType");
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		if(list!=null){
			for(KeyValuePair pair:list){
				result.put((Integer) pair.getKey(), (String)pair.getValue());
			}
		}
		return result;
	}
	
	public int insertOrganizationType(String type){
		SqlSession session = getSession();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("type", type);
		int result = 0;
		try {
			result = session.insert("com.weakie.dao.SelectionDAO.insertOrganizationType", param);
			session.commit();
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		return result;
	}
	
	public int updateOrganizationType(String type, int id){
		SqlSession session = getSession();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("type", type);
		param.put("id", id);
		int result = 0;
		try {
			result = session.update("com.weakie.dao.SelectionDAO.updateOrganizationType", param);
			session.commit();
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		return result;
	}
	
	public Map<Integer,String> getTitleMap(){
		SqlSession session = getSession();
		Map<Integer,String> result = new HashMap<Integer,String>();
		List<KeyValuePair> list = null;
		try {
			list = session.selectList("com.weakie.dao.SelectionDAO.getTitleType");
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		if(list!=null){
			for(KeyValuePair pair:list){
				result.put((Integer) pair.getKey(), (String)pair.getValue());
			}
		}
		return result;
	}
	
	public int insertTitleType(String type){
		SqlSession session = getSession();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("type", type);
		int result = 0;
		try {
			result = session.insert("com.weakie.dao.SelectionDAO.insertTitleType", param);
			session.commit();
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		return result;
	}
	
	public int updateTitleType(String type, int id){
		SqlSession session = getSession();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("type", type);
		param.put("id", id);
		int result = 0;
		try {
			result = session.update("com.weakie.dao.SelectionDAO.updateTitleType", param);
			session.commit();
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		return result;
	}
	
	public Map<Integer,String> getQualificationMap(){
		SqlSession session = getSession();
		Map<Integer,String> result = new HashMap<Integer,String>();
		List<KeyValuePair> list = null;
		try {
			list = session.selectList("com.weakie.dao.SelectionDAO.getQualification");
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		if(list!=null){
			for(KeyValuePair pair:list){
				result.put((Integer) pair.getKey(), (String)pair.getValue());
			}
		}
		return result;
	}
	
	public int insertQualificationType(String type){
		SqlSession session = getSession();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("type", type);
		int result = 0;
		try {
			result = session.insert("com.weakie.dao.SelectionDAO.insertQualification", param);
			session.commit();
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		return result;
	}
	
	public int updateQualificationType(String type, int id){
		SqlSession session = getSession();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("type", type);
		param.put("id", id);
		int result = 0;
		try {
			result = session.update("com.weakie.dao.SelectionDAO.updateQualification", param);
			session.commit();
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		return result;
	}
	
	public Map<Integer,String> getMajorFieldCatMap(){
		SqlSession session = getSession();
		Map<Integer,String> result = new HashMap<Integer,String>();
		List<KeyValuePair> list = null;
		try {
			list = session.selectList("com.weakie.dao.SelectionDAO.getMajorFieldCat");
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		if(list!=null){
			for(KeyValuePair pair:list){
				result.put((Integer) pair.getKey(), (String)pair.getValue());
			}
		}
		return result;
	}
	
	public int insertMajorFieldCatType(String type){
		SqlSession session = getSession();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("type", type);
		int result = 0;
		try {
			result = session.insert("com.weakie.dao.SelectionDAO.insertMajorFieldCat", param);
			session.commit();
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		return result;
	}
	
	public int updateMajorFieldCatType(String type, int id){
		SqlSession session = getSession();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("type", type);
		param.put("id", id);
		int result = 0;
		try {
			result = session.update("com.weakie.dao.SelectionDAO.updateMajorFieldCat", param);
			session.commit();
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		return result;
	}
	
	public Map<Integer,String> getMajorFieldMap(int majorClassId){
		SqlSession session = getSession();
		Map<Integer,String> result = new HashMap<Integer,String>();
		List<KeyValuePair> list = null;
		try {
			list = session.selectList("com.weakie.dao.SelectionDAO.getMajorField",majorClassId);
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		if(list!=null){
			for(KeyValuePair pair:list){
				result.put((Integer) pair.getKey(), (String)pair.getValue());
			}
		}
		return result;
	}
	
	public int insertMajorFieldType(String type, int category){
		SqlSession session = getSession();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("type", type);
		param.put("category", category);
		int result = 0;
		try {
			result = session.insert("com.weakie.dao.SelectionDAO.insertMajorField", param);
			session.commit();
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		return result;
	}
	
	public int updateMajorFieldType(String type, int category, int id){
		SqlSession session = getSession();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("type", type);
		param.put("category", category);
		param.put("id", id);
		int result = 0;
		try {
			result = session.update("com.weakie.dao.SelectionDAO.updateMajorField", param);
			session.commit();
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		return result;
	}
	
	public Map<Integer,Integer> getMajorFieldMajorFieldCatMap(){
		SqlSession session = getSession();
		Map<Integer,Integer> result = new HashMap<Integer,Integer>();
		List<KeyValuePair> list = null;
		try {
			list = session.selectList("com.weakie.dao.SelectionDAO.getMajorFieldMajorFieldCat");
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		if(list!=null){
			for(KeyValuePair pair:list){
				result.put((Integer) pair.getKey(), (Integer)pair.getValue());
			}
		}
		return result;
	}
	
	public int insertProvince(String type, int country){
		SqlSession session = getSession();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("type", type);
		param.put("country", (country==0?0:1));
		int result = 0;
		try {
			result = session.insert("com.weakie.dao.SelectionDAO.insertProvince", param);
			session.commit();
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		return result;
	}
	
	public int updateProvince(String type, int country, int id){
		SqlSession session = getSession();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("type", type);
		param.put("country", country);
		param.put("id", id);
		int result = 0;
		try {
			result = session.update("com.weakie.dao.SelectionDAO.updateProvince", param);
			session.commit();
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		return result;
	}
	
	public int insertCity(String type, int province){
		SqlSession session = getSession();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("type", type);
		param.put("province", province);
		int result = 0;
		try {
			result = session.insert("com.weakie.dao.SelectionDAO.insertCity", param);
			session.commit();
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		return result;
	}
	
	public int updateCity(String type, int province, int id){
		SqlSession session = getSession();
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("type", type);
		param.put("province", province);
		param.put("id", id);
		int result = 0;
		try {
			result = session.update("com.weakie.dao.SelectionDAO.updateCity", param);
			session.commit();
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		return result;
	}
	
	public Map<Integer,Integer> getCityProvinceMap(List<Integer> cityList){
		SqlSession session = getSession();
		Map<Integer,Integer> result = new HashMap<Integer,Integer>();
		List<KeyValuePair> list = null;
		try {
			list = session.selectList("com.weakie.dao.SelectionDAO.getCityProvince",cityList);
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		if(list!=null){
			for(KeyValuePair pair:list){
				result.put((Integer) pair.getKey(), (Integer)pair.getValue());
			}
		}
		return result;
	}
	
	public Map<Integer,Boolean> getProvinceAbroadMap(List<Integer> provinceList){
		SqlSession session = getSession();
		Map<Integer,Boolean> result = new HashMap<Integer,Boolean>();
		List<KeyValuePair> list = null;
		try {
			list = session.selectList("com.weakie.dao.SelectionDAO.getProvinceAbroad",provinceList);
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		if(list!=null){
			for(KeyValuePair pair:list){
				result.put((Integer) pair.getKey(), (Boolean)pair.getValue());
			}
		}
		return result;
	}
	
	public Map<Integer,String> getCityMap(int province){
		SqlSession session = getSession();
		Map<Integer,String> result = new HashMap<Integer,String>();
		List<KeyValuePair> list = null;
		try {
			list = session.selectList("com.weakie.dao.SelectionDAO.getCity",province);
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		if(list!=null){
			for(KeyValuePair pair:list){
				result.put((Integer) pair.getKey(), (String)pair.getValue());
			}
		}
		return result;
	}
	
	public Map<Integer,String> getProvinceMap(boolean isAbroad){
		SqlSession session = getSession();
		Map<Integer,String> result = new HashMap<Integer,String>();
		List<KeyValuePair> list = null;
		try {
			list = session.selectList("com.weakie.dao.SelectionDAO.getProvince",isAbroad);
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		if(list!=null){
			for(KeyValuePair pair:list){
				result.put((Integer) pair.getKey(), (String)pair.getValue());
			}
		}
		return result;
	}
	
	public Map<Integer,String> getCityNameMap(List<Integer> cityList){
		SqlSession session = getSession();
		Map<Integer,String> result = new HashMap<Integer,String>();
		List<KeyValuePair> list = null;
		try {
			list = session.selectList("com.weakie.dao.SelectionDAO.getCityNameMap",cityList);
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		if(list!=null){
			for(KeyValuePair pair:list){
				result.put((Integer) pair.getKey(), (String)pair.getValue());
			}
		}
		return result;
	}
	
	public Map<Integer,String> getProvinceNameMap(List<Integer> cityList){
		SqlSession session = getSession();
		Map<Integer,String> result = new HashMap<Integer,String>();
		List<KeyValuePair> list = null;
		try {
			list = session.selectList("com.weakie.dao.SelectionDAO.getProvinceNameMap",cityList);
		} catch(Exception e){
			LogUtil.error(e);
		} finally {
		  session.close();
		}
		if(list!=null){
			for(KeyValuePair pair:list){
				result.put((Integer) pair.getKey(), (String)pair.getValue());
			}
		}
		return result;
	}
}
