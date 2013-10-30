package com.xihuani.tlatoa.service.impl;

import java.util.ArrayList;
import java.util.List;

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
        	s.getResources().add(resource);
        	resource.setSentence(s);
        }
       em.merge(s);
	}
	
	@Override
	@Transactional
	public List<Resource> listResource(Integer sentenceId) {
		Sentence s = em.find(Sentence.class, sentenceId);
        if (null != s) {
        	return new ArrayList<Resource>(s.getResources());
        }
        
        return null;
	}

}
