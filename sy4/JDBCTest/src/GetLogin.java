

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

 		//����û��û�����������ȷ
 		//���detailinfo���ж�����ϸ��Ϣ�������û���ϸ��Ϣ��bean
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
					//˵���û�ֻ��ע�����û��������룬û��ע����ϸ��Ϣ,��Ҫ���û�������ϸע����Ϣ
					forwardUrl="detailedregister.jsp";
				}
				else{//����bean��������ͼ��չ��
					//request.setAttribute("readdetailedinfobean", dbean);
					forwardUrl="showdetailedinfo.jsp";
					request.getSession().setAttribute("readdetailedinfobean",dbean);
				}
			}

 		}
 		else {//���û����µ�¼
 			forwardUrl="loginagain.jsp";
 		}
		//request.getRequestDispatcher(forwardUrl).forward(request,response);
		response.sendRedirect(forwardUrl);
	}

}
