import controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import userpojo.usertable;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ad
 */
@WebServlet("/GetLogin")
@Controller
public class GetLogin extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String username = request.getParameter("User");
        String password = request.getParameter("password");

        usertable usertable =new usertable();
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("Bean.xml");
        UserController userController =
                (UserController) applicationContext.getBean("userController");
        usertable=userController.issuccessLogin(username);
        String forwardurl = null;
        if (usertable==null||!usertable.getPassword().equals(password))
        {
            forwardurl="/loginfail.jsp";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(forwardurl);
        dispatcher.forward(request, response);
    }
}
