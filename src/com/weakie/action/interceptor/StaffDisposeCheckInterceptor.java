package com.weakie.action.interceptor;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

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
public class StaffDisposeCheckInterceptor  extends AbstractInterceptor {
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// 取得请求相关的ActionContext实例
		ActionContext ctx = invocation.getInvocationContext();
		Map<String,Object> session = ctx.getSession();
		Person user = (Person) session.get(SystemConstant.USER);

		// 如果没有登陆,返回重新登陆
		if (user == null) {
			ctx.put("message", "你还没登录");
			return ActionConstant.RESULT_FAIL;
		}
		if(user.getRole() != UserAccountConstant.ROLE_STAFF){
			ctx.put("message", "你不是工作人员");
			return ActionConstant.RESULT_FAIL;
		}
		//验证staff是否有操作权利
		Map<String,Object> param = ctx.getParameters();
		LogUtil.debug(ctx.getName()+" ,staff dispose applyInfo:"+param+",user:"+user.getUserName());
		
		String staffId = this.getParamener(param.get("staffId"));
		LogUtil.info(ctx.getName()+" ,userName="+staffId);
		if(!StringUtils.equals(user.getUserName(), staffId)){
			ctx.put("message", "你不是该工作人员");
			return ActionConstant.RESULT_FAIL;
		}
		return invocation.invoke();
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
