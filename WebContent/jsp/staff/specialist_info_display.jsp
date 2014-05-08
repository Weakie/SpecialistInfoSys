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
	function confirmSpecInfo(applyInfoId,staffId){
		var url = "/SpecialistInfoSys/staffDisposeApplyConfirm.action?applyInfoId=" + applyInfoId + "&staffId="+staffId;

		createXMLHttpRequest();
		xmlHttp.onreadystatechange = handleStateChangeSpecInfoConfirm;
		xmlHttp.open("GET", url, true);
		xmlHttp.send(null);
	}

	function handleStateChangeSpecInfoConfirm() {
		if (xmlHttp.readyState == 4) {
			if (xmlHttp.status == 200) {
				onGetConfirmResult();
			}
		}
	}
	
	function onGetConfirmResult(){
		alert(xmlHttp.responseText);
	}
</script>
<body>
<div class="container">
	<div class="row clearfix">
		<!-- page header -->
		<c:set var="pageHeader" value="1" scope="page"/>
		<%@ include file="header.jsp" %>
		<br><br>
		<div class="page-header">
			<kbd>状态: </kbd> 
			&nbsp;&nbsp;
			<c:if test="${specInfoBean.state==1 }"><span style="color:#80BFFF">未确认</span></c:if>
			<c:if test="${specInfoBean.state!=1 }">未确认</c:if>
			&nbsp;&gt;&gt;&nbsp;
			<c:if test="${specInfoBean.state==2 }"><span style="color:#80BFFF">确认中</span></c:if>
			<c:if test="${specInfoBean.state!=2 }">确认中</c:if>
			&nbsp;&gt;&gt;&nbsp;
			<c:if test="${specInfoBean.state==3 }"><span style="color:#80BFFF">已确认</span></c:if>
			<c:if test="${specInfoBean.state!=3 }">已确认</c:if>
		</div>
		<%
		if(request.getAttribute("applyInfoId")==null || request.getAttribute("staffId")==null){
			ApplyInfoService service = (ApplyInfoService)SpringBeanUtil.getBeans("applyInfoService");
			String applyId = request.getParameter("applyInfoId");
			int id = Integer.parseInt(applyId);
			ApplyInfo info= service.getApplyInfoById(id);
			pageContext.setAttribute("applyInfoId", info.getId());
			pageContext.setAttribute("staffId", info.getStaffID());
			LogUtil.info(info.getStaffID());
		}
		LogUtil.info( request.getAttribute("staffId")+":"+request.getAttribute("applyInfoId"));
		%>
		<div class="page-header">
			<input type="button" id="button" value="确认信息" class="btn btn-primary" onClick="confirmSpecInfo(${applyInfoId},'${staffId }')">
		</div>
		<div class="page-header">
			<h3 class="text-left">
				<strong>专家信息</strong>
			</h3>
		</div>
		
		<%@ include file="../include/specialist_info_display.jsp" %>
	</div>
	<h5 class="text-center text-muted">
		上海同济城市规划设计研究院
	</h5>
</div>
</body>
</html>
