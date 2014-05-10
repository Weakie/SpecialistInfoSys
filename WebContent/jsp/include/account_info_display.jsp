<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	var xmlHttp;

	function createXMLHttpRequest() {
		if (window.ActiveXObject) {
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		} else if (window.XMLHttpRequest) {
			xmlHttp = new XMLHttpRequest();
		}
	}
	
	function updateNickNameRequest() {
		var nickName = encodeURI(encodeURI(document.getElementById("nickName").value));
		var url = "/SpecialistInfoSys/updateNickName.action?userName=${sessionScope.USER.userName}&password=" + nickName;

		createXMLHttpRequest();
		xmlHttp.onreadystatechange = disposeResult;
		xmlHttp.open("GET", url, true);
		xmlHttp.send(null);
	}

	function disposeResult() {
		if (xmlHttp.readyState == 4) {
			if (xmlHttp.status == 200) {
				update();
			}
		}
	}
	
	function update(){
		var results = xmlHttp.responseText.split(":");
		alert(results[1]);
	}
</script>
		<div class="col-md-10 column">
			<div class="row clearfix">
				<div class="col-md-6 column">
					<span class="label label-default">账户信息</span><br><br>
					<p>
						<b>用户名: </b> ${sessionScope.USER.userName}
					</p>
					<br>
					<p>
						<b>名称: </b> ${sessionScope.USER.nickName}
					</p>
					<br>
					<p>
						<input type="text" class="form-control" id="nickName"/>
						<input type="button" class="btn btn-default" onclick="updateNickNameRequest()" value="更改账户名称"/>
					</p>
					<br>
					<p>
						<b>角色: </b><c:if test="${sessionScope.USER.role == 1}">专家</c:if><c:if test="${sessionScope.USER.role == 2}">工作人员</c:if>
					</p>
					<br>
					<p>
						<b>搜索权限: </b><c:if test="${sessionScope.USER.authority == 1}">有</c:if><c:if test="${sessionScope.USER.authority == 0}">无</c:if>
					</p>
					<br>
					<p>
						<b>注册时间: </b> ${sessionScope.USER.registerTimeString}
					</p>
					<br>
					<p>
						<b>上次登录时间: </b> ${sessionScope.USER.loginTimeString}
					</p>
				</div>
			</div>
			<hr>
		</div>
	