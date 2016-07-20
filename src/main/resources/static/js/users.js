/**
 * 
 */
$(function(){
	var dpId = $("#currentDpId").val();
	var url = "user-add/" + dpId;
	$("#addUser").click(function() {
		//通过异步请求获取add的局部视图
		$.get(url, function(r) {
			$("#showUser").empty().html(r);
		});
	});

	$(".user-modify").each(function(i) {
		$(this).click(function() {
			$.get($(this).attr("url"), function(r) {
				$("#showUser").empty().html(r);
			});
		});
	});

	$(".user-remove").each(function(i) {
		$(this).click(function() {
			var cur = $(this);
			var sId=cur.val();
			alert(sId);
			if (window.confirm("确定要删除吗？")) {
				$.get("/users-remove/"+sId, function(r) {
					var obj = window.eval("(" + r + ")");
					alert(obj.message);
					$(cur).parents("tr").remove();
					cur = null;
				});
			}
		});
	});

	$(".queryUserPage").each(function(i) {
		$(this).click(function() {
			$.get($(this).attr("url"), function(r) {
				$("#showDepartment").empty().html(r);
			});
		});
	});
})


