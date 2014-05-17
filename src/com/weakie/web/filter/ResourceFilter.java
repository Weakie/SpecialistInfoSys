package com.weakie.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.weakie.util.log.LogUtil;

public class ResourceFilter implements Filter {

	public ResourceFilter() {
		LogUtil.info("new resource filter");
	}

	@Override
	public void destroy() {
		LogUtil.info("destroy resource filter");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		//把ServletRequest和ServletResponse转换成真正的类型
        HttpServletRequest req = (HttpServletRequest)arg0;
        String requestURI = req.getRequestURI();
        if(requestURI.endsWith(postfixRedirect)){
        	((HttpServletResponse)arg1).sendRedirect(redirect_to);
            return;
        }
        if(requestURI.endsWith(postfixExclude)){
        	((HttpServletResponse)arg1).sendError(404, "找不到指定资源,请确认请求路径是否正确");
            return;
        }
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		postfixExclude = filterConfig.getInitParameter("exclude");
		postfixRedirect= filterConfig.getInitParameter("redirect");
		redirect_to= filterConfig.getInitParameter("redirect_to");
		LogUtil.info("init resource filter :"+postfixExclude+";"+postfixRedirect+";"+redirect_to);
	}

	private String postfixExclude;
	private String postfixRedirect;
	private String redirect_to;
}
