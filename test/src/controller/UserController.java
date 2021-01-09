package controller;

import inter.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author ad
 */
@Controller("userController")
public class UserController {

    @Autowired
    private Log log;
    public userpojo.usertable issuccessLogin (String username){
        return log.issuccessLogin(username);
    }
}
