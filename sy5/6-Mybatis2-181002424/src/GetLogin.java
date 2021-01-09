import detailedinfo.Detailedinfo;
import logintable.Loginfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Detailedinfotable;
import pojo.Logintable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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

 		Logintable logintable=new Logintable();
 		logintable.setUsername(username);
 		logintable.setPassword(pwd);

 		String resource1= "mybatis-config.xml";

		// 读取配置文件
		InputStream is1 = Resources.getResourceAsStream(resource1);
		// 构建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory1 = new SqlSessionFactoryBuilder().build(is1);
		// 获取sqlSession
		SqlSession sqlSession1 = sqlSessionFactory1.openSession();
		Detailedinfo detailedinfo = sqlSession1.getMapper(Detailedinfo.class);
		Loginfo loginfo = sqlSession1.getMapper(Loginfo.class);
 		
 		Detailedinfotable dbean=null;
 		List<Logintable> loginBean=null;
 		String forwardUrl=null;

 		//如果用户用户名和密码正确
 		//则从detailinfo表中读出详细信息，产生用户详细信息的bean
 		if (loginfo.isexsitanceLogin(logintable)!=null){
 			dbean= detailedinfo.getDetail(username);
 			if ("abc".equals(username)&& "abc".equals(pwd))
			{
				forwardUrl="manager.jsp";
				loginBean=loginfo.allLogin();
				request.getSession().setAttribute("loginbean",loginBean);
			}
 			else
			{
				if(dbean==null){
					//说明用户只是注册了用户名和密码，没有注册详细信息,需要请用户输入详细注册信息
					forwardUrl="detailedregister.jsp";
				}
				else{//设置bean共享，供视图层展现
					forwardUrl="showdetailedinfo.jsp";
					request.getSession().setAttribute("readdetailedinfobean",dbean);
				}
			}

 		}
 		else {//请用户重新登录
 			forwardUrl="loginagain.jsp";
 		}
		response.sendRedirect(forwardUrl);
	}

}
