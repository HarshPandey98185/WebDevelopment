package neu.edu.bean;

public class UserProjectBean {
	private Integer projectId;
	private Integer userId;
	private String projectName;
	private String projectDescription;
	
	
	
	public UserProjectBean(String projectName, String projectDescription) {
		
		this.projectName = projectName;
		this.projectDescription = projectDescription;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectDescription() {
		return projectDescription;
	}
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
	
	
}
