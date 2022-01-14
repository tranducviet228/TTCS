package com.KMA.BookingCare.Dto;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User {
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}
	public String getNameScheduler() {
		return nameScheduler;
	}
	public void setNameScheduler(String nameScheduler) {
		this.nameScheduler = nameScheduler;
	}
	public String getPhoneScheduler() {
		return phoneScheduler;
	}
	public void setPhoneScheduler(String phoneScheduler) {
		this.phoneScheduler = phoneScheduler;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private Long id;
	private String name;
	private String sex;
	@NotEmpty(message = "Thiếu số điện thoại")
	@Size(max = 12)
	private String phone;
	private String location;
	private String birthYear;
	private String nameScheduler;
	private String phoneScheduler;
	private String reason;
	@Email(message = "Email không hợp lệ")
	private String email;
	@NotEmpty(message = "Thiếu username")
	private String username;
	@NotEmpty(message = "Thiếu password")
    @Min(value = 6, message = "Password phải từ 6 kí tự trở lên")
	private String password;
	private Set<Role> roles;
	private String role;
	
	
	public User() {
		super();
	}
	
	

}
