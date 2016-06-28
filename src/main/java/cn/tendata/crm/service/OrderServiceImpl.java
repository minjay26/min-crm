package cn.tendata.crm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tendata.crm.repository.OrderDetailRepository;
import cn.tendata.crm.response.OrderDetailResponse;
import cn.tendata.crm.response.StatisticsOfSale;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDetailRepository orderDetailRepository;

	@Override
	public List<OrderDetailResponse> getAllOrder(Integer page,Integer size) {
		List<OrderDetailResponse> list = new ArrayList<OrderDetailResponse>();
		List<Object> objects = this.orderDetailRepository.getAll(page,size);
		for (Object object : objects) {
			Object[] item = (Object[]) object;//每一个Object都可以是一个数据库中查询的一条记录中所有属性的数组
			OrderDetailResponse od = new OrderDetailResponse();
			od.setCustomerName(String.valueOf(item[4]));//将数组中与OrderDetailResponse对象相对应的属性set进去，即获得一个OrderDetailResponse实例对象
			od.setEmployeeName(String.valueOf(item[5]));
			od.setOrderStatus(String.valueOf(item[1]));
			od.setpName(String.valueOf(item[6]));
			od.setProductNum((Integer) item[3]);
			od.setTotalPrice((Double) item[2]);
			od.setOrderNum(String.valueOf(item[0]));
			list.add(od);
		}
		return list;
	}
   
	/**
	 * 根据商品id统计该商品销售数量
	 */
	@Override
	public StatisticsOfSale get(int pId) {
		StatisticsOfSale statisticsOfSale = new StatisticsOfSale();
		Object[] object = (Object[]) this.orderDetailRepository.saleSumProduct(pId);
        
		if (null == object[0]) {
			statisticsOfSale.setNum(0);//如果获得的记录为0，则销售量为0
		} else {
			statisticsOfSale.setNum(Integer.valueOf(object[0].toString()));
		}
		statisticsOfSale.setpName(String.valueOf(object[1]));
		return statisticsOfSale;
	}
   
	/**
	 * 根据不同的搜索内容类型进行搜索
	 */
	@Override
	public List<OrderDetailResponse> search(String searchType, String searchContent) {
		List<OrderDetailResponse> list = new ArrayList<OrderDetailResponse>();
		List<Object> objects = null;
		switch (searchType) {
		case "订单号":
			System.out.println(searchContent);
			objects = this.orderDetailRepository.searchByOrderNum(searchContent);
			break;

		case "订单用户名":
			objects = this.orderDetailRepository.searchByCustomerName(searchContent);
			break;

		case "销售人员名":
			objects = this.orderDetailRepository.searchByEmployeeName(searchContent);
			break;

		case "商品名":
			objects = this.orderDetailRepository.searchByPName(searchContent);
			break;

		case "已支付":

			searchContent = "已支付";
			objects = this.orderDetailRepository.searchByOrderStatus(searchContent);
			break;
		case "未支付":
			searchContent = "未支付";
			objects = this.orderDetailRepository.searchByOrderStatus(searchContent);
			break;
		}
		if (null == objects) {
			return list;
		}
		for (Object object : objects) {
			Object[] item = (Object[]) object;
			OrderDetailResponse od = new OrderDetailResponse();
			od.setCustomerName(String.valueOf(item[4]));
			od.setEmployeeName(String.valueOf(item[5]));
			od.setOrderStatus(String.valueOf(item[1]));
			od.setpName(String.valueOf(item[6]));
			od.setProductNum((Integer) item[3]);
			od.setTotalPrice((Double) item[2]);
			od.setOrderNum(String.valueOf(item[0]));
			list.add(od);
		}
		return list;
	}

	@Override
	public Integer sum() {
		return this.orderDetailRepository.sum();
	}

}
