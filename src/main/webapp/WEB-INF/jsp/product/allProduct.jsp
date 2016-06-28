<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<table class="table table-bordered">
			<thead>
				<tr>
					<th>产品名</th><th>产品颜色</th><th>产品材质</th><th>产品单价</th><th>操作</th>
				</tr>
			</thead>
			<tbody >
			<c:forEach var="ele" items="${list }">
<tr>
	<td><a href="javascript:void(0);" class="statisticsView" url="product_statistics/${ele.pId}">${ele.pName }</a></td>
	<td>${ele.color }</td>
	<td>${ele.material }</td>
	<td>${ele.unitPrice }</td>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
	<td>		
		<a href="javascript:void(0);" class="product-modify" url="product-modify/${ele.pId}"
		 ><span class="glyphicon glyphicon-edit">修改</span></a>
		<a href="javascript:void(0);" class="product-remove" url="product-remove/${ele.pId }"
		   ><span class="glyphicon glyphicon-remove">删除</span></a>
	</td>
	</sec:authorize>
</tr>
</c:forEach>
			</tbody>

</table>
<nav>
  <ul class="pagination">
    <li>
      <a href="javascript:void(0)" class="queryProductPage" url="allProductWithPage/${page-1}" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <c:forEach var="i" begin="1" end="${pageSum}">
    <li ${i==page+1? "class=\"active\"" : "" }><a href="javascript:void(0)" class="queryProductPage" url="allProductWithPage/${i-1}">${i}</a></li>
    </c:forEach>
    <li>
      <a href="javascript:void(0)" class="queryProductPage" url="allProductWithPage/${page+1}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
<br>
<sec:authorize access="hasRole('ROLE_ADMIN')">
<a href="javascript:void(0)" id="addProduct">增加产品信息</a>
</sec:authorize>
<div>
<span id="showProduct"></span>
</div>
<script type="text/javascript">
$(".statisticsView").each(function(i){
	$(this).click(function(){
		$.get($(this).attr("url"),function(r){
			$("#showProduct").empty().html(r);
		});
	});
});

$("#addProduct").click(function(){
	//通过异步请求获取add的局部视图
	$.get("product-add", function(r){
		  $("#showProduct").empty().html(r);
	});
});

$(".product-modify").each(function(i){
	$(this).click(function(){
		$.get($(this).attr("url"),function(r){
			$("#showProduct").empty().html(r);
		});
	});
});

$(".product-remove").each(function(i){
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

$(".queryProductPage").each(function(i){
	$(this).click(function(){
		$.get($(this).attr("url"),function(r){
			$("#content-right").empty().html(r);
		});
	});
});
</script>	