package com.weakie.action.interceptor;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.weakie.bean.Person;
import com.weakie.constant.ActionConstant;
import com.weakie.constant.SystemConstant;
import com.weakie.constant.UserAccountConstant;
import com.weakie.util.log.LogUtil;

/**
 * ר�Ҳ鿴���޸�ר����Ϣ��ʱ����֤�Ƿ���Ȩ��
 * parameter : userName=?,applyInfoId=?,staffId=?
 * @author weakie E-mail:weakielin@gmail.com
 * 2014��5��9������10:48:05
 */
public class SearchAuthorityCheckInterceptor  extends AbstractInterceptor {
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// ȡ��������ص�ActionContextʵ��
		ActionContext ctx = invocation.getInvocationContext();
		Map<String,Object> session = ctx.getSession();
		Person user = (Person) session.get(SystemConstant.USER);

		// ���û�е�½,�������µ�½
		if (user == null) {
			ctx.put("messageStore.message", "�㻹û��¼");
			return Action.LOGIN;
		}
		
		//��֤�Ƿ��в���Ȩ��
		Map<String,Object> param = ctx.getParameters();
		LogUtil.debug(ctx.getName()+" ,show search result for specInfo:"+param+",user:"+user.getUserName());
		
		String userName = this.getParamener(param.get("userName"));
		LogUtil.info(ctx.getName()+" ,userName="+userName);
		//�鿴��Ϣ��ʱ��
		if( user.getAuthority() != UserAccountConstant.SEARCH_AUTHORITY){
			ctx.put("message", "��û��Ȩ������");
			return ActionConstant.RESULT_FAIL;
		}else {
			return invocation.invoke();
		}
	}
	
	private String getParamener(Object paramIn){
		String[] params = (String[])paramIn;
		if(params != null && params.length > 0){
			return params[0];
		}else{
			LogUtil.info("param :"+paramIn);
			return StringUtils.EMPTY;
		}
	}

}
