<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
    
<!DOCTYPE html>
<html>
<head>
	<link rel="icon" href="images/graduate.jpg" type="image/x-icon" />
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
					<tbody>
						<div>
							<label>学号</label>
							<div >
								${own.userid }
							</div>
						</div>
						<div>
							<label>姓名</label>
							<div >
								${own.username }
							</div>
						</div>
						<div>
							<label >性别</label>
							<div >
								${own.sex }
							</div>
						</div>
						<div>
							<label >出生年份</label>
							<div >
								${own.birthyear }
							</div>
						</div>
						<div>
							<label>入学年份</label>
							<div >
								${own.gradeyear }
							</div>
						</div>
						<div>
							<label>学院</label>
							<div>
								${own.college }
							</div>
						</div>
						<div>
							<label>班级</label>
							<div>
								${own.stu_class }
							</div>
						</div>
						<div>
							<label>账号</label>
							<div>
								${own.account }
							</div>
						</div>
						<div>
							<label>密码</label>
							<div>
								${own.passwd }
							</div>
						</div>
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