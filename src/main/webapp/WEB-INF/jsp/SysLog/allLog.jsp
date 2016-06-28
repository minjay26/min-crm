<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<table class="table table-bordered">
			<thead>
				<tr>
					<th>日志序号</th><th>日志描述</th><th>日志时间</th>
				</tr>
			</thead>
			<tbody >
			<c:forEach var="ele" items="${logList }">
<tr>

	<td>${ele.num }</td>
	<td>${ele.logDesc }</td>
	<td>${ele.logTime }</td>
</tr>
</c:forEach>
			</tbody>

</table>
<nav>
	<ul class="pagination">
		<li><a href="javascript:void(0)" class="queryLogPage"
			url="log_getAll/${page-1}" aria-label="Previous"> <span
				aria-hidden="true">&laquo;</span>
		</a></li>
		<c:forEach var="i" begin="1" end="${pageSum}">
			<li ${i==page+1? "class=\"active\"" : "" }><a
				href="javascript:void(0)" class="queryLogPage"
				url="log_getAll/${i-1}">${i}</a></li>
		</c:forEach>
		<li><a href="javascript:void(0)" class="queryLogPage"
			url="log_getAll/${page+1}" aria-label="Next"> <span
				aria-hidden="true">&raquo;</span>
		</a></li>
	</ul>
</nav>
<script type="text/javascript">

$(".queryLogPage").each(function(i){
	$(this).click(function(){
		$.get($(this).attr("url"),function(r){
			$("#content-right").empty().html(r);
		});
	});
});
</script>	