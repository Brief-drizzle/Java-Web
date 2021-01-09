package pojo;

import controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetDetailInfo
 */
@WebServlet("/GetUserRegister")
public class GetUserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;    



	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String username=request.getParameter("User");	//获取用户名
 		String pwd=request.getParameter("pwd"); //获取密码
		String password=request.getParameter("password"); //获取密码
 		String email=request.getParameter("Email");	//获取性别
 		String telephone=request.getParameter("Telephone");	//获取位置
		String forwardUrl=null;
		if (!pwd.equals(password))
		{
			forwardUrl="registerAgain.jsp";
		}
		else
		{
			UserBean userbean=new UserBean();	//用户详细信息的bean
			userbean.setUsername(username);	//设置bean
			userbean.setPassword(pwd);
			userbean.setEmail(email);
			userbean.setTelephone(telephone);

			ApplicationContext appCon=new ClassPathXmlApplicationContext("applicationContext.xml");
			UserController dc=(UserController)appCon.getBean("userController") ;
			dc.insert(userbean);

			forwardUrl="registerSuccess.jsp";	//提示注册成功
		}

 		RequestDispatcher dispatcher =
 				request.getRequestDispatcher(forwardUrl);
 				dispatcher.forward(request, response);	
	}

}
