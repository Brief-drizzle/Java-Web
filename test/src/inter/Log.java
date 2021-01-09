package inter;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Log {
    public userpojo.usertable issuccessLogin(String username);
}
