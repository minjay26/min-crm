/**
 * 
 */
$(document).ready(function(){ 
			$("#menu li").each(
					function(index) {
						$(this).click(
								function() {
									$("#menu li.tabFocus").removeClass(
											"tabFocus");
									$(this).addClass("tabFocus");
									$("#content-detail li:eq(" + index + ")").show()
											.siblings().hide();
								});
					});
			
			$("#add").click(function(){
				//通过异步请求获取add的局部视图
				$.get("department-add", function(r){
					  $("#others").empty().html(r);
				});
			});
		});	
		$(".modify").each(function(i){
			$(this).click(function(){
				$.get($(this).attr("url"),function(r){
					$("#others").empty().html(r);
				});
			});
		});
		
		$(".remove").each(function(i){
			$(this).click(function(){
				var cur = $(this);
				if(window.confirm("确定要删除吗？")){
					$.get($(this).attr("url"), function(r){
						var obj = window.eval("(" + r + ")");						
						alert(obj.message);					
						$(cur).parents("tr").remove();
						cur = null;
					});
				}
			});
		});
		$(".department_employees").each(function(i){
			$(this).click(function(){
				$.get($(this).attr("url"),function(r){
					$("#others").empty().html(r);
				});
			});
		});
		
		
		
		