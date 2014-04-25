<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
	
	function createQueryString(item, itemID) {
		var queryString = "item=" + item + "&itemID=" + itemID;
		return queryString;
	}


	function refreshProvinceList(index) {
		var orgPlace = document.getElementById("orgPlace-"+index).checked;

		var url = "/SpecialistInfoSys/specInfoAddUpdate.action?" + "index=" + index + "&" + createQueryString("orgPlace", orgPlace);

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
		clearProvinceList(results[0]);
		
		var province = document.getElementById("province-"+results[0]);
		var option = null;
		for ( var i = 1; i < results.length; i++) {
			option = document.createElement("option");
			option.setAttribute("value", results[i].split(":")[0]);
			option.appendChild(document.createTextNode(results[i].split(":")[1]));
			province.appendChild(option);
		}
		refreshCityList(results[0]);
	}
	
	function clearProvinceList(index) {
		var province = document.getElementById("province-"+index);
		while (province.childNodes.length >= 1) {
			province.removeChild(province.lastChild);
		}
	}
	
	function refreshCityList(index) {
		var province = document.getElementById("province-"+index).value;

		var url = "/SpecialistInfoSys/specInfoAddUpdate.action?" + "index=" + index + "&" + createQueryString("province", province);

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
		clearCityList(results[0]);
		
		var city = document.getElementById("city-"+results[0]);
		var option = null;
		for ( var i = 1; i < results.length; i++) {
			option = document.createElement("option");
			option.setAttribute("value", results[i].split(":")[0]);
			option.appendChild(document.createTextNode(results[i].split(":")[1]));
			city.appendChild(option);
		}
	}
	
	function clearCityList(index) {
		var city = document.getElementById("city-"+index);
		while (city.childNodes.length >= 1) {
			city.removeChild(city.lastChild);
		}
	}
	
	function refreshMajorList() {
		var majorClass = document.getElementById("majorClass").value;

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
		clearMajorList();
		
		var major = document.getElementById("major");
		var option = null;
		for ( var i = 0; i < results.length; i++) {
			option = document.createElement("option");
			option.setAttribute("value", results[i].split(":")[0]);
			option.appendChild(document.createTextNode(results[i].split(":")[1]));
			major.appendChild(option);
		}
	}
	
	function clearMajorList() {
		var major = document.getElementById("major");
		while (major.childNodes.length >= 1) {
			major.removeChild(major.lastChild);
		}
	}
	
	var contactTableIndex = 1;
	function addContactTable() {
		contactTableIndex++;
		
		if(contactTableIndex > 10){
			var button = document.getElementById("contactButton");
			button.setAttribute("class", "btn btn-default disabled");
			return;
		}
		
		var table = document.getElementById("contact-table");
		var tr = document.createElement("tr");
		tr.setAttribute("id", "tableContact:"+contactTableIndex);
		
		var th1 = document.createElement("th");
		var input1 = document.createElement("input");
		input1.setAttribute("type", "text");
		input1.setAttribute("class", "form-control");
		input1.setAttribute("id","name");
		input1.setAttribute("placeholder","联系人"+contactTableIndex);
		th1.appendChild(input1);
		
		var th2 = document.createElement("th");
		var input2 = document.createElement("input");
		input2.setAttribute("type", "text");
		input2.setAttribute("class", "form-control");
		input2.setAttribute("id","name");
		input2.setAttribute("placeholder","联系方式");
		th2.appendChild(input2);
		
		var th3 = document.createElement("th");
		var button = document.createElement("button");
		button.setAttribute("type", "button");
		button.setAttribute("class", "btn btn-default");
		button.setAttribute("onclick", "removeContactTable("+contactTableIndex+")");
		var itag = document.createElement("i");
		itag.setAttribute("class","glyphicon glyphicon-minus");
		button.appendChild(itag);
		th3.appendChild(button);
		
		tr.appendChild(th1);
		tr.appendChild(th2);
		tr.appendChild(th3);
		table.appendChild(tr);
	}
	
	function removeContactTable(i) {
		var table = document.getElementById("contact-table");
		
		var childNodes = table.getElementsByTagName("tr");
		var id = "tableContact:"+i;
		for(var k=1;k < childNodes.length;k++){
			var node = childNodes.item(k);
			var id2 = node.attributes["id"].nodeValue;
			if( id2 != null && id2 == id){
				table.removeChild(node);
				break;
			}
		}
	}
	
	var addressTableIndex = 1;
	function addAddressTable() {
		addressTableIndex++;
		
		if(addressTableIndex > 10){
			var button = document.getElementById("addressButton");
			button.setAttribute("class", "btn btn-default disabled");
			return;
		}
		
		var table = document.getElementById("address-table");
		var tr = document.createElement("tr");
		tr.setAttribute("id", "tableAddress:"+addressTableIndex);
		
		var th1 = document.createElement("th");
		var label = document.createElement("label");
		label.setAttribute("style", "width:60px;");
		label.setAttribute("class", "checkbox-inline");
		var input1 = document.createElement("input");
		input1.setAttribute("type", "checkbox");
		input1.setAttribute("value", "1");
		input1.setAttribute("id","orgPlace-"+addressTableIndex);
		input1.setAttribute("onclick","refreshProvinceList("+addressTableIndex+");");
		label.appendChild(input1);
		label.appendChild(document.createTextNode("国内"));
		th1.appendChild(label);
		
		var th2 = document.createElement("th");
		var select2 = document.createElement("select");
		select2.setAttribute("name", "text");
		select2.setAttribute("class", "form-control");
		select2.setAttribute("id", "province-"+addressTableIndex);
		select2.setAttribute("onchange","refreshCityList("+addressTableIndex+");");
		select2.setAttribute("style", "width:100px;");
		th2.appendChild(select2);
		
		var th3 = document.createElement("th");
		var select3 = document.createElement("select");
		select3.setAttribute("name", "text");
		select3.setAttribute("class", "form-control");
		select3.setAttribute("id", "city-"+addressTableIndex);
		select3.setAttribute("style", "width:100px;");
		th3.appendChild(select3);
		
		var th4 = document.createElement("th");
		var button = document.createElement("button");
		button.setAttribute("type", "button");
		button.setAttribute("class", "btn btn-default");
		button.setAttribute("onclick", "removeAddressTable("+addressTableIndex+")");
		var itag = document.createElement("i");
		itag.setAttribute("class","glyphicon glyphicon-minus");
		button.appendChild(itag);
		th4.appendChild(button);
		
		tr.appendChild(th1);
		tr.appendChild(th2);
		tr.appendChild(th3);
		tr.appendChild(th4);
		table.appendChild(tr);
		
		//refresh
		refreshProvinceList(addressTableIndex);
	}
	
	function removeAddressTable(i) {
		var table = document.getElementById("address-table");
		
		var childNodes = table.getElementsByTagName("tr");
		var id = "tableAddress:"+i;
		for(var k=1;k < childNodes.length;k++){
			var node = childNodes.item(k);
			var id2 = node.attributes["id"].nodeValue;
			if( id2 != null && id2 == id){
				table.removeChild(node);
				break;
			}
		}
	}
</script>
<head>
  <meta charset="utf-8">
  <title>信息登记表-上海同济城市规划设计研究院</title>
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
					<a class="navbar-brand" href="#">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;同济专家信息库&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
				</div>
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active">
							<a href="#">基本信息</a>
						</li>
						<li>
							<a href="#">修改信息</a>
						</li>
						<li>
							<a href="#">高级搜索</a>
						</li>
					</ul>
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input type="text" class="form-control" style="width:305px;" placeholder="关键字：专业类别、研究专长、工作地点"/>
						</div> <button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-search"></i>搜索</button>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<li>
							<a href="#">Link</a>
						</li>
						<li class="dropdown">
							 <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-cog"></i>个人设置<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li>
									<a href="#">Action</a>
								</li>
								<li>
									<a href="#">Another action</a>
								</li>
								<li>
									<a href="#">Something else here</a>
								</li>
								<li class="divider">
								</li>
								<li>
									<a href="#">Separated link</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</nav>
		</div>
		<div class="col-md-10 column">
			<br><br><br>
			<h3 class="text-left">
				<Strong>信息登记表</Strong>
			</h3>
			<form action="/SpecialistInfoSys/specInfoAdd.action" enctype="multipart/form-data" method="post" class="form-horizontal">
				<span class="label label-default">基本资料</span><br><br>
				<input type="hidden" name="specInfoBean.userName" value="<s:property value="userName"/>" />
				<div class="form-group">
					 <label for="name" class="col-sm-2 col-xs-2 control-label">姓名</label>
					 <div class="col-sm-2 col-xs-2">
						<input type="text" class="form-control" id="name" name="specInfoBean.name" placeholder="姓名">
					 </div>
				</div>
				<div class="form-group">
					 <label for="sex" class="col-sm-2 col-xs-2 control-label">性别</label>
					 <div class="col-sm-2 col-xs-3">
						<select name="specInfoBean.sex" class="form-control" id="sex">
							<option value="false">男</option>
							<option value="true">女</option>
						</select>
					 </div>
				</div>
				<div class="form-group">
					 <label for="year" class="col-sm-2 col-xs-2 control-label">出生年月</label>
					 <div class="col-sm-4 col-xs-7">
						<table class="col-sm-4 col-xs-7">
							 <tbody>
								 <tr>
									<th>
										<select name="year" class="form-control" id="year" style="width:105px;">
										<%for(int i=1950;i<2050;i++){ %>
											<option value="<%=i %>"><%=i %></option>
										<%} %>
										</select>
									</th>
									<th>
										<select name="month" class="form-control" id="month" style="width:80px;">
										<%for(int i=1;i<13;i++){ %>
											<option value="<%=i %>"><%=StringUtils.leftPad(i+"", 2, '0') %></option>
										<%} %>
										</select>
									</th>
								 </tr>
							 </tbody>
						</table>
					</div>						 
				</div>
				<div class="form-group">
					 <label for="email" class="col-sm-2 col-xs-2 control-label">专家电子邮箱</label>
					 <div class="col-sm-3 col-xs-3">
						<input type="email" class="form-control" id="email" name="specInfoBean.email" placeholder="输入电子邮箱地址">
					 </div>
				</div>
				
				
				<div class="form-group">
					<label for="contactName-1" class="col-sm-2 col-xs-2 control-label">联系人及联系方式</label>
					<div class="col-sm-8">
						<p class="help-block">
							最多添加10个联系人.
						</p>
						<table class="col-sm-8">
							 <tbody id="contact-table">
								 <tr>
									<th><input type="text" class="form-control" id="contactName-1" name="contactName-1" placeholder="联系人1"></th>
									<th><input type="text" class="form-control" id="contactMethod-1" name="contactMethod-1" placeholder="联系方式"></th>
									<th><button type="button" class="btn btn-default" id="contactButton" onclick="addContactTable()"><i class="glyphicon glyphicon-plus"></i></button></th>
								 </tr>
							 </tbody>
						</table>
					</div>
				</div>
				<div class="form-group">
					 <label for="exampleInputFile" class="col-sm-2 control-label">上传照片</label>
					 <div class="col-sm-6">
						<input type="file" id="exampleInputFile">
						<p class="help-block">
							Example block-level help text here.
						</p>
					 </div>
				</div>
				<!---------------------------------------------------------------------------------------------------->
				<hr>
				<span class="label label-default">工作信息</span><br><br>
				<div class="form-group">
					 <label for="organization" class="col-sm-2 col-xs-2 control-label">工作单位</label>
					 <div class="col-sm-3 col-xs-3">
						<input type="text" class="form-control" id="organization" name="specInfoBean.organization" placeholder="工作单位">
					 </div>
					 <label for="orgType" class="col-sm-2 col-xs-2 control-label">单位性质</label>
					 <div class="col-sm-2 col-xs-2">
						<select name="specInfoBean.orgTypeId" class="form-control" id="orgType">
							<s:iterator value="orgTypeMap">
								<option value="<s:property value="key"/>"><s:property value="value"/></option>
							</s:iterator>
						</select>
					 </div>
				</div>
				<div class="form-group">
					 <label for="website" class="col-sm-2 col-xs-2 control-label">单位网站</label>
					 <div class="col-sm-3 col-xs-3">
						<input type="text" class="form-control" id="website" name="specInfoBean.website" placeholder="工作单位网站">
					 </div>
					 <label for="role" class="col-sm-2 col-xs-2 control-label">担任职务</label>
					 <div class="col-sm-2 col-xs-2">
						<input type="text" class="form-control" id="role" name="specInfoBean.role" placeholder="职务">
					 </div>
				</div>
				<div class="form-group">
					 <label for="province-1" class="col-sm-2 col-xs-2 control-label">工作地点</label>
					 <div class="col-sm-8 col-xs-8">
					 	<p class="help-block">
							最多添加10个工作地点.
						</p>
					  	<table class="col-sm-6">
							 <tbody id="address-table">
								 <tr>
									<th>
										<label class="checkbox-inline" style="width:60px;">
											<input type="checkbox" id="orgPlace-1" value="1" onclick="refreshProvinceList(1);" checked /> 国内
										</label>
									</th>
									<th>
										<select class="form-control" id="province-1" onchange="refreshCityList(1);" style="width:100px;">
											<s:iterator value="provinceMap">
												<option value="<s:property value="key"/>"><s:property value="value"/></option>
											</s:iterator>
										</select>
									</th>
									<th>
										<select name="specInfoBean.workPositionId" class="form-control" id="city-1" style="width:100px;">
											<s:iterator value="cityMap">
												<option value="<s:property value="key"/>"><s:property value="value"/></option>
											</s:iterator>
										</select>
									</th>
									<th><button type="button" class="btn btn-default" id="addressButton" onclick="addAddressTable()"><i class="glyphicon glyphicon-plus"></i></button></th>
								 </tr>
							 </tbody>
						</table>
					 </div>
				</div>
				<div class="form-group">
					 <label for="partTimeJob" class="col-sm-2 col-xs-2 control-label">社会兼职</label>
					 <div class="col-sm-7 col-xs-7">
						<textarea class="form-control" rows="5" id="partTimeJob" name="specInfoBean.partTimeJob" placeholder="社会兼职"></textarea>
					 </div>
				</div>
				<!---------------------------------------------------------------------------------------------------->
				<hr>
				<span class="label label-default">学习、培训及工作经历</span><br><br>
				<div class="form-group">
					<div class="col-sm-13">
						<table>
							<tbody>
								<tr>
									<th>
										<div class="form-group">
											<label for="degree" class="col-sm-6 control-label">最高学位、学历</label>
											<div class="col-sm-6">
												<input type="text" class="form-control" id="degree" name="specInfoBean.degree" placeholder="学位、学历">
											</div>
										</div>
									</th>
									<th>
										<div class="form-group">
											 <label for="school" class="col-sm-6 control-label">毕业院校</label>
											 <div class="col-sm-6">
												<input type="text" class="form-control" id="school" name="specInfoBean.school" placeholder="毕业院校">
											 </div>
										</div>
									</th>
								</tr>
								<tr>
									<th>
										<div class="form-group">
											 <label for="language" class="col-sm-6 control-label">外语能力</label>
											 <div class="col-sm-6">
												<input type="text" class="form-control" id="language" name="specInfoBean.languane" placeholder="外语能力">
											 </div>
										</div>
									</th>
									<th>
										<div class="form-group">
											 <label for="workTime" class="col-sm-6 control-label">从业时间</label>
											 <div class="col-sm-6">
												<input type="text" class="form-control" id="workTime" name="specInfoBean.workTime" placeholder="从业时间：年">
											 </div>
										</div>
									</th>
								</tr>
								<tr>
									<th>
										<div class="form-group">
											 <label for="qualification" class="col-sm-6 control-label">执业资格</label>
											 <div class="col-sm-6">
												<select name="specInfoBean,qualificationId" class="form-control" id="qualification">
													<s:iterator value="qualificationMap">
														<option value="<s:property value="key"/>"><s:property value="value"/></option>
													</s:iterator>
												</select>
											 </div>
										</div>
									</th>
									<th>
										<div class="form-group">
											 <label for="title" class="col-sm-6 control-label">职称</label>
											 <div class="col-sm-6">
												<select name="specInfoBean.titleId" class="form-control" id="title">
													<s:iterator value="titleMap">
														<option value="<s:property value="key"/>"><s:property value="value"/></option>
													</s:iterator>
												</select>
											 </div>
										</div>
									</th>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<div class="form-group">
					<label for="majorClass" class="col-sm-2 control-label">专业方向</label>
					 <div class="col-sm-4">
						 <table class="col-sm-8">
							 <tbody id="contact-table">
								 <tr>
									<th>
										<select name="majorClass" class="form-control" id="majorClass" onchange="refreshMajorList();" >
											<s:iterator value="majorClassMap">
												<option value="<s:property value="key"/>"><s:property value="value"/></option>
											</s:iterator>
										</select>
									</th>
									<th>
										<select name="specInfoBean.majorId" class="form-control" id="major">
											<s:iterator value="majorMap">
												<option value="<s:property value="key"/>"><s:property value="value"/></option>
											</s:iterator>
										</select>
									</th>
								 </tr>
							 </tbody>
						</table>
					</div>
				</div>					 
				<div class="form-group">
					<label for="experience" class="col-sm-2 control-label">主要项目经历<br>科研经历<br>获奖情况</label>
					<div class="col-sm-6 col-xs-6">
						<textarea class="form-control" id="experience" name="specInfoBean.experience" rows="6" placeholder="主要项目经历,科研经历,获奖情况"></textarea>
					</div>
				</div>
				<span class="label label-default">其他</span><br>
				<div class="form-group">
					<label for="other" class="col-sm-2 control-label">备注</label>
					<div class="col-sm-6 col-xs-6">
						<textarea class="form-control" id="other" name="specInfoBean.other" rows="3" placeholder="备注信息"></textarea>
					</div>
				</div>
				<div class="form-group">
					<label for="experience" class="col-sm-2 control-label"></label>
					<div class="col-sm-2">
						<button type="submit" class="btn btn-default">提交</button>
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