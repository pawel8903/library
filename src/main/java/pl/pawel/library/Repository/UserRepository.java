package pl.pawel.library.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import pl.pawel.library.entity.User;

public interface UserRepository extends Repository<User, Integer>{
	
	public User save(User theUser);

	public List<User> findByUsername(String userName);

	public List<User> findByEmail(String email);

	public List<User> findByPassword(String password);

	public List<User> findAll();

	public void deleteById(int userId);
	
}
