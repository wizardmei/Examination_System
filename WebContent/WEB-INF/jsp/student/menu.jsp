<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="col-md-1"></div>
<div class="col-md-1">
	<ul class="nav nav-pills nav-stacked" id="nav">
		<li><a href="${pageContext.request.contextPath}/student/showUserInfo"><h4>个人信息<span class="glyphicon glyphicon-user pull-right"></span></h4></a></li>
		<li><a href="${pageContext.request.contextPath}/student/showMark"><h4>课程成绩<span class="glyphicon glyphicon-user pull-right"></span></h4></a></li>
		<li><a href="${pageContext.request.contextPath}/student/Schedule_Card"><h4>课程安排<span class="glyphicon glyphicon-list-alt pull-right"></span></h4></a></li>
		<li><a href="${pageContext.request.contextPath}/student/stu_showCourse"><h4>查看课程信息<span class="glyphicon glyphicon-book pull-right"></span></h4></a></li>
		<li><a href="${pageContext.request.contextPath}/student/showElectiveCourse"><h4>选择课程<span class="glyphicon glyphicon-book pull-right"></span></h4></a></li>
		<li><a href="${pageContext.request.contextPath}/student/resetPasswd"><h4>修改密码<span class="glyphicon glyphicon-pencil pull-right"></span></h4></a></li>
		<li><a href="${pageContext.request.contextPath}/admin/logout"><h4>退出系统<span class="glyphicon glyphicon-log-out pull-right"></span></h4></a></li>
        <li class="disabled"><a href="##">Examination_System</a></li>	
	</ul>
</div>