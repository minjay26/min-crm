<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal fade" id="modify-dialog" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">
        	<span>&times;</span>
        </button>
        <h4 class="modal-title">修改客户信息</h4>
      </div>
      <div class="modal-body">
      	<input type="hidden" name="csId" id="csId" value="${ currentCustomer.csId}"/>
		<div class="form-group">
			<input type="text" class="form-control" name="customerName" id="customerName" value="${ currentCustomer.customerName}" placeholder="客户姓名" title="客户姓名"/>
		</div>
		<div class="form-group">
			<label class="radio-inline">
				<input type="radio" name="gender" value="女" 
					${ "女" eq currentCustomer.gender ? "checked=\"checked\"" : ""} />女
			</label>
			<label class="radio-inline">
				<input type="radio" name="gender" value="男" 
					${ "男" eq currentCustomer.gender ? "checked=\"checked\"" : ""}/>男
			</label>
		</div>
		<div class="form-group">
			<input type="text" class="form-control" name="company" value="${ currentCustomer.company}" id="company" placeholder="公司" title="公司"/>
		</div>
		<div class="form-group">
			<input type="text" class="form-control" name="type" value="${ currentCustomer.type}" id="type" placeholder="类型" title="类型"/>
		</div>
		<div class="form-group">
			<input type="text" class="form-control" name="address" value="${ currentCustomer.address}" id="address" placeholder="地址" title="地址"/>
		</div>
		<div class="form-group">
			<input type="text" class="form-control" name="phone" value="${ currentCustomer.phone}" id="phone" placeholder="电话号码" title="电话号码"/>
		</div>
		<div class="form-group">
			<input type="text" class="form-control" name="sId" value="${ currentCustomer.sId}" id="sId" placeholder="负责人" title="负责人"/>
		</div>
		<div class="form-group">
			<input type="text" class="form-control" name="joinTime" value="${ currentCustomer.joinTime}" id="joinTime" placeholder="加入时间" title="加入时间"/>
		</div>
		<div class="form-group">
			<span id="message" class="text-danger"></span>
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary" id="save">保存</button>
        
        <script type="text/javascript">
        $("#modify-dialog").modal('show');
        
        $("#modify-dialog .modal-footer>#save").click(function(){        	
        	var customer = {csId: $("#modify-dialog #csId").val(), customerName: $("#modify-dialog #customerName").val()};
        	customer.company = $("#company").val();
        	customer.type = $("#type").val();
        	customer.address = $("#address").val();
        	customer.phone = $("#phone").val();
        	customer.sId = $("#sId").val();
        	customer.joinTime = $("#joinTime").val();
        	customer.gender = $("#modify-dialog input[type='radio']:checked").val();
			
			
			//将数据投递到服务端
			$.post("customer-modify", customer, function(r){
				var obj = window.eval("(" + r + ")");//将JSON格式的字符串转换成JSON对象
				
				if(obj && obj.result){
					$("#message").text(obj.message);												
				}
			});
        });
        </script>
      </div>
    </div>
  </div>  
</div>