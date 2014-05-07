<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ page import="com.weakie.constant.SystemConstant,com.weakie.bean.Person"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<div class="col-md-12 column">
			<nav class="navbar navbar-default navbar-fixed-top" >
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
					<a class="navbar-brand" href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;同济专家信息库&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
				</div>
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li <c:if test="${pageHeader==1}">class="active"</c:if> >
							<a href="/SpecialistInfoSys/staffDisposeApplyShowAll.action?pageIndex=1&status=1&staffId=${sessionScope.USER.userName}">处理申请</a>
						</li>
						<li <c:if test="${pageHeader==2}">class="active"</c:if> >
							<a href="/SpecialistInfoSys/selectionInfoAddPrepare.action">关键字维护</a>
						</li>
						<c:if test="${sessionScope.USER.authority==1 }">
						<li <c:if test="${pageHeader==3}">class="active"</c:if> >
							<a href="#">高级搜索</a>
						</li>
						</c:if>
					</ul>
					<c:if test="${sessionScope.USER.authority==1 }">
					<form class="navbar-form navbar-left" >
						<div class="form-group">
							<input type="text" class="form-control" style="width:305px;" placeholder="关键字：专业类别、研究专长、工作地点"/>
						</div> <button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-search"></i>搜索</button>
					</form>
					</c:if>
					<ul class="nav navbar-nav navbar-right">
						<li>
							<a href="#">你好, ${sessionScope.USER.nickName}</a>
						</li>
						<li>
							<a href="#"><span class="badge pull-right">42</span>系统消息</a>
						</li>
						<li class="dropdown">
							 <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-cog"></i>个人设置<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li>
									<a href="#">修改密码</a>
								</li>
								<li>
									<a href="#">账户信息</a>
								</li>
								<li>
									<a href="#">申请搜索权限</a>
								</li>
								<li class="divider">
								</li>
								<li>
									<a href="#">退出</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</nav>
		</div>
		