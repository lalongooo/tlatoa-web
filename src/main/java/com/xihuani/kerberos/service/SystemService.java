package com.xihuani.kerberos.service;

import java.util.List;

import com.xihuani.kerberos.model.Role;
import com.xihuani.kerberos.model.System;

public interface SystemService {
	List<System> getSystemList();
	System findSystem(Integer systemId);
	void addSystem(System system);
	void save(System system);
	List<Role> getSystemRoles(Integer systemId);
	void addRole(Integer systemId, Role role);
	void deleteRole(Integer systemId, Integer roleId);
}
