<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<div class="col-md-10 column">
			<div class="row clearfix">
				<div class="col-md-6 column">
					<h3>
						<kbd>${specInfoBean.name }</kbd>
					</h3>
					<span class="label label-default">基本资料</span><br><br>
					<p class="text-left">
						<i>性别： <c:if test="${!specInfoBean.sex}">男</c:if><c:if test="${specInfoBean.sex}">女</c:if></i>
					</p>
					<p class="text-left">
						<i>邮箱：</i><em>${specInfoBean.email }</em>
					</p>
					<p>
						<i>出生日期：${specInfoBean.year}年${specInfoBean.month}月</i>
					</p>
					<p class="text-left">
						<i>联系人：</i>
					</p>
					<table class="table">
						<s:iterator value="specInfoBean.contactMap">
							<tr><td></td><td><i><s:property value="key"/></i></td><td><i><s:property value="value"/></i></td><tr>
						</s:iterator>
					</table>
				</div>
				<div class="col-md-4 column">
					<br><br><br><br>
					<img id="image" class="img-thumbnail" alt="暂无照片" width="140" height="140" src="/SpecialistInfoSys/downloadImage.action?userName=${specInfoBean.userName}">
				</div>
			</div>
			<hr>
			<div class="row clearfix">
				<div class="col-md-12 column">
					<span class="label label-default">工作信息</span><br><br>
					<p>
						<b>工作单位: </b> <a class="btn-left" href="${specInfoBean.website}" target=_blank>${specInfoBean.organization} </a>
					</p>
					<p>
						<b>单位网址: </b> <a class="btn-left" href="${specInfoBean.website}" target=_blank>${specInfoBean.website} </a>
					</p>
					<p>
						<b>单位性质: </b> ${specInfoBean.orgType}
					</p>
					<p>
						<b>工作地点: </b> ${specInfoBean.workPosition}
					</p>
					<p>
						<b>社会兼职: </b><br>${specInfoBean.partTimeJob}
					</p>
				</div>
			</div>
			<hr>
			<div class="row clearfix">
				<div class="col-md-12 column">
					<span class="label label-default">学习、培训及工作经历</span><br><br>
					<p>
						<b>最高学位、学历: </b> ${specInfoBean.degree}
					</p>
					<p>
						<b>毕业院校: </b> ${specInfoBean.school}
					</p>
					<p>
						<b>外语能力: </b> ${specInfoBean.language}
					</p>
					<p>
						<b>从业时间: </b> ${specInfoBean.workTime}年
					</p>
					<p>
						<b>职业资格: </b>${specInfoBean.qualification}
					</p>
					<p>
						<b>专业方向: </b>${specInfoBean.major}
					</p>
					<p>
						<b>职称: </b>${specInfoBean.title}
					</p>
					<p>
						<b>主要项目经历、科研经历、获奖情况: </b><br>${specInfoBean.experience}
					</p>
				</div>
			</div>
		</div>
	