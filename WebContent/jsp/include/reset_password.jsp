<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

			<div class="row clearfix">
				<div class="col-md-4 column">
					<br><br>
					<form action="${formAction }" method="post" class="form-horizontal" >
						<s:property value="messageStore.message" />
						<input type="hidden" name="userName" value="${sessionScope.USER.userName }"/>
						<div class="form-group">
							<label for="inputPassword" class="col-sm-3 control-label">原始密码</label>
							<div class="col-sm-8">
								<input type="password" class="form-control" id="inputPassword" name="password">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword" class="col-sm-3 control-label">新密码</label>
							<div class="col-sm-8">
								<input type="password" class="form-control" id="inputPassword" name="newPassword">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								 <button type="submit" class="btn btn-default">提交</button>
							</div>
						</div>
					</form>
				</div>
				
			</div>
		