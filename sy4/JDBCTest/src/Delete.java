import beans.DetailedInfoBean;
import beans.LoginBean;
import beans.ModifyInfoBean;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @author ad
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username=request.getParameter("username");
        DetailedInfoBean detailedInfoBean=new DetailedInfoBean();
        boolean ans1= LoginBean.deletedelogin(username);
        boolean ans2= DetailedInfoBean.deletedetailed(username);
        List<LoginBean> loginBean=null;
        loginBean=LoginBean.getALLusers();
        String forwardUrl="manager.jsp";
        request.getSession().setAttribute("loginbean",loginBean);
        response.sendRedirect(forwardUrl);
    }
}
