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

		// ��ȡ�����ļ�
		InputStream is1 = Resources.getResourceAsStream(resource1);
		// ����SqlSessionFactory
		SqlSessionFactory sqlSessionFactory1 = new SqlSessionFactoryBuilder().build(is1);
		// ��ȡsqlSession
		SqlSession sqlSession1 = sqlSessionFactory1.openSession();
		Detailedinfo detailedinfo = sqlSession1.getMapper(Detailedinfo.class);
		Loginfo loginfo = sqlSession1.getMapper(Loginfo.class);
 		
 		Detailedinfotable dbean=null;
 		List<Logintable> loginBean=null;
 		String forwardUrl=null;

 		//����û��û�����������ȷ
 		//���detailinfo���ж�����ϸ��Ϣ�������û���ϸ��Ϣ��bean
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
					//˵���û�ֻ��ע�����û��������룬û��ע����ϸ��Ϣ,��Ҫ���û�������ϸע����Ϣ
					forwardUrl="detailedregister.jsp";
				}
				else{//����bean��������ͼ��չ��
					forwardUrl="showdetailedinfo.jsp";
					request.getSession().setAttribute("readdetailedinfobean",dbean);
				}
			}

 		}
 		else {//���û����µ�¼
 			forwardUrl="loginagain.jsp";
 		}
		response.sendRedirect(forwardUrl);
	}

}
