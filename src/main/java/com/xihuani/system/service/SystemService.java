package com.xihuani.system.service;

import java.util.List;

import com.xihuani.system.model.Role;
import com.xihuani.system.model.System;

public interface SystemService {
	List<System> getSystemList();
	System findSystem(Integer systemId);
	void addSystem(System system);
	void save(System system);
	List<Role> getSystemRoles(Integer systemId);
	void addRole(Integer systemId, Role role);
	void deleteRole(Integer systemId, Integer roleId);
}
