package com.xihuani.tlatoa.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xihuani.tlatoa.model.Resource;
import com.xihuani.tlatoa.model.Sentence;
import com.xihuani.tlatoa.service.ResourceService;

@Service
public class ResourceServiceImpl implements ResourceService {

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	@Transactional
	public List<Sentence> listSentences() {
		CriteriaQuery<Sentence> c = em.getCriteriaBuilder().createQuery(Sentence.class);
		Root<Sentence> roleRoot = c.from( Sentence.class );
		return em.createQuery(c).getResultList();
	}
	
	@Override
	@Transactional
	public List<Sentence> search(String sentence) {
		CriteriaQuery<Sentence> c = em.getCriteriaBuilder().createQuery(Sentence.class);
		Root<Sentence> roleRoot = c.from( Sentence.class );
		c.select( roleRoot );
		Expression<String> exp = roleRoot.get( "sentence_name" );
		Predicate r = em.getCriteriaBuilder().like(exp, sentence);
		c.where( r );		
		return em.createQuery(c).getResultList();
	}

	@Override
	@Transactional
	public void addSentence(Sentence sentence) {
		em.persist(sentence);
	}
	
	@Override
	@Transactional
	public void saveSentence(Sentence sentence) {
		em.merge(sentence);
	}

	@Override
	@Transactional
	public void deleteSentence(Integer sentenceId) {
		Sentence s = em.find(Sentence.class, sentenceId);
        if (null != s) {
            em.remove(s);
        }
	}
	
	@Override
	@Transactional
	public void addResource(Integer sentenceId, Resource resource) {
		Sentence s = em.find(Sentence.class, sentenceId);
        if (null != s) {
        	resource.setSequenceOrder(s.getResources().size());
        	s.getResources().add(resource);
        	resource.setSentence(s);
        }
       em.merge(s);
	}
	
	@Override
	@Transactional
	public void removeResource(Integer sentenceId, Integer resourceId) {
		Sentence s = em.find(Sentence.class, sentenceId);
        if (null != s) {
        	List<Resource> resources = s.getResources();
        	for(int i = 0; i < resources.size(); i++) {
        		Resource r = resources.get(i); 
        		if(r.getResourceId() == resourceId){
        			resources.remove(i);
        			em.remove(r);
        		}
        	}
        }
	}
	
	@Override
	@Transactional
	public void sortResource(Integer sentenceId, Integer []resourceId) {
		Sentence s = em.find(Sentence.class, sentenceId);
        if (null != s) {
        	List<Resource> resources = s.getResources();
        	ListIterator<Resource> it = resources.listIterator();
        	while(it.hasNext()) {
        		Resource r = it.next();
        		for(int i = 0; i < resourceId.length; i++) {
        			if(resourceId[i] == r.getResourceId()) {
        				r.setSequenceOrder(i);
        			}
        		}
        	}
        }
        em.merge(s);
	}
	
	@Override
	@Transactional
	public List<Resource> listResource(Integer sentenceId) {
		Sentence s = em.find(Sentence.class, sentenceId);
        if (null != s) {
        	return s.getResources();
        }
        
        return null;
	}

}
