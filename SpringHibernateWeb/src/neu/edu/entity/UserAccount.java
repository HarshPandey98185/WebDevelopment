package neu.edu.entity;
// Generated Apr 4, 2017 9:59:00 PM by Hibernate Tools 5.2.1.Final

/**
 * UserAccount generated by hbm2java
 */
public class UserAccount implements java.io.Serializable {

	private Integer userId;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String dateOfBirth;
	private String email;
	private String mobileNumber;

	public UserAccount() {
	}

	public UserAccount(String firstName, String lastName, String userName, String password, String dateOfBirth,
			String email, String mobileNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

}
