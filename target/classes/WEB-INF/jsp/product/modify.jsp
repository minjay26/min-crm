<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal fade" id="modify-dialog" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">
        	<span>&times;</span>
        </button>
        <h4 class="modal-title">修改产品信息</h4>
      </div>
      <div class="modal-body">
      	<input type="hidden" name="pId" id="pId" value="${ currentProduct.pId}"/>
		<div class="form-group">
			<input type="text" class="form-control" name="pName" id="pName" value="${ currentProduct.pName}" placeholder="产品名" title="产品名"/>
		</div>		
		<div class="form-group">
			<input type="text" class="form-control" name="unitPrice" value="${ currentProduct.unitPrice}" id="unitPrice" placeholder="产品单价" title="产品单价"/>
		</div>
		<div class="form-group">
			<input type="text" class="form-control" name="color" value="${ currentProduct.color}" id="color" placeholder="产品颜色" title="产品颜色"/>
		</div>
		<div class="form-group">
			<input type="text" class="form-control" name="material" value="${ currentProduct.material}" id="material" placeholder="产品材质" title="产品材质"/>
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
        	var product = {pId: $("#modify-dialog #pId").val(), pName: $("#modify-dialog #pName").val()};
        	product.unitPrice = $("#unitPrice").val();
        	product.color = $("#color").val();
        	product.material = $("#material").val();
     
        	
			
			
			//将数据投递到服务端
			$.post("product-modify", product, function(r){
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