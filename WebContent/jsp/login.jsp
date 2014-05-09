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
  <!-- include the static header -->
  <%@ include file="page_static_header.html" %>
  <title>登录-上海同济城市规划设计研究院</title>
</head>

<body>
<div class="container">
	<div class="row clearfix">
	<div class="col-md-12 column">
			<nav class="navbar navbar-default navbar-fixed-top" >
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
					<a class="navbar-brand" href="login.jsp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;同济专家信息库&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
				</div>
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					
					<ul class="nav navbar-nav navbar-right">
						<li>
							<a href="/SpecialistInfoSys/jsp/registerForm.action">注册</a>
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
					<form action="/SpecialistInfoSys/login.action" method="post" class="form-horizontal" >
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