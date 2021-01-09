
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.*;

import static beans.ModifyInfoBean.updateBeanToDB;

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
        ModifyInfoBean dbean;
        try {
            if(ModifyInfoBean.updateBeanToDB(username, age, sex, pictureLocation))
            {
                dbean=ModifyInfoBean.getDetailedInfoBean(username);
                request.getSession().setAttribute("readmodifyinfobean",dbean);
                String forwardUrl="showmodifyinfo.jsp";
                response.sendRedirect(forwardUrl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
