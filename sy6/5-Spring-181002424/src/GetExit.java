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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/GetExit")
@Controller
public class GetExit extends HttpServlet {
    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("LoginBean.xml");
        UserController userController =
                (UserController) applicationContext.getBean("userController");
        Logtable logtable = null;
        logtable= (Logtable) request.getSession().getAttribute("logbean");
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date log= null;
        try {
            log = simpleDateFormat.parse(logtable.getLogtime());
            Date now=new Date();
            long con=now.getTime()-log.getTime();
            logtable.setLogcontime(con);
            userController.insertLog(logtable);
            String forwardurl="/exit.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(forwardurl);
            dispatcher.forward(request, response);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
