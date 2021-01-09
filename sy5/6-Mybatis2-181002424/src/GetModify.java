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
 * @author ad
 */
@WebServlet("/GetModify")
public class GetModify extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String username=request.getParameter("username");
        int age= Integer.parseInt(request.getParameter("age"));
        String sex=request.getParameter("sexy");
        String pictureLocation=request.getParameter("pictureLocation");

        Detailedinfotable detailedinfotable=new Detailedinfotable();
        detailedinfotable.setUsername(username);
        detailedinfotable.setAge(age);
        detailedinfotable.setSexy(sex);
        detailedinfotable.setPicturelocation(pictureLocation);
        String resource1= "mybatis-config.xml";

        Detailedinfotable dbean=null;

        // 读取配置文件
        InputStream is1 = Resources.getResourceAsStream(resource1);
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory1 = new SqlSessionFactoryBuilder().build(is1);
        // 获取sqlSession
        SqlSession sqlSession1 = sqlSessionFactory1.openSession();
        Detailedinfo detailedinfo = sqlSession1.getMapper(Detailedinfo.class);

        detailedinfo.updateDetail(detailedinfotable);
        sqlSession1.commit();
        dbean=detailedinfo.getDetail(username);
        request.getSession().setAttribute("readmodifyinfobean",dbean);
        String forwardUrl="showmodifyinfo.jsp";
        response.sendRedirect(forwardUrl);

    }
}
