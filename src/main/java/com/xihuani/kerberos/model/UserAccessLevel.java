package com.xihuani.kerberos.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@Table(name="user_access_level")
public class UserAccessLevel extends AbstractTimestampEntity implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;
	
	@OneToOne
    @PrimaryKeyJoinColumn
	private User user;
	
	@OneToOne
    @PrimaryKeyJoinColumn
	private Role role;
	
	
	
}
