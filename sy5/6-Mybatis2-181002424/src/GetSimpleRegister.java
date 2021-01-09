import detailedinfo.Detailedinfo;
import logintable.Loginfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Logintable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/GetSimpleRegister")
public class GetSimpleRegister extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
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

        String forwardUrl=null;
        if(loginfo.isexsitanceLogin(logintable)==null)
        {
            forwardUrl="simpleregister.jsp";
            request.getRequestDispatcher(forwardUrl).forward(request,response);
        }
        else if(loginfo.insertLogin(logintable)==1)
        {
            sqlSession1.commit();
            forwardUrl="detailedregister.jsp";
            request.getRequestDispatcher(forwardUrl).forward(request,response);
        }
        else
        {
            forwardUrl="simpleregister.jsp";
            request.getRequestDispatcher(forwardUrl).forward(request,response);
        }
    }
}
