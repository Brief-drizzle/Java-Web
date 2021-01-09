import controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import userpojo.Usertable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GetLogin")
@Controller
public class GetLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Usertable usertable = null;

        String forwardurl;
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("LoginBean.xml");
        UserController userController =
                (UserController) applicationContext.getBean("userController");
        usertable = userController.isexsitanceLogin(username);
        if (usertable != null) {
            if (usertable.getPassword().equals(password)) {
                if (usertable.isStatus()) {
                    forwardurl = "/loginsuccess.jsp";
                    request.getSession().setAttribute("infobean", usertable);
                } else {
                    forwardurl = "/wrongstatus.jsp";
                }
            } else {
                forwardurl = "/wrongpwd.jsp";
            }
        } else {
            forwardurl = "/register.jsp";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(forwardurl);
        dispatcher.forward(request, response);
    }
}
