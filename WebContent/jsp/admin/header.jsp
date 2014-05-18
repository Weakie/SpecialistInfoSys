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
							<a href="/SpecialistInfoSys/adminAuthorityShowAll.action?pageIndex=1&status=0">权限管理</a>
						</li>
						<li <c:if test="${pageHeader==2}">class="active"</c:if> >
							<a href="/SpecialistInfoSys/addNewStaffForm.action">添加工作人员</a>
						</li>
						<c:if test="${sessionScope.USER.authority==1 }">
						<li <c:if test="${pageHeader==9}">class="active"</c:if> >
							<a href="/SpecialistInfoSys/advanceSearchPrepare.action">高级搜索</a>
						</li>
						</c:if>
					</ul>
					<c:if test="${sessionScope.USER.authority==1 }">
					<form action="/SpecialistInfoSys/searchSpecInfo.action" method="post" class="navbar-form navbar-left" >
						<div class="form-group">
							<input type="text" name="searchValue" value="${searchValue}" class="form-control" style="width:305px;" placeholder="关键字：专业类别、研究专长、工作地点"/>
						</div> <button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-search"></i>搜索</button>
					</form>
					</c:if>
					<ul class="nav navbar-nav navbar-right">
						<li>
							<a href="#">你好, ${sessionScope.USER.nickName}</a>
						</li>
						<!-- 
						<li>
							<a href="#"><span class="badge pull-right">42</span>系统消息</a>
						</li>
						 -->
						<li class="dropdown" <c:if test="${pageHeader==5}">class="active"</c:if>>
							 <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-cog"></i>个人设置<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li>
									<a href="/SpecialistInfoSys/resetPasswordFormForAdmin.action">修改密码</a>
								</li>
								<li>
									<a href="/SpecialistInfoSys/accountInfoDisplayFormForAdmin.action">账户信息</a>
								</li>
								
								<li class="divider">
								</li>
								<li>
									<a href="/SpecialistInfoSys/logout.action">退出</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</nav>
		</div>
		