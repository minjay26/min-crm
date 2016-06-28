<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人财务报销</title>
<script type="text/javascript" src="\statics\js\jquery-1.11.3.min.js"></script>
<link href="../statics\bootstrap\css\bootstrap.min.css" rel="stylesheet">
<script src="../statics\bootstrap\js\bootstrap.min.js"></script>
<link  href="statics\css\adminManageRb.css" rel="stylesheet"/>
</head>
<body>
<div id="top"><jsp:include page="../home_top.jsp"></jsp:include></div>
<div id="content">
   <div id="content_left"><jsp:include page="../home_left.jsp"></jsp:include></div>

  <div id="content_right">     
     <a href="javascript:void(0)" url="person_noCheck" id="person_noCheck">未审批报销</a>
     <a href="javascript:void(0)" url="person_noPass" id="person_noPass">未通过报销</a>
     <a href="javascript:void(0)" url="person_apply" id="person_apply">申请报销</a>
     
     <div id="showMsg"></div>
  </div>
  

</div>  
  <script type="text/javascript">
  $("#person_noCheck").click(function(){
		$.get("person_noCheck/0", function(r){
			  $("#showMsg").empty().html(r);
		});
	});
  
  $("#person_noPass").click(function(){
		$.get("person_noPass/0", function(r){
			  $("#showMsg").empty().html(r);
		});
	});
  
  $("#person_apply").click(function(){
		$.get("person_apply", function(r){
			  $("#showMsg").empty().html(r);
		});
	});
  </script>
</body>
</html>