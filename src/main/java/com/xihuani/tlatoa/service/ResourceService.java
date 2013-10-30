package com.xihuani.tlatoa.service;

import java.util.List;
import java.util.Set;

import com.xihuani.tlatoa.model.Resource;
import com.xihuani.tlatoa.model.Sentence;

public interface ResourceService {
	public List<Sentence> listSentences();
	public List<Sentence> search(String sentence);
	public void addSentence(Sentence sentence);
	public void saveSentence(Sentence sentence);
	public void deleteSentence(Integer sentenceId);
	public void addResource(Integer sentenceId, Resource resource);
	public List<Resource> listResource(Integer sentenceId);
}
