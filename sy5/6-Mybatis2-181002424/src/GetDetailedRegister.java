import detailedinfo.Detailedinfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Detailedinfotable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

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

		Detailedinfotable detailedinfotable=new Detailedinfotable();
		detailedinfotable.setUsername(username);
		detailedinfotable.setAge(age);
		detailedinfotable.setSexy(sexy);
		detailedinfotable.setPicturelocation(location);
		String resource1= "mybatis-config.xml";

		Detailedinfotable dbean=new Detailedinfotable();
		dbean.setUsername(username);
		dbean.setAge(age);
		dbean.setSexy(sexy);
		dbean.setPicturelocation(location);

		//request.setAttribute("readdetailedinfobean", dbean);
		request.getSession().setAttribute("readdetailedinfobean",dbean);

		// 读取配置文件
		InputStream is1 = Resources.getResourceAsStream(resource1);
		// 构建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory1 = new SqlSessionFactoryBuilder().build(is1);
		// 获取sqlSession
		SqlSession sqlSession1 = sqlSessionFactory1.openSession();
		Detailedinfo detailedinfo = sqlSession1.getMapper(Detailedinfo.class);

		if(detailedinfo.insertDetail(dbean)==1)
		{
			sqlSession1.commit();
			forwardUrl="detailedregistersuccess.jsp";
			response.sendRedirect(forwardUrl);
		}
		else {
			forwardUrl="detailedregisteragain.jsp";
			response.sendRedirect(forwardUrl);
		}
	}
}
