package cn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String uname = request.getParameter("uname");
     uname = new String(uname.getBytes("iso-8859-1"),"utf-8");
        System.out.println(uname);
     if (uname.equals("admin")){
         response.getWriter().write("true");
     }else{
         response.getWriter().write("false");
     }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}