/**
 * 
 */
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