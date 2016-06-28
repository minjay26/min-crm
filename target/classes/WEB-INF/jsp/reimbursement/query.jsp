<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<table class="table table-bordered">
	<thead>
		<tr>
		 <th>报销序号</th><th>申请报销人</th><th>报销金额</th><th>报销缘由</th><th>报销申请时间</th><th>报销状态</th><th>报销审核人</th><th>报销审核时间</th>
		</tr>
	</thead>
	  <tbody>
		<c:forEach var="ele" items="${list}">
          <tr>	
	         <td>${ele.rbId }</td>
	         <td>${ele.applicant.username }</td>
	         <td>${ele.amount }</td>
	         <td>${ele.reason }</td>
	         <td>${ele.creatTime }</td>
	         <td>${ele.status }</td>
	         <td>${ele.checkUser==null?"-":ele.checkUser.username}</td>
	         <td>${ele.checkTime==null?"-":ele.checkTime}</td>
	         <td>
	           <a href="javascript:void(0)" class="check" url="checkPass/${ele.rbId}/0">审核通过</a>
	           <a href="javascript:void(0)" class="check" url="checkPass/${ele.rbId}/1">无法报批</a>
	         </td>
         </tr>
       </c:forEach>
	 </tbody> 	 
    </table>
   <nav>
  <ul class="pagination">
    <li>
      <a href="javascript:void(0)" class="${url}" url="${url}/${page-1}" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <c:forEach var="i" begin="1" end="${pageSum}">
    <li ${i==page+1? "class=\"active\"" : "" }><a href="javascript:void(0)" class="${url}" url="${url}/${i-1}">${i}</a></li>
    </c:forEach>
    <li>
      <a href="javascript:void(0)" class="${url}" url="${url}/${page+1}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
    <script type="text/javascript">
    $(".check").each(function(i){
    	$(this).click(function(){
    		if(window.confirm("确认审核？")){
    			$.get($(this).attr("url"), function(r){
    				var obj = window.eval("(" + r + ")");						
    				alert(obj.message);					
    			});
    		}
    	});
    });
    
    $(".queryReimbursementPage").each(function(i){
    	$(this).click(function(){
    		$.get($(this).attr("url"),function(r){
    			$("#showMsg").empty().html(r);
    		});
    	});
    });
    </script>