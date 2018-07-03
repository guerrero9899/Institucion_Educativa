package model.entity;

import java.util.Date;

import javax.jdo.annotations.*;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class User {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	@Persistent
	private Long roleId;
	@Persistent
	private String email;
	@Persistent
	private Date birth;
	@Persistent
	private boolean gender;
	@Persistent
	private boolean status;
	public User(Long roleId,String email, boolean gender,Date d) {
		this.roleId=roleId;
		this.email=email;
		this.status=true;
		this.birth = d;
		this.gender=gender;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRole(Long roleId) {
		this.roleId = roleId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
