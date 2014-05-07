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
	//addKeyValueTable('U',<%=SystemConstant.KEY_ORGTYPE%>,'orgTypeInput')">
	function createQueryString1(ope, key, value) {
		var queryString = "ope=" + ope + "&key=" + key + "&value=" + value;
		return queryString;
	}
	function addKeyValueTable(ope, key, id) {
		//get the encoded value
		var inputValue = encodeURI(encodeURI(document.getElementById(id).value));
		//set the value to null
		document.getElementById(id).value="";
		//create the requset url
		var url = "/SpecialistInfoSys/selectionInfoAddUpdate.action?" + createQueryString1(ope, key, inputValue);

		if(ope=="U"){
			var valueId = document.getElementById(""+key).value;
			url += "&id="+valueId;
		}
		
		createXMLHttpRequest();
		xmlHttp.onreadystatechange = handleStateChange;
		xmlHttp.open("GET", url, true);
		xmlHttp.send(null);
	}
	//
	function createQueryString2(ope, key, value, item) {
		var queryString = "ope=" + ope + "&key=" + key + "&value=" + value + "&item=" + item;
		return queryString;
	}
	function addKeyValueTable2(ope, key, id, itemId) {
		//get the item value
		var itemValue;
		if(key == <%=SystemConstant.KEY_PROVINCE%>){
			if(document.getElementById(itemId).checked)
				itemValue = 1;
			else
				itemValue = 0;
		}else{
			itemValue = document.getElementById(itemId).value;
		}
		//get the encoded value
		var inputValue = encodeURI(encodeURI(document.getElementById(id).value));
		//set the value to null
		document.getElementById(id).value="";
		//create the requset url
		var url = "/SpecialistInfoSys/selectionInfoAddUpdate.action?" + createQueryString2(ope, key, inputValue, itemValue);

		if(ope=="U"){
			var valueId = document.getElementById(""+key).value;
			url += "&id="+valueId;
		}
		
		createXMLHttpRequest();
		xmlHttp.onreadystatechange = handleStateChange;
		xmlHttp.open("GET", url, true);
		xmlHttp.send(null);
	}
	//
	function handleStateChange() {
		if (xmlHttp.readyState == 4) {
			if (xmlHttp.status == 200) {
				updateList();
			}
		}
	}
	
	function updateList() {
		var results = xmlHttp.responseText.split(";");
		if(results[0].split(":")[0]=="1"){
			alert('信息更新成功');
		}else if(results[0].split(":")[0]=="0"){
			alert('信息更新失败');
			return;
		}
		
		//clear
		var select = document.getElementById(results[0].split(":")[1]);
		while (select.childNodes.length >= 1) {
			select.removeChild(select.lastChild);
		}
		var option = null;
		for ( var i = 1; i < results.length; i++) {
			option = document.createElement("option");
			option.setAttribute("value", results[i].split(":")[0]);
			option.appendChild(document.createTextNode(results[i].split(":")[1]));
			select.appendChild(option);
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
	}
</script>
<head>
   <!-- include the static header -->
  <%@ include file="../page_static_header.html" %>
  <title>关键字维护-上海同济城市规划设计研究院</title>
</head>

<body>
<div class="container">
	<div class="row clearfix">
		<!-- page header -->
		<c:set var="pageHeader" value="2" scope="page"/>
		<%@ include file="header.jsp" %>
		
		<div class="col-md-10 column">
			<br><br><br>
			<h3 class="text-left">
				<Strong>关键字维护</Strong>
			</h3>
			<form class="form-horizontal" method="post">
				<div class="form-group">
					<label for="orgType" class="col-sm-2 col-xs-2 control-label">单位性质</label>
					<div class="col-sm-3 col-xs-3">
						<table class="col-sm-6">
							<tbody id="address-table">
								<tr>
									<th>
					 					<input type="text" class="form-control" style="width:130px;" id="orgTypeInput" placeholder="单位性质">
					 				</th>
					 				<th>
					 					<button type="button" class="btn btn-default" onclick="addKeyValueTable('A',<%=SystemConstant.KEY_ORGTYPE%>,'orgTypeInput')"><i class="glyphicon glyphicon-plus"></i></button>
					 				</th>
					 				<th>
					 					<button type="button" class="btn btn-default" onclick="addKeyValueTable('U',<%=SystemConstant.KEY_ORGTYPE%>,'orgTypeInput')"><i class="glyphicon glyphicon-chevron-right"></i></button>
					 				</th>
					 				<th>
					 					<select class="form-control" style="width:130px;" id="<%=SystemConstant.KEY_ORGTYPE%>">
											<s:iterator value="orgTypeMap">
												<option value="<s:property value="key"/>" ><s:property value="value"/></option>
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
					 					<input type="text" class="form-control" style="width:130px;" id="qualificationInput" placeholder="执业资格">
					 				</th>
					 				<th>
					 					<button type="button" class="btn btn-default" onclick="addKeyValueTable('A',<%=SystemConstant.KEY_QUALIFICATION%>,'qualificationInput')"><i class="glyphicon glyphicon-plus"></i></button>
					 				</th>
					 				<th>
					 					<button type="button" class="btn btn-default" onclick="addKeyValueTable('U',<%=SystemConstant.KEY_QUALIFICATION%>,'qualificationInput')"><i class="glyphicon glyphicon-chevron-right"></i></button>
					 				</th>
					 				<th>
					 					<select class="form-control" style="width:130px;" id="<%=SystemConstant.KEY_QUALIFICATION%>">
											<s:iterator value="qualificationMap">
												<option value="<s:property value="key"/>" ><s:property value="value"/></option>
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
						 					<input type="text" class="form-control" style="width:130px;" id="titleInput" placeholder="职称">
						 				</th>
						 				<th>
					 						<button type="button" class="btn btn-default" onclick="addKeyValueTable('A',<%=SystemConstant.KEY_TITLE%>,'titleInput')"><i class="glyphicon glyphicon-plus"></i></button>
					 					</th>
						 				<th>
						 					<button type="button" class="btn btn-default" onclick="addKeyValueTable('U',<%=SystemConstant.KEY_TITLE%>,'titleInput')"><i class="glyphicon glyphicon-chevron-right"></i></button>
						 				</th>
						 				<th>
						 					<select class="form-control" style="width:130px;" id="<%=SystemConstant.KEY_TITLE%>">
												<s:iterator value="titleMap">
													<option value="<s:property value="key"/>" ><s:property value="value"/></option>
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
						 				<input type="text" class="form-control" style="width:130px;" id="majorClassInput" placeholder="专业方向大类">
						 			</th>
						 			<th>
					 					<button type="button" class="btn btn-default" onclick="addKeyValueTable('A',<%=SystemConstant.KEY_MAJORCLASS%>,'majorClassInput')"><i class="glyphicon glyphicon-plus"></i></button>
					 				</th>
						 			<th>
						 				<button type="button" class="btn btn-default" onclick="addKeyValueTable('U',<%=SystemConstant.KEY_MAJORCLASS%>,'majorClassInput')"><i class="glyphicon glyphicon-chevron-right"></i></button>
						 			</th>
									<th>
										<select class="form-control" style="width:130px;" id="<%=SystemConstant.KEY_MAJORCLASS%>" onchange="refreshMajorList();" >
											<s:iterator value="majorClassMap">
												<option value="<s:property value="key"/>" ><s:property value="value"/></option>
											</s:iterator>
										</select>
									</th>
									<th>
						 				<input type="text" class="form-control" style="width:130px;" id="majorInput" placeholder="专业方向">
						 			</th>
						 			<th>
					 					<button type="button" class="btn btn-default" onclick="addKeyValueTable2('A',<%=SystemConstant.KEY_MAJOR%>,'majorInput','<%=SystemConstant.KEY_MAJORCLASS%>')"><i class="glyphicon glyphicon-plus"></i></button>
					 				</th>
						 			<th>
						 				<button type="button" class="btn btn-default" onclick="addKeyValueTable2('U',<%=SystemConstant.KEY_MAJOR%>,'majorInput','<%=SystemConstant.KEY_MAJORCLASS%>')"><i class="glyphicon glyphicon-chevron-right"></i></button>
						 			</th>
									<th>
										<select class="form-control" style="width:130px;" id="<%=SystemConstant.KEY_MAJOR%>">
											<s:iterator value="majorMap">
												<option value="<s:property value="key"/>" <c:if test="${specInfoBean.majorId==key}">selected</c:if> ><s:property value="value"/></option>
											</s:iterator>
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
					 					<input type="text" class="form-control" style="width:100px;" id="provinceInput" placeholder="省（国内）、国家（国外）">
					 				</th>
					 				<th>
					 					<button type="button" class="btn btn-default" onclick="addKeyValueTable2('A',<%=SystemConstant.KEY_PROVINCE%>,'provinceInput','abroad')"><i class="glyphicon glyphicon-plus"></i></button>
					 				</th>
					 				<th>
					 					<button type="button" class="btn btn-default" onclick="addKeyValueTable2('U',<%=SystemConstant.KEY_PROVINCE%>,'provinceInput','abroad')"><i class="glyphicon glyphicon-chevron-right"></i></button>
					 				</th>
									<th>
										<select class="form-control" id="<%=SystemConstant.KEY_PROVINCE%>" onchange="refreshCityList();" style="width:100px;">
											<s:iterator value="provinceMap">
												<option value="<s:property value="key"/>"><s:property value="value"/></option>
											</s:iterator>
										</select>
									</th>
									<th>
					 					<input type="text" class="form-control" style="width:100px;" id="cityInput" placeholder="城市">
					 				</th>
					 				<th>
					 					<button type="button" class="btn btn-default" onclick="addKeyValueTable2('A',<%=SystemConstant.KEY_CITY%>,'cityInput','<%=SystemConstant.KEY_PROVINCE%>')"><i class="glyphicon glyphicon-plus"></i></button>
					 				</th>
					 				<th>
					 					<button type="button" class="btn btn-default" onclick="addKeyValueTable2('U',<%=SystemConstant.KEY_CITY%>,'cityInput','<%=SystemConstant.KEY_PROVINCE%>')"><i class="glyphicon glyphicon-chevron-right"></i></button>
					 				</th>
									<th>
										<select class="form-control" id="<%=SystemConstant.KEY_CITY%>" style="width:100px;">
											<s:iterator value="cityMap">
												<option value="<s:property value="key"/>"><s:property value="value"/></option>
											</s:iterator>
										</select>
									</th>
								 </tr>
							</tbody>
						</table>
					 </div>
				</div>				
			</form>
		</div>
		
	</div>
	<h5 class="text-center text-muted">
		上海同济城市规划设计研究院
	</h5>
</div>
</body>
</html>
