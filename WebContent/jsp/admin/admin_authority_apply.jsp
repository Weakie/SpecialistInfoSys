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
	
	function disposeApplyRequest(userName,authority) {
		var url = "/SpecialistInfoSys/adminAuthorityDispose.action?userName=" + userName + "&authority=" + authority;

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
		var statu = document.getElementById("statu-"+results[1]);
		var ope = document.getElementById("operation-"+results[1]);
		if(results[0]=="1"){
			if(results[2]=="1"){
				alert(results[3]);
				status.innerText="有";
				ope.innerHTML="<a href=\"#\" onclick=\"disposeApplyRequest('"+results[1]+"',0)\">取消</a>";
			}else if(results[2]=="0"){
				alert(results[3]);
				status.innerText="无";
				ope.innerHTML="<a href=\"#\" onclick=\"disposeApplyRequest('"+results[1]+"',1)\">给予</a>";
			}
		}else{
			alert('失败');
		}
	}
</script>
<head>
  <!-- include the static header -->
  <%@ include file="../page_static_header.html" %>
  <title>权限管理-上海同济城市规划设计研究院</title>
</head>
<body>
<div class="container">
	<div class="row clearfix">
		<!-- page header -->
		<c:set var="pageHeader" value="1" scope="page"/>
		<%@ include file="header.jsp" %>
		
		<div class="page-header">
			<br>
			<h3 class="text-left">
				<strong>权限管理</strong>
			</h3>
		</div>
		<div class="col-md-12 column">
			<ul class="breadcrumb">
				<li>
					<a href="/SpecialistInfoSys/adminAuthorityShowAll.action?pageIndex=1&status=0">
						<c:if test="${status==0 }"><b>无查询权限</b></c:if><c:if test="${status!=0 }">无查询权限</c:if>
					</a> 
					<span class="divider">/</span>
				</li>
				<li class="active">
					<a href="/SpecialistInfoSys/adminAuthorityShowAll.action?pageIndex=1&status=1">
						<c:if test="${status==1 }"><b>有查询权限</b></c:if><c:if test="${status!=1 }">有查询权限</c:if>
					</a> 
					<span class="divider">/</span>
				</li>
			</ul>
			<table class="table">
				<thead>
					<tr>
						<th>序号</th><th>用户名</th><th>角色</th><th>注册时间</th><th>登录时间</th><th>搜索权限</th><th>操作</th>
					</tr>
				</thead>
				<tbody>
				<c:set var="i" value="1" scope="page"/>
				<c:forEach var="info" items="${userInfo}">
					<tr <c:if test="${info.authority==-1 }">class="danger"</c:if> <c:if test="${info.authority==0 }">class="warning"</c:if> <c:if test="${info.authority==1 }">class="success"</c:if> >
						<td>
							${i }
						</td>
						<td>
							${info.userName }
						</td>
						<td>
							<c:if test="${info.role==1 }">专家</c:if><c:if test="${info.role==2 }">工作人员</c:if><c:if test="${info.role==3 }">管理员</c:if>
						</td>
						<td>
							${info.registerTimeString }
						</td>
						<td>
							${info.loginTimeString }
						</td>
						<td id="statu-${info.userName }">
							<c:if test="${info.authority==-1 }">新申请</c:if>
							<c:if test="${info.authority== 0 }">无</c:if>
							<c:if test="${info.authority== 1 }">有</c:if>
						</td>
						<td id="operation-${info.userName }">
							<c:if test="${info.authority== 1 }">
								<a href="#" onclick="disposeApplyRequest('${info.userName }',0)">取消</a>
							</c:if>
							<c:if test="${info.authority!= 1 }">
								<a href="#" onclick="disposeApplyRequest('${info.userName }',1)">给予</a>
							</c:if>
						</td>
					</tr>
					<c:set var="i" value="${i+1 }" scope="page"/>
				</c:forEach>
				</tbody>
			</table>
			<ul class="pagination">
				<c:forEach var="x" begin="0" end="6" step="1">
				<li>
					<a href="/SpecialistInfoSys/adminAuthorityShowAll.action?pageIndex=${pages[x]}&status=${status }&staffId=${sessionScope.USER.userName}">
						<c:if test="${x==0 }">Prev</c:if>
						<c:if test="${x!=0&&x!=6 }">${pages[x]}</c:if>
						<c:if test="${x==6 }">Next</c:if>
					</a>
				</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<h5 class="text-center text-muted">
		上海同济城市规划设计研究院
	</h5>
</div>
</body>
</html>
		