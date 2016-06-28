package cn.tendata.crm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cn.tendata.crm.entities.Product;
public interface OrderDetailRepository extends JpaRepository<Product, Integer>{
     
	/**
	 * 通过注解@Query实现自定义查询语句，通过nativeQuery=true实现通过原生sql语句进行查询
	 * 该查询语句是订单表与多表内联进行查询，获得订单的详细信息,以Object集合形式返回
	 * @param page
	 * @param size
	 * @return
	 */
	@Query(value="select co.order_num, co.order_status,bp.price,bp.product_num,c.customer_name,e.username,p.p_name from crm_order co  INNER JOIN bought_product bp on bp.od_id=co.od_id INNER JOIN customer c on co.cs_id=c.cs_id  INNER JOIN User e on co.s_id=e.s_id INNER JOIN product p ON bp.p_id=p.p_id limit :page,:size",nativeQuery=true)
	public List<Object> getAll(@Param("page") Integer page,@Param("size") Integer size);
	
	/**
	 * 根据商品id获取当前商品总共销售数量
	 * @param pId
	 * @return
	 */
	@Query(value="select sum(bp.product_num), p.p_name from bought_product bp INNER JOIN product p on bp.p_id=p.p_id where bp.p_id=:pId",nativeQuery=true)
	public Object saleSumProduct(@Param("pId") int pId);
	
	/**
	 * 根据订单号查询订单详细信息
	 * @param orderNum
	 * @return
	 */
	@Query(value="select co.order_num, co.order_status,bp.price,bp.product_num,c.customer_name,e.username,p.p_name from crm_order co  INNER JOIN bought_product bp on bp.od_id=co.od_id INNER JOIN customer c on co.cs_id=c.cs_id  INNER JOIN User e on co.s_id=e.s_id INNER JOIN product p ON bp.p_id=p.p_id where co.order_num like %:orderNum% ",nativeQuery=true)
	public List<Object> searchByOrderNum(@Param("orderNum") String orderNum);
	
	/**
	 * 根据客户名查询订单详细信息
	 * @param orderNum
	 * @return
	 */
	@Query(value="select co.order_num, co.order_status,bp.price,bp.product_num,c.customer_name,e.username,p.p_name from crm_order co  INNER JOIN bought_product bp on bp.od_id=co.od_id INNER JOIN customer c on co.cs_id=c.cs_id  INNER JOIN User e on co.s_id=e.s_id INNER JOIN product p ON bp.p_id=p.p_id where c.customer_name like %:customerName%",nativeQuery=true)
	public List<Object> searchByCustomerName(@Param("customerName") String customerName);
	
	/**
	 * 根据销售人员名查询订单详细信息
	 * @param orderNum
	 * @return
	 */
	@Query(value="select co.order_num, co.order_status,bp.price,bp.product_num,c.customer_name,e.username,p.p_name from crm_order co  INNER JOIN bought_product bp on bp.od_id=co.od_id INNER JOIN customer c on co.cs_id=c.cs_id  INNER JOIN User e on co.s_id=e.s_id INNER JOIN product p ON bp.p_id=p.p_id where e.employee_name like %:employeeName%",nativeQuery=true)
	public List<Object> searchByEmployeeName(@Param("employeeName") String employeeName);
	
	/**
	 * 根据订单状态查询订单详细信息
	 * @param orderNum
	 * @return
	 */
	@Query(value="select co.order_num, co.order_status,bp.price,bp.product_num,c.customer_name,e.username,p.p_name from crm_order co  INNER JOIN bought_product bp on bp.od_id=co.od_id INNER JOIN customer c on co.cs_id=c.cs_id  INNER JOIN User e on co.s_id=e.s_id INNER JOIN product p ON bp.p_id=p.p_id where co.order_status like %:orderStatus%",nativeQuery=true)
	public List<Object> searchByOrderStatus(@Param("orderStatus") String orderStatus);
	
	/**
	 * 根据商品名查询订单详细信息
	 * @param orderNum
	 * @return
	 */
	@Query(value="select co.order_num, co.order_status,bp.price,bp.product_num,c.customer_name,e.username,p.p_name from crm_order co  INNER JOIN bought_product bp on bp.od_id=co.od_id INNER JOIN customer c on co.cs_id=c.cs_id  INNER JOIN User e on co.s_id=e.s_id INNER JOIN product p ON bp.p_id=p.p_id where p.p_name like %:pName%",nativeQuery=true)
	public List<Object> searchByPName(@Param("pName") String pName);
	
	/**
	 * 获取查询出的订单详细记录总条数
	 * @param orderNum
	 * @return
	 */
	@Query(value="select COUNT(*) from crm_order co  INNER JOIN bought_product bp on bp.od_id=co.od_id INNER JOIN customer c on co.cs_id=c.cs_id  INNER JOIN User e on co.s_id=e.s_id INNER JOIN product p ON bp.p_id=p.p_id",nativeQuery=true)
	public Integer sum();
}
