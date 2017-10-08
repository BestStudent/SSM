package cn.happy.servlet;

import cn.happy.entity.Talk;
import cn.happy.service.INewsService;
import cn.happy.service.ITalkService;
import cn.happy.service.impl.NewsServiceImpl;
import cn.happy.service.impl.TalkServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class TalkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        ITalkService service = new TalkServiceImpl();
        if(action==null||"".equals(action)||action.equals("null")){
            Talk talk = new Talk();
            Date date = new Date();
            talk.setTalktime(date);
            String content = request.getParameter("content");
            content = new String(content.getBytes("iso-8859-1"),"utf-8");
            talk.setContent(content);
            long id =  Integer.parseInt(request.getParameter("id"));
            talk.setNid(id);
            int intint = service.addTalk(talk);
            if (intint>0){
                System.out.println("ok");
                request.getRequestDispatcher("NewsServlet?action=show").forward(request,response);
            }

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request,response);
    }
}