package com.xihuani.tlatoa.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="tltt_resource")
public class Resource {
	@Id
	@GeneratedValue
	@Column(name="resource_id")
	private Integer resourceId;
	
	@Column(name="sequence_order")
	private Integer sequenceOrder;
	
	@Column(name="resource_url")
	private String resourceURL;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE}) 
	@JoinColumn(name="sentence_id", insertable = true, updatable = true, nullable = false)
	@JsonIgnore
	private Sentence sentence;  
	
	/**
	 * @return the resourceId
	 */
	public Integer getResourceId() {
		return resourceId;
	}
	/**
	 * @param resourceId the resourceId to set
	 */
	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}
	/**
	 * @return the sequenceOrder
	 */
	public Integer getSequenceOrder() {
		return sequenceOrder;
	}
	/**
	 * @param sequenceOrder the sequenceOrder to set
	 */
	public void setSequenceOrder(Integer sequenceOrder) {
		this.sequenceOrder = sequenceOrder;
	}
	/**
	 * @return the resourceURL
	 */
	public String getResourceURL() {
		return resourceURL;
	}
	/**
	 * @param resourceURL the resourceURL to set
	 */
	public void setResourceURL(String resourceURL) {
		this.resourceURL = resourceURL;
	}
	/**
	 * @return the sentence
	 */
	public Sentence getSentence() {
		return sentence;
	}
	/**
	 * @param sentence the sentence to set
	 */
	public void setSentence(Sentence sentence) {
		this.sentence = sentence;
	}
	

}
