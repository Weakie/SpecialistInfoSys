<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>专家信息主页-上海同济城市规划设计研究院</title>
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
  <link rel="apple-touch-icon-precomposed" sizes="144x144" href="img/apple-touch-icon-144-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="114x114" href="img/apple-touch-icon-114-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="72x72" href="img/apple-touch-icon-72-precomposed.png">
  <link rel="apple-touch-icon-precomposed" href="/SpecialistInfoSys/jsp/img/apple-touch-icon-57-precomposed.png">
  <link rel="shortcut icon" href="/SpecialistInfoSys/jsp/img/favicon.png">
  
	<script type="text/javascript" src="/SpecialistInfoSys/jsp/js/jquery.min.js"></script>
	<script type="text/javascript" src="/SpecialistInfoSys/jsp/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/SpecialistInfoSys/jsp/js/scripts.js"></script>
</head>

<body>
<div class="container">
	<div class="row clearfix">
		<div class="page-header">
			<h3 class="text-left">
				<strong>专家信息主页</strong>
			</h3>
		</div>
		<div class="col-md-12 column">
			<div class="row clearfix">
				<div class="col-md-8 column">
					<h3>
						<kbd>${specInfoBean.name }</kbd>
					</h3>
					<span class="label label-default">基本资料</span><br><br>
					<p class="text-left">
						<i>男, 1970年06月</i>
					</p>
					<p class="text-left">
						<em>244161716@qq.com</em>
					</p>
					<p class="text-left">
						<em>联系人：</em>
					</p>
				</div>
				<div class="col-md-4 column">
					<img alt="140x140" src="http://lorempixel.com/140/140/" class="img-thumbnail">
				</div>
			</div>
			<hr>
			<div class="row clearfix">
				<div class="col-md-12 column">
					<span class="label label-default">工作信息</span><br><br>
					<p>
						<b>工作单位: </b> <a class="btn-left" href="http://www.tongji.edu.cn" target=_blank>同济大学 </a>
					</p>
					<p>
						<b>单位性质: </b> 大学
					</p>
					<p>
						<b>工作地点: </b> 上海市
					</p>
					<p>
						<b>社会兼职: </b><br>
					</p>
				</div>
			</div>
			<hr>
			<div class="row clearfix">
				<div class="col-md-12 column">
					<span class="label label-default">学习、培训及工作经历</span><br><br>
					<p>
						<b>毕业院校: </b> 同济大学 
					</p>
					<p>
						<b>最高学位、学历: </b> 大学
					</p>
					<p>
						<b>外语能力: </b> 上海市
					</p>
					<p>
						<b>从业时间: </b>
					</p>
					<p>
						<b>职业资格: </b><br>
					</p>
					<p>
						<b>职称: </b><br>
					</p>
					<p>
						<b>专业方向: </b><br>
					</p>
					<p>
						<b>主要项目经历、科研经历、获奖情况: </b><br>
					</p>
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
