
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<select id="choice" style="float:left;margin-right:15px;height:21px;">
  <option selected="selected">请选择搜索的类型</option>
  <option>订单号</option>
  <option>订单用户名</option>
  <option>销售人员名</option>
  <option>已支付</option>
  <option>未支付</option>
  <option>商品名</option>
</select>
<div class="form-group">
<input type="text" class="form-control" name="queryValue" id="queryValue" style="width:80px;float:left;height:21px;" placeholder="搜索内容" title="搜索内容"/>
<input type="submit" style="float:left;" value="搜索" id="submitSelect"/>
</div>
<table class="table table-bordered">
			<thead>
				<tr>
					<th>订单号</th><th>订单用户名</th><th>订单销售职工姓名</th><th>订单商品价格</th><th>订单状态</th><th>订单商品数量</th><th>订单商品名</th>
				</tr>
			</thead>
			<tbody >
			<c:forEach var="ele" items="${allOrder}">
<tr>
	<td>${ele.orderNum }</td>
	<td>${ele.customerName }</td>
	<td>${ele.employeeName }</td>
	<td>${ele.totalPrice }</td>
	<td>${ele.orderStatus }</td>
	<td>${ele.productNum }</td>
	<td>${ele.pName }</td>
	
</tr>
</c:forEach>
             </tbody>

</table>
<nav>
	<ul class="pagination">
		<li><a href="javascript:void(0)" class="queryOrderPage"
			url="order_getAll/${page-1}" aria-label="Previous"> <span
				aria-hidden="true">&laquo;</span>
		</a></li>
		<c:forEach var="i" begin="1" end="${pageSum}">
			<li ${i==page+1? "class=\"active\"" : "" }><a
				href="javascript:void(0)" class="queryOrderPage"
				url="order_getAll/${i-1}">${i}</a></li>
		</c:forEach>
		<li><a href="javascript:void(0)" class="queryOrderPage"
			url="order_getAll/${page+1}" aria-label="Next"> <span
				aria-hidden="true">&raquo;</span>
		</a></li>
	</ul>
</nav>
<script>
	$("#submitSelect").click(function(){
		var searchType=$("#choice").val();
		var searchContent=$("#queryValue").val();
		$.get("search_order",{searchType:searchType,searchContent:searchContent},function(r){
			   $("#content-right").empty().html(r);
		   });
	})
	
	$(".queryOrderPage").each(function(i){
	$(this).click(function(){
		$.get($(this).attr("url"),function(r){
			$("#content-right").empty().html(r);
		});
	});
});
	
</script>

