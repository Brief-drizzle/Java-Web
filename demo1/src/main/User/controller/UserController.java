package controller;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

import java.util.List;

/**
 * @author ad
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * ��ѯ���м�¼
     *
     * @return ���ؼ��ϣ�û�з��ؿ�List
     */
    @RequestMapping("list")
    public List<User> listAll() {
        return userService.listAll();
    }


    /**
     * ����������ѯ
     *
     * @param userId ����
     * @return ���ؼ�¼��û�з���null
     */
    @RequestMapping("getById")
    public User getById(String userId) {
        return userService.getById(userId);
    }

    /**
     * ����������null�ֶ�
     *
     * @param user �����ļ�¼
     * @return ����Ӱ������
     */
    @RequestMapping("insert")
    public int insert(@RequestBody User user) {
        return userService.insertIgnoreNull(user);
    }

    /**
     * �޸ģ�����null�ֶ�
     *
     * @param user �޸ĵļ�¼
     * @return ����Ӱ������
     */
    @RequestMapping("update")
    public int update(@RequestBody User user) {
        return userService.updateIgnoreNull(user);
    }

    /**
     * ɾ����¼
     *
     * @param user ��ɾ���ļ�¼
     * @return ����Ӱ������
     */
    @RequestMapping("delete")
    public int delete(@RequestBody User user) {
        return userService.delete(user);
    }

}