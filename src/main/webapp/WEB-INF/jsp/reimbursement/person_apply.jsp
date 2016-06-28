<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal fade" id="add-dialog" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">
        	<span>&times;</span>
        </button>
        <h4 class="modal-title">申请报销</h4>
      </div>
      <div class="modal-body">
        <div class="form-group">
        	<input type="text" name="amount" id="amount" class="form-control" placeholder="报销金额"/>
        </div>
        <div class="form-group">
        	<input type="text" name="reason" id="reason" class="form-control" placeholder="报销缘由"/>
        </div>     
        <div class="form-group">
        	<span id="message" ></span>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary" id="save">提交申请</button>
        
        <script type="text/javascript">
        $("#add-dialog").modal('show');
        
        $("#add-dialog .modal-footer>#save").click(function(){
        	var queryReimbursement = {amount: $("#add-dialog #amount").val(), reason: $("#add-dialog #reason").val()};       	
        	
			//将数据投递到服务端
			$.post("person_apply", queryReimbursement, function(r){
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