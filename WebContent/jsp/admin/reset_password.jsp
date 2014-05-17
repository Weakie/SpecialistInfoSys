<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ page import="com.weakie.service.ApplyInfoService" %>
<%@ page import="com.weakie.global.SpringBeanUtil" %>
<%@ page import="com.weakie.bean.ApplyInfo" %>
<%@ page import="com.weakie.util.log.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <!-- include the static header -->
  <%@ include file="../page_static_header.html" %>
  <title>修改密码-上海同济城市规划设计研究院</title>
</head>
<body>
<div class="container">
	<div class="row clearfix">
		<!-- page header -->
		<c:set var="pageHeader" value="5" scope="page"/>
		<%@ include file="header.jsp" %>
		
		<br><br>
		<div class="page-header">
			<h3 class="text-left">
				<strong>修改密码</strong>
			</h3>
		</div>
		
		<c:set var="formAction" value="/SpecialistInfoSys/resetPasswordForAdmin.action" scope="page"/>
		<%@ include file="../include/reset_password.jsp" %>
		
	</div>
	<h5 class="text-center text-muted">
		上海同济城市规划设计研究院
	</h5>
</div>
</body>
</html>
