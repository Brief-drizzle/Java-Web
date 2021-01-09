package detailed;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import userpojo.Logtable;
import userpojo.Usertable;/*
@Repository(value = "userInfo")*/
import java.util.List;

@Mapper
public interface Userinfo {
    int insertUsertailed(Usertable usertable);
    Usertable isexsitanceLogin(String username);
    List<Logtable> alluser();
    int insertLoginfo(Logtable logtable);
}
