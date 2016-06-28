<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户资源管理系统</title>
<script type="text/javascript" src="\statics\js\jquery-1.11.3.min.js"></script>
<link href="../statics\bootstrap\css\bootstrap.min.css" rel="stylesheet">
 <link  href="statics\css\home.css" rel="stylesheet"/>
<script src="../statics\bootstrap\js\bootstrap.min.js"></script>
</head>
<body>
	<div id="top">
        <jsp:include page="home_top.jsp"></jsp:include>
	</div>
	
	<div id="content">	
		<div id="content-left">
			<jsp:include page="home_left.jsp"></jsp:include>
		</div>		
		<div id="content-right"></div>
	</div>
	
	<div id="buttom"></div>

	
</body>
</html>