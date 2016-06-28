<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal fade" id="add-dialog" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">
        	<span>&times;</span>
        </button>
        <h4 class="modal-title">产品销售统计</h4>
      </div>
      <div class="modal-body">
        <div class="form-group">
        	<input type="text" name="pName" id="pName" class="form-control" value="目前已销售：${statisticsOfSale.num }" readonly="readonly"/>
        </div>       
        <script type="text/javascript">
        $("#add-dialog").modal('show');           
        </script>
      </div>
    </div>
  </div>
</div>