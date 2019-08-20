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
							<h1 class="col-md-5">学生信息管理</h1>
							<form id="form1" class="bs-example bs-example-form col-md-3 pull-right" style="margin:20px 0 10px 0;" action="${pageContext.request.contextPath }/admin/selectStudent" method="post">
								<div class="input-group">
									<input type="text" class="form-control" placeholder="请输入姓名" name="findByName">
									<span class="input-group-addon btn" id="sub">搜索</span>
								</div>
							</form>
							<button class="btn btn-default col-md-2 pull-right" style="margin-top:20px;" onClick="location.href='${pageContext.request.contextPath}/admin/addStudent'">
								添加学生信息
								<span class="glyphicon glyphicon-plus"></span>
							</button>
							<button class="btn btn-default col-md-2 pull-right" style="margin-top:20px;" onClick="location.href='${pageContext.request.contextPath}/downloadStudent'">
								导出学生信息
								<span class="glyphicon glyphicon-file"></span>
							</button>
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
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${stu_list}" var="item">
							<tr>
								<td>${item.userid }</td>
								<td>${item.username }</td>
								<td>${item.sex }</td>
								<td>${item.birthyear}</td>
								<td>${item.gradeyear}</td>
								<td>${item.college }</td>
								<td>${item.stu_class }</td>
								<td>${item.account }</td>
								<td>${item.passwd }</td>
								<td>
									<button class="btn btn-default btn-xs btn-info" onClick="location.href='${pageContext.request.contextPath}/admin/editStudent?id=${item.userid}'">修改</button>
									<button class="btn btn-default btn-xs btn-danger btn-primary" onClick="location.href='${pageContext.request.contextPath}/admin/removeStudent?id=${item.userid}'">删除</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="panel-footer">
					<nav style="text-align:center">
						<ul class="pagination">
							<c:if test="${page != 1}"><li><a href="${pageContext.request.contextPath}/admin/showStudent?page=${page-1}">&laquo;上一页</a></li></c:if>
							<c:forEach var="i" begin="1" end="${pagenum }">
								<li><a href="${pageContext.request.contextPath }/admin/showStudent?page=${i}">${i }</a></li>
							</c:forEach>
							<c:if test="${page != pagenum}"><li ><a href="${pageContext.request.contextPath}/admin/showStudent?page=${page+1}">下一页&raquo;</a></li></c:if>
						</ul>
					</nav>
				</div>
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