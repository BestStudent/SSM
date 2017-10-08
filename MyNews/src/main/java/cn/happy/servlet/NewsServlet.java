package cn.happy.servlet;

import cn.happy.entity.News;
import cn.happy.entity.Page;
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
import java.text.SimpleDateFormat;
import java.util.List;

public class NewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        INewsService service = new NewsServiceImpl();
        if(action==null||"".equals(action)||action.equals("null")){
            Page page = new Page();
            //每页几条
            int pageRow = 2;
            //总记录数
            int count = service.findAllCount();
            //总页数
            int sumPage = count%pageRow==0?count/pageRow:count/pageRow+1;
            //当前页码
            String  the_page =request.getParameter("thepage");
            int thePage = 0;
            if(the_page==null) {
                thePage = 1;
            }else {
                thePage= Integer.parseInt(the_page);
            }
            if(thePage<1){
                thePage=1;
            }
            if (thePage>sumPage){
                thePage=sumPage;
            }
            //当前页的首条数据索引
            int thePageFirst = (thePage-1)*pageRow;
            page.setPageRow(pageRow);
            page.setCount(count);
            page.setSumPage(sumPage);
            page.setThePage(thePage);
            page.setThePageFirst(thePageFirst);
            List<News> list = service.findAllbypage(page);
            for (News news : list){
                ITalkService tservice = new TalkServiceImpl();
                Long idid =  news.getNewsid();
                System.out.println(idid);
                int ididid = Integer.parseInt(idid.toString());
                int idididid = tservice.findcishu(ididid);
                System.out.println(idididid);
                news.setPingluncishu(idididid);
            }
            request.setAttribute("page",page);
            request.setAttribute("list",list);
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
        if (action.equals("show")){
            Integer id =  Integer.parseInt(request.getParameter("id"));
            List<Talk> list = service.findTalk(id);
            for (Talk talk1 : list){
                String fmt = "yyyy-MM-dd";
                SimpleDateFormat sdf = new SimpleDateFormat(fmt);
                String dateStr = sdf.format(talk1.getTalktime());
                talk1.setTalktime1(dateStr);
            }
            News news = service.findOne(id);

            ITalkService tservice = new TalkServiceImpl();
            Long idid =  news.getNewsid();
            System.out.println(idid);
            int ididid = Integer.parseInt(idid.toString());
            int idididid = tservice.findcishu(ididid);
            System.out.println(idididid);
            news.setPingluncishu(idididid);

            request.setAttribute("news",news);
            request.setAttribute("talk",list);
            request.getRequestDispatcher("/show.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doPost(request,response);
    }
}