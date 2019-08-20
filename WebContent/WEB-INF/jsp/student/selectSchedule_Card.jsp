<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>学生个人页面</title>
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
				<div class="panel panel-heading">
					<div class="row">
						<h1 class="col-md-5">课程表</h1>
						<form class="bs-example bs-example-form col-md-3 pull-right" style="margin:20px 0 10px 0;" action="${pageContext.request.contextPath }/student/Schedule_Card" method="post">
							<div class="input-group">
								<select name="crs_semester" style="height:27px;">
									<c:forEach items="${semesters }" var="item">
										<option value="${item.crs_semester }">${item.crs_semester }</option>
									</c:forEach>
								</select>
								<input  type="submit" value="查询">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
	<script type="text/javascript">
	$("#nav li:nth-child(3)").addClass("active");
	</script>
</html>