package cn.tendata.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tendata.crm.entities.SysRole;
import cn.tendata.crm.repository.SysRoleRepository;

@Service
public class SysRoleServiceImpl implements SysRoleService{
	
	@Autowired
	private SysRoleRepository sysRoleRepository;

	@Override
	public SysRole get(int id) {
		return sysRoleRepository.findOne(id);
	}

}
