<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
	<link rel="icon" href="images/graduate.jpg" type="image/x-icon" />
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
				<table style="background-color:#E0FFFF" border="1">
					<thead>
						<tr>
							<td width="4%" class="sortable">&nbsp;</td>
							<td width="12%" class="sortable">&nbsp;</td>
							<td width="12" class="sortable">
								<div align="center"><b>星期一</b></div>
							</td>
							<td width="12" class="sortable">
								<div align="center"><b>星期二</b></div>
							</td>
							<td width="12" class="sortable">
								<div align="center"><b>星期三</b></div>
							</td>
							<td width="12" class="sortable">
								<div align="center"><b>星期四</b></div>
							</td>
							<td width="12" class="sortable">
								<div align="center"><b>星期五</b></div>
							</td>
							<td width="12" class="sortable">
								<div align="center"><b>星期六</b></div>
							</td>
							<td width="12" class="sortable">
								<div align="center"><b>星期天</b></div>
							</td>
						</tr>
						<tr bgcolor="#FFFFFF">
							<td colspan="9">
								<p align="center" >
									<strong>上午</strong>
								</p>
							</td>
						</tr>
						<tr bgcolor="#FFFFFF">
							<td width="4%" rowspan="4">
								<p>上午</p>
							</td>
							<td width="12%">第一节(08:15-9:00)</td>
							<td width="12%" valign="top" align="center">
								${monday12.crs_name}(${monday12.crs_address },${moday12.crs_teacher},${monday12.crs_frequency}) 
							</td>
							<td width="12%" valign="top" align="center">
								${tuesday12.crs_name}(${tuesday12.crs_address},${tuesday12.crs_teacher},${tuesday12.crs_frequency}) 
							</td>
							<td width="12%" valign="top" align="center">
								${wednesday12.crs_name}(${wednesday12.crs_address},${wednesday12.crs_teacher},${wednesday12.crs_frequency})
							</td>
							<td width="12%" valign="top" align="center">
								${thursday12.crs_name}(${thursday12.crs_address},${thursday12.crs_teacher},${thursday12.crs_frequency})
							</td>
							<td width="12%" valign="top" align="center">
								${friday12.crs_name}(${friday12.crs_address},${friday12.crs_teacher},${friday12.crs_frequency})
							</td>
							<td width="12%" valign="top" align="center">
								${saturday12.crs_name}(${saturday12.crs_address},${saturday12.crs_teacher},${saturday12.crs_frequency})
							</td>
							<td width="12%" valign="top" align="center">
								${sunday12.crs_name}(${sunday12.crs_address},${sunday12.crs_teacher},${sunday12.crs_frequency})
							</td>
						</tr>
						<tr bgcolor="#FFFFFF">
							<td width="12%">第一节(09:05-9:50)</td>
							<td width="12%" valign="top" align="center">
								${monday12.crs_name}(${monday12.crs_address },${moday12.crs_teacher},${monday12.crs_frequency})
							</td>
							<td width="12%" valign="top" align="center">
								${tuesday12.crs_name}(${tuesday12.crs_address},${tuesday12.crs_teacher},${tuesday12.crs_frequency}) 
							</td>
							<td width="12%" valign="top" align="center">
								${wednesday12.crs_name}(${wednesday12.crs_address},${wednesday12.crs_teacher},${wednesday12.crs_frequency}) 
							</td>
							<td width="12%" valign="top" align="center">
								${thursday12.crs_name}(${thursday12.crs_address},${thursday12.crs_teacher},${thursday12.crs_frequency}) 
							</td>
							<td width="12%" valign="top" align="center">
								${friday12.crs_name}(${friday12.crs_address},${friday12.crs_teacher},${friday12.crs_frequency}) 
							</td>
							<td width="12%" valign="top" align="center">
								${saturday12.crs_name}(${saturday12.crs_address},${saturday12.crs_teacher},${saturday12.crs_frequency})
							</td>
							<td width="12%" valign="top" align="center">
								${sunday12.crs_name}(${sunday12.crs_address},${sunday12.crs_teacher},${sunday12.crs_frequency})
							</td>
						</tr>
						<tr bgcolor="#FFFFFF">
							<td width="12%">第二节(10:05-10:50)</td>
							<td width="12%" valign="top" align="center">
								${monday34.crs_name}(${monday34.crs_address },${moday34.crs_teacher},${monday34.crs_frequency})
							</td>
							<td width="12%" valign="top" align="center">
								${tuesday34.crs_name}(${tuesday34.crs_address},${tuesday34.crs_teacher},${tuesday34.crs_frequency}) 
							</td>
							<td width="12%" valign="top" align="center">
								${wednesday34.crs_name}(${wednesday34.crs_address},${wednesday34.crs_teacher},${wednesday34.crs_frequency}) 
							</td>
							<td width="12%" valign="top" align="center">
								${thursday34.crs_name}(${thursday34.crs_address},${thursday34.crs_teacher},${thursday34.crs_frequency}) 
							</td>
							<td width="12%" valign="top" align="center">
								${friday34.crs_name}(${friday34.crs_address},${friday34.crs_teacher},${friday34.crs_frequency}) 
							</td>
							<td width="12%" valign="top" align="center">
								${saturday34.crs_name}(${saturday34.crs_address},${saturday34.crs_teacher},${saturday34.crs_frequency})
							</td>
							<td width="12%" valign="top" align="center">
								${sunday34.crs_name}(${sunday34.crs_address},${sunday34.crs_teacher},${sunday34.crs_frequency})
							</td>
						</tr>
						<tr bgcolor="#FFFFFF">
							<td width="12%">第二节(10:55-11:40)</td>
							<td width="12%" valign="top" align="center">
								${monday34.crs_name}(${monday34.crs_address },${moday34.crs_teacher},${monday34.crs_frequency})
							</td>
							<td width="12%" valign="top" align="center">
								${tuesday34.crs_name}(${tuesday34.crs_address},${tuesday34.crs_teacher},${tuesday34.crs_frequency}) 
							</td>
							<td width="12%" valign="top" align="center">
								${wednesday34.crs_name}(${wednesday34.crs_address},${wednesday34.crs_teacher},${wednesday34.crs_frequency}) 
							</td>
							<td width="12%" valign="top" align="center">
								${thursday34.crs_name}(${thursday34.crs_address},${thursday34.crs_teacher},${thursday34.crs_frequency}) 
							</td>
							<td width="12%" valign="top" align="center">
								${friday34.crs_name}(${friday34.crs_address},${friday34.crs_teacher},${friday34.crs_frequency}) 
							</td>
							<td width="12%" valign="top" align="center">
								${saturday34.crs_name}(${saturday34.crs_address},${saturday34.crs_teacher},${saturday34.crs_frequency})
							</td>
							<td width="12%" valign="top" align="center">
								${sunday34.crs_name}(${sunday34.crs_address},${sunday34.crs_teacher},${sunday34.crs_frequency})
							</td>
						</tr>
						<tr bgcolor="#FFFFFF">
							<td colspan="9">
								<p align="center" >
									<strong>午休</strong>
								</p>
							</td>
						</tr>
						<tr bgcolor="#FFFFFF">
							<td width="4%" rowspan="4">
								<p>下午</p>
							</td>
							<td width="12%">第三节(14:00-14:45)</td>
							<td width="12%" valign="top" align="center">
								${monday56.crs_name}(${monday56.crs_address },${moday56.crs_teacher},${monday56.crs_frequency})
							</td>
							<td width="12%" valign="top" align="center">
								${tuesday56.crs_name}(${tuesday56.crs_address},${tuesday56.crs_teacher},${tuesday56.crs_frequency}) 
							</td>
							<td width="12%" valign="top" align="center">
								${wednesday56.crs_name}(${wednesday56.crs_address},${wednesday56.crs_teacher},${wednesday56.crs_frequency}) 
							</td>
							<td width="12%" valign="top" align="center">
								${thursday56.crs_name}(${thursday56.crs_address},${thursday56.crs_teacher},${thursday56.crs_frequency}) 
							</td>
							<td width="12%" valign="top" align="center">
								${friday56.crs_name}(${friday56.crs_address},${friday56.crs_teacher},${friday56.crs_frequency}) 
							</td>
							<td width="12%" valign="top" align="center">
								${saturday56.crs_name}(${saturday56.crs_address},${saturday56.crs_teacher},${saturday56.crs_frequency})
							</td>
							<td width="12%" valign="top" align="center">
								${sunday56.crs_name}(${sunday56.crs_address},${sunday56.crs_teacher},${sunday56.crs_frequency})
							</td>
						</tr>
						<tr bgcolor="#FFFFFF">
							<td width="12%">第三节(14:50-15:35)</td>
							<td width="12%" valign="top" align="center">
								${monday56.crs_name}(${monday56.crs_address },${moday56.crs_teacher},${monday56.crs_frequency})
							</td>
							<td width="12%" valign="top" align="center">
								${tuesday56.crs_name}(${tuesday56.crs_address},${tuesday56.crs_teacher},${tuesday56.crs_frequency}) 
							</td>
							<td width="12%" valign="top" align="center">
								${wednesday56.crs_name}(${wednesday56.crs_address},${wednesday56.crs_teacher},${wednesday56.crs_frequency}) 
							</td>
							<td width="12%" valign="top" align="center">
								${thursday56.crs_name}(${thursday56.crs_address},${thursday56.crs_teacher},${thursday56.crs_frequency}) 
							</td>
							<td width="12%" valign="top" align="center">
								${friday56.crs_name}(${friday56.crs_address},${friday56.crs_teacher},${friday56.crs_frequency}) 
							</td>
							<td width="12%" valign="top" align="center">
								${saturday56.crs_name}(${saturday56.crs_address},${saturday56.crs_teacher},${saturday56.crs_frequency})
							</td>
							<td width="12%" valign="top" align="center">
								${sunday56.crs_name}(${sunday56.crs_address},${sunday56.crs_teacher},${sunday56.crs_frequency})
							</td>
						</tr>
						<tr bgcolor="#FFFFFF">
							<td width="12%">第四节(15:50-16:35)</td>
							<td width="12%" valign="top" align="center">
								${monday78.crs_name}(${monday78.crs_address },${moday78.crs_teacher},${monday78.crs_frequency})
							</td>
							<td width="12%" valign="top" align="center">
								${tuesday78.crs_name}(${tuesday78.crs_address},${tuesday78.crs_teacher},${tuesday78.crs_frequency}) 
							</td>
							<td width="12%" valign="top" align="center">
								${wednesday78.crs_name}(${wednesday78.crs_address},${wednesday78.crs_teacher},${wednesday78.crs_frequency}) 
							</td>
							<td width="12%" valign="top" align="center">
								${thursday78.crs_name}(${thursday78.crs_address},${thursday78.crs_teacher},${thursday78.crs_frequency}) 
							</td>
							<td width="12%" valign="top" align="center">
								${friday78.crs_name}(${friday78.crs_address},${friday78.crs_teacher},${friday78.crs_frequency}) 
							</td>
							<td width="12%" valign="top" align="center">
								${saturday78.crs_name}(${saturday78.crs_address},${saturday78.crs_teacher},${saturday78.crs_frequency})
							</td>
							<td width="12%" valign="top" align="center">
								${sunday78.crs_name}(${sunday78.crs_address},${sunday78.crs_teacher},${sunday78.crs_frequency})
							</td>
						</tr>
						<tr bgcolor="#FFFFFF">
							<td width="12%">第四节(16:40-17:25)</td>
							<td width="12%" valign="top" align="center">
								${monday78.crs_name}(${monday78.crs_address },${moday78.crs_teacher},${monday78.crs_frequency})
							</td>
							<td width="12%" valign="top" align="center">
								${tuesday78.crs_name}(${tuesday78.crs_address},${tuesday78.crs_teacher},${tuesday78.crs_frequency}) 
							</td>
							<td width="12%" valign="top" align="center">
								${wednesday78.crs_name}(${wednesday78.crs_address},${wednesday78.crs_teacher},${wednesday78.crs_frequency}) 
							</td>
							<td width="12%" valign="top" align="center">
								${thursday78.crs_name}(${thursday78.crs_address},${thursday78.crs_teacher},${thursday78.crs_frequency}) 
							</td>
							<td width="12%" valign="top" align="center">
								${friday78.crs_name}(${friday78.crs_address},${friday78.crs_teacher},${friday78.crs_frequency}) 
							</td>
							<td width="12%" valign="top" align="center">
								${saturday78.crs_name}(${saturday78.crs_address},${saturday78.crs_teacher},${saturday78.crs_frequency})
							</td>
							<td width="12%" valign="top" align="center">
								${sunday78.crs_name}(${sunday78.crs_address},${sunday78.crs_teacher},${sunday78.crs_frequency})
							</td>
						</tr>
						<tr bgcolor="#FFFFFF">
							<td colspan="9">
								<p align="center" >
									<strong>晚饭</strong>
								</p>
							</td>
						</tr>
						<tr bgcolor="#FFFFFF">
							<td width="4%" rowspan="2">
								<p>晚上</p>
							</td>
							<td width="12%">第五节(18:30-19:15)</td>
							<td width="12%" valign="top" align="center">
								${monday910.crs_name}(${monday910.crs_address },${moday910.crs_teacher},${monday910.crs_frequency})
							</td>
							<td width="12%" valign="top" align="center">
								${tuesday910.crs_name}(${tuesday910.crs_address},${tuesday910.crs_teacher},${tuesday910.crs_frequency}) 
							</td>
							<td width="12%" valign="top" align="center">
								${wednesday910.crs_name}(${wednesday910.crs_address},${wednesday910.crs_teacher},${wednesday910.crs_frequency}) 
							</td>
							<td width="12%" valign="top" align="center">
								${thursday910.crs_name}(${thursday910.crs_address},${thursday910.crs_teacher},${thursday910.crs_frequency}) 
							</td>
							<td width="12%" valign="top" align="center">
								${friday910.crs_name}(${friday910.crs_address},${friday910.crs_teacher},${friday910.crs_frequency}) 
							</td>
							<td width="12%" valign="top" align="center">
								${saturday910.crs_name}(${saturday910.crs_address},${saturday910.crs_teacher},${saturday910.crs_frequency})
							</td>
							<td width="12%" valign="top" align="center">
								${sunday910.crs_name}(${sunday910.crs_address},${sunday910.crs_teacher},${sunday910.crs_frequency})
							</td>
						</tr>
						<tr bgcolor="#FFFFFF">
							<td width="12%">第五节(19:20-20:05)</td>
							<td width="12%" valign="top" align="center">
								${monday910.crs_name}(${monday910.crs_address },${moday910.crs_teacher},${monday910.crs_frequency})
							</td>
							<td width="12%" valign="top" align="center">
								${tuesday910.crs_name}(${tuesday910.crs_address},${tuesday910.crs_teacher},${tuesday910.crs_frequency}) 
							</td>
							<td width="12%" valign="top" align="center">
								${wednesday910.crs_name}(${wednesday910.crs_address},${wednesday910.crs_teacher},${wednesday910.crs_frequency}) 
							</td>
							<td width="12%" valign="top" align="center">
								${thursday910.crs_name}(${thursday910.crs_address},${thursday910.crs_teacher},${thursday910.crs_frequency}) 
							</td>
							<td width="12%" valign="top" align="center">
								${friday910.crs_name}(${friday910.crs_address},${friday910.crs_teacher},${friday910.crs_frequency}) 
							</td>
							<td width="12%" valign="top" align="center">
								${saturday910.crs_name}(${saturday910.crs_address},${saturday910.crs_teacher},${saturday910.crs_frequency})
							</td>
							<td width="12%" valign="top" align="center">
								${sunday910.crs_name}(${sunday910.crs_address},${sunday910.crs_teacher},${sunday910.crs_frequency})
							</td>
						</tr>
					</thead>
				</table>
			</div>
			<div class="col-md-1"></div>
		</div>
	</div>
</body>
	<script type="text/javascript">
	$("#nav li:nth-child(3)").addClass("active");
	</script>
</html>