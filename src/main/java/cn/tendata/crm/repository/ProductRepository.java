package cn.tendata.crm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import cn.tendata.crm.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
     Page<Product> findAll(Pageable pageable);
}
