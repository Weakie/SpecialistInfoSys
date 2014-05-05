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
