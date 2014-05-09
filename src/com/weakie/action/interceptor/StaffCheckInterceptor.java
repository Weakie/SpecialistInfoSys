package com.weakie.action.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.weakie.bean.Person;
import com.weakie.constant.ActionConstant;
import com.weakie.constant.SystemConstant;
import com.weakie.constant.UserAccountConstant;

/**
 * ר�Ҳ鿴���޸�ר����Ϣ��ʱ����֤�Ƿ���Ȩ��
 * parameter : userName=?,applyInfoId=?,staffId=?
 * @author weakie E-mail:weakielin@gmail.com
 * 2014��5��9������10:48:05
 */
public class StaffCheckInterceptor  extends AbstractInterceptor {
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// ȡ��������ص�ActionContextʵ��
		ActionContext ctx = invocation.getInvocationContext();
		Map<String,Object> session = ctx.getSession();
		Person user = (Person) session.get(SystemConstant.USER);

		// ���û�е�½,�������µ�½
		if (user == null) {
			ctx.put("message", "�㻹û��¼");
			return ActionConstant.RESULT_FAIL;
		}
		if(user.getRole() != UserAccountConstant.ROLE_STAFF){
			ctx.put("message", "�㲻�ǹ�����Ա");
			return ActionConstant.RESULT_FAIL;
		}
		return invocation.invoke();
	}

}
