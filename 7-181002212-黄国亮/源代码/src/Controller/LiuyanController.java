package Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.LiuyanDao;
import domain.Liuyan;

@Controller("liuyanController")

public class LiuyanController {
	@Autowired
	private LiuyanDao liuyanDao;
	
	/*
	 * @Autowired HttpSession session;
	 */
	
	@RequestMapping("/liuyan")
	public String insertLiuyan(String username,String topic,String detail) {
		Liuyan liuyan=new Liuyan();
		//session.setAttribute("username", liuyan.getUsername());
		liuyan.setUsername(username);
		liuyan.setTopic(topic);
		liuyan.setDetail(detail);
		liuyanDao.addLiuyan(liuyan);
		return "liuyanSuccess";
	}
	
	@RequestMapping("/liuyanSuccess")
	public String choice(String choice) {
		if(choice.equals("yes"))
			return "liuyanContinue";
		else
			return "liuyanExit";
	}
}
