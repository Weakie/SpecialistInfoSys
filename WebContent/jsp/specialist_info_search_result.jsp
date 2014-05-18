<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <!-- include the static header -->
  <%@ include file="./page_static_header.html" %>
  <title>搜索-上海同济城市规划设计研究院</title>
</head>
<body>
<div class="container">
	<div class="row clearfix">
		<!-- page header -->
		<c:set var="pageHeader" value="9" scope="page"/>
		<c:if test="${sessionScope.USER.role == 1 }">
		<%@ include file="./spec/header.jsp" %>
		</c:if>
		<c:if test="${sessionScope.USER.role == 2 }">
		<%@ include file="./staff/header.jsp" %>
		</c:if>
		<c:if test="${sessionScope.USER.role == 3 }">
		<%@ include file="./admin/header.jsp" %>
		</c:if>
		<br>
		<%@ include file="./include/specialist_info_search_result.jsp" %>
	</div>
	<h5 class="text-center text-muted">
		上海同济城市规划设计研究院
	</h5>
</div>
</body>
</html>
