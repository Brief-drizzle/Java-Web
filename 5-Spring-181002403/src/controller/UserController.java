package controller;

import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import pojo.UserBean;

@Controller("userController")
public class UserController {

    @Autowired
    private UserDao userDao;
    public UserBean select(String name)
    {
        UserBean user=userDao.queryUserOne(name);
        return user;
    }
    public void insert(UserBean user)
    {
        userDao.insertUser(user);
    }

}
