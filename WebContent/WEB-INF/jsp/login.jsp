<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>用户登陆界面</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
	<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<style type="text/css">
	body{
	   background: url("${pageContext.request.contextPath}/images/a.jpg")repeat;
	}
	#login-box {
		/*border:1px solid #F00;*/
		padding: 35px;
		border-radius:15px;
		background: #56666B;
		color: #fff;
	}

	</style>
</head>
<body>
	<div class="row" style="margin-top:280px">
		<div class="col-md-5"></div>
		<div class="col-md-2" id="login-box">
			<h1>用户登录</h1>
			<form class="form-horizontal" action="${pageContext.request.contextPath}/login" method="post">
			<div class="form-group">
				<label class="col-sm-3 label-control">账号:</label>
				<div class="col-sm-9">
					<input class="form-control" type="text" name="username" id="username" placeholder="请输入账号名称">
				</div>				
			</div>
			<div class="form-group">
				<label class="col-sm-3 label-control">密码:</label>
				<div class="col-sm-9">
					<input class="form-control" type="password" name="password" placeholder="请输入密码">
				</div>
			</div>
			<div class="form-group pull-right" style="margin-right: 15px;">
				<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default btn-info">登陆</button>
				</div>
			</div>
			</form>
		</div>
		<div class="col-md-5"></div>
	</div>
</body>
</html>