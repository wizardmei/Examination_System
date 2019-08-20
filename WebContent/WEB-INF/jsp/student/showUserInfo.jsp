<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>管路员个人页面</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
	<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="top.jsp"></jsp:include>
	<div class="row">
		<jsp:include page="menu.jsp"></jsp:include>
		<div class="col-md-9">
			<div class="panel panel-default">
				<div class="panel-heading">
						<div class="row">
							<h1 class="col-md-5">个人信息</h1>
						</div>
				</div>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>学号</th>
							<th>姓名</th>
							<th>性别</th>
							<th>出生年份</th>
							<th>入学年份</th>
							<th>学院</th>
							<th>班级</th>
							<th>账号</th>
							<th>密码</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${own.userid }</td>
							<td>${own.username }</td>
							<td>${own.sex }</td>
							<td>${own.birthyear }</td>
							<td>${own.gradeyear }</td>
							<td>${own.college }</td>
							<td>${own.stu_class }</td>
							<td>${own.account }</td>
							<td>${own.passwd }</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="col-md-1"></div>
	</div>
</body>
	<script type="text/javascript">
		$("#nav li:nth-child(1)").addClass("active");
		$("#sub").click(function () {
            $("#form1").submit();
        });
	</script>
</html>