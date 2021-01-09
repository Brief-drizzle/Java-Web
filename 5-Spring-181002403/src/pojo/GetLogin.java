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
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class GetLogin
 */
@WebServlet("/GetLogin")
public class GetLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
 		request.setCharacterEncoding("UTF-8");
 		response.setCharacterEncoding("UTF-8");
 		
 		String username=request.getParameter("username");
 		//获取用户名
 		String password=request.getParameter("password");
 		//获取密码
 		UserBean user=null;
 		//存储从user表中获取的用户信息
 		String forwardUrl=null;
 		//如果用户用户名和密码正确
 		//则从detailinfo表中读出详细信息，产生用户详细信息的bean
//		user=userDao.queryUserOne(username);	//选取用户信息
		ApplicationContext appCon=new ClassPathXmlApplicationContext ("applicationContext.xml");
			UserController uc =(UserController) appCon.getBean ("userController") ;
			user=uc.select(username);

 		if (user!=null){	//该用户在数据库中存在
 			if (password.equals(user.getPassword()))
			{
				if (user.getState()==1)
				{
					HttpSession session=request.getSession();
					session.setAttribute("readUserBean", user);
					forwardUrl="showUserInfo.jsp";
				}
				else
				{
					forwardUrl="stateError.jsp";

				}

			}
 			else
			{
				forwardUrl="loginagain.jsp";
			}


 		}
 		else{//请用户注册
 			forwardUrl="userRegister.jsp";
 		} 			
 		RequestDispatcher dispatcher =
 				request.getRequestDispatcher(forwardUrl);
 				dispatcher.forward(request, response);	
	}

}
