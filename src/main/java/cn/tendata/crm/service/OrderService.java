package cn.tendata.crm.service;

import java.util.List;

import cn.tendata.crm.entities.CrmOrder;
import cn.tendata.crm.response.OrderDetailResponse;
import cn.tendata.crm.response.StatisticsOfSale;

public interface OrderService {
     List<OrderDetailResponse> getAllOrder(Integer page,Integer size);
     
     StatisticsOfSale get(int pId);
     
     List<OrderDetailResponse> search(String searchType,String searchContent);
     
     Integer sum();
}
