package cn.tendata.crm.service;

import java.util.List;

import org.springframework.data.domain.Page;

import cn.tendata.crm.entities.Product;

public interface ProductService {
 // List<Product> getAll();

  Product get(int pId);

void modify(Product product);

void remove(int pId);

void add(Product product);

Page<Product> getAllWithPage(Integer page,Integer size);
}
