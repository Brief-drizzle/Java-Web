package beans;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.*;

@WebServlet("/GetSimpleRegister")
public class GetSimpleRegister extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String username=request.getParameter("username");
        String pwd=request.getParameter("pwd");

        String forwardUrl=null;

        if(LoginBean.isExistsInLogintable(username,pwd))
        {
            forwardUrl="simpleregister.jsp";
            //request.getRequestDispatcher(forwardUrl).forward(request,response);
            response.sendRedirect(forwardUrl);
        }
        else if(LoginBean.insertBeantoDB(username,pwd))
        {
            forwardUrl="detailedregister.jsp";
            //request.getRequestDispatcher(forwardUrl).forward(request,response);
            response.sendRedirect(forwardUrl);
        }
        else
        {
            forwardUrl="simpleregister.jsp";
            request.getRequestDispatcher(forwardUrl).forward(request,response);
            //response.sendRedirect(forwardUrl);
        }
    }
}
