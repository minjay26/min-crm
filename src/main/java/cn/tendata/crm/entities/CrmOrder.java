package cn.tendata.crm.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 订单
 * @author Administrator
 *
 */
@Entity
public class CrmOrder{
	/*
	 * 订单编号
	 */
	@Id
	@GeneratedValue
      private int odId;
      
      /*
  	 * 订单客户
  	 */

	  
      private int csId ;
     
      /*
  	 * 订单销售人员
  	 */		
      private int sId;
 
      /*
  	 * 订单状态
  	 */
      private String orderStatus;

	public int getOdId() {
		return odId;
	}

	public void setOdId(int odId) {
		this.odId = odId;
	}

	public int getCsId() {
		return csId;
	}

	public void setCsId(int csId) {
		this.csId = csId;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}



	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
      
      
    
}
