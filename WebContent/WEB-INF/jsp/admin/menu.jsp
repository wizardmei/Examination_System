<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="col-md-1"></div>
<div class="col-md-1">
	<ul class="nav nav-pills nav-stacked" id="nav">
		<li><a href="${pageContext.request.contextPath}/admin/showStudent"><h4>学生管理<span class="badge pull-right">${stu_num }</span></h4></a></li>
		<li><a href="${pageContext.request.contextPath}/admin/showCourse"><h4>课程管理<span class="badge pull-right">${crs_num }</span></h4></a></li>
		<li><a href="${pageContext.request.contextPath}/admin/showTeacher"><h4>教师管理<span class="badge pull-right">${tcr_num }</span></h4></a></li>
		<li><a href="${pageContext.request.contextPath}/admin/userReset"><h4>账号密码重置<span class="glyphicon glyphicon-repeat pull-right"></span></h4></a></li>
		<li><a href="${pageContext.request.contextPath}/admin/resetPasswd"><h4>修改密码<span class="glyphicon glyphicon-pencil pull-right"></span></h4></a></li>
		<li><a href="${pageContext.request.contextPath}/admin/logout"><h4>退出系统<span class="glyphicon glyphicon-log-out pull-right"></span></h4></a></li>
        <li class="disabled"><a href="##">Examination_System</a></li>	
	</ul>
</div>