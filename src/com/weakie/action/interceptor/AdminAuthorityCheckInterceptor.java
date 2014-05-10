package com.weakie.action.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.weakie.bean.Person;
import com.weakie.constant.ActionConstant;
import com.weakie.constant.SystemConstant;
import com.weakie.constant.UserAccountConstant;
import com.weakie.util.log.LogUtil;

/**
 * 专家查看、修改专家信息的时候验证是否有权利
 * parameter : userName=?,applyInfoId=?,staffId=?
 * @author weakie E-mail:weakielin@gmail.com
 * 2014年5月9日下午10:48:05
 */
public class AdminAuthorityCheckInterceptor  extends AbstractInterceptor {
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// 取得请求相关的ActionContext实例
		ActionContext ctx = invocation.getInvocationContext();
		Map<String,Object> session = ctx.getSession();
		Person user = (Person) session.get(SystemConstant.USER);

		// 如果没有登陆,返回重新登陆
		if (user == null) {
			String url = "<a href=\"/SpecialistInfoSys/loginForm.action\" >点此进入登录页面</a>";
			ctx.put("message", "你还没登录,"+url);
			return ActionConstant.RESULT_FAIL;
		}
		LogUtil.info(ctx.getName()+" ,userName="+user.getUserName());
		
		if(user.getAuthority() != UserAccountConstant.ROLE_ADMIN){
			ctx.put("message", "你没有权力操作");
			return ActionConstant.RESULT_FAIL;
		}
		
		return invocation.invoke();
	}
}
