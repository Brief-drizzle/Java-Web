package mybatis.user;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pojo.Userpojo;
//@Repository("Usermapper")
//@Mapper
public interface Usermapper {
    public Usermapper queryUserById(String username);
    public void insertUser(Userpojo user);
    public void updateUser(Userpojo user);
}
