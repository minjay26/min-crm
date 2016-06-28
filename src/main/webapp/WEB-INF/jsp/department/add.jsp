<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal fade" id="add-dialog" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">
        	<span>&times;</span>
        </button>
        <h4 class="modal-title">增加部门</h4>
      </div>
      <div class="modal-body">
        <div class="form-group">
        	<input type="text" name="dpName" id="dpName" class="form-control" placeholder="部门名"/>
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
        	var department = {dpName: $("#add-dialog #dpName").val()};       	
        
			//将数据投递到服务端
			$.post("department-add", department, function(r){
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