package neu.edu.session;

import java.util.ArrayList;
import java.util.List;

import neu.edu.bean.UserAddressBean;
import neu.edu.bean.UserEducationBean;
import neu.edu.bean.UserInformationBean;
import neu.edu.bean.UserProjectBean;
import neu.edu.bean.UserSkillsBean;
import neu.edu.entity.UserAccount;

public class UserSessionInfo {
	
	private Integer userId;
	private String name;
	private UserAddressBean userAddressBean;
	private UserInformationBean userInformationBean;
	private List<UserProjectBean> userProjectBeanList;
	private List<UserEducationBean> userEducationBeanList;
	private UserSkillsBean userSkillsBean;
	
	
	public UserSessionInfo(Integer userId) {
		// TODO Auto-generated constructor stub
		this.userId = userId;
		userInformationBean = new UserInformationBean();
		
		userProjectBeanList = new ArrayList<>();
		userEducationBeanList = new ArrayList<>();
		
		userSkillsBean = new UserSkillsBean();
		userAddressBean = new UserAddressBean();
	}

	public Integer getUserId() {
		return userId;
	}

	public List<UserProjectBean> getUserProjectBeanList() {
		return userProjectBeanList;
	}

	public void setUserProjectBeanList(List<UserProjectBean> userProjectBeanList) {
		this.userProjectBeanList = userProjectBeanList;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserInformationBean getUserInformationBean() {
		return userInformationBean;
	}

	public void setUserInformationBean(UserInformationBean userInformationBean) {
		this.userInformationBean = userInformationBean;
	}



	public UserAddressBean getUserAddressBean() {
		return userAddressBean;
	}

	public void setUserAddressBean(UserAddressBean userAddressBean) {
		this.userAddressBean = userAddressBean;
	}



	public List<UserEducationBean> getUserEducationBeanList() {
		return userEducationBeanList;
	}

	public void setUserEducationBeanList(List<UserEducationBean> userEducationBeanList) {
		this.userEducationBeanList = userEducationBeanList;
	}

	public UserSkillsBean getUserSkillsBean() {
		return userSkillsBean;
	}

	public void setUserSkillsBean(UserSkillsBean userSkillsBean) {
		this.userSkillsBean = userSkillsBean;
	}
	
	
	public void addEducation(UserEducationBean e){
		userEducationBeanList.add(e);
	}
	
	public void addProjects(UserProjectBean e){
		userProjectBeanList.add(e);
	}

}
