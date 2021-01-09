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
 		//��ȡ�û���
 		String password=request.getParameter("password");
 		//��ȡ����
 		UserBean user=null;
 		//�洢��user���л�ȡ���û���Ϣ
 		String forwardUrl=null;
 		//����û��û�����������ȷ
 		//���detailinfo���ж�����ϸ��Ϣ�������û���ϸ��Ϣ��bean
//		user=userDao.queryUserOne(username);	//ѡȡ�û���Ϣ
		ApplicationContext appCon=new ClassPathXmlApplicationContext ("applicationContext.xml");
			UserController uc =(UserController) appCon.getBean ("userController") ;
			user=uc.select(username);

 		if (user!=null){	//���û������ݿ��д���
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
 		else{//���û�ע��
 			forwardUrl="userRegister.jsp";
 		} 			
 		RequestDispatcher dispatcher =
 				request.getRequestDispatcher(forwardUrl);
 				dispatcher.forward(request, response);	
	}

}
