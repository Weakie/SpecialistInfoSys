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
	
	function acceptApplyRequest(staffId,applyId) {
		var url = "/SpecialistInfoSys/staffDisposeApplyAccept.action?staffId=" + staffId + "&applyInfoId=" + applyId;

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
		var results = xmlHttp.responseText.split(";");
		var statu = document.getElementById("statu-"+results[1]);
		var ope = document.getElementById("operation-"+results[1]);
		if(results[0]=="SUCCESS"){
			alert(results[0]);
			status.innerText="已接收";
			ope.innerHTML="<a href=\"/SpecialistInfoSys/staffDisposeApplyDispose.action?staffId="+results[2]+"&applyId="+results[2]+"\">处理</a>";
		}else{
			alert(results[0]+",已经被"+results[2]+"接收");
			statu.innerText=results[2]+"处理"; 
			ope.innerHTML="";
		}
	}
</script>
<head>
  <!-- include the static header -->
  <%@ include file="../page_static_header.html" %>
  <title>申请处理-上海同济城市规划设计研究院</title>
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
				<strong>专家信息申请</strong>
			</h3>
		</div>
		<div class="col-md-12 column">
			<ul class="breadcrumb">
				<li>
					<a href="/SpecialistInfoSys/staffDisposeApplyShowAll.action?pageIndex=1&status=1&staffId=${sessionScope.USER.userName}">
						<c:if test="${status==1 }"><b>新的申请</b></c:if><c:if test="${status!=1 }">新的申请</c:if>
					</a> 
					<span class="divider">/</span>
				</li>
				<li>
					<a href="/SpecialistInfoSys/staffDisposeApplyShowAll.action?pageIndex=1&status=3&staffId=${sessionScope.USER.userName}">
						<c:if test="${status==3 }"><b>待处理的申请</b></c:if><c:if test="${status!=3 }">待处理的申请</c:if>
					</a> 
					<span class="divider">/</span>
				</li>
				<li class="active">
					<a href="/SpecialistInfoSys/staffDisposeApplyShowAll.action?pageIndex=1&status=4&staffId=${sessionScope.USER.userName}">
						<c:if test="${status==4 }"><b>已处理的申请</b></c:if><c:if test="${status!=4 }">已处理的申请</c:if>
					</a> 
					<span class="divider">/</span>
				</li>
				<li>
					<a href="/SpecialistInfoSys/staffDisposeApplyShowAll.action?pageIndex=1&status=0&staffId=${sessionScope.USER.userName}">
						<c:if test="${status==0 }"><b>所有申请</b></c:if><c:if test="${status!=0 }">所有申请</c:if>
					</a> 
					<span class="divider">/</span>
				</li>
			</ul>
			<table class="table">
				<thead>
					<tr>
						<th>序号</th><th>申请ID</th><th>用户名</th><th>专家姓名</th><th>申请时间</th><th>接收时间</th><th>处理时间</th><th>状态</th><th>操作</th>
					</tr>
				</thead>
				<tbody>
				<c:set var="i" value="1" scope="page"/>
				<c:forEach var="info" items="${applyInfo}">
					<tr <c:if test="${info.status==1 }">class="danger"</c:if> <c:if test="${info.status==2 }">class="warning"</c:if> <c:if test="${info.status==3 }">class="success"</c:if> <c:if test="${info.status==4 }">class="active"</c:if> >
						<td>
							${i }
						</td>
						<td>
							${info.id }
						</td>
						<td>
							${info.userName }
						</td>
						<td>
							${info.specName }
						</td>
						<td>
							${info.applyTime }
						</td>
						<td>
							${info.acceptTime }
						</td>
						<td>
							${info.disposeTime }
						</td>
						<td id="statu-${info.id }">
							<c:if test="${info.status==1 }">新申请</c:if>
							<c:if test="${info.status==2 }">已过时</c:if>
							<c:if test="${info.status==3&&info.staffID!=sessionScope.USER.userName }">已被${staffIdNameMap[info.staffID]}接收</c:if>
							<c:if test="${info.status==3&&info.staffID==sessionScope.USER.userName }">已接收</c:if>
							<c:if test="${info.status==4&&info.staffID!=sessionScope.USER.userName }">已被${staffIdNameMap[info.staffID]}处理</c:if>
							<c:if test="${info.status==4&&info.staffID==sessionScope.USER.userName }">已处理</c:if>
						</td>
						<td id="operation-${info.id }">
							<c:if test="${info.status==1 }">
								<a href="#" onclick="acceptApplyRequest('${sessionScope.USER.userName }',${info.id})">接收</a>
							</c:if>
							<c:if test="${info.status==3&&info.staffID==sessionScope.USER.userName }">
								<a href="/SpecialistInfoSys/specInfoAddPrepare.action?userName=${info.userName }&applyInfoId=${info.id }&staffId=${info.staffID}">处理</a>
							</c:if>
							<c:if test="${info.status==4&&info.staffID==sessionScope.USER.userName }">
								<a href="/SpecialistInfoSys/staffDisposeApplyAccept.action?staffId=${sessionScope.USER.userName}">查看</a>-
								<a href="/SpecialistInfoSys/specInfoAddPrepare.action?userName=${info.userName }&applyInfoId=${info.id }&staffId=${info.staffID}">修改</a>
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
					<a href="/SpecialistInfoSys/staffDisposeApplyShowAll.action?pageIndex=${pages[x]}&status=${status }&staffId=${sessionScope.USER.userName}">
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
		