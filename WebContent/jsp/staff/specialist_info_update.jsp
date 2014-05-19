<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ page import="com.weakie.service.ApplyInfoService" %>
<%@ page import="com.weakie.global.SpringBeanUtil" %>
<%@ page import="com.weakie.bean.ApplyInfo" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <!-- include the static header -->
  <%@ include file="../page_static_header.html" %>
  <title>信息修改表-上海同济城市规划设计研究院</title>
</head>
<script type="text/javascript">
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
		var result = xmlHttp.responseText.split(':')[0];
		if(result==2){
			var confirm_not = document.getElementById("confim_not");
			if(confirm_not == null){
				confirm_not = document.getElementById("confim_ing");
			}
			confirm_not.setAttribute("style","color:black");
			var confirm_ing = document.getElementById("confim_ed");
			confirm_ing.setAttribute("style","color:#80BFFF");
			var button = document.getElementById("button");
			button.disabled = true;
		}
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
			<c:if test="${specInfoBean.state==1 }"><span id="confim_not" style="color:#80BFFF">未确认</span></c:if>
			<c:if test="${specInfoBean.state!=1 }">未确认</c:if>
			&nbsp;&gt;&gt;&nbsp;
			<c:if test="${specInfoBean.state==2 }"><span id="confim_ing" style="color:#80BFFF">待确认</span></c:if>
			<c:if test="${specInfoBean.state!=2 }">待确认</c:if>
			&nbsp;&gt;&gt;&nbsp;
			<c:if test="${specInfoBean.state==3 }"><span id="confim_ed" style="color:#80BFFF">已确认</span></c:if>
			<c:if test="${specInfoBean.state!=3 }"><span id="confim_ed" >已确认</span></c:if>
		</div>
		<div class="page-header">
			<h3 class="text-left">
				<strong>专家信息修改</strong>
			</h3>
		</div>
		<%
			ApplyInfoService service = (ApplyInfoService)SpringBeanUtil.getBeans("applyInfoService");
			String applyId = request.getParameter("applyInfoId");
			int id = Integer.parseInt(applyId);
			ApplyInfo info= service.getApplyInfoById(id);
			pageContext.setAttribute("info", info);
		%>
		<div class="page-header">
			<input type="button" id="button" value="不修改直接确认" class="btn btn-primary" onClick="confirmSpecInfo(${applyInfoId},'${staffId }')" <c:if test="${specInfoBean.state!=1 }">disabled="disabled"</c:if>>
		</div>
		<span class="label label-default">修改参考</span><br><br>
		<div class="col-sm-6 col-xs-6">
			<textarea class="form-control" id="comment" rows="4" placeholder="修改备注">${info.comment }</textarea><br>
		</div>
		
		<c:set var="formAction" value="/SpecialistInfoSys/specInfoAddForStaff.action" scope="page"/>
		<!-- include page need info in pageContex -->
		<%@ include file="../include/specialist_info_update.jsp" %>
	</div>
	<h5 class="text-center text-muted">
		上海同济城市规划设计研究院
	</h5>
</div>
</body>
</html>
