package neu.edu.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import neu.edu.entity.UserAccount;
import neu.edu.entity.UserAddress;
import neu.edu.entity.UserEducation;
import neu.edu.entity.UserInfo;
import neu.edu.entity.UserProject;
@Repository
public class UserDAO {

	@Autowired
	private SessionFactory sessionFactory;




	@Transactional
	public UserAccount validateUser(String username, String password) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from UserAccount where userName=:username and password=:password ");
		query.setString("username", username);
		query.setString("password", password);

		UserAccount userAccount = (UserAccount) query.uniqueResult();

		return userAccount;

	}
	
	@Transactional
	public UserAccount createUser(UserAccount userAccount) {
		Session session = sessionFactory.getCurrentSession();
		session.save(userAccount);
		return userAccount;
	}
	
	@Transactional
	public UserInfo fetchUserInfo(Integer userId){
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from UserInfo where userId=:userIdnum");
		query.setInteger("userIdnum", userId);
		UserInfo userInfo =  (UserInfo) query.uniqueResult();
		
		return userInfo;
		
	}
	
	@Transactional
	public ArrayList<UserEducation> fetchUserEducation(Integer userId){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from UserEducation where userId=:userIdnum");
		query.setInteger("userIdnum", userId);
		ArrayList<UserEducation> eduList = (ArrayList<UserEducation>) query.list();
		return eduList;
		
		
	}
	
	@Transactional
	public ArrayList<UserProject> fetchUserProject(Integer userId){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from UserProject where userId=:userIdnum");
		query.setInteger("userIdnum", userId);
		ArrayList<UserProject> projList=(ArrayList<UserProject>)query.list();
		return projList;
	}
	
	
	
	@Transactional
	public UserAccount fetchUserAccount(Integer userId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(UserAccount.class, userId);
	}

	
	
	
	@Transactional
	public void SaveInformation(UserAddress userAddress,UserInfo userInfo){
		System.out.println("SaveInformation");
		Session session = sessionFactory.getCurrentSession();
		session.save(userAddress);
		
		session.save(userInfo);
		
	}
	
	@Transactional
	public void updateInformation(UserInfo userInfo){
		System.out.println("updateInformation");
		 
		Session session = sessionFactory.getCurrentSession();
	
		session.update(userInfo);
		
		
	}
	
	@Transactional
	public void updateAddress(UserAddress u){
		System.out.println("updateAddress");
		Session session = sessionFactory.getCurrentSession();
		
		session.update(u);
		
	}
	
	@Transactional
	public void updateEducation(UserEducation userEducation){
		Session session = sessionFactory.getCurrentSession();
		
		
		session.update(userEducation);
		
		
	}
	
	@Transactional
	public void updateProject(UserProject u){
		Session session = sessionFactory.getCurrentSession();
		
		session.update(u);
	}
	
	
	@Transactional
	public void SaveProject(UserProject up){
		Session session = sessionFactory.getCurrentSession();
		session.save(up);
	}
	
	@Transactional
	public void saveEducation(UserEducation userEducation){
		Session session = sessionFactory.getCurrentSession();
		session.save(userEducation);
	}
	
	@Transactional
	public UserAddress fetchAddress(Integer userId){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from UserAddress where userId=:userIdnum");
		query.setInteger("userIdnum", userId);
		UserAddress userAddress =  (UserAddress) query.uniqueResult();
		
		return userAddress;
	}
	
	@Transactional
	public boolean checkIfExiste(Integer userId){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from UserInfo where userId=:userIdnum");
		query.setInteger("userIdnum", userId);
		UserInfo userInfo =  (UserInfo) query.uniqueResult();
		if(userInfo ==null){
			return false;
		}
		else{
			return true;
		}
	}
	
}
