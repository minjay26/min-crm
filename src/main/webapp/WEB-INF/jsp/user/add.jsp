<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal fade" id="add-dialog" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">
        	<span>&times;</span>
        </button>
        <h4 class="modal-title">增加员工</h4>
      </div>
      <div class="modal-body">
        <div class="form-group">
        	<input type="text" name="username" id="username" class="form-control" placeholder="员工姓名"/>
        	<input type="hidden" name="currentDpId" id="currentDpId" value="${currentDpId }"/>
        </div>
        <div class="form-group">
        	<input type="text" name="account" id="account" class="form-control" placeholder="员工账号"/>
        </div>
        <div class="form-group">
        	<div class="radioGender">
        	<label><input type="radio" name="gender" value="女"/>女</label>
			<label><input type="radio" name="gender" value="男"/>男</label>
			</div>
        </div>
        <div class="form-group">
        	<input type="password" name="password" id="password" class="form-control" placeholder="账号密码"/>
        </div>
        <div class="form-group">
        	<div class="radioRole">
        	<label><input type="radio" name="role" value=1 />管理员</label>
			<label><input type="radio" name="role" value=2 />普通职工</label>
			</div>
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
        	var user = {username: $("#add-dialog #username").val(), account: $("#add-dialog #account").val()};
        	user.gender = $("#add-dialog .radioGender input[type='radio']:checked").val();
        	user.password = $("#add-dialog #password").val();
        	user.dpId=$("#add-dialog #currentDpId").val();
        	var roleId = $("#add-dialog .radioRole input[type='radio']:checked").val();
			//将数据投递到服务端
			$.post("user-add?roleId="+roleId,user,function(r){
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