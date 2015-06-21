package com.xihuani.system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xihuani.system.model.Role;

@Service
public interface RoleService {
	public List<Role> getRoleList();
	public void addRole(Role user);
	public void deleteRole(Integer rolesId);
	public List<Role> findRole(Integer []roleId);
}
