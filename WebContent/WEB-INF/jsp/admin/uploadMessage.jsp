<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
    
<!DOCTYPE html>
<html>
<head>
	<link rel="icon" href="images/favicon.ico" type="image/x-icon" />
	<meta charset="UTF-8">
	<title>管路员个人页面</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
	<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<style type="text/css">

	</style>
</head>
<body>
<jsp:include page="top.jsp"></jsp:include>
	<div class="row">
		<jsp:include page="menu.jsp"></jsp:include>
		<div class="col-md-9">
			<div class="panel panel-default">
			<button class="btn btn-default col-md-2 pull-right" style="margin-top:20px;" onClick="location.href='${pageContext.request.contextPath}/admin/modelStudent'">
				导入学生学生模板
				<span class=" glyphicon glyphicon-arrow-down"></span>
			</button>
			<button class="btn btn-default col-md-2 pull-right" style="margin-top:20px;" onClick="location.href='${pageContext.request.contextPath}/admin/modelStudent'">
				导入课程信息模板
				<span class=" glyphicon glyphicon-arrow-down"></span>
			</button>
			<br><br><br><br><br><br><br><br>
				<form method="post" action="/Examination_System_2019801/UpLoadMessage" enctype="multipart/form-data" style="margin-left:500px">
					<h3><input type="file" name="uploadFile" /></h3>
					<br>
					<br>
					<h3><input type="submit" value="导入"  style="margin-left:100px"/></h3>
				</form>
			<br><br><br><br><br><br><br><br>
			</div>
		</div>
		<div class="col-md-1"></div>
	</div>
</body>
	<script type="text/javascript">
		$("#nav li:nth-child(5)").addClass("active");
		$("#sub").click(function () {
            $("#form1").submit();
        });
	</script>
</html>