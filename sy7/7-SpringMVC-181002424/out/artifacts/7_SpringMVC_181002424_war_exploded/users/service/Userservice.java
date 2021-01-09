package users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import users.pojo.Userpojo;
import users.user.Usermapper;

@Service("userservice")
public class Userservice {
    @Autowired
    private Usermapper usermapper;

    public void insert(Userpojo userpojo){
        usermapper.insertUser(userpojo);
    }
}
