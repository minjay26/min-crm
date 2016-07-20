
<table class="table table-bordered">
			<thead>
				<tr>
					<th>部门名称</th><th>部门人数</th><th>操作</th>
				</tr>
			</thead>
			<tbody >
			<c:forEach var="ele" items="${dpList }">
<tr th:each="ele : ${dpList}">
	<td><a href="javascript:void(0);" class="department_users" url="department_users/0/${ele.dpId }">${ele.dpName }</a></td><td>${ele.numOfEmployess }</td>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
	<td>		
		<a href="javascript:void(0);" url="department-modify/${ele.dpId}"
		 class="modify"><span class="glyphicon glyphicon-edit">修改</span></a>
		<a href="javascript:void(0);" class="remove" url="department-remove/${ele.dpId }"
		   ><span class="glyphicon glyphicon-remove">删除</span></a>
	</td>
   </sec:authorize>
</tr>
</c:forEach>
	    </tbody>

</table>
<sec:authorize access="hasRole('ROLE_ADMIN')">
<a href="javascript:void(0)" id="addDepartment">增加部门</a>
</sec:authorize>
<div>
<span id="showDepartment"></span>
</div>	
<script type="text/javascript">
$("#addDepartment").click(function(){
	//通过异步请求获取add的局部视图
	$.get("department-add", function(r){
		  $("#showDepartment").empty().html(r);
	});
});

$(".modify").each(function(i){
	$(this).click(function(){
		$.get($(this).attr("url"),function(r){
			$("#showDepartment").empty().html(r);
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
$(".department_users").each(function(i){
	$(this).click(function(){
		$.get($(this).attr("url"),function(r){
			$("#showDepartment").empty().html(r);
		});
	});
});
</script>
