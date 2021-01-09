package dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import domain.User;

@Repository("userDao")
@Mapper
public interface UserDao {
	public User selectUserByname(String username);
	public void addUser(User user);
}
