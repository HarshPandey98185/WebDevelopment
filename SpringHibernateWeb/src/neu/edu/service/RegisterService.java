package neu.edu.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import neu.edu.bean.UserRegistrationBean;
import neu.edu.dao.UserDAO;
import neu.edu.entity.UserAccount;

@Service
public class RegisterService {
	
	@Autowired
	private UserDAO userDao;

	
	public Integer createUser(UserRegistrationBean userRegistrationBean) {

		UserAccount userAccount = new UserAccount();
		
		userAccount.setFirstName(userRegistrationBean.getFirstName());
		userAccount.setLastName(userRegistrationBean.getLastName());
		userAccount.setUserName(userRegistrationBean.getUserName());
		userAccount.setPassword(userRegistrationBean.getPassword());
		userAccount.setMobileNumber(userRegistrationBean.getMobileNumber());
		userAccount.setDateOfBirth(userRegistrationBean.getDateOfBirth());
		userAccount.setEmail(userRegistrationBean.getEmail());
		
	
		//2017-12-31
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//		
//		
//		try {
//			userAccount.setDateOfBirth(userRegistrationBean.getDateOfBirth());
//		
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		userAccount = userDao.createUser(userAccount);
		
			
			

		return userAccount.getUserId();
	}
	
	
	public boolean validateRegisteredUser(String name,String password){
		UserAccount u =userDao.validateUser(name, password);
		if(u == null){
			return false;
		}
		else{
			return true;
		}
	}
	
	
	
	
	
	

}
