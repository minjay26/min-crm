<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
span{
color:red;
}

</style>
<title>登录界面</title>
</head>
<body>

    <form action="login" method="post">
       账户 <input type="text" name="username" id="username" onblur="validate();"/><span id="tip_username" class="tip"></span>
       账密码<input type="password" name="password" id="password" onblur="validate();"/><span id="tip_password" class="tip"></span>
       <input type="submit" value="提交" onclick="return validate();"/> 
   </form>
<script type="text/javascript">
function validate(){
	var r = true;	
	var acc = document.getElementById("username");
	var tip = document.getElementById("tip_username");
	if("" == acc.value){
		r = false;
		
		tip.textContent = "请输入账号！";			
	}else{
		tip.textContent = "";
	}
	acc = null;
	
	var pwd = document.getElementById("password");
	tip = document.getElementById("tip_password");
	if("" == pwd.value){
		r = false;
				
		tip.textContent = "请输入密码！";
	}
	else{
		tip.textContent = "";
	}
	pwd= null;	
	
	return r;

}
</script>
</body>
</html>
