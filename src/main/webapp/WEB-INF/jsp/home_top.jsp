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
	  function clock(){		
 		    var attime;
		    var time=new Date();
			var year=time.getFullYear();
			var month=time.getMonth()+1;
			var day=time.getDate();
		    var HH = time.getHours();
		    if(HH<10){HH="0"+HH};
		    var MM = time.getMinutes();
		    if(MM<10){MM="0"+MM};
		    var SS = time.getSeconds();
		    if(SS<10){SS="0"+SS};
		    var ww = ["星期日","星期一","星期二","星期三","星期四","星期五","星期六"]
		    var nWeek = time.getDay();
		    attime= year+"-"+month+"-"+day+"      "+HH+":"+MM+":"+SS+" "+ww[nWeek];
		    document.getElementById("time").innerHTML = attime;
		    
		 
		  }
		setInterval(clock,1000);
	</script>
	<span>当前用户：<sec:authentication property="principal.username" scope="session" var="username"/>
     ${username}
	</span>	
	<span>
	   <a href="/logout">注销</a>
	</span>
	<span id="title">客户资源管理系统</span>
	<span id="time"></span>
	