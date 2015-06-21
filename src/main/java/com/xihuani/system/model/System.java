package com.xihuani.system.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import javax.persistence.CascadeType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "krrt_system")
public class System extends AbstractTimestampEntity implements Serializable {

	@Id
	@GeneratedValue
	@Column(name="system_id")
	private Integer systemId;
	@Column(name="system_name")
	private String systemName;
	@Column(name="system_description")
	private String systemDescription;

	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "krrt_system_access_level", joinColumns = { 
			@JoinColumn(name = "system_id", nullable = false, updatable = true) }, 
			inverseJoinColumns = { @JoinColumn(name = "role_id", 
					nullable = false, updatable = true) })
	private Set<Role> roles = new HashSet<Role>(0);

	/**
	 * @return the systemId
	 */
	public Integer getSystemId() {
		return systemId;
	}

	/**
	 * @param systemId the systemId to set
	 */
	public void setSystemId(Integer systemId) {
		this.systemId = systemId;
	}

	/**
	 * @return the systemName
	 */
	public String getSystemName() {
		return systemName;
	}

	/**
	 * @param systemName the systemName to set
	 */
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	/**
	 * @return the systemDescription
	 */
	public String getSystemDescription() {
		return systemDescription;
	}

	/**
	 * @param systemDescription the systemDescription to set
	 */
	public void setSystemDescription(String systemDescription) {
		this.systemDescription = systemDescription;
	}

	/**
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}	
}
