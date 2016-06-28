package cn.tendata.crm.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 已购买的商品类
 * @author Administrator
 *
 */
@Entity
public class BoughtProduct {
	
	@Id
	@GeneratedValue
	private int bpId;
	/*
	 * 对应商品id
	 */
     private int pId;
     
     /*
 	 * 所属订单id
 	 */
      private int odId;
      
      /*
  	 * 购买该商品的数量
  	 */
       private int productNum;

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public int getOdId() {
		return odId;
	}

	public void setOdId(int odId) {
		this.odId = odId;
	}

	public int getProductNum() {
		return productNum;
	}

	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}
       
       
}
