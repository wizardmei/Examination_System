<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
	<link rel="icon" href="images/favicon.ico" type="image/x-icon" />
	<meta charset="UTF-8">
	<title>添加学生信息</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
	<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<link href="${pageContext.request.contextPath}/skins/square/green.css" rel="stylesheet">
	<script src="${pageContext.request.contextPath}/js/icheck.js"></script>
	<style type="text/css">

	</style>
</head>
<body>
	<jsp:include page="top.jsp"></jsp:include>
	<div class="row">
		<jsp:include page="menu.jsp"></jsp:include>
		<div class="col-md-9">
			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="row">
						<h1 style="text-align:center;">修改密码</h1>
					</div>
				</div>
				<div class="panel-body">
					<div class="col-sm-4"></div>
					<div class="col-sm-6">
						<form name="reset" class="form-horizontal" action="${pageContext.request.contextPath }/admin/resetPasswd" method="post" onsubmit="return check()">
							<div class="form-group">
								<label class="col-sm-2 control-label">旧密码</label>
								<div class="col-sm-4">
									<input type="password" name="oldpassword" id="oldpassword" class="form-control" >
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">新密码</label>
								<div class="col-sm-4">
									<input type="password" name="newpassword" id="newpassword" class="form-control" >
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">确认密码</label>
								<div class="col-sm-4">
									<input type="password" name="verification" id="verification" class="form-control" >
								</div>
							</div>
							<div class="col-sm-3"></div>
							<div class="form-group">
								<button class="btn btn-default" type="submit">提交</button>
								<button class="btn btn-default" type="reset">重置</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-1"></div>
	</div>
</body>
	<script type="text/javascript">
	$("#nav li:nth-child(7)").addClass("active");
	$(document).ready(function(){
		$('input').iCheck({
			checkboxClass:'icheckbox_square-green',
			radioClass:'iradio_square-green',
			increaseArea:"20%"
		});
	});
	function check(){
		if(reset.oldpassword.value == '' || reset.oldpassword.value == null){
			alert("请输入用户原密码");
			return false;
		}
		if(reset.oldpassword.value != ${oldpassword}){
			alert("与用户原密码不符");
			return false;
		}
		if(reset.newpassword.value != reset.verification.value){
			alert("两次密码不一致");
			return false;
		}
	}
	</script>
</html>