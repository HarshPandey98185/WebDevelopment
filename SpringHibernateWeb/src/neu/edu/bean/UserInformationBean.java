package neu.edu.bean;

import java.util.ArrayList;
import java.util.List;

public class UserInformationBean {
	private Integer userInfoId;

	private String firstName;
	private String lastName;
	private String careerSummary;
	private String linesAboutYourself;
	private String dateOfBirth;
	private String email;
	private String mobileNumber;
	private String placeOfInterest;
	private List<String> areasOfInterest;
	

	
	
	
	public UserInformationBean() {
		areasOfInterest = new ArrayList<>();
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getCareerSummary() {
		return careerSummary;
	}
	public void setCareerSummary(String careerSummary) {
		this.careerSummary = careerSummary;
	}
	public String getLinesAboutYourself() {
		return linesAboutYourself;
	}
	public void setLinesAboutYourself(String linesAboutYourself) {
		this.linesAboutYourself = linesAboutYourself;
	}
	public String getPlaceOfInterest() {
		return placeOfInterest;
	}
	public void setPlaceOfInterest(String placeOfInterest) {
		this.placeOfInterest = placeOfInterest;
	}
	public List<String> getAreasOfInterest() {
		return areasOfInterest;
	}
	public void setAreasOfInterest(List<String> areasOfInterest) {
		this.areasOfInterest = areasOfInterest;
	}

	
	public Integer getUserInfoId() {
		return userInfoId;
	}
	public void setUserInfoId(Integer userInfoId) {
		this.userInfoId = userInfoId;
	}
	
	
	
	
	
}
