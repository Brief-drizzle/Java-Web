import controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import userpojo.Usertable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ad
 */
@WebServlet("/GetRegister")
public class GetRegister extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String username=request.getParameter("User");
        //获取用户名
        String pwd=request.getParameter("password1");
        //获取密码
        String password=request.getParameter("password2");
        //获取密码
        String email=request.getParameter("email");
        //获取性别
        String telephone=request.getParameter("phonnumber");
        //获取位置
        String forwardUrl=null;
        if (!pwd.equals(password))
        {
            forwardUrl="registerAgain.jsp";
        }
        else
        {
            Usertable userbean=new Usertable();
            //用户详细信息的bean
            userbean.setUsername(username);
            //设置bean
            userbean.setPassword(pwd);
            userbean.setEmail(email);
            userbean.setPhonenumber(telephone);
            userbean.setStatus(true);

            ApplicationContext appCon=new ClassPathXmlApplicationContext("LoginBean.xml");
            UserController dc=(UserController)appCon.getBean("userController") ;
            dc.insertUsertailed(userbean);

            forwardUrl="registerSuccess.jsp";
            //提示注册成功
        }

        RequestDispatcher dispatcher =
                request.getRequestDispatcher(forwardUrl);
        dispatcher.forward(request, response);
    }
}
