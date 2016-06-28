package cn.tendata.crm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cn.tendata.crm.entities.Product;

public interface LogRepository extends JpaRepository<Product, Integer>{
	
	/**
	 * 通过注解@Query实现自定义查询语句，通过nativeQuery=true实现通过原生sql语句进行查询
	 * @param page
	 * @param size
	 * @return
	 */
	@Query(value="select event_id, timestmp,formatted_message   from logging_event limit :page,:size",nativeQuery=true)
     public List<Object> getAllLog(@Param("page") Integer page,@Param("size") Integer size);
	
	@Query(value="select COUNT(*) from logging_event",nativeQuery=true)
	public Integer sum();
}  
