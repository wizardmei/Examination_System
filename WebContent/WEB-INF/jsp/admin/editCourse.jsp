<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>修改学生信息</title>
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
						<h1 style="text-align:center;">修改课程信息</h1>
					</div>
				</div>
				<div class="panel-body">
					<div class="col-sm-4"></div>
					<div class="col-sm-6">
						<form name="edit" class="form-horizontal" action="${pageContext.request.contextPath }/admin/editCourse" method="post" onsubmit="return check()">
							<div class="form-group">
								<label class="col-sm-2 control-label">课程代码</label>
								<div class="col-sm-4">
									<input type="text" name="crs_code" class="form-control" value="${target.crs_code }">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">课程名</label>
								<div class="col-sm-4">
									<input type="text" name="crs_name" class="form-control" value="${target.crs_name }">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">课程属性</label>
								<div class="col-sm-4">
									<select name="crs_attribute" style="width:200px;height:35px">
										<option value="必修" <c:if test="${target.crs_attribute=='必修' }">selected</c:if>>必修</option>
										<option value="选修"<c:if test="${target.crs_attribute=='选修' }">selected</c:if>>选修</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">课程学分</label>
								<div class="col-sm-4">
									<input type="text" name="crs_credit" class="form-control" value="${target.crs_credit }">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">课程时间</label>
								<div class="col-sm-4">
									<input type="text" name="crs_time" class="form-control" value="${target.crs_time }">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">课程周次</label>
								<div class="col-sm-4">
									<input type="text" name="crs_frequency" class="form-control" value="${target.crs_frequency }">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">课程班级</label>
								<div class="col-sm-4">
									<input type="text" name="crs_class" class="form-control" value="${target.crs_class }">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">课程老师</label>
								<div class="col-sm-4">
									<input type="text" name="crs_teacher" class="form-control" value="${target.crs_teacher }">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">课程地点</label>
								<div class="col-sm-4">
									<input type="text" name="crs_address" class="form-control" value="${target.crs_address }">
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
	$("#nav li:nth-child(2)").addClass("active");
	$(document).ready(function(){
		$('input').iCheck({
			checkboxClass:'icheckbox_square-green',
			radioClass:'iradio_square-green',
			increaseArea:"20%"
		});
	});
	</script>
</html>