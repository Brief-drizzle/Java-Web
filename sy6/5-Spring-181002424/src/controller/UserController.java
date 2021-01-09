package controller;

import detailed.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import userpojo.Logtable;
import userpojo.Usertable;

import java.util.List;

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
    public List<Logtable> getall(){
        return userinfo.alluser();
    }
    public void insertLog(Logtable logtable){userinfo.insertLoginfo(logtable);}


}
