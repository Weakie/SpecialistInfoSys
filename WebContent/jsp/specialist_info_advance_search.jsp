<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ page import="com.weakie.constant.SystemConstant" %>
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
</script>
<script type="text/javascript">
	function createQueryString(item, itemID) {
		var queryString = "item=" + item + "&itemID=" + itemID;
		return queryString;
	}
	
	function refreshProvinceList() {
		var orgPlace = document.getElementById("abroad").checked;
	
		var url = "/SpecialistInfoSys/specInfoAddUpdate.action?" + "index=" + 0 + "&" + createQueryString("orgPlace", orgPlace);
	
		createXMLHttpRequest();
		xmlHttp.onreadystatechange = handleStateChangeProvince;
		xmlHttp.open("GET", url, true);
		xmlHttp.send(null);
	}
	
	function handleStateChangeProvince() {
		if (xmlHttp.readyState == 4) {
			if (xmlHttp.status == 200) {
				updateProvinceList();
			}
		}
	}
	
	function updateProvinceList() {
		var results = xmlHttp.responseText.split(";");
		var province = document.getElementById("<%=SystemConstant.KEY_PROVINCE%>");
		while (province.childNodes.length >= 1) {
			province.removeChild(province.lastChild);
		}
		var option = null;
		for ( var i = 1; i < results.length; i++) {
			option = document.createElement("option");
			option.setAttribute("value", results[i].split(":")[0]);
			option.appendChild(document.createTextNode(results[i].split(":")[1]));
			province.appendChild(option);
		}
		option = document.createElement("option");
		option.setAttribute("value", '-1');
		option.appendChild(document.createTextNode('--请选择--'));
		province.appendChild(option);
		refreshCityList();
	}
	
	function refreshCityList() {
		var province = document.getElementById("<%=SystemConstant.KEY_PROVINCE%>").value;
	
		var url = "/SpecialistInfoSys/specInfoAddUpdate.action?" + "index=" + 0 + "&" + createQueryString("province", province);
	
		createXMLHttpRequest();
		xmlHttp.onreadystatechange = handleStateChangeCity;
		xmlHttp.open("GET", url, true);
		xmlHttp.send(null);
	}
	
	function handleStateChangeCity() {
		if (xmlHttp.readyState == 4) {
			if (xmlHttp.status == 200) {
				updateCityList();
			}
		}
	}
	
	function updateCityList() {
		var results = xmlHttp.responseText.split(";");
		var city = document.getElementById("<%=SystemConstant.KEY_CITY%>");
		while (city.childNodes.length >= 1) {
			city.removeChild(city.lastChild);
		}
		var option = null;
		for ( var i = 1; i < results.length; i++) {
			option = document.createElement("option");
			option.setAttribute("value", results[i].split(":")[0]);
			option.appendChild(document.createTextNode(results[i].split(":")[1]));
			city.appendChild(option);
		}
		option = document.createElement("option");
		option.setAttribute("value", '-1');
		option.appendChild(document.createTextNode('--请选择--'));
		city.appendChild(option);
	}
	
	function refreshMajorList() {
		var majorClass = document.getElementById("<%=SystemConstant.KEY_MAJORCLASS%>").value;
	
		var url = "/SpecialistInfoSys/specInfoAddUpdate.action?" + createQueryString("majorClass", majorClass);
	
		createXMLHttpRequest();
		xmlHttp.onreadystatechange = handleStateChangeMajor;
		xmlHttp.open("GET", url, true);
		xmlHttp.send(null);
	}
	
	function handleStateChangeMajor() {
		if (xmlHttp.readyState == 4) {
			if (xmlHttp.status == 200) {
				updateMajorList();
			}
		}
	}
	
	function updateMajorList() {
		var results = xmlHttp.responseText.split(";");
		var major = document.getElementById("<%=SystemConstant.KEY_MAJOR%>");
		while (major.childNodes.length >= 1) {
			major.removeChild(major.lastChild);
		}
		var option = null;
		for ( var i = 0; i < results.length; i++) {
			option = document.createElement("option");
			option.setAttribute("value", results[i].split(":")[0]);
			option.appendChild(document.createTextNode(results[i].split(":")[1]));
			major.appendChild(option);
		}
		option = document.createElement("option");
		option.setAttribute("value", '-1');
		option.appendChild(document.createTextNode('--请选择--'));
		major.appendChild(option);
	}
</script>
<head>
   <!-- include the static header -->
  <%@ include file="./page_static_header.html" %>
  <title>关键字维护-上海同济城市规划设计研究院</title>
</head>

<body>
<div class="container">
	<div class="row clearfix">
		<!-- page header -->
		<c:set var="pageHeader" value="9" scope="page"/>
		<c:if test="${sessionScope.USER.role == 1 }">
		<%@ include file="./spec/header.jsp" %>
		</c:if>
		<c:if test="${sessionScope.USER.role == 2 }">
		<%@ include file="./staff/header.jsp" %>
		</c:if>
		<c:if test="${sessionScope.USER.role == 3 }">
		<%@ include file="./admin/header.jsp" %>
		</c:if>
		
		<div class="col-md-10 column">
			<br><br><br>
			<h3 class="text-left">
				<Strong>高级搜索</Strong>
			</h3>
			<form class="form-horizontal" method="post" action="advanceSearch.action">
				<div class="form-group">
					<label for="orgType" class="col-sm-2 col-xs-2 control-label">单位性质</label>
					<div class="col-sm-3 col-xs-3">
						<table class="col-sm-6">
							<tbody id="address-table">
								<tr>
					 				<th>
					 					<select class="form-control" style="width:130px;" name="orgType" id="<%=SystemConstant.KEY_ORGTYPE%>">
											<s:iterator value="orgTypeMap">
												<option value="<s:property value="key"/>" <c:if test="${key==-1}">selected</c:if> ><s:property value="value"/></option>
											</s:iterator>
										</select>
									</th>
					 			</tr>
					 		</tbody>
					 	</table>
					 </div>
				</div>
				<div class="form-group">
					 <label for="qualification" class="col-sm-2 control-label">执业资格</label>
					 <div class="col-sm-2">
					 	<table class="col-sm-6">
							<tbody id="address-table">
								<tr>
					 				<th>
					 					<select class="form-control" style="width:130px;" name="qualification" id="<%=SystemConstant.KEY_QUALIFICATION%>">
											<s:iterator value="qualificationMap">
												<option value="<s:property value="key"/>" <c:if test="${key==-1}">selected</c:if> ><s:property value="value"/></option>
											</s:iterator>
										</select>
					 				</th>
					 			</tr>
					 		</tbody>
					 	</table>
						
					 </div>
				</div>
				<div class="form-group">
					<label for="title" class="col-sm-2 control-label">职称</label>
					<div class="col-sm-2">
						<table class="col-sm-6">
							<tbody id="address-table">
								<tr>
						 			<th>
						 				<select class="form-control" style="width:130px;" name="title" id="<%=SystemConstant.KEY_TITLE%>">
											<s:iterator value="titleMap">
												<option value="<s:property value="key"/>" <c:if test="${key==-1}">selected</c:if>><s:property value="value"/></option>
											</s:iterator>
										</select>
									</th>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<div class="form-group">
					<label for="majorClass" class="col-sm-2 control-label">专业方向</label>
					<div class="col-sm-4">
						<table class="col-sm-4">
							<tbody>
								 <tr>
									<th>
										<select class="form-control" style="width:130px;" name="majorClass" id="<%=SystemConstant.KEY_MAJORCLASS%>" onchange="refreshMajorList();" >
											<s:iterator value="majorClassMap">
												<option value="<s:property value="key"/>" <c:if test="${key==-1}">selected</c:if> ><s:property value="value"/></option>
											</s:iterator>
										</select>
									</th>
									<th>
										<select class="form-control" style="width:130px;" name="major" id="<%=SystemConstant.KEY_MAJOR%>">
										</select>
									</th>
								 </tr>
							</tbody>
						</table>
					</div>
				</div>					 
				<div class="form-group">
					 <label for="province-01" class="col-sm-2 col-xs-2 control-label">工作地点</label>
					 <div class="col-sm-8 col-xs-8">
					 	<table class="col-sm-6">
							 <tbody id="address-table">
								 <tr>
									<th>
										<label class="checkbox-inline" style="width:60px;">
											<input type="checkbox" id="abroad" onclick="refreshProvinceList();" checked> 国内
										</label>
									</th>
									<th>
										<select class="form-control" style="width:100px;" name="province" id="<%=SystemConstant.KEY_PROVINCE%>" onchange="refreshCityList();" >
											<s:iterator value="provinceMap">
												<option value="<s:property value="key"/>" <c:if test="${key==-1}">selected</c:if> ><s:property value="value"/></option>
											</s:iterator>
										</select>
									</th>
									<th>
										<select class="form-control" style="width:100px;" name="city" id="<%=SystemConstant.KEY_CITY%>" >
										</select>
									</th>
								 </tr>
							</tbody>
						</table>
					 </div>
				</div>	
				<button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-search"></i>检索</button>
			</form>
		</div>
		
	</div>
	<h5 class="text-center text-muted">
		上海同济城市规划设计研究院
	</h5>
</div>
</body>
</html>
