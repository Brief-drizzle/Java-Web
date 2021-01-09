import mybatis.user.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Userpojo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/Userliuyan")
public class Userliuyan extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name=request.getParameter("name");
        String word=request.getParameter("word");
        String forwardUrl=null;
        int len1=5,len2=0;
        String resource="mybatisconfig.xml";
        // 读取配置文件
        InputStream is = Resources.getResourceAsStream(resource);
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.getMapper(User.class);

        Userpojo user1=new Userpojo();
        user1.setUsername(name);
        user1.setWord(word);

        user.insertUser(user1);
        sqlSession.commit();

        if(isParameterNull(name)||isParameterNull(word))
        {
            forwardUrl="/inputAgain.jsp";
        }
        else if(word.trim().length()<len1&&word.trim().length()>len2)
        {
            forwardUrl="/inputError.jsp";
        }
        else
        {
            forwardUrl="/inputOk.jsp";
        }
        request.getSession().setAttribute("liuyanbean",user1);
        response.sendRedirect(forwardUrl);
    }
    private boolean isParameterNull(String name) {
        if (name=="") {
            return true;
        }
        else {
            return false;
        }
    }
}
