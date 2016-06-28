<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal fade" id="modify-dialog" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">
        	<span>&times;</span>
        </button>
        <h4 class="modal-title">修改部门信息</h4>
      </div>
      <div class="modal-body">
      	<input type="hidden" name="dpId" id="dpId" value="${ currentDepartment.dpId}"/>
		<div class="form-group">
			<input type="text" class="form-control" name="dpName" id="dpName" value="${ currentDepartment.dpName}" placeholder="部门名称" title="部门名称"/>
		</div>
		<div class="form-group">
			<input type="text" class="form-control" name="numOfEmployess" value="${ currentDepartment.numOfEmployess}" id="numOfEmployess" placeholder="部门人数" title="部门人数"/>
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
        	var department = {dpId: $("#modify-dialog #dpId").val(), dpName: $("#modify-dialog #dpName").val()};
        	department.numOfEmployess = $("#numOfEmployess").val();
			
			
			//将数据投递到服务端
			$.post("department-modify", department, function(r){
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