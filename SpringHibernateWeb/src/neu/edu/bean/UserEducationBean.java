package neu.edu.bean;

public class UserEducationBean {

	private Integer eduId;
	private String universityName;
	private String courseName;
	private String gpa;
	private String year;
	private Integer userId;

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public void setGpa(String gpa) {
		this.gpa = gpa;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getUniversityName() {
		return universityName;
	}
	public String getCourseName() {
		return courseName;
	}
	public String getGpa() {
		return gpa;
	}
	public String getYear() {
		return year;
	}
	public Integer getEduId() {
		return eduId;
	}
	public void setEduId(Integer eduId) {
		this.eduId = eduId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
