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
  <meta charset="utf-8">
  <title>注册-上海同济城市规划设计研究院</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">

	<!--link rel="stylesheet/less" href="/SpecialistInfoSys/jsp/less/bootstrap.less" type="text/css" /-->
	<!--link rel="stylesheet/less" href="/SpecialistInfoSys/jsp/less/responsive.less" type="text/css" /-->
	<!--script src="/SpecialistInfoSys/jsp/js/less-1.3.3.min.js"></script-->
	<!--append ‘#!watch’ to the browser URL, then refresh the page. -->
	
	<link href="/SpecialistInfoSys/jsp/css/bootstrap.min.css" rel="stylesheet">
	<link href="/SpecialistInfoSys/jsp/css/style.css" rel="stylesheet">

  <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
  <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
  <![endif]-->

  <!-- Fav and touch icons -->
  <link rel="apple-touch-icon-precomposed" sizes="144x144" href="/SpecialistInfoSys/jsp/img/apple-touch-icon-144-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/SpecialistInfoSys/jsp/img/apple-touch-icon-114-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/SpecialistInfoSys/jsp/img/apple-touch-icon-72-precomposed.png">
  <link rel="apple-touch-icon-precomposed" href="/SpecialistInfoSys/jsp/img/apple-touch-icon-57-precomposed.png">
  <link rel="shortcut icon" href="/SpecialistInfoSys/jsp/img/favicon.png">
  
	<script type="text/javascript" src="/SpecialistInfoSys/jsp/js/jquery.min.js"></script>
	<script type="text/javascript" src="/SpecialistInfoSys/jsp/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/SpecialistInfoSys/jsp/js/scripts.js"></script>
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
							<a href="/SpecialistInfoSys/jsp/register.jsp">注册</a>
						</li>
						<li>
							<a href="/SpecialistInfoSys/jsp/login.jsp">登录</a>
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
								<input type="text" class="form-control" id="userName" name="userName" onblur="confirmUsernameExist()" onkeyup="confirmUsernameExist()" />
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword" class="col-sm-3 control-label">密码</label>
							<div class="col-sm-8">
								<input type="password" class="form-control" id="inputPassword" name="password">
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