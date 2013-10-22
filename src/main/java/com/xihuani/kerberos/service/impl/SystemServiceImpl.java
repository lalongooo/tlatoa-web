package com.xihuani.kerberos.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xihuani.kerberos.model.Role;
import com.xihuani.kerberos.model.System;
import com.xihuani.kerberos.service.SystemService;

@Service
public class SystemServiceImpl implements SystemService {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public List<System> getSystemList() {
		CriteriaQuery<System> c = em.getCriteriaBuilder().createQuery(System.class);
        c.from(System.class);
        return em.createQuery(c).getResultList();
	}
	
	@Override
	@Transactional
	public System findSystem(Integer systemId) {
		return em.find(System.class, systemId);
	}
	
	@Override
	@Transactional
	public void addSystem(System system) {
		em.persist(system);
	}

	@Override
	@Transactional
	public void save(System system) {
		em.merge(system);
	}

	@Override
	@Transactional
	public List<Role> getSystemRoles(Integer systemId) {
		System system = this.findSystem(systemId);
		return new ArrayList(system.getRoles());
	}
	
	@Override
	@Transactional
	public void addRole(Integer systemId, Role role) {
		System system = this.findSystem(systemId);
		system.getRoles().add(role);
		this.save(system);
	}

	@Override
	@Transactional
	public void deleteRole(Integer systemId, Integer roleId) {
		System system = this.findSystem(systemId);
		Set<Role> roles = new HashSet<Role>();
		for(Role role: system.getRoles()) {
			if(role.getId() != roleId)
				roles.add(role);
		}
		this.save(system);
	}
}
