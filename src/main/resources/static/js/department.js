/**
 * 
 */
$(function(){
	$("#addDepartment").click(function(){
		//通过异步请求获取add的局部视图
		$.get("department-add", function(r){
			  $("#myModal").empty().html(r);
		});
	});

	$(".modify").each(function(i){
		$(this).click(function(){
			var dpId=$(this).val();
			$.get("department-modify/"+dpId,function(r){
				$("#myModal").empty().html(r);
			});
		});
	});

	$(".remove").each(function(i){
		$(this).click(function(){
			var cur = $(this);
			var dpId=cur.val();
			alert(dpId);
			if(window.confirm("确定要删除吗？")){			
				$.get("department-remove/"+dpId, function(r){
					var obj = window.eval("(" + r + ")");						
					alert(obj.message);					
					$(cur).parents("tr").remove();
					cur = null;
				});
			}
		});
	});
})


//$(".department_users").each(function(i){
//	$(this).click(function(){
//		$.get($(this).attr("url"),function(r){
//			$("#showDepartment").empty().html(r);
//		});
//	});
//});