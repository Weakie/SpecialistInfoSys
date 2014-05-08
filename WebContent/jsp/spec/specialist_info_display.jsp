<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <!-- include the static header -->
  <%@ include file="../page_static_header.html" %>
  <title>专家信息主页-上海同济城市规划设计研究院</title>
</head>
<script type="text/javascript">
	var xmlHttp;
	
	function createXMLHttpRequest() {
		if (window.ActiveXObject) {
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		} else if (window.XMLHttpRequest) {
			xmlHttp = new XMLHttpRequest();
		}
	}
	
	function applySpecInfo(){
		var url = "/SpecialistInfoSys/specAddNewApply.action?userName=" + ${specInfoBean.userName} + "&name="+encodeURI(encodeURI('${specInfoBean.name}'));

		createXMLHttpRequest();
		xmlHttp.onreadystatechange = handleStateChangeSpecInfoApply;
		xmlHttp.open("GET", url, true);
		xmlHttp.send(null);
	}

	function handleStateChangeSpecInfoApply() {
		if (xmlHttp.readyState == 4) {
			if (xmlHttp.status == 200) {
				onGetConfirmResult();
			}
		}
	}
	
	function onGetConfirmResult(){
		alert(xmlHttp.responseText);
		var result = xmlHttp.responseText.split(':')[0];
		if(result==2){
			var confirm_not = document.getElementById("confim_not");
			confirm_not.setAttribute("style","color:black");
			var confirm_ing = document.getElementById("confim_ing");
			confirm_ing.setAttribute("style","color:#80BFFF");
			var button = document.getElementById("button");
			button.setAttribute("type","hidden");
		}
	}
</script>
<body>
<div class="container">
	<div class="row clearfix">
		<!-- page header -->
		<c:set var="pageHeader" value="1" scope="page"/>
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
		<div>
			<c:if test="${specInfoBean.state==1 }">
				<input type="button" id="button" value="提交申请" class="btn btn-primary" onClick="applySpecInfo()">
			</c:if>
		</div>
		<%@ include file="../include/specialist_info_display.jsp" %>
	</div>
	<h5 class="text-center text-muted">
		上海同济城市规划设计研究院
	</h5>
</div>
</body>
</html>
