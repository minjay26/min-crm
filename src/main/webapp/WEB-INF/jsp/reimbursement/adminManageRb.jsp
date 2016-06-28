<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="\statics\js\jquery-1.11.3.min.js"></script>
<link href="../statics\bootstrap\css\bootstrap.min.css" rel="stylesheet">
<script src="../statics\bootstrap\js\bootstrap.min.js"></script>
<link  href="statics\css\adminManageRb.css" rel="stylesheet"/>
<title>报销</title>
</head>
<body>
<div id="top"><jsp:include page="../home_top.jsp"></jsp:include></div>
<div id="content">
<div id="content_left"><jsp:include page="../home_left.jsp"></jsp:include></div>
<div id="content_right">
    <a href="javascript:void(0)" id="noCheck">暂未审核报销</a>
    <a href="javascript:void(0)" id="all">所有报销</a>
    <div id="query">
   开始时间： <input type="date" name="beginTime" id="beginTime"/>
   结束时间： <input type="date" name="endTime" id="endTime"/>
         <input type="button" value="查询" id="queryByDate" class="queryByDate"/>
    </div>    
    <div id="showMsg"></div>
</div>
</div>
<script type="text/javascript">
$("#noCheck").click(function(){
	$.get("noCheck", function(r){
		  $("#showMsg").empty().html(r);
	});
});

$("#all").click(function(){
	$.get("queryReimbursementPage/0", function(r){
		  $("#showMsg").empty().html(r);
	});
});

 
 $(".queryByDate").click(function(){
	 var beginTime=$("#beginTime").val();
	 var endTime=$("#endTime").val();
	 $.get("queryByDate/0",{beginTime:beginTime,endTime:endTime},function(r){
		 $("#showMsg").empty().html(r);
	 });
 })
</script>
</body>
</html>