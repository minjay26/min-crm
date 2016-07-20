/**
 * 
 */
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