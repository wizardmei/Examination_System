<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 导航 -->
<div class="container-fiuled" id="top">
	<div class="row">
		<div class="col-lg-1"></div>
		<div class="col-lg-10">
			<nav class="navbar navbar-default" role="navigation">
				<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">教务信息查询系统(学生)</a>
				</div>
				<form action="##" class="navbar-form navbar-right">
					<div class="dropdown">
						<button class="btn btn-default dropdown-toggle" id="dropdownMenu1" type="button" style="margin-right: 20px;" data-toggle="dropdown">
							<span class="glyphicon glyphicon-user">${username }</span>
							<span class="caret"></span>
						</button>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
							<li>
								<a tabindex="-1" href="#">
									<span class="glyphicon glyphicon-tags pull-right"></span>
									修改个人信息
								</a>
							</li>
							<li class="divider"></li>
							<li>
								<a tabindex="-1" href="${pageContext.request.contextPath}/login">
									<span class="glyphicon glyphicon-off pull-right"></span>
									注销
								</a>
							</li>
						</ul>
					</div>
				</form>
				</div>
			</nav>
		</div>
		<div class="col-lg-1"></div>
	</div>
</div>