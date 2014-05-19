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
		<div class="col-md-12 column">
			<br><br><br>
			<h3 class="text-left">
				<Strong>搜索结果</Strong>
			</h3>
			<br><br>
			<c:set var="i" value="1" scope="page"/>
			<c:forEach var="info" items="${specInfos}">
			<div class="row clearfix">
				<div class="col-md-8 column">
					<h2>
						${info.name }
					</h2>
					<p>
						${info.infoString }
					</p>
					<p>
						<a class="btn" href="/SpecialistInfoSys/specInfoSearchResultDetail.action?userName=${info.userName}" target="_blank">View details »</a>
					</p>
				</div>
				<div class="col-md-4 column">
					<img class="img-thumbnail" alt="暂无照片" width="160" height="160" src="/SpecialistInfoSys/downloadImage.action?userName=${info.userName}" />
				</div>
			</div>
			<hr>
			<c:set var="i" value="${i+1 }" scope="page"/>
			</c:forEach>
		</div>
	</div>
	<h5 class="text-center text-muted">
		上海同济城市规划设计研究院
	</h5>
</div>
</body>
</html>
