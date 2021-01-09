package dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pojo.UserBean;

import java.util.List;
//@Repository("userDao")
@Mapper
public interface UserDao {
    public UserBean queryUserOne(String name);
    public List<UserBean> queryUserAll();
    public void insertUser(UserBean user);
    public void updateUser(UserBean user);
    public void deleteUser(String name);
}
