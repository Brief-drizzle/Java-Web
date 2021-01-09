package Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.UserDao;
import domain.User;

@Controller("userController")
public class UserController {
	@Autowired
	private UserDao userDao;
	
	 
	@RequestMapping("/login.do")
	public String login(String username,String password ,Model model) {
		User user=new User();
		user=userDao.selectUserByname(username);
		if(user!=null)			//�û��Ƿ���ڣ�
			if(user.getPassword().equals(password)) {		//�����Ƿ���ȷ
				
				model.addAttribute("userinfo", user);
				return "liuyan";
			}
		return "loginAgain";
	}
	
	@RequestMapping("/register")
	public String register(User user) {
		User user1=new User();
		user1=userDao.selectUserByname(user.getUsername());
		if(user1!=null)		//�û�������
			return "registerFail";
		userDao.addUser(user);
		return "registerSuccess";
		
	}
}
