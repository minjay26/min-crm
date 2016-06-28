package cn.tendata.crm.response;

/**
 * 订单详细类
 * @author Administrator
 *
 */
public class OrderDetailResponse {
	/**
	 * 订单号
	 */
	private String orderNum;
    
	/**
	 * 订单客户名
	 */
	private String customerName;
    
	/**
	 * 订单销售职工名
	 */
	private String employeeName;
	
	/**
	 * 订单总价钱
	 */
	private double totalPrice;
	
	/**
	 * 订单状态
	 */
	private String orderStatus;
	
	/**
	 * 订单购买商品数量
	 */
	private int productNum;
	
	/**
	 * 订单购买商品名
	 */
	private String pName;

	
	
	
	
	
	
	public OrderDetailResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

   

	public OrderDetailResponse(String orderNum, String customerName, String employeeName, double totalPrice,
			String orderStatus, int productNum, String pName) {
		super();
		this.orderNum = orderNum;
		this.customerName = customerName;
		this.employeeName = employeeName;
		this.totalPrice = totalPrice;
		this.orderStatus = orderStatus;
		this.productNum = productNum;
		this.pName = pName;
	}



	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getProductNum() {
		return productNum;
	}

	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}



	public String getOrderNum() {
		return orderNum;
	}



	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	
	
	
}
