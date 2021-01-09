

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.*;

/**
 * Servlet implementation class GetLogin
 * @author ad
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
 		String pwd=request.getParameter("pwd");
 		
 		DetailedInfoBean dbean=null;
 		List<LoginBean> loginBean=null;
 		String forwardUrl=null;

 		//如果用户用户名和密码正确
 		//则从detailinfo表中读出详细信息，产生用户详细信息的bean
 		if (LoginBean.isExistsInLogintable(username, pwd)){
 			dbean=DetailedInfoBean.getDetailedInfoBean(username);
 			if (LoginBean.isManager(username,pwd))
			{
				forwardUrl="manager.jsp";
				loginBean=LoginBean.getALLusers();
				request.getSession().setAttribute("loginbean",loginBean);
			}
 			else
			{
				if(dbean==null){
					//说明用户只是注册了用户名和密码，没有注册详细信息,需要请用户输入详细注册信息
					forwardUrl="detailedregister.jsp";
				}
				else{//设置bean共享，供视图层展现
					//request.setAttribute("readdetailedinfobean", dbean);
					forwardUrl="showdetailedinfo.jsp";
					request.getSession().setAttribute("readdetailedinfobean",dbean);
				}
			}

 		}
 		else {//请用户重新登录
 			forwardUrl="loginagain.jsp";
 		}
		//request.getRequestDispatcher(forwardUrl).forward(request,response);
		response.sendRedirect(forwardUrl);
	}

}
