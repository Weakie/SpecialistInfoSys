<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		var results = xmlHttp.responseText;
		if(results == "EXIST"){
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
		}else{
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
	function checkform(){
		//username exists
		if(result==0){
			var div_parent = document.getElementById("username_div_parent");
			div_parent.setAttribute("class", "form-group has-error");
			document.getElementById("userName").focus();
			return false;
		}
		//confirm password
		var pwdInput = document.getElementById("inputPassword");
		var pwdInputCofirm = document.getElementById("inputPasswordConfirm");
		var pwd = pwdInput.value;
		var pwdConfirm = pwdInputCofirm.value;
		if(pwd!=pwdConfirm){
			var div = document.getElementById("confirm_div");
			var oldTag = div.childNodes;
			if(oldTag[2] != null){
				div.removeChild(oldTag[2]);
			}
			var p = document.createElement("p");
			var font = document.createElement("font");
			font.setAttribute("color", "red");
			font.appendChild(document.createTextNode("确认密码不一致"));
			p.appendChild(font);
			div.appendChild(p);
			
			var div_parent = document.getElementById("confirm_div_parent");
			div_parent.setAttribute("class", "form-group has-error");
			
			pwdInputCofirm.focus();
			return false;
		}
	}
</script>
<head>
  <!-- include the static header -->
  <%@ include file="page_static_header.html" %>
  <title>注册-上海同济城市规划设计研究院</title>
</head>

<body>
<div class="container">
	<div class="row clearfix">
	<div class="col-md-12 column">
			<nav class="navbar navbar-default navbar-fixed-top" >
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
					<a class="navbar-brand" href="login.jsp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;同济专家信息库&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
				</div>
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					
					<ul class="nav navbar-nav navbar-right">
						<li>
							<a href="/SpecialistInfoSys/jsp/registerForm.action">注册</a>
						</li>
						<li>
							<a href="/SpecialistInfoSys/jsp/loginForm.action">登录</a>
						</li>
					</ul>
				</div>
			</nav>
		</div>
		<div class="col-md-12 column">
		<br><br><br><br>
			<div class="row clearfix">
				<div class="col-md-4 column">
				</div>
				<div class="col-md-4 column">
				</div>
				<div class="col-md-4 column">
					<br><br>
					${messageStore.message}
					<form action="/SpecialistInfoSys/register.action" method="post" onsubmit="return checkform();" class="form-horizontal" >
						<div class="form-group" id="username_div_parent">
							<label for="userName" class="col-sm-3 control-label">用户名</label>
							<div class="col-sm-8" id="username_div">
								<input type="text" class="form-control" id="userName" name="userName"  value="${userName}" onblur="confirmUsernameExist()" onkeyup="confirmUsernameExist()" />
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword" class="col-sm-3 control-label">密码</label>
							<div class="col-sm-8">
								<input type="password" class="form-control" id="inputPassword" name="password" >
							</div>
						</div>
						<div class="form-group" id="confirm_div_parent">
							<label for="inputPasswordConfirm" class="col-sm-3 control-label">确认密码</label>
							<div class="col-sm-8" id="confirm_div">
								<input type="password" class="form-control" id="inputPasswordConfirm">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								 <button type="submit" class="btn btn-default">注册</button>
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