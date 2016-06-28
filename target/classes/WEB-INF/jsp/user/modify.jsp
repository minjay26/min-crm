<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal fade" id="modify-dialog" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">
        	<span>&times;</span>
        </button>
        <h4 class="modal-title">修改员工信息</h4>
      </div>
      <div class="modal-body">
      	<input type="hidden" name="sId" id="sId" value="${ user.sId}"/>
		<div class="form-group">
			<input type="text" class="form-control" name="username" id="username" value="${ user.username}" />
		</div>
			<div class="form-group">
			<label class="radio-inline">
				<input type="radio" name="gender" value="女" 
					${ "女" eq user.gender ? "checked=\"checked\"" : ""} />女
			</label>
			<label class="radio-inline">
				<input type="radio" name="gender" value="男" 
					${ "男" eq user.gender ? "checked=\"checked\"" : ""}/>男
			</label>
		</div>
		<div class="form-group">
			<input type="text" class="form-control" name="account" id="account" value="${ user.account}" />
		</div>
		<div class="form-group">
			<input type="text" class="form-control" name="password" id="password" value="${ user.password}" />
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
        	var user = {sId: $("#modify-dialog #sId").val(), username: $("#modify-dialog #username").val()};
        	user.gender = $("#modify-dialog input[type='radio']:checked").val();
        	user.account = $("#account").val();
        	user.password = $("#password").val();

			
			
			//将数据投递到服务端
			$.post("user-modify", user, function(r){
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