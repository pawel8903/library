package pl.pawel.library.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.pawel.library.entity.User;
import pl.pawel.library.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void saveUser(User theUser) {
		userRepository.save(theUser);
	}
	
	public boolean checkAvaibleOfUsername(String username) {
		List<User> listOfUsername = userRepository.findByUsername(username);
		if(listOfUsername.size() == 0) 
			return true;
		return false;
	}
	public boolean checkAvaibleOfEmail(String email) {
		List<User> listOfEmail = userRepository.findByEmail(email);
		if(listOfEmail.size() == 0) 
			return true;
		return false;
	}
	
	public boolean checkMinimumSizeOfPassword(String password) {
		if(password.length()<6) return true;
		return false;
	}
	
	public boolean checkMaxSizeOfPassword(String password) {
		if(password.length()>12) return true;
		return false;
	}
	
	public boolean checkConfigPassword(String password, String configPassword) {
		if(password.equals(configPassword)==false)return true;
		return false;
	}

	public boolean checkCorrectOfLogin(String login) {
		if(login.contains("@")) {
			return checkAvaibleOfEmail(login);
		}else{
			return checkAvaibleOfUsername(login);
		} 
	}

	public boolean checkCorrectOfPassword(String password) {
		List<User> listOfPassword = userRepository.findByPassword(password);
		if(listOfPassword.size()==0) {
			return true;
		}else {
			if(password.equals(listOfPassword.get(0).getPassword())) {
				return false;
			}
		}
		return true;
	}
}
