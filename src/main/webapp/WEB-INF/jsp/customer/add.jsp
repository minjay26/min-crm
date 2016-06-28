<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal fade" id="add-dialog" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">
        	<span>&times;</span>
        </button>
        <h4 class="modal-title">增加客户信息</h4>
      </div>
      <div class="modal-body">
        <div class="form-group">
        	<input type="text" name="customerName" id="customerName" class="form-control" placeholder="客户姓名"/>
        </div>
        <div class="form-group">
        	<input type="text" name="company" id="company" class="form-control" placeholder="所属公司"/>
        </div>
        <div class="form-group">
        	<div class="radioGender">
        	<label><input type="radio" name="gender" value="女"/>女</label>
			<label><input type="radio" name="gender" value="男"/>男</label>
			</div>
        </div>
        <div class="form-group">
        	<input type="text" name="address" id="address" class="form-control" placeholder="地址"/>
        </div>
        <div class="form-group">
        	<input type="text" name="phone" id="phone" class="form-control" placeholder="电话号码"/>
        </div>
        <div class="form-group">
        	<input type="text" name="type" id="type" class="form-control" placeholder="客户类型"/>
        </div>
      
        <div class="form-group">
        	<input type="date" name="joinTime" id="joinTime" class="form-control" placeholder="加入时间"/>
        </div>
      
        <div class="form-group">
        	<span id="message" ></span>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary" id="save">保存</button>
        
        <script type="text/javascript">
        $("#add-dialog").modal('show');
        
        $("#add-dialog .modal-footer>#save").click(function(){
        	var customer = {customerName: $("#add-dialog #customerName").val(), company: $("#add-dialog #company").val()};
        	customer.gender = $("#add-dialog .radioGender input[type='radio']:checked").val();
        	customer.address = $("#add-dialog #address").val();
        	customer.phone=$("#add-dialog #phone").val();
        	customer.type = $("#add-dialog #type").val();
        	customer.joinTime =$("#add-dialog #joinTime").val();
			
			//将数据投递到服务端
			$.post("customer-add", customer, function(r){
				var obj = window.eval("(" + r + ")");			
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