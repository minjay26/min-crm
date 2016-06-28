<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal fade" id="add-dialog" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">
        	<span>&times;</span>
        </button>
        <h4 class="modal-title">增加产品信息</h4>
      </div>
      <div class="modal-body">
        <div class="form-group">
        	<input type="text" name="pName" id="pName" class="form-control" placeholder="产品名"/>
        </div>
        <div class="form-group">
        	<input type="text" name="unitPrice" id="unitPrice" class="form-control" placeholder="产品单价"/>
        </div>     
        <div class="form-group">
        	<input type="text" name="color" id="color" class="form-control" placeholder="产品颜色"/>
        </div>
        <div class="form-group">
        	<input type="text" name="material" id="material" class="form-control" placeholder="产品材质"/>
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
        	var product = {pName: $("#add-dialog #pName").val(), unitPrice: $("#add-dialog #unitPrice").val()};       	
        	product.color = $("#add-dialog #color").val();
        	product.material=$("#add-dialog #material").val();
			//将数据投递到服务端
			$.post("product-add", product, function(r){
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