import jsptest.LiuyanBean;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DoliuyanInput")
public class DoLiuyanInput extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setCharacterEncoding("utf-8");
        String name=request.getParameter("name");
        String word=request.getParameter("word");
        String forwardUrl=null;
        int len1=5,len2=0;

        LiuyanBean liuyanBean=new LiuyanBean();
        liuyanBean.setName(name);
        liuyanBean.setWord(word);
        request.setAttribute("Liuyan",liuyanBean);

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
