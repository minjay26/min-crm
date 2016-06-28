package cn.tendata.crm.controllers;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.classic.Logger;
import cn.tendata.crm.controllers.util.GetCurrentInfo;
import cn.tendata.crm.response.OrderDetailResponse;
import cn.tendata.crm.response.StatisticsOfSale;
import cn.tendata.crm.service.OrderService;
/**
 * 订单控制类
 * @author Administrator
 *
 */
@Controller
public class OrderController {
	private static final Logger LOGGER=(Logger) LoggerFactory.getLogger(LoginController.class);
    @Autowired
	private OrderService orderService;
    
    /**
	 * 自动注入当前登录用户信息组件
	 */
    @Autowired
    private GetCurrentInfo currentInfo;
    
	@RequestMapping("/order_getAll/{page}")
	public String getAllOrder(@PathVariable("page")Integer page,ModelMap map){
		int sum=this.orderService.sum();//获取订单所有记录条数
		int pageSum=sum/5+1;
		List<OrderDetailResponse> allOrder=this.orderService.getAllOrder(page*5,5);	//默认分页每页显示五条记录	
		map.addAttribute("allOrder", allOrder);
		map.addAttribute("pageSum", pageSum);
		map.addAttribute("page", page);
		return "/sale/allOrder";		
	}
	
	/**
	 * 根据所有订单统计每件商品的销售数量
	 * 从订单中商品id，商品数量求得所有商品销售数量
	 * @param pId
	 * @param map
	 * @return
	 */
	@RequestMapping("/product_statistics/{pId}")
	public String  getStatistics(@PathVariable("pId")int pId,ModelMap map){
		StatisticsOfSale statisticsOfSale=this.orderService.get(pId);
		map.addAttribute("statisticsOfSale", statisticsOfSale);	
		return "/sale/product_statistics";
	}
	
	/**
	 * 根据搜索内容的类型搜索
	 * 类型：商品名，客户名，销售人员名等
	 * @param searchType
	 * @param searchContent
	 * @param map
	 * @return
	 */
	@RequestMapping("/search_order")
	public String search(String searchType,String searchContent,ModelMap map){
		List<OrderDetailResponse> searchOrders=this.orderService.search(searchType, searchContent);
		if (null==searchOrders) {
			return null;
		}
		map.addAttribute("allOrder", searchOrders);
		return "/sale/allOrder";
		
		
	}
}
