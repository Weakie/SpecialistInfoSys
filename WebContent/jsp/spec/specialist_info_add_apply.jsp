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
		var url = "/SpecialistInfoSys/specAddNewApply.action";
		
		var inputValue = encodeURI(encodeURI(document.getElementById("comment").value));
		var valueSend = "userName=" + "${specInfoBean.userName}" + "&name="+encodeURI(encodeURI("${specInfoBean.name}"))+"&comment="+inputValue;
		createXMLHttpRequest();
		xmlHttp.onreadystatechange = handleStateChangeSpecInfoApply;
		xmlHttp.open("post", url, true);
		xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded; charset=utf-8");
		xmlHttp.send(valueSend);
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
			button.disabled = true;
		}
	}
</script>
<body>
<div class="container">
	<div class="row clearfix">
		<!-- page header -->
		<c:set var="pageHeader" value="3" scope="page"/>
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
		<c:if test="${specInfoBean.state==2 }">
			<span style="color:#80BFFF">信息正在确认中</span>
		</c:if>
		<br>
		<div class="col-md-10 column">
			<div class="row clearfix">
				<div class="col-md-6 column">
					<span class="label label-default">基本资料</span><br><br>
					<p class="text-left">
						<i>姓名: </i>：${specInfoBean.name }
					</p>
					<p class="text-left">
						<i>性别： <c:if test="${!specInfoBean.sex}">男</c:if><c:if test="${specInfoBean.sex}">女</c:if></i>
					</p>
					<p class="text-left">
						<i>邮箱：</i><em>${specInfoBean.email }</em>
					</p>
					<p>
						<i>出生日期：${specInfoBean.year}年${specInfoBean.month}月</i>
					</p>
				</div>
			</div>
		</div>
		<br><br>
		<div class="col-sm-6 col-xs-6" id="inputArea">
			<span class="label label-default">备注</span><br><br>
			若表单中没有相应选项，请在备注信息中输入。
			<textarea class="form-control" id="comment" rows="3" placeholder="备注信息"></textarea><br>
			<input type="button" id="button" value="提交申请" class="btn btn-primary" onClick="applySpecInfo()" <c:if test="${specInfoBean.state!=1 }">disabled="disabled"</c:if>>
		</div>
	</div>
	<h5 class="text-center text-muted">
		上海同济城市规划设计研究院
	</h5>
</div>
</body>
</html>
