package cn.tendata.crm.service;

import java.util.List;

import cn.tendata.crm.entities.Department;

public interface DepartmentService {
       List<Department> getAll();
       
       Department getByDp_name(String dpName);
       
       Department get(int dpId);
       
       void modify(Department department);
       void remove(int dpId);
       
       void add(Department department);
}
