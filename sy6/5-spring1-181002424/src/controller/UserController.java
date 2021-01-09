package controller;

import detailed.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import userpojo.Usertable;

/**
 * @author ad
 */
@Controller("userController")
public class UserController {

    @Autowired
    private Userinfo userinfo;
    public void insertUsertailed(Usertable usertable){
        userinfo.insertUsertailed(usertable);
    }
    public Usertable isexsitanceLogin(String username){
        return userinfo.isexsitanceLogin(username);
    }
}
