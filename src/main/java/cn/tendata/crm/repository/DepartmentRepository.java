package cn.tendata.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.tendata.crm.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{
    Department findByDpName(String dpName);
}
