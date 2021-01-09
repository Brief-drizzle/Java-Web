package mybatis.user;

import pojo.Userpojo;

import java.util.List;

public interface User {
    /**
     * 根据id查询用户信息
     *
     * @param username
     * @return
     */
    public User queryUserById(String username);

    /**
     * 新增用户
     *
     * @param user
     */
    public void insertUser(Userpojo user);

    /**
     * 更新用户信息
     *
     * @param user
     */
    public void updateUser(Userpojo user);

}
