package detailed;

import org.apache.ibatis.annotations.Mapper;
import userpojo.Usertable;

@Mapper
public interface Userinfo {
    int insertUsertailed(Usertable usertable);
    Usertable isexsitanceLogin(String username);
}
