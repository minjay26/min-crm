<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
	<style type="text/css">
	 li{
	   list-style: none;
	 }
	
	</style>
<ul id="menu">
	<li><a href="javascript:void(0)" url="department_getAll">部门管理</a></li>
	<li><a href="javascript:void(0)" url="allCustomerWithPage/0">客户管理</a></li>
	<li><a href="javascript:void(0)" url="allProductWithPage/0">产品管理</a></li>
	<li><a href="javascript:void(0)" url="order_getAll/0">订单查询</a></li>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<li><a href="javascript:void(0)" url="log_getAll/0">查看系统日志</a></li>
		<li><a href="reimbursement">财务报销管理</a></li>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_USER')">
	    <li><a href="personReimbursement">个人财务报销</a></li>
	</sec:authorize>
</ul>
	<script type="text/javascript">
		//$(document).ready(function(){ 
			//$("a").each(
					//function(index) {
						//$(this).click(
								//function() {
									//$.get($(this).attr("url"),function(r){
										//$("#content-right").empty().html(r);
									//});
									
								//});
					//});	
			
			
		// });	
		
	</script>
