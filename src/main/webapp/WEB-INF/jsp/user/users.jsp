<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<input type="hidden" value="${currentDpId}" id="currentDpId" />
<c:choose>
	<c:when test="${isExist==true}">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>姓名</th>
					<th>账号</th>
					<th>性别</th>
					<th>密码</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="ele" items="${usersOfSameDpId }">
					<tr>
						<td>${ele.username }</td>
						<td>${ele.account }</td>
						<td>${ele.gender }</td>
						<td>${ele.password }</td>

						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<td><a href="javascript:void(0);"
								url="user-modify/${ele.sId}" class="user-modify"><span
									class="glyphicon glyphicon-edit">修改</span></a> <a
								href="javascript:void(0);" class="user-remove"
								url="remove/${ele.sId }"><span
									class="glyphicon glyphicon-remove">删除</span></a></td>
						</sec:authorize>

					</tr>
				</c:forEach>
			</tbody>
		</table>
<nav>
  <ul class="pagination">
    <li>
      <a href="javascript:void(0)" class="queryUserPage" url="department_users/${page-1}/${currentDpId}" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <c:forEach var="i" begin="1" end="${pageSum}">
    <li ${i==page+1? "class=\"active\"" : "" }><a href="javascript:void(0)" class="queryUserPage" url="department_users/${i-1}/${currentDpId}">${i}</a></li>
    </c:forEach>
    <li>
      <a href="javascript:void(0)" class="queryUserPage" url="department_users/${page+1}/${currentDpId}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
		<br>
	</c:when>
	<c:otherwise>
  无该部门员工信息
 </c:otherwise>
</c:choose>
<sec:authorize access="hasRole('ROLE_ADMIN')">
	<a href="javascript:void(0)" id="addUser">增加员工信息</a>
</sec:authorize>
<div id="showUser">
	
</div>
<script type="text/javascript">
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

	$(".queryUserPage").each(function(i) {
		$(this).click(function() {
			$.get($(this).attr("url"), function(r) {
				$("#showDepartment").empty().html(r);
			});
		});
	});
</script>