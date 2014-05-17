package com.weakie.service.impl.test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.weakie.bean.Person;
import com.weakie.service.UserAccountService;
import com.weakie.util.ReadOnlyMap;

public class UserAccountServiceTest implements UserAccountService {

	@Override
	public Person login(String userName, String password) {
		if(StringUtils.isEmpty(userName)||StringUtils.isEmpty(password)){
			return null;
		}
		if(userName.equals("hahaha")&&password.equals("hahaha")){
			return new Person("hahaha",1,1,new Date(),new Date());
		}
		return null;
	}

	@Override
	public boolean checkAccount(String userName) {
		if(StringUtils.isEmpty(userName)){
			return false;
		}
		if(StringUtils.equals(userName, "hahaha")){
			return true;
		}
		return false;
	}

	@Override
	public boolean register(String userName, String password) throws Exception{
		if(StringUtils.isEmpty(userName)||StringUtils.isEmpty(password)){
			return false;
		}
		if(userName.equals("hahaha")&&password.equals("hahaha")){
			return true;
		}
		return true;
	}

	@Override
	public ReadOnlyMap<String, String> getStaffNiceNameMap(Set<String> staffId) {
		Map<String,String> map = new HashMap<String,String>();
		for(String id:staffId){
			if(StringUtils.equals(id, "111")){
				map.put(id, "小王1");
			}
			if(StringUtils.equals(id, "222")){
				map.put(id, "小王2");
			}
			if(StringUtils.equals(id, "333")){
				map.put(id, "小王3");
			}
			if(StringUtils.equals(id, "444")){
				map.put(id, "小王4");
			}
			if(StringUtils.equals(id, "555")){
				map.put(id, "小王5");
			}
		}
		return new ReadOnlyMap<String, String>(map);
	}

	@Override
	public String getStaffNicmName(String staffId) {
		// TODO Auto-generated method stub
		return "小王";
	}

	@Override
	public Person resetPassword(String userName, String password,
			String newPassword) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateNickName(String userName, String nickName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Person> getPersonInfos(int authority, int pageIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateUserAuthority(String username, int authority) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean addNewStaff(String userName) {
		// TODO Auto-generated method stub
		return false;
	}

}
