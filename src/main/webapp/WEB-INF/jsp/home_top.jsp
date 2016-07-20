<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<link  href="statics\css\home_top.css" rel="stylesheet"/>
<style type="text/css">
     #title{
            font-size: 25px;
            margin-left: 500px;
            font-style: italic;
            }
     </style>
    <script type="text/javascript">
	  
	</script>
	
	<span>当前用户：<sec:authentication property="principal.username" scope="session" var="username"/>
     ${username}
	</span>	
	<span>
	   <a href="/logout">注销</a>
	</span>
	<span id="title">客户资源管理系统</span>
	<span id="time"></span>
	