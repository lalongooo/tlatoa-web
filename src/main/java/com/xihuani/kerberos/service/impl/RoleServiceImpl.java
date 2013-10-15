package com.xihuani.kerberos.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xihuani.kerberos.service.RoleService;
import com.xihuani.kerberos.model.Role;
import com.xihuani.kerberos.model.User;

@Service
public class RoleServiceImpl implements RoleService {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public List<Role> getRoleList() {
		CriteriaQuery<Role> c = em.getCriteriaBuilder().createQuery(Role.class);
        c.from(Role.class);
        return em.createQuery(c).getResultList();
	}

	@Override
	@Transactional
	public void addRole(Role role) {
		em.persist(role);
	}

	@Override
	@Transactional
	public void deleteRole(Integer roleId) {
		Role role = em.find(Role.class, roleId);
        if (null != role) {
            em.remove(role);
        }
	}

	@Override
	@Transactional
	public List<Role> findRole(Integer []roleId) {
		CriteriaQuery<Role> criteria = em.getCriteriaBuilder().createQuery( Role.class );
		Root<Role> roleRoot = criteria.from( Role.class );
		criteria.select( roleRoot );
		Expression<String> exp = roleRoot.get( "id" );
		criteria.where( exp.in(roleId) );
        
        return em.createQuery( criteria ).getResultList();
	}
}
