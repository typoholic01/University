package kh.com.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("UsersDto")
public class UsersDto implements Serializable {
	private static final long serialVersionUID = 7676251580300482326L;
	
	private String userId;
	private String userPw;
	private String userEmail;
	private String userPhone;
	private String userAddress;
	private int userAuth;
	private int majorNumber;
	private int userStatus;
	
	
	//디폴드값 제외 생성자
	public UsersDto(String userId, String userPw, String userEmail, String userPhone, String userAddress) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
	}
	
	public UsersDto() {
		
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public int getUserAuth() {
		return userAuth;
	}
	public void setUserAuth(int userAuth) {
		this.userAuth = userAuth;
	}
	public int getMajorNumber() {
		return majorNumber;
	}
	public void setMajorNumber(int majorNumber) {
		this.majorNumber = majorNumber;
	}
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userPw=" + userPw + ", userEmail=" + userEmail + ", userPhone="
				+ userPhone + ", userAddress=" + userAddress + ", userAuth=" + userAuth + ", majorNumber=" + majorNumber
				+ ", userStatus=" + userStatus + "]";
	}

	
}
