<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <!-- include the static header -->
  <%@ include file="../page_static_header.html" %>
  <title>信息修改表-上海同济城市规划设计研究院</title>
</head>
<script type="text/javascript">
	function confirmSpecInfo(applyInfoId,staffId){
		var url = "/SpecialistInfoSys/staffDisposeApplyConfirm.action?applyInfoId=" + applyInfoId + "&staffId="+staffId;

		createXMLHttpRequest();
		xmlHttp.onreadystatechange = handleStateChangeSpecInfoConfirm;
		xmlHttp.open("GET", url, true);
		xmlHttp.send(null);
	}

	function handleStateChangeSpecInfoConfirm() {
		if (xmlHttp.readyState == 4) {
			if (xmlHttp.status == 200) {
				onGetConfirmResult();
			}
		}
	}
	
	function onGetConfirmResult(){
		alert(xmlHttp.responseText);
	}
</script>
<body>
<div class="container">
	<div class="row clearfix">
		<!-- page header -->
		<c:set var="pageHeader" value="1" scope="page"/>
		<%@ include file="header.jsp" %>
		<br><br><br>
		
		<div class="col-md-12 column">
		<button type="button" class="btn btn-primary" onClick="confirmSpecInfo(${applyInfoId},'${staffId }')">确认信息</button>
		<div class="form-group">
			<label for="other" class="col-sm-2 control-label">备注信息</label>
			<div class="col-sm-6 col-xs-6">
				<textarea class="form-control" id="other" name="specInfoBean.other" rows="3" placeholder="备注信息">${specInfoBean.other}</textarea>
			</div>
		</div>
		</div>
		<%@ include file="../include/specialist_info_update.jsp" %>
	</div>
	<h5 class="text-center text-muted">
		上海同济城市规划设计研究院
	</h5>
</div>
</body>
</html>
