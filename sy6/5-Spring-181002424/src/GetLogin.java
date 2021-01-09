import controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import userpojo.Logtable;
import userpojo.Usertable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/GetLogin")
@Controller
public class GetLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String username = request.getParameter("User");
        String password = request.getParameter("password");
        Usertable usertable = null;
        Logtable logtable=new Logtable();

        String forwardurl;
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("LoginBean.xml");
        UserController userController =
                (UserController) applicationContext.getBean("userController");
        usertable = userController.isexsitanceLogin(username);
        if (usertable != null) {
            if (usertable.getPassword().equals(password)) {
                if (usertable.isStatus()) {
                    logtable.setUsername(username);
                    Date now=new Date();
                    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    logtable.setLogtime(simpleDateFormat.format(now));
                    InetAddress addr = InetAddress.getLocalHost();
                    logtable.setLogip(addr.getHostAddress());
                    forwardurl = "/loginsuccess.jsp";
                    request.getSession().setAttribute("logbean",logtable);
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
