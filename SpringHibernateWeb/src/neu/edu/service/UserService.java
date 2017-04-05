package neu.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.bean.UserEducationBean;
import neu.edu.bean.UserProjectBean;
import neu.edu.dao.UserDAO;
import neu.edu.entity.UserAccount;
import neu.edu.entity.UserAddress;
import neu.edu.entity.UserEducation;
import neu.edu.entity.UserInfo;
import neu.edu.entity.UserProject;
import neu.edu.session.UserSessionInfo;
@Service
public class UserService {
	@Autowired
	private UserDAO userDao;
	
	public Integer validateUser(String username,String password){
		//System.out.println("Service is called Called");
		UserAccount userAcct = userDao.validateUser(username,password);
		
		if (userAcct == null) {
			System.out.println("User Not Found");
			return null;
		} else {
			System.out.println("User  Found");
			return userAcct.getUserId();
		}
	}

	public UserSessionInfo fetchUserAccountDetails(Integer userId) {
		// TODO Auto-generated method stub
		UserSessionInfo userSessionInfo=null;
		
		UserAccount userAccount = userDao.fetchUserAccount(userId);
		if(userAccount!=null){
			userSessionInfo = new UserSessionInfo(userAccount.getUserId());
			userSessionInfo.setUserId(userId);
			userSessionInfo.setName(userAccount.getFirstName()+" "+userAccount.getLastName());
		    userSessionInfo.getUserInformationBean().setFirstName(userAccount.getFirstName());
		    userSessionInfo.getUserInformationBean().setLastName(userAccount.getLastName());
		    userSessionInfo.getUserInformationBean().setDateOfBirth(userAccount.getDateOfBirth());
		    userSessionInfo.getUserInformationBean().setEmail(userAccount.getEmail());
		    userSessionInfo.getUserInformationBean().setMobileNumber(userAccount.getMobileNumber());
		    
		  
			
			
		}
	
	
		return userSessionInfo;
	}
	
	public UserSessionInfo fetchEducation(UserSessionInfo userSessionInfo){
		for(UserEducation ue:userDao.fetchUserEducation(userSessionInfo.getUserId())){
			UserEducationBean e = new UserEducationBean();
			e.setUniversityName(ue.getUniversityName());
			e.setCourseName(ue.getCourseName());
			e.setGpa(ue.getGpa());
			e.setYear(ue.getYear());
			e.setEduId(ue.getEduId());
			e.setUserId(ue.getUserId());
			userSessionInfo.getUserEducationBeanList().add(e);
		}
		
		return userSessionInfo;
		
	}
	
	
	public UserSessionInfo fetchProject(UserSessionInfo userSessionInfo){
		
		for(UserProject u:userDao.fetchUserProject(userSessionInfo.getUserId())){
			
			UserProjectBean ub = new UserProjectBean(u.getProjectName(), u.getProjectDesc());
			ub.setProjectId(u.getProjectId());
			ub.setUserId(u.getUserId());
			userSessionInfo.getUserProjectBeanList().add(ub);
			
		}
		return userSessionInfo;
		
		
		
	}
	
	
	
	public UserSessionInfo fetchUserInfo(UserSessionInfo userSessionInfo){
		UserInfo userInfo=userDao.fetchUserInfo(userSessionInfo.getUserId());
		userSessionInfo.getUserInformationBean().setUserInfoId(userInfo.getUserInfoId());
		userSessionInfo.getUserInformationBean().setCareerSummary(userInfo.getCareerSummary());
		return userSessionInfo;
	}
	
	public UserSessionInfo fetchUserAddress(UserSessionInfo userSessionInfo){
		UserAddress ua = userDao.fetchAddress(userSessionInfo.getUserId());
		userSessionInfo.getUserAddressBean().setAddressId(ua.getAddressId());
		userSessionInfo.getUserAddressBean().setUserId(ua.getUserId());
		userSessionInfo.getUserAddressBean().setAddress(ua.getAddress());
		userSessionInfo.getUserAddressBean().setCity(ua.getCity());
		userSessionInfo.getUserAddressBean().setState(ua.getState());
		userSessionInfo.getUserAddressBean().setZip(ua.getZip());
		return userSessionInfo;
		
		
		
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
