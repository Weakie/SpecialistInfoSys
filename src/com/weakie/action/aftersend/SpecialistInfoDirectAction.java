package com.weakie.action.aftersend;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.weakie.bean.Person;
import com.weakie.constant.SystemConstant;
import com.weakie.constant.UserAccountConstant;
import com.weakie.util.log.LogUtil;

/**
 * 
 * @author dell
 *
 */
public class SpecialistInfoDirectAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String SPEC = "SPEC";
	private	String STAFF = "STAFF";
	
	public String executeDirect() throws Exception {
		Map<String,Object> session = ActionContext.getContext().getSession();
		Person p = (Person) session.get(SystemConstant.USER);
		if(p.getRole() == UserAccountConstant.ROLE_SPEC){
			LogUtil.info("person type:specialist");
			return SPEC;
		}else{
			LogUtil.info("person type:stuff");
			return STAFF;
		}
	}
	
	public void setSPEC(String sPEC) {
		SPEC = sPEC;
	}
	public void setSTAFF(String sTAFF) {
		STAFF = sTAFF;
	}
	
	
}