package cn.tendata.crm.service;

import java.util.List;

import org.springframework.data.domain.Page;

import cn.tendata.crm.entities.Customer;

public interface CustomerService {
    List<Customer> getAll();
    
    void add(Customer customer);
    
    Customer get(int csId);
    
    void modify(Customer customer);
    
    List<Customer> search(String customerName);
    
    Page<Customer> getAllWithPage(Integer page,Integer pageSize);
}
