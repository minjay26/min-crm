package cn.tendata.crm.response;

/**
 * 商品销售统计类
 * @author Administrator
 *
 */
public class StatisticsOfSale {
	
	/**
	 * 商品名
	 */
      private String pName;
     
      /**
       * 销售数量
       */
      private int num;

	public StatisticsOfSale() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StatisticsOfSale(String pName, int num) {
		super();
		this.pName = pName;
		this.num = num;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
      
      
}
