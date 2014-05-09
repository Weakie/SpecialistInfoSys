package com.weakie.action.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.weakie.bean.MessageStore;
import com.weakie.bean.Person;
import com.weakie.constant.SystemConstant;
import com.weakie.util.log.LogUtil;

public class LoginInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		// 取得请求相关的ActionContext实例
		ActionContext ctx = invocation.getInvocationContext();
		Map<String,Object> session = ctx.getSession();
		Person user = (Person) session.get(SystemConstant.USER);

		// 如果没有登陆,返回重新登陆
		if (user != null) {
			return invocation.invoke();
		}
		
		LogUtil.info("not login,"+invocation.getAction());
		ctx.put("messageStore", new MessageStore("你还没登录"));
		return Action.LOGIN;

	}

}
