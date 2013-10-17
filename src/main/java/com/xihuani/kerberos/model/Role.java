package com.xihuani.kerberos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="krrt_role")
public class Role {

	@Id
	@GeneratedValue
	@Column(name="role_id")
	private int id;
	
	@Column(name="role_name")
	private String roleName;
	
	public Role() {
		this.setId(0);
		this.setRoleName("Sample");
	}
	
	public Role(int id, String roleName) {
		this.setId(id);
		this.setRoleName(roleName);
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}
	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
