package com.xihuani.kerberos.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xihuani.kerberos.service.UserService;
import com.xihuani.kerberos.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public List<User> getUserList() {
		CriteriaQuery<User> c = em.getCriteriaBuilder().createQuery(User.class);
        c.from(User.class);
        return em.createQuery(c).getResultList();
	}
	
	@Override
	@Transactional
	public User findUser(int userId) {
		return em.find(User.class, userId);
	}

	@Override
	@Transactional
	public void addUser(User user) {
		em.persist(user);
	}

	@Override
	@Transactional
	public void deleteUser(Integer userId) {
		User user = em.find(User.class, userId);
        if (null != user) {
            em.remove(user);
        }
	}
	
	@Override
	@Transactional
	public void save(User user) {
		em.merge(user);
	}

}
