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
						<h1 style="text-align:center;">修改学生信息</h1>
					</div>
				</div>
				<div class="panel-body">
					<div class="col-sm-4"></div>
					<div class="col-sm-6">
						<form name="edit" class="form-horizontal" action="${pageContext.request.contextPath }/admin/editStudent" method="post" onsubmit="return check()">
							<div class="form-group">
								<label class="col-sm-2 control-label">学号</label>
								<div class="col-sm-4">
									<input type="text" name="userid" class="form-control" value="${target.userid }">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">姓名</label>
								<div class="col-sm-4">
									<input type="text" name="username" class="form-control" value="${target.username }">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">性别</label>
								<div class="col-sm-4">
									<div class="col-sm-4">
										<input type="radio" name="sex" value="男" <c:if test="${target.sex=='男' }">checked="checked"</c:if>>男
									</div>
									<div class="col-sm-2"></div>
									<div class="col-sm-4">
										<input type="radio" name="sex" value="女" <c:if test="${target.sex=='女' }">checked="checked"</c:if>>女
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">出生年份</label>
								<div class="col-sm-4">
									<select name="birthyear" style="width:200px;height:35px">
										<option value="1995"<c:if test="${target.birthyear=='1995' }">selected</c:if>>1995</option>
										<option value="1996"<c:if test="${target.birthyear=='1996' }">selected</c:if>>1996</option>
										<option value="1997"<c:if test="${target.birthyear=='1997' }">selected</c:if>>1997</option>
										<option value="1998"<c:if test="${target.birthyear=='1998' }">selected</c:if>>1998</option>
										<option value="1999"<c:if test="${target.birthyear=='1999' }">selected</c:if>>1999</option>
										<option value="2000"<c:if test="${target.birthyear=='2000' }">selected</c:if>>2000</option>
										<option value="2001"<c:if test="${target.birthyear=='2001' }">selected</c:if>>2001</option>
										<option value="2002"<c:if test="${target.birthyear=='2002' }">selected</c:if>>2002</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">入学年份</label>
								<div class="col-sm-4">
									<select name="gradeyear" style="width:200px;height:35px">
										<option value="2013"<c:if test="${target.gradeyear=='2013' }">selected</c:if>><h3>2013</h3></option>
										<option value="2014"<c:if test="${target.gradeyear=='2014' }">selected</c:if>><h3>2014</h3></option>
										<option value="2015"<c:if test="${target.gradeyear=='2015' }">selected</c:if>><h3>2015</h3></option>
										<option value="2016"<c:if test="${target.gradeyear=='2016' }">selected</c:if>><h3>2016</h3></option>
										<option value="2017"<c:if test="${target.gradeyear=='2017' }">selected</c:if>><h3>2017</h3></option>
										<option value="2018"<c:if test="${target.gradeyear=='2018' }">selected</c:if>><h3>2018</h3></option>
										<option value="2019"<c:if test="${target.gradeyear=='2019' }">selected</c:if>><h3>2019</h3></option>
										<option value="2020"<c:if test="${target.gradeyear=='2020' }">selected</c:if>><h3>2020</h3></option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">院校</label>
								<div class="col-sm-4">
									<input type="text" name="college" class="form-control" value="${target.college }">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">班级</label>
								<div class="col-sm-4">
									<input type="text" name="stu_class" class="form-control" value="${target.stu_class }">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">账号</label>
								<div class="col-sm-4">
									<input type="text" name="account" class="form-control" value="${target.account }">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">密码</label>
								<div class="col-sm-4">
									<input type="password" name="passwd" class="form-control" value="${target.passwd }">
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
	$("#nav li:nth-child(1)").addClass("active");
	$(document).ready(function(){
		$('input').iCheck({
			checkboxClass:'icheckbox_square-green',
			radioClass:'iradio_square-green',
			increaseArea:"20%"
		});
	});
	</script>
</html>