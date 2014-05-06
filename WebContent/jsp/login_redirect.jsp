<%@ page import="com.weakie.constant.SystemConstant,com.weakie.bean.Person"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>登录-上海同济城市规划设计研究院</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">

	<!--link rel="stylesheet/less" href="/SpecialistInfoSys/jsp/less/bootstrap.less" type="text/css" /-->
	<!--link rel="stylesheet/less" href="/SpecialistInfoSys/jsp/less/responsive.less" type="text/css" /-->
	<!--script src="/SpecialistInfoSys/jsp/js/less-1.3.3.min.js"></script-->
	<!--append ‘#!watch’ to the browser URL, then refresh the page. -->
	
	<link href="/SpecialistInfoSys/jsp/css/bootstrap.min.css" rel="stylesheet">
	<link href="/SpecialistInfoSys/jsp/css/style.css" rel="stylesheet">

  <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
  <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
  <![endif]-->

  <!-- Fav and touch icons -->
  <link rel="apple-touch-icon-precomposed" sizes="144x144" href="/SpecialistInfoSys/jsp/img/apple-touch-icon-144-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/SpecialistInfoSys/jsp/img/apple-touch-icon-114-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/SpecialistInfoSys/jsp/img/apple-touch-icon-72-precomposed.png">
  <link rel="apple-touch-icon-precomposed" href="/SpecialistInfoSys/jsp/img/apple-touch-icon-57-precomposed.png">
  <link rel="shortcut icon" href="/SpecialistInfoSys/jsp/img/favicon.png">
  
	<script type="text/javascript" src="/SpecialistInfoSys/jsp/js/jquery.min.js"></script>
	<script type="text/javascript" src="/SpecialistInfoSys/jsp/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/SpecialistInfoSys/jsp/js/scripts.js"></script>
</head>

<body>
登录成功，浏览器自动跳转
<% Person p = (Person)session.getAttribute(SystemConstant.USER);%>
<%	if(p.getRole()==1){ %>
<a href="/SpecialistInfoSys/specInfoDisplay?userName=${p.userName }">点此</a>
<%
		response.setHeader("Refresh","3;URL="+"/SpecialistInfoSys/specInfoDisplay?userName="+p.getUserName()); 
}
%>
<%	if(p.getRole()==2){ %>
<a href="/SpecialistInfoSys/staffDisposeApplyShowAll.action?pageIndex=1&status=1&staffId=${p.userName }">点此</a>
<%
		response.setHeader("Refresh","3;URL="+"/SpecialistInfoSys/staffDisposeApplyShowAll.action?pageIndex=1&status=1&staffId="+p.getUserName()); 
}
%>
</body>
</html>