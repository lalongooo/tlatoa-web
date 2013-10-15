package com.xihuani.kerberos.service;

import java.util.List;

import com.xihuani.kerberos.model.Role;

public interface RoleService {
	public List<Role> getRoleList();
	public void addRole(Role user);
	public void deleteRole(Integer rolesId);
	public List<Role> findRole(Integer []roleId);
}
