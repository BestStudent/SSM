package cn.one.servlet;

import cn.one.dao.IUserDAO;
import cn.one.entity.User;
import cn.one.entity.UserPage;
import cn.one.service.IUserService;
import cn.one.service.impl.UserServiceImpl;
import cn.one.until.until;
import org.apache.ibatis.session.SqlSession;
import org.apache.poi.hssf.usermodel.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        IUserService service = new UserServiceImpl();
        String action = request.getParameter("action");
        if (action==null||action.equals("")){
            String ucode= request.getParameter("username");
            String upwd = request.getParameter("password");
            User u = new User();
            u.setUcode(ucode);
            u.setUpwd(upwd);
            System.out.println(ucode);
            System.out.println(upwd);
            User user = service.isLogin(u);
            if(user!=null){
                System.out.println("Login OK");
                request.setAttribute("user",user);
                request.getRequestDispatcher("/welcome.jsp").forward(request,response);
            }
            else{
                System.out.println("Login NO");
                response.sendRedirect("/one/login.jsp");
            }
            return;
        }else if ("list".equals(action)){
            //输入姓名
            String name = request.getParameter("name");
            String sname=null;
            if(name!=null) {
               sname  = new String(name.getBytes("iso-8859-1"), "utf-8");
            }
            UserPage up = new UserPage();
            up.setInputname(sname);
            //每页条数
            Integer pagerow = 7;
            up.setPageRow(pagerow);
            //总条数
            Integer count = service.findAllCount(up);
            up.setUserCount(count);
            //总页数
            Integer sumpage =count%pagerow==0?count/pagerow:count/pagerow+1;
            up.setSumPage(sumpage);
            //当前页码
            String thepage = (request.getParameter("thepage"));
            Integer  thepage1;
            if (thepage==null) {
                thepage1=1;
            }else {
                thepage1  = Integer.parseInt(thepage);
                if (thepage1<1){
                    thepage1=1;
                }
                if(thepage1>sumpage){
                    thepage1=sumpage;
                }
            }
            up.setThePage(thepage1);
            //当前页面首条索引
            Integer thepagefirst = 0;
            up.setThePageFirst(thepagefirst);
            List<User> list1 = service.findAllbypage(up);
            for(User user : list1){
                //性别转化
                if (user.getUgender()==0){
                    user.setGender("女");
                }else{
                    user.setGender("男");
                }
                //年龄转化
                String bir = new SimpleDateFormat("yyyy").format(user.getUbirthday());
                Date time=new Date();
                DateFormat format=new SimpleDateFormat("yyyy");
                String now=format.format(time);
                Integer birint = Integer.parseInt(bir);
                Integer nowint = Integer.parseInt(now);
                int age = nowint-birint;
                user.setAge(age);
                //级别转化
                if (user.getUrole()==1){
                    user.setRole("管理员");
                }else if(user.getUrole()==2){
                    user.setRole("经理");
                }else if(user.getUrole()==3){
                    user.setRole("普通用户");
                }
            }
            request.setAttribute("up",up);
            request.setAttribute("list1",list1);
            request.getRequestDispatcher("/userList.jsp").forward(request,response);
            return;
        }else if ("del".equals(action)){
            SqlSession session = until.getsession();
            Integer uid = Integer.parseInt(request.getParameter("id"));
            Integer count = service.delOne(uid);
            if(count==1){
                System.out.println("del ok");
                request.getRequestDispatcher("UserServlet?action=list").forward(request,response);
            }else{
                System.out.println("del no");
            }


        }else if ("add".equals(action)){
            String ucode = request.getParameter("userId");
            String uname = request.getParameter("userName");
            String upwd = request.getParameter("userpassword");
            int ugender = Integer.parseInt(request.getParameter("sex"));
            String ubirthday = request.getParameter("data");
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Date birthday =null;
            try {
                birthday  =sdf.parse(ubirthday);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String uphone = request.getParameter("userphone");
            Integer urole = Integer.parseInt(request.getParameter("userlei"));
            String uaddress = request.getParameter("userAddress");
            User user = new User();
            user.setUcode(ucode);
            user.setUname(uname);
            user.setUpwd(upwd);
            user.setUgender(ugender);
            user.setUbirthday(birthday);
            user.setUphone(uphone);
            user.setUrole(urole);
            user.setUaddress(uaddress);
            int count = service.addOne(user);
            if (count==1){
                System.out.println("add ok");
                request.getRequestDispatcher("UserServlet?action=list").forward(request,response);
            }else{
                System.out.println("add no");
            }
        }else if("show".equals(action)){
            SqlSession session = until.getsession();
            Integer uid = Integer.parseInt(request.getParameter("id"));
            User user = service.findOne(uid);
            String fmt = "yyyy-MM-dd";
            SimpleDateFormat sdf = new SimpleDateFormat(fmt);
            String dateStr = sdf.format(user.getUbirthday());
            user.setSbirthday(dateStr);
            if (user.getUgender()==0){
                user.setGender("女");
            }else{
                user.setGender("男");
            }
            System.out.println(user.getUrole());
            request.setAttribute("user",user);
            request.getRequestDispatcher("/userUpdate.jsp").forward(request,response);
        }else if ("upd".equals(action)){
            User user = new User();
            Integer id =Integer.parseInt(request.getParameter("uid"));
            user.setUid(id);
            String name = request.getParameter("userName");
            user.setUname(name);
            int sex = Integer.parseInt(request.getParameter("gender"));
            user.setUgender(sex);
            String ubirthday = request.getParameter("data");
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Date birthday =null;
            try {
                birthday  =sdf.parse(ubirthday);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            user.setUbirthday(birthday);
            String uphone = request.getParameter("userphone");
            user.setUphone(uphone);
            String uaddress = request.getParameter("userAddress");
            user.setUaddress(uaddress);
            Integer urole = Integer.parseInt(request.getParameter("userlei"));
            user.setUrole(urole);
            service.updOne(user);
            request.getRequestDispatcher("UserServlet?action=list").forward(request,response);
        }else if("view".equals(action)){
            SqlSession session = until.getsession();
            Integer uid = Integer.parseInt(request.getParameter("id"));
            System.out.println(uid);
            User user = service.findOne(uid);
            String fmt = "yyyy-MM-dd";
            SimpleDateFormat sdf = new SimpleDateFormat(fmt);
            String dateStr = sdf.format(user.getUbirthday());
            user.setSbirthday(dateStr);
            if (user.getUgender()==0){
                user.setGender("女");
            }else{
                user.setGender("男");
            }
            //级别转化
            if (user.getUrole()==1){
                user.setRole("管理员");
            }else if(user.getUrole()==2){
                user.setRole("经理");
            }else if(user.getUrole()==3){
                user.setRole("普通用户");
            }
            request.setAttribute("user",user);
            request.getRequestDispatcher("/userView.jsp").forward(request,response);
        }else if ("excle".equals(action)){
            //输入姓名
            String name = request.getParameter("name");
            String sname=null;
            if(name!=null) {
                sname  = new String(name.getBytes("iso-8859-1"), "utf-8");
            }
            UserPage up = new UserPage();
            up.setInputname(sname);
            //每页条数
            Integer pagerow = 7;
            up.setPageRow(pagerow);
            //总条数
            Integer count = service.findAllCount(up);
            up.setUserCount(count);
            //总页数
            Integer sumpage =count%pagerow==0?count/pagerow:count/pagerow+1;
            up.setSumPage(sumpage);
            //当前页码
            String thepage = (request.getParameter("thepage"));
            Integer  thepage1;
            if (thepage==null) {
                thepage1=1;
            }else {
                thepage1  = Integer.parseInt(thepage);
                if (thepage1<1){
                    thepage1=1;
                }
                if(thepage1>sumpage){
                    thepage1=sumpage;
                }
            }
            up.setThePage(thepage1);
            //当前页面首条索引
            Integer thepagefirst = 0;
            up.setThePageFirst(thepagefirst);
            List<User> list1 = service.findAllbypage(up);
            for(User user : list1){
                //性别转化
                if (user.getUgender()==0){
                    user.setGender("女");
                }else{
                    user.setGender("男");
                }
                //年龄转化
                String bir = new SimpleDateFormat("yyyy").format(user.getUbirthday());
                Date time=new Date();
                DateFormat format=new SimpleDateFormat("yyyy");
                String now=format.format(time);
                Integer birint = Integer.parseInt(bir);
                Integer nowint = Integer.parseInt(now);
                int age = nowint-birint;
                user.setAge(age);
                //级别转化
                if (user.getUrole()==1){
                    user.setRole("管理员");
                }else if(user.getUrole()==2){
                    user.setRole("经理");
                }else if(user.getUrole()==3){
                    user.setRole("普通用户");
                }
            }
            // 第一步，创建一个webbook，对应一个Excel文件
            HSSFWorkbook wb = new HSSFWorkbook();
            // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
            HSSFSheet sheet = wb.createSheet("学生表一");
            // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
            HSSFRow row = sheet.createRow((int) 0);
            // 第四步，创建单元格，并设置值表头 设置表头居中
            HSSFCellStyle style = wb.createCellStyle();
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

            HSSFCell cell = row.createCell((short) 0);
            cell.setCellValue("用户编码");
            cell.setCellStyle(style);
            cell = row.createCell((short) 1);
            cell.setCellValue("用户姓名");
            cell.setCellStyle(style);
            cell = row.createCell((short) 2);
            cell.setCellValue("性别");
            cell.setCellStyle(style);
            cell = row.createCell((short) 3);
            cell.setCellValue("年龄");
            cell.setCellStyle(style);
            cell = row.createCell((short) 4);
            cell.setCellValue("电话");
            cell.setCellStyle(style);
            cell = row.createCell((short) 5);
            cell.setCellValue("用户类型");
            cell.setCellStyle(style);

            List list = list1;

            for (int i = 0; i < list.size(); i++)
            {
                row = sheet.createRow((int) i + 1);
                User u = (User) list.get(i);
                // 第四步，创建单元格，并设置值
                row.createCell((short) 0).setCellValue((String) u.getUcode());
                row.createCell((short) 1).setCellValue(u.getUname());
                row.createCell((short) 2).setCellValue((String) u.getGender());
                row.createCell((short) 3).setCellValue((int) u.getAge());
                row.createCell((short) 4).setCellValue((String) u.getUphone());
                row.createCell((short) 5).setCellValue((String) u.getRole());

            }
            try
            {
                FileOutputStream fout = new FileOutputStream("E:/Test.xls");
                wb.write(fout);
                fout.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            request.setAttribute("up",up);
            request.setAttribute("list1",list1);
            request.getRequestDispatcher("/userList.jsp").forward(request,response);
            return;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }
}