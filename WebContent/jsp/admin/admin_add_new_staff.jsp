<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<script type="text/javascript">
	var xmlHttp;

	function createXMLHttpRequest() {
		if (window.ActiveXObject) {
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		} else if (window.XMLHttpRequest) {
			xmlHttp = new XMLHttpRequest();
		}
	}
	
	var result=0;
	function confirmUsernameExist() {
		var userNameInput = document.getElementById("userName");
		var userName = userNameInput.value;
		var url = "/SpecialistInfoSys/usernameConfirm.action?userName="+userName;

		createXMLHttpRequest();
		xmlHttp.onreadystatechange = handleStateChangeUsername;
		xmlHttp.open("GET", url, true);
		xmlHttp.send(null);
	}

	function handleStateChangeUsername() {
		if (xmlHttp.readyState == 4) {
			if (xmlHttp.status == 200) {
				update();
			}
		}
	}
	
	function update() {
		clear();
		var results = xmlHttp.responseText.split(":");
		if(results[0] == "INVALID"){
			//add new hint
			var div = document.getElementById("username_div");
			var p = document.createElement("p");
			var font = document.createElement("font");
			font.setAttribute("color", "red");
			if(results[1] == "1"){
				font.appendChild(document.createTextNode("用户名不能为空"));
			}else if(results[1] == "2"){
				font.appendChild(document.createTextNode("用户名由5-12位字母或者数字组成"));
			}
			p.appendChild(font);
			div.appendChild(p);
			//set class of div
			var div_parent = document.getElementById("username_div_parent");
			div_parent.setAttribute("class", "form-group has-error");
			document.getElementById("userName").focus();
			result=0;
		}else if(results[0] == "EXIST"){
			//add new hint
			var div = document.getElementById("username_div");
			var p = document.createElement("p");
			var font = document.createElement("font");
			font.setAttribute("color", "red");
			font.appendChild(document.createTextNode("用户名已存在"));
			p.appendChild(font);
			div.appendChild(p);
			//set class of div
			var div_parent = document.getElementById("username_div_parent");
			div_parent.setAttribute("class", "form-group has-error");
			document.getElementById("userName").focus();
			result=0;
		}else if(results[0] == "NOTEXIST"){
			//add new hint
			var div = document.getElementById("username_div");
			var p = document.createElement("p");
			var font = document.createElement("font");
			font.setAttribute("color", "green");
			font.appendChild(document.createTextNode("可以使用此用户名"));
			p.appendChild(font);
			div.appendChild(p);
			//set class of div
			var div_parent = document.getElementById("username_div_parent");
			div_parent.setAttribute("class", "form-group has-success");
			result=1;
		}
	}
	
	function clear(){
		//remove exist hint
		var div = document.getElementById("username_div");
		if (div.childNodes.length > 2) {
			div.removeChild(div.lastChild);
		}
	}
</script>
<head>
  <!-- include the static header -->
  <%@ include file="../page_static_header.html" %>
  <title>添加工作人员-上海同济城市规划设计研究院</title>
</head>
<body>
<div class="container">
	<div class="row clearfix">
		<!-- page header -->
		<c:set var="pageHeader" value="2" scope="page"/>
		<%@ include file="header.jsp" %>
		
		<div class="page-header">
			<br>
			<h3 class="text-left">
				<strong>添加工作人员</strong>
			</h3>
		</div>
		<div class="col-md-12 column">
			<br><br><br>
			<div class="row clearfix">
				<div class="col-md-4 column">
					<br><br>
					${messageStore.message}
					<form action="/SpecialistInfoSys/addNewStaff.action" method="post" class="form-horizontal" >
						<div class="form-group" id="username_div_parent">
							<label for="userName" class="col-sm-3 control-label">用户名</label>
							<div class="col-sm-8" id="username_div">
								<input type="text" class="form-control" id="userName" name="userName" onblur="confirmUsernameExist()" onkeyup="confirmUsernameExist()" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								 <button type="submit" class="btn btn-default">添加</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<h5 class="text-center text-muted">
		上海同济城市规划设计研究院
	</h5>
</div>
</body>
</html>
		