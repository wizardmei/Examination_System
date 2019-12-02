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
						<h1 style="text-align:center;">添加课程信息</h1>
					</div>
				</div>
				<div class="panel-body">
					<div class="col-sm-4"></div>
					<div class="col-sm-6">
						<form name="add" class="form-horizontal" action="${pageContext.request.contextPath }/admin/addCourse" method="post" onsubmit="return check()">
							<div class="form-group">
								<label class="col-sm-2 control-label">课程代码</label>
								<div class="col-sm-4">
									<input type="text" name="crs_code" class="form-control" >
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">课程名称</label>
								<div class="col-sm-4">
									<input type="text" name="crs_name" class="form-control" >
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">课程属性</label>
								<div class="col-sm-4">
									<select name="crs_attribute" style="width:200px;height:35px">
										<option value="必修" >必修</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">课程学分</label>
								<div class="col-sm-4">
									<select name="crs_credit"  style="width:200px;height:35px">
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
										<option value="6">6</option>
										<option value="7">7</option>
										<option value="8">8</option>
										<option value="9">9</option>
										<option value="10">10</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">课程学期</label>
								<div class="col-sm-4">
									<input type="text" name="crs_semester" class="form-control" >
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">课程时间</label>
								<div class="col-sm-4">
									<select name="crs_time"  style="width:200px;height:35px">
										<option value="周一第1、2节">周一第1、2节</option>
										<option value="周一第3、4节">周一第3、4节</option>
										<option value="周一第5、6节">周一第5、6节</option>
										<option value="周一第7、8节">周一第7、8节</option>
										<option value="周一第9、10节">周一第9、10节</option>
										<option value="周二第1、2节">周二第1、2节</option>
										<option value="周二第3、4节">周二第3、4节</option>
										<option value="周二第5、6节">周二第5、6节</option>
										<option value="周二第7、8节">周二第7、8节</option>
										<option value="周二第9、10节">周二第9、10节</option>
										<option value="周三第1、2节">周三第1、2节</option>
										<option value="周三第3、4节">周三第3、4节</option>
										<option value="周三第5、6节">周三第5、6节</option>
										<option value="周三第7、8节">周三第7、8节</option>
										<option value="周三第9、10节">周三第9、10节</option>
										<option value="周四第1、2节">周四第1、2节</option>
										<option value="周四第3、4节">周四第3、4节</option>
										<option value="周四第5、6节">周四第5、6节</option>
										<option value="周四第7、8节">周四第7、8节</option>
										<option value="周四第9、10节">周四第9、10节</option>
										<option value="周五第1、2节">周五第1、2节</option>
										<option value="周五第3、4节">周五第3、4节</option>
										<option value="周五第5、6节">周五第5、6节</option>
										<option value="周五第7、8节">周五第7、8节</option>
										<option value="周五第9、10节">周五第9、10节</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">课程周次</label>
								<div class="col-sm-4">
									<select name="crs_frequency" style="width:200px;height:35px">
										<option value="1周次">1周次</option>
										<option value="2周次">2周次</option>
										<option value="3周次">3周次</option>
										<option value="4周次">4周次</option>
										<option value="5周次">5周次</option>
										<option value="6周次">6周次</option>
										<option value="7周次">7周次</option>
										<option value="8周次">8周次</option>
										<option value="9周次">9周次</option>
										<option value="10周次">10周次</option>
										<option value="11周次">11周次</option>
										<option value="12周次">12周次</option>
										<option value="13周次">13周次</option>
										<option value="14周次">14周次</option>
										<option value="15周次">15周次</option>
										<option value="16周次">16周次</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">课程班级</label>
								<div class="col-sm-4">
									<select name="crs_class" style="width:200px;height:35px">
										<c:forEach items="${stu_class }" var="item">
											<option value="${item.stu_class }">${item.stu_class }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">课程老师</label>
								<div class="col-sm-4">
									<input type="text" name="crs_teacher" class="form-control" >
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">课程地点</label>
								<div class="col-sm-4">
									<input type="text" name="crs_address" class="form-control">
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