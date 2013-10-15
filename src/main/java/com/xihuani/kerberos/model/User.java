package com.xihuani.kerberos.model;

import java.util.ArrayList;
import java.util.List;

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
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="tlat_user")
public class User {
	@Id
	@GeneratedValue
	@Column(name="USER_ID")
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="MIDDLE_NAME")
	private String middleName;
	@Column(name="SOCIAL_MEDIA_ID")
	private String socialMediaId;
	@Column(name="GENDER")
	private String gender;
	@Column(name="LOCATION_ID")
	private String locationId;
	@Column(name="LOCATION_NAME")
	private String locationName;
	@Column(name="EMAIL")
	private String email;
	@Column(name="PROFILE_PICTURE_URL")
	private String profilePictureUrl;
	
	@ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(name="tlat_access_level", 
                joinColumns={@JoinColumn(name="user_id")}, 
                inverseJoinColumns={@JoinColumn(name="role_id")})
	private List<Role> roles;
	
	public User() {
		this.setName("Cristian Colorado");
		this.setEmail("ccoloradoc@gmail.com");
		this.setGender("Male");
		this.setLocationName("Monterrey, Mexico");
		this.roles = new ArrayList<Role>();
//		this.roles.add(new Role(1, "Sample1"));
//		this.roles.add(new Role(2, "Sample2"));
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}
	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	/**
	 * @return the socialMediaId
	 */
	public String getSocialMediaId() {
		return socialMediaId;
	}
	/**
	 * @param socialMediaId the socialMediaId to set
	 */
	public void setSocialMediaId(String socialMediaId) {
		this.socialMediaId = socialMediaId;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the locationId
	 */
	public String getLocationId() {
		return locationId;
	}
	/**
	 * @param locationId the locationId to set
	 */
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	/**
	 * @return the locationName
	 */
	public String getLocationName() {
		return locationName;
	}
	/**
	 * @param locationName the locationName to set
	 */
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the profilePictureUrl
	 */
	public String getProfilePictureUrl() {
		return profilePictureUrl;
	}
	/**
	 * @param profilePictureUrl the profilePictureUrl to set
	 */
	public void setProfilePictureUrl(String profilePictureUrl) {
		this.profilePictureUrl = profilePictureUrl;
	}
	/**
	 * @return the roles
	 */
	public List<Role> getRoles() {
		return roles;
	}
	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
