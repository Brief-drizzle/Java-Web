package mybatis.user;

import pojo.Userpojo;

public interface Usermapper {
    /**
     * 根据id查询用户信息
     *
     * @param username
     * @return
     */
    public Usermapper queryUserById(String username);

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
