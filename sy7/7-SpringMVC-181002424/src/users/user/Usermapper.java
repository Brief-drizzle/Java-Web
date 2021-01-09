package users.user;

import org.apache.ibatis.annotations.Mapper;
import users.pojo.Userpojo;
/**
 * @author ad
 */
@Mapper
public interface Usermapper {
    public Userpojo queryUserById(String username);
    public void insertUser(Userpojo user);
    public void updateUser(Userpojo user);
}
