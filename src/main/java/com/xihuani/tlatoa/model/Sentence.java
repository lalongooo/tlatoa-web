package com.xihuani.tlatoa.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name="tltt_sentence")
public class Sentence {
	@Id
	@GeneratedValue
	@Column(name="sentence_id")
	private Integer sentenceId;
	
	@Column(name="sentence_name")
	private String sentence;
	
	
	@OneToMany(mappedBy = "sentence", cascade = CascadeType.ALL, fetch = FetchType.EAGER)  
	@OrderBy("sequenceOrder")
	private List<Resource> resources; 
	
	/**
	 * @return the sentenceId
	 */
	public Integer getSentenceId() {
		return sentenceId;
	}
	/**
	 * @param sentenceId the sentenceId to set
	 */
	public void setSentenceId(Integer sentenceId) {
		this.sentenceId = sentenceId;
	}
	/**
	 * @return the sentence
	 */
	public String getSentence() {
		return sentence;
	}
	/**
	 * @param sentence the sentence to set
	 */
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	/**
	 * @return the resources
	 */
	public List<Resource> getResources() {
		return resources;
	}
	/**
	 * @param resources the resources to set
	 */
	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}
	
}
