<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
<script type="text/javascript">
window.onload=function()
{
	if(!(document.cookie || navigator.cookieEnabled))
	{
		alert('浏览器 cookie 未打开!使用本系统请先打开浏览器cookie。');
	}
};
</script>
<head>
  <meta charset="utf-8">
  <title>登录-上海同济城市规划设计研究院</title>
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
			<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
					<a class="navbar-brand" href="login.jsp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;同济专家信息库&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
				</div>
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					
					<ul class="nav navbar-nav navbar-right">
						<li>
							<a href="register.jsp">注册</a>
						</li>
						<li>
							<a href="login.jsp">登录</a>
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
					<form action="/SpecialistInfoSys/login.action" method="post" class="form-horizontal" role="form" >
						<s:property value="messageStore.message" />
						<div class="form-group">
							<label for="userName" class="col-sm-3 control-label">用户名</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="userName" name="userName"/>
							</div>
						</div>
						<div class="form-group">
							 <label for="inputPassword" class="col-sm-3 control-label">密码</label>
							<div class="col-sm-8">
								<input type="password" class="form-control" id="inputPassword" name="password">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<div class="checkbox">
									 <label><input type="checkbox">记住我</label>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								 <button type="submit" class="btn btn-default">登录</button>
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