package cn.tendata.crm.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 产品
 * @author Administrator
 *
 */
@Entity
public class Product {
	/*
	 * 产品编号
	 */
	@Id
	@GeneratedValue
        private int pId;
        
        /*
    	 * 产品名称
    	 */
        private String pName;
        
        /*
    	 * 产品单价
    	 */
        private double unitPrice;
        
        /*
    	 * 产品颜色
    	 */
        private String color;
        
        /*
    	 * 产品材质
    	 */
        private String material;

		public int getpId() {
			return pId;
		}

		public void setpId(int pId) {
			this.pId = pId;
		}

		public String getpName() {
			return pName;
		}

		public void setpName(String pName) {
			this.pName = pName;
		}

		public double getUnitPrice() {
			return unitPrice;
		}

		public void setUnitPrice(double unitPrice) {
			this.unitPrice = unitPrice;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String getMaterial() {
			return material;
		}

		public void setMaterial(String material) {
			this.material = material;
		}
        
        
}
