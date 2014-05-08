<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <!-- include the static header -->
  <%@ include file="../page_static_header.html" %>
  <title>信息登记表-上海同济城市规划设计研究院</title>
</head>

<body>
<div class="container">
	<div class="row clearfix">
		<!-- page header -->
		<c:set var="pageHeader" value="2" scope="page"/>
		<%@ include file="header.jsp" %>
		<br>
		<div class="page-header">
			<kbd>状态: </kbd> &nbsp;&nbsp;
			<c:if test="${specInfoBean.state==1 }"><span id="confim_not" style="color:#80BFFF">未确认</span></c:if>
			<c:if test="${specInfoBean.state!=1 }">未确认</c:if>
			&nbsp;&gt;&gt;&nbsp;
			<c:if test="${specInfoBean.state==2 }"><span style="color:#80BFFF">确认中</span></c:if>
			<c:if test="${specInfoBean.state!=2 }"><span id="confim_ing" style="color:black">确认中</span></c:if>
			&nbsp;&gt;&gt;&nbsp;
			<c:if test="${specInfoBean.state==3 }"><span style="color:#80BFFF">已确认</span></c:if>
			<c:if test="${specInfoBean.state!=3 }">已确认</c:if>
		</div>
		<div class="page-header">
			<h3 class="text-left">
				<strong>信息登记表</strong>
			</h3>
		</div>
		<%@ include file="../include/specialist_info_update.jsp" %>
	</div>
	<h5 class="text-center text-muted">
		上海同济城市规划设计研究院
	</h5>
</div>
</body>
</html>
