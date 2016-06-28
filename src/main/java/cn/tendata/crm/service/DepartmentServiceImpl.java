package cn.tendata.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tendata.crm.entities.Department;
import cn.tendata.crm.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public List<Department> getAll() {		
		return this.departmentRepository.findAll();
	}
	
	@Override
	public Department getByDp_name(String dpName) {		
		return this.departmentRepository.findByDpName(dpName);
	}

	@Override
	public Department get(int dpId) {
		return this.departmentRepository.findOne(dpId);
	}

	@Override
	public void modify(Department department) {
		System.out.println(department.getDpId());
	this.departmentRepository.save(department);
		
	}

	@Override
	public void remove(int dpId) {
		this.departmentRepository.delete(dpId);
		
	}

	@Override
	public void add(Department department) {
		this.departmentRepository.save(department);
		
	}

}
