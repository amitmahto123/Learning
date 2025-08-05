package com.amit.UserService.DTO;



public class UserDTO {
	
	private Integer userId;
	private String userName;
	private String address;
	private String city;
	
	
	
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDTO(Integer userId, String userName, String userPassword, String address, String city) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.address = address;
		this.city = city;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", userName=" + userName + ", address="
				+ address + ", city=" + city + "]";
	}
	
	

}
