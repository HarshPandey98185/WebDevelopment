package neu.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.bean.UserEducationBean;
import neu.edu.bean.UserProjectBean;
import neu.edu.dao.UserDAO;
import neu.edu.entity.UserAddress;
import neu.edu.entity.UserEducation;
import neu.edu.entity.UserInfo;
import neu.edu.entity.UserProject;
import neu.edu.session.UserSessionInfo;

@Service
public class InformationService {

	@Autowired
	private UserDAO userDao;
	
	
	public void saveInformation(UserSessionInfo userSessionInfo){
	//	System.out.println("saveInformation");
		UserAddress userAddress = new UserAddress();
		
		UserInfo userInfo = new UserInfo();
		
		
		userAddress.setAddress(userSessionInfo.getUserAddressBean().getAddress());
		userAddress.setCity(userSessionInfo.getUserAddressBean().getCity());
		userAddress.setState(userSessionInfo.getUserAddressBean().getState());
		userAddress.setZip(userSessionInfo.getUserAddressBean().getZip());
		userAddress.setUserId(userSessionInfo.getUserId());
		
		
		
		userInfo.setFirstName(userSessionInfo.getUserInformationBean().getFirstName());
		userInfo.setLastName(userSessionInfo.getUserInformationBean().getLastName());
		userInfo.setEmail(userSessionInfo.getUserInformationBean().getEmail());
		userInfo.setDateOfBirth(userSessionInfo.getUserInformationBean().getDateOfBirth());
		userInfo.setCareerSummary(userSessionInfo.getUserInformationBean().getCareerSummary());
		userInfo.setUserId(userSessionInfo.getUserId());
		
		userDao.SaveInformation(userAddress, userInfo);
		
		
	}
	
	
	public void saveProjects(UserSessionInfo userSessionInfo){
		for(UserProjectBean p:userSessionInfo.getUserProjectBeanList()){
			UserProject up = new UserProject();
			up.setProjectName(p.getProjectName());
			up.setProjectDesc(p.getProjectDescription());
			up.setUserId(userSessionInfo.getUserId());
			userDao.SaveProject(up);
		}
	}
	
	
	public void saveEducation(UserSessionInfo userSessionInfo){
		for(UserEducationBean u:userSessionInfo.getUserEducationBeanList()){
			UserEducation userEducation = new UserEducation();
			userEducation.setCourseName(u.getCourseName());
			userEducation.setUniversityName(u.getUniversityName());
			userEducation.setGpa(u.getGpa());
			userEducation.setUserId(userSessionInfo.getUserId());
			userDao.saveEducation(userEducation);
		}
	}
	
	
	
	public void updateDetailsForExistingUser(UserSessionInfo userSessionInfo){
	//	System.out.println("updateInformation");
//		UserAddress userAddress = new UserAddress();
		UserInfo userInfo = new UserInfo();
		
		userInfo.setFirstName(userSessionInfo.getUserInformationBean().getFirstName());
		userInfo.setLastName(userSessionInfo.getUserInformationBean().getLastName());
		userInfo.setEmail(userSessionInfo.getUserInformationBean().getEmail());
		userInfo.setDateOfBirth(userSessionInfo.getUserInformationBean().getDateOfBirth());
		userInfo.setCareerSummary(userSessionInfo.getUserInformationBean().getCareerSummary());
		userInfo.setUserId(userSessionInfo.getUserId());
		userInfo.setUserInfoId(userSessionInfo.getUserInformationBean().getUserInfoId());
	    userDao.updateInformation(userInfo);
		
		
		UserAddress userAddress = new UserAddress();
		userAddress.setAddress(userSessionInfo.getUserAddressBean().getAddress());
		userAddress.setCity(userSessionInfo.getUserAddressBean().getCity());
		userAddress.setState(userSessionInfo.getUserAddressBean().getState());
		userAddress.setZip(userSessionInfo.getUserAddressBean().getZip());
		userAddress.setUserId(userSessionInfo.getUserId());
		userAddress.setAddressId(userSessionInfo.getUserAddressBean().getAddressId());
		userDao.updateAddress(userAddress);
		
//		
//		

//		
		for(UserEducationBean u:userSessionInfo.getUserEducationBeanList()){
		//	System.out.println("updateEducation");
			if(u.getEduId() != null){
			UserEducation userEducation = new UserEducation();
			userEducation.setCourseName(u.getCourseName());
			userEducation.setUniversityName(u.getUniversityName());
			userEducation.setGpa(u.getGpa());
			userEducation.setYear(u.getYear());
			userEducation.setUserId(u.getUserId());
			userEducation.setEduId(u.getEduId());
		//	System.out.println("edu id:"+u.getEduId());
		//	System.out.println("edu course:"+u.getCourseName());
			userDao.updateEducation(userEducation);
			}
		}
//		
		for(UserProjectBean p:userSessionInfo.getUserProjectBeanList()){
		//	System.out.println("updateproject");
			if(p.getProjectId()!= null){
			UserProject up = new UserProject();
			up.setProjectName(p.getProjectName());
			up.setProjectDesc(p.getProjectDescription());
			up.setUserId(userSessionInfo.getUserId());
			up.setProjectId(p.getProjectId());
			userDao.updateProject(up);
			}
		}
		
		
	}
	
	public boolean userUpdateOrSave(UserSessionInfo userSessionInfo){
		Boolean u = userDao.checkIfExiste(userSessionInfo.getUserId());
		if(u){
			return true;
			
		}
		else{
			return false;
		}
	}
	
	
	
	
	
}
