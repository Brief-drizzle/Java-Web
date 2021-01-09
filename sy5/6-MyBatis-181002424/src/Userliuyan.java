import mybatis.user.Usermapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.Userpojo;

import javax.servlet.RequestDispatcher;
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
        String resource= "mybatis-config.xml";
        // 读取配置文件
        InputStream is = Resources.getResourceAsStream(resource);
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //sqlSessionFactory.getConfiguration().addMapper(Usermapper.class);
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Usermapper usermapper = sqlSession.getMapper(Usermapper.class);

        Userpojo user1=new Userpojo();
        user1.setUsername(name);
        user1.setWord(word);
        request.setAttribute("liuyanbean",user1);

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
            usermapper.insertUser(user1);
            sqlSession.commit();
            forwardUrl="/inputOk.jsp";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
        dispatcher.forward(request, response);
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
