<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<div class="form-group">
	<input type="text" class="form-control" name="queryValue"
		id="queryValue" style="width: 80px; float: left; height: 21px;"
		placeholder="搜索内容" title="搜索内容" /> 
		<input type="submit" value="搜索" id="submit"/>
</div>
<table class="table table-bordered">
	<thead>
		<tr>
			<th>姓名</th>
			<th>地址</th>
			<th>性别</th>
			<th>地址</th>
			<th>加入时间</th>
			<th>电话号码</th>
			<th>负责人</th>
			<th>类型</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="ele" items="${list}">
			<tr>
				<td><a href="javascript:void(0);">${ele.customerName }</a></td>
				<td>${ele.address }</td>
				<td>${ele.gender }</td>
				<td>${ele.company }</td>
				<td>${ele.joinTime }</td>
				<td>${ele.phone }</td>
				<td>${ele.sId }</td>
				<td>${ele.type }</td>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<td><a href="javascript:void(0);" class="customer-modify"
						url="customer-modify/${ele.csId }"><span
							class="glyphicon glyphicon-edit">修改</span></a> <a
						href="javascript:void(0);" class="customer-remove"
						url="customer-remove/${ele.csId }"><span
							class="glyphicon glyphicon-remove">删除</span></a></td>
				</sec:authorize>
			</tr>
		</c:forEach>
	</tbody>

</table>
<nav>
	<ul class="pagination">
		<li><a href="javascript:void(0)" class="queryCustomerPage"
			url="allCustomerWithPage/${page-1}" aria-label="Previous"> <span
				aria-hidden="true">&laquo;</span>
		</a></li>
		<c:forEach var="i" begin="1" end="${pageSum}">
			<li ${i==page+1? "class=\"active\"" : "" }><a
				href="javascript:void(0)" class="queryCustomerPage"
				url="allCustomerWithPage/${i-1}">${i}</a></li>
		</c:forEach>
		<li><a href="javascript:void(0)" class="queryCustomerPage"
			url="allCustomerWithPage/${page+1}" aria-label="Next"> <span
				aria-hidden="true">&raquo;</span>
		</a></li>
	</ul>
</nav>
<br>
<a href="javascript:void(0)" id="addCustomer">增加客户信息</a><br>
<a href="javascript:void(0)" class="toExcel">导出用户信息</a>
<div>
	<span id="showCustomer"></span>
</div>
<script type="text/javascript">
	$("#addCustomer").click(function() {
		//通过异步请求获取add的局部视图
		$.get("customer-add", function(r) {
			$("#showCustomer").empty().html(r);
		});
	});

	$(".customer-modify").each(function(i) {
		$(this).click(function() {
			$.get($(this).attr("url"), function(r) {
				$("#showCustomer").empty().html(r);
			});
		});
	});

	$(".queryCustomerPage").each(function(i) {
		$(this).click(function() {
			$.get($(this).attr("url"), function(r) {
				$("#content-right").empty().html(r);
			});
		});
	});

	$("#submit").click(function() {
		var searchContent = $("#queryValue").val();
		$.get("search_customer", {
			searchContent : searchContent
		}, function(r) {
			$("#content-right").empty().html(r);
		});
	})

	$(".customer-remove").each(function(i) {
		$(this).click(function() {
			var cur = $(this);
			if (window.confirm("确定要删除吗？")) {
				$.get($(this).attr("url"), function(r) {
					var obj = window.eval("(" + r + ")");
					alert(obj.message);
					$(cur).parents("tr").remove();
					cur = null;
				});
			}
		});
	});
	
	$(".toExcel").click(function(){
		$.get("toExcel",function(r){
			alert(r);
		})
	})
</script>
