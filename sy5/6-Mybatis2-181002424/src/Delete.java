import detailedinfo.Detailedinfo;
import logintable.Loginfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Detailedinfotable;
import pojo.Logintable;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author ad
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username=request.getParameter("username");
        Detailedinfotable detailedInfoBean=new Detailedinfotable();

        String resource1= "mybatis-config.xml";

        // 读取配置文件
        InputStream is1 = Resources.getResourceAsStream(resource1);
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory1 = new SqlSessionFactoryBuilder().build(is1);
        // 获取sqlSession
        SqlSession sqlSession1 = sqlSessionFactory1.openSession();
        Detailedinfo detailedinfo = sqlSession1.getMapper(Detailedinfo.class);
        Loginfo loginfo = sqlSession1.getMapper(Loginfo.class);

        detailedinfo.deleteDetail(username);
        loginfo.deleteLogin(username);
        List<Logintable> loginBean=null;
        loginBean=loginfo.allLogin();
        sqlSession1.commit();

        String forwardUrl="manager.jsp";
        request.getSession().setAttribute("loginbean",loginBean);
        response.sendRedirect(forwardUrl);
    }
}
