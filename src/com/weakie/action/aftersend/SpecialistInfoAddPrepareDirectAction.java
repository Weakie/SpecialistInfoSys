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
public class SpecialistInfoAddPrepareDirectAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String SPEC_UPDATE = "SPEC_UPDATE";
	private	String STAFF_UPDATE = "STAFF_UPDATE";
	
	public String execute() throws Exception {
		Map<String,Object> session = ActionContext.getContext().getSession();
		Person p = (Person) session.get(SystemConstant.USER);
		if(p.getRole() == UserAccountConstant.ROLE_SPEC){
			LogUtil.info("person type:specialist");
			return SPEC_UPDATE;
		}else{
			LogUtil.info("person type:stuff");
			return STAFF_UPDATE;
		}
	}

	public void setSPEC_UPDATE(String sPEC_UPDATE) {
		SPEC_UPDATE = sPEC_UPDATE;
	}

	public void setSTAFF_UPDATE(String sTAFF_UPDATE) {
		STAFF_UPDATE = sTAFF_UPDATE;
	}	
}