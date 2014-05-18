<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	
	//EL Expression
	var contactTableIndex = ${contactNum};
	function addContactTable() {
		contactTableIndex++;
		
		//EL Expression
		if(contactTableIndex > ${contactNum+10} ){
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
		input1.setAttribute("id","contactName-"+contactTableIndex);
		input1.setAttribute("name","contactName-"+contactTableIndex);
		input1.setAttribute("placeholder","联系人"+contactTableIndex);
		th1.appendChild(input1);
		
		var th2 = document.createElement("th");
		var input2 = document.createElement("input");
		input2.setAttribute("type", "text");
		input2.setAttribute("class", "form-control");
		input2.setAttribute("id","contactMethod-"+contactTableIndex);
		input2.setAttribute("name","contactMethod-"+contactTableIndex);
		input2.setAttribute("placeholder","联系方式"+contactTableIndex);
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
	
	var addressTableIndex = ${workPosNum};
	function addAddressTable() {
		addressTableIndex++;
		
		if(addressTableIndex > ${workPosNum+10} ){
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
		select2.setAttribute("class", "form-control");
		select2.setAttribute("id", "province-"+addressTableIndex);
		select2.setAttribute("onchange","refreshCityList("+addressTableIndex+");");
		select2.setAttribute("style", "width:100px;");
		th2.appendChild(select2);
		
		var th3 = document.createElement("th");
		var select3 = document.createElement("select");
		select3.setAttribute("name", "specInfoBean.workPositionId");
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
<script type="text/javascript">
	function createXMLHttpRequestInstance() {
		var xmlHttp;
		if (window.ActiveXObject) {
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		} else if (window.XMLHttpRequest) {
			xmlHttp = new XMLHttpRequest();
		}
		return xmlHttp;
	}
	
	function fileSelected() {
	    var file = document.getElementById('fileToUpload').files[0];
	    if (file) {
	        var fileSize = 0;
	        if (file.size > 1024 * 1024)
	            fileSize = (Math.round(file.size * 100 / (1024 * 1024)) / 100).toString() + 'MB';
	        else
	            fileSize = (Math.round(file.size * 100 / 1024) / 100).toString() + 'KB';
	
	        //document.getElementById('fileName').innerHTML = 'Name: ' + file.name;
	        document.getElementById('fileSize').innerHTML = "图片大小:" + fileSize;
	        //document.getElementById('fileType').innerHTML = 'Type: ' + file.type;
	        document.getElementById('fileToUploadButton').setAttribute('type', 'button');
	    }
	}
	
	function uploadFile(username) {
	    var fd = new FormData();
	    fd.append("file", document.getElementById('fileToUpload').files[0]);
	    var xhr = createXMLHttpRequestInstance();
	    xhr.upload.addEventListener("progress", uploadProgress, false);
	    xhr.addEventListener("load", uploadComplete, false);
	    xhr.addEventListener("error", uploadFailed, false);
	    xhr.addEventListener("abort", uploadCanceled, false);
	    xhr.open("POST", "/SpecialistInfoSys/uploadImage.action?userName="+username);
	    xhr.send(fd);
	}
	
	function uploadProgress(evt) {
	    if (evt.lengthComputable) {
	        var percentComplete = Math.round(evt.loaded * 100 / evt.total);
	        document.getElementById('progressNumber').innerHTML = "上传进度:" + percentComplete.toString() + '%';
	    }
	    else {
	        document.getElementById('progressNumber').innerHTML = 'unable to compute';
	    }
	}
	
	function uploadComplete(evt) {
	    /* This event is raised when the server send back a response */
	    alert(evt.target.responseText);
	    var result = evt.target.responseText.split(":");
	    if(result[0]=="user"){
	    	var image = document.getElementById("image");
	 	    image.src="/SpecialistInfoSys/downloadImage.action?userName="+result[1];
	    }
	}
	
	function uploadFailed(evt) {
	    alert("There was an error attempting to upload the file.");
	}
	
	function uploadCanceled(evt) {
	    alert("The upload has been canceled by the user or the browser dropped the connection.");
	}
</script>
<script type="text/javascript">
	function checkform(){
		//do not upload image in form!!
		document.getElementById('fileToUpload').setAttribute('type', 'button');
	}
</script>
		
		<div class="col-md-10 column">
			<form action="${formAction }" method="post" onsubmit="return checkform();" class="form-horizontal">
				<span class="label label-default">基本资料</span><br><br>
				<input type="hidden" id="userName" name="specInfoBean.userName" value="${userName }" />
				<!-- for staff update -->
				<c:if test="${!empty info.userName }">
					<input type="hidden" name="userName" value="${info.userName }" />
				</c:if>
				<c:if test="${empty info.userName }">
					<input type="hidden" name="userName" value="${userName }" />
				</c:if>
				<input type="hidden" name="applyInfoId" value="${info.id }" />
				<input type="hidden" name="staffId" value="${info.staffID }" />
				<!-- for staff update -->
				<div class="form-group">
					 <label for="name" class="col-sm-2 col-xs-2 control-label">姓名</label>
					 <div class="col-sm-2 col-xs-2">
						<input type="text" class="form-control" id="name" name="specInfoBean.name" value="${specInfoBean.name }" placeholder="姓名">
					 </div>
				</div>
				<div class="form-group">
					 <label for="sex" class="col-sm-2 col-xs-2 control-label">性别</label>
					 <div class="col-sm-2 col-xs-3">
						<select name="specInfoBean.sex" class="form-control" id="sex">
							<option value="false" <c:if test="${specInfoBean.sex==false}">selected</c:if>>男</option>
							<option value="true"  <c:if test="${specInfoBean.sex==true}">selected</c:if>>女</option>
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
										<c:forEach var="i" begin="1950" end="2050" step="1">
											<option value="${i}" <c:if test="${specInfoBean.year==i}">selected</c:if> >${i}</option>
										</c:forEach>
										</select>
									</th>
									<th>
										<select name="month" class="form-control" id="month" style="width:80px;">
										<c:forEach var="i" begin="1" end="12" step="1">
											<option value="${i}" <c:if test="${specInfoBean.month==i}">selected</c:if> ><c:if test="${i<10}">0</c:if>${i}</option>
										</c:forEach>
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
						<input type="email" class="form-control" id="email" name="specInfoBean.email" value="${specInfoBean.email }" placeholder="输入电子邮箱地址">
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
								<c:if test="${empty specInfoBean.contactMap}">
									<tr>
										<th><input type="text" class="form-control" id="contactName-1" name="contactName-1"  placeholder="联系人1"></th>
										<th><input type="text" class="form-control" id="contactMethod-1" name="contactMethod-1"  placeholder="联系方式"></th>
										<th><button type="button" class="btn btn-default" id="contactButton" onclick="addContactTable()"><i class="glyphicon glyphicon-plus"></i></button></th>
									</tr>
								</c:if>
							  	<c:if test="${!empty specInfoBean.contactMap}">
							 	<c:set var="i" value="1" scope="page"/>
								<s:iterator value="specInfoBean.contactMap">
									<c:if test="${i==1}">
										<tr>
											<th><input type="text" class="form-control" id="contactName-1" name="contactName-1" value="<s:property value="key"/>" placeholder="联系人1"></th>
											<th><input type="text" class="form-control" id="contactMethod-1" name="contactMethod-1" value="<s:property value="value"/>" placeholder="联系方式"></th>
											<th><button type="button" class="btn btn-default" id="contactButton" onclick="addContactTable()"><i class="glyphicon glyphicon-plus"></i></button></th>
										</tr>
									</c:if>
									<c:if test="${i!=1}">
										<tr id="tableContact:${i}">
											<th><input type="text" class="form-control" id="contactName-${i}" name="contactName-${i}" value="<s:property value="key"/>" placeholder="联系人${i}"></th>
											<th><input type="text" class="form-control" id="contactMethod-${i}" name="contactMethod-${i}" value="<s:property value="value"/>" placeholder="联系方式"></th>
											<th><button type="button" class="btn btn-default" id="contactButton" onclick="removeContactTable(${i})"><i class="glyphicon glyphicon-minus"></i></button></th>
										</tr>
									</c:if>
									<c:set var="i" value="${i+1}" />
								</s:iterator>
								</c:if>
							 </tbody>
						</table>
					</div>
				</div>
				<div class="form-group">
					 <label for="fileToUpload" class="col-sm-2 control-label">上传照片</label>
					 <div class="col-sm-6">
						<input type="file" name="file" id="fileToUpload" onchange="fileSelected();" />
						<p class="help-block">
							上传图片为jpeg格式,大小不能超过2MB.
						</p>
						<div id="fileSize"></div>
				        <input type="hidden" onclick="uploadFile('<s:property value="userName"/>')"  id="fileToUploadButton" value="上传文件" />
				       	<div id="progressNumber"></div>
				        <img id="image" class="img-thumbnail" alt="暂无照片" width="160" height="160" src="/SpecialistInfoSys/downloadImage.action?userName=${specInfoBean.userName}">
					 </div>
					 
				</div>
				<!---------------------------------------------------------------------------------------------------->
				<hr>
				<span class="label label-default">工作信息</span><br><br>
				<div class="form-group">
					 <label for="organization" class="col-sm-2 col-xs-2 control-label">工作单位</label>
					 <div class="col-sm-3 col-xs-3">
						<input type="text" class="form-control" id="organization" name="specInfoBean.organization" value="${specInfoBean.organization}" placeholder="工作单位">
					 </div>
					 <label for="orgType" class="col-sm-2 col-xs-2 control-label">单位性质</label>
					 <div class="col-sm-2 col-xs-2">
						<select name="specInfoBean.orgTypeId" class="form-control" id="orgType">
							<s:iterator value="orgTypeMap">
								<option value="<s:property value="key"/>" <c:if test="${specInfoBean.orgTypeId==key}">selected</c:if> ><s:property value="value"/></option>
							</s:iterator>
						</select>
					 </div>
				</div>
				<div class="form-group">
					 <label for="website" class="col-sm-2 col-xs-2 control-label">单位网站</label>
					 <div class="col-sm-3 col-xs-3">
						<input type="text" class="form-control" id="website" name="specInfoBean.website" value="${specInfoBean.website}" placeholder="工作单位网站">
					 </div>
					 <label for="role" class="col-sm-2 col-xs-2 control-label">担任职务</label>
					 <div class="col-sm-2 col-xs-2">
						<input type="text" class="form-control" id="role" name="specInfoBean.role" value="${specInfoBean.role}" placeholder="职务">
					 </div>
				</div>
				<div class="form-group">
					 <label for="province-1" class="col-sm-2 col-xs-2 control-label">工作地点</label>
					 <div class="col-sm-8 col-xs-8">
					 	<p class="help-block">
							最多添加10个工作地点.若以下列表中没有,请最后提交申请的时候在备注栏中填写,我们的工作人员会为你添加.
						</p>
					  	<table class="col-sm-6">
							 <tbody id="address-table">
							 <c:if test="${empty specInfoBean.workPositionId}">
							 	<tr>
									<th>
										<label class="checkbox-inline" style="width:60px;">
											<input type="checkbox" id="orgPlace-1" onclick="refreshProvinceList(1);" checked/> 国内
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
							 </c:if>
							 <c:if test="${!empty specInfoBean.workPositionId}">
							 <c:set var="workPosIndex" value="1" scope="page"/>
							 <s:iterator value="specInfoBean.workPositionId" var="posId">
								 <c:if test="${workPosIndex==1}">
								 <tr id="tableAddress:${workPosIndex}">
									<th>
										<label class="checkbox-inline" style="width:60px;">
											<input type="checkbox" id="orgPlace-${workPosIndex}" onclick="refreshProvinceList(${workPosIndex});" <c:if test="${proAbroMap[cityProMap[posId]]}">checked</c:if> /> 国内
										</label>
									</th>
									<th>
										<select class="form-control" id="province-${workPosIndex}" onchange="refreshCityList(${workPosIndex});" style="width:100px;">
											<s:iterator value="provinceMap">
												<option value="<s:property value="key"/>" <c:if test="${cityProMap[posId]==key}">selected</c:if> ><s:property value="value"/></option>
											</s:iterator>
										</select>
									</th>
									<th>
										<select name="specInfoBean.workPositionId" class="form-control" id="city-${workPosIndex}" style="width:100px;">
											<s:iterator value="cityMap">
												<option value="<s:property value="key"/>" <c:if test="${posId==key}">selected</c:if> ><s:property value="value"/></option>
											</s:iterator>
										</select>
									</th>
									<th><button type="button" class="btn btn-default" id="addressButton" onclick="addAddressTable()"><i class="glyphicon glyphicon-plus"></i></button></th>
								 </tr>
								 </c:if>
								 <c:if test="${workPosIndex!=1}">
								 <tr id="tableAddress:${workPosIndex}">
								 	<th>
										<label class="checkbox-inline" style="width:60px;">
											<input type="checkbox" id="orgPlace-${workPosIndex}" <c:if test="${proAbroMap[cityProMap[posId]]}">checked</c:if> disabled/> 国内
										</label>
									</th>
									<th>
										<select class="form-control" id="province-${workPosIndex}" style="width:100px;" disabled>
											<option value="${cityProMap[posId]}" >${provNameMap[cityProMap[posId]]}</option>
										</select>
									</th>
									<th>
										<select class="form-control" id="city-${workPosIndex}" name="specInfoBean.workPositionId" style="width:100px;" disabled>
											<option value="${posId}" >${cityNameMap[posId]}</option>
										</select>
										<input type="hidden" name="specInfoBean.workPositionId" value="${posId}"/>
									</th>
									<th><button type="button" class="btn btn-default" id="addressButton" onclick="removeAddressTable(${workPosIndex})"><i class="glyphicon glyphicon-minus"></i></button></th>
								 </tr>
								 </c:if>
								 <c:set var="workPosIndex" value="${workPosIndex+1}" scope="page"/>
							 </s:iterator>
							 </c:if>
							 </tbody>
						</table>
					 </div>
				</div>
				<div class="form-group">
					 <label for="partTimeJob" class="col-sm-2 col-xs-2 control-label">社会兼职</label>
					 <div class="col-sm-7 col-xs-7">
						<textarea class="form-control" rows="5" id="partTimeJob" name="specInfoBean.partTimeJob" placeholder="社会兼职">${specInfoBean.partTimeJob}</textarea>
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
												<input type="text" class="form-control" id="degree" name="specInfoBean.degree" value="${specInfoBean.degree}" placeholder="学位、学历">
											</div>
										</div>
									</th>
									<th>
										<div class="form-group">
											 <label for="school" class="col-sm-6 control-label">毕业院校</label>
											 <div class="col-sm-6">
												<input type="text" class="form-control" id="school" name="specInfoBean.school" value="${specInfoBean.school}" placeholder="毕业院校">
											 </div>
										</div>
									</th>
								</tr>
								<tr>
									<th>
										<div class="form-group">
											 <label for="language" class="col-sm-6 control-label">外语能力</label>
											 <div class="col-sm-6">
												<input type="text" class="form-control" id="language" name="specInfoBean.language" value="${specInfoBean.language}" placeholder="外语能力">
											 </div>
										</div>
									</th>
									<th>
										<div class="form-group">
											 <label for="workTime" class="col-sm-6 control-label">从业时间</label>
											 <div class="col-sm-6">
												<input type="text" class="form-control" id="workTime" name="specInfoBean.workTime" value="${specInfoBean.workTime}" placeholder="从业时间：年">
											 </div>
										</div>
									</th>
								</tr>
								<tr>
									<th>
										<div class="form-group">
											 <label for="qualification" class="col-sm-6 control-label">执业资格</label>
											 <div class="col-sm-6">
												<select name="specInfoBean.qualificationId" class="form-control" id="qualification">
													<s:iterator value="qualificationMap">
														<option value="<s:property value="key"/>" <c:if test="${specInfoBean.qualificationId==key}">selected</c:if> ><s:property value="value"/></option>
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
														<option value="<s:property value="key"/>" <c:if test="${specInfoBean.titleId==key}">selected</c:if> ><s:property value="value"/></option>
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
										<select class="form-control" id="majorClass" onchange="refreshMajorList();" >
											<s:iterator value="majorClassMap">
												<option value="<s:property value="key"/>" <c:if test="${majorClassId==key}">selected</c:if> ><s:property value="value"/></option>
											</s:iterator>
										</select>
									</th>
									<th>
										<select name="specInfoBean.majorId" class="form-control" id="major">
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
					<label for="experience" class="col-sm-2 control-label">主要项目经历<br>科研经历<br>获奖情况</label>
					<div class="col-sm-6 col-xs-6">
						<textarea class="form-control" id="experience" name="specInfoBean.experience" rows="6" placeholder="主要项目经历,科研经历,获奖情况">${specInfoBean.experience}</textarea>
					</div>
				</div>
				<span class="label label-default">其他</span><br>
				<div class="form-group">
					<label for="other" class="col-sm-2 control-label">备注</label>
					<div class="col-sm-6 col-xs-6">
						<textarea class="form-control" id="other" name="specInfoBean.other" rows="3" placeholder="备注信息">${specInfoBean.other}</textarea>
					</div>
				</div>
				<div class="form-group">
					<label for="experience" class="col-sm-2 control-label"></label>
					<div class="col-sm-2">
						<button type="submit" class="btn btn-default">保存信息</button>
					</div>
				</div>
			</form>
		</div>