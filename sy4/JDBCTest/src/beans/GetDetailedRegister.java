package beans;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetDetailInfo
 * @author ad
 */
@WebServlet("/GetDetailedRegister")
public class GetDetailedRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String username=request.getParameter("User");
 		int age=Integer.parseInt(request.getParameter("age"));
 		String sexy=request.getParameter("sexy");
 		String location=request.getParameter("uploadfile");
 		String forwardUrl=null;

		DetailedInfoBean dbean=new DetailedInfoBean();
		dbean.setUsername(username);
		dbean.setAge(age);
		dbean.setSexy(sexy);
		dbean.setPictureLocation(location);

		//request.setAttribute("readdetailedinfobean", dbean);
		request.getSession().setAttribute("readdetailedinfobean",dbean);

 		if(DetailedInfoBean.insertBeantoDB(username, age, sexy, location))
		{
			forwardUrl="detailedregistersuccess.jsp";
			/*RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
			dispatcher.forward(request, response);*/
			response.sendRedirect(forwardUrl);
		}
 		else
		{
			forwardUrl="detailedregisteragain.jsp";
			/*RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
			dispatcher.forward(request, response);*/
			response.sendRedirect(forwardUrl);
		}
	}
}
