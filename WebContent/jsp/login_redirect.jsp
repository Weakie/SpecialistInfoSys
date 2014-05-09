<%@ page import="com.weakie.constant.SystemConstant,com.weakie.bean.Person"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <!-- include the static header -->
  <%@ include file="page_static_header.html" %>
  <title>登录-上海同济城市规划设计研究院</title>
</head>

<body>
登录成功，浏览器自动跳转
<% Person p = (Person)session.getAttribute(SystemConstant.USER);%>
<%	if(p.getRole()==1){ %>
<a href="/SpecialistInfoSys/specInfoDisplay?userName=${p.userName }">点此</a>
<%
		response.setHeader("Refresh","1;URL="+"/SpecialistInfoSys/specInfoDisplay.action?userName="+p.getUserName()); 
}
%>
<%	if(p.getRole()==2){ %>
<a href="/SpecialistInfoSys/staffDisposeApplyShowAll.action?pageIndex=1&status=1&staffId=${p.userName }">点此</a>
<%
		response.setHeader("Refresh","1;URL="+"/SpecialistInfoSys/staffDisposeApplyShowAll.action?pageIndex=1&status=1&staffId="+p.getUserName()); 
}
%>
</body>
</html>