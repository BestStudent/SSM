package cn.happy.dao;

import cn.happy.entity.dept;
import cn.happy.until.until;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test20170914 {
    @Test
    public void findAll() throws IOException {
        SqlSession session = until.getsession();
        List<dept> list = session.selectList("findall");
        for (dept item:list) {
            System.out.println(item.getId());
            System.out.println(item.getName());
        }
    }
    @Test
    public void addDept() throws IOException {
        String resouce = "mybatis-config.xml";
        //1.1  将硬盘上一个xml变成一个输入流
        InputStream is = Resources.getResourceAsStream(resouce);
        //1.2   使用流对象作为参数创建一个会话工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //1.3  通过会话工厂创建会话对象 session就是程序员和数据库交互的入口
        SqlSession session = factory.openSession();
        IDeptDao mapper = session.getMapper(IDeptDao.class);
        dept d = new dept();
        d.setId1(4);
        d.setName("四号");
        mapper.add(d);
        session.commit();
        System.out.println("add ok");
    }
    @Test
    public void delDept() throws IOException {
        String resouce = "mybatis-config.xml";
        //1.1  将硬盘上一个xml变成一个输入流
        InputStream is = Resources.getResourceAsStream(resouce);
        //1.2   使用流对象作为参数创建一个会话工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //1.3  通过会话工厂创建会话对象 session就是程序员和数据库交互的入口
        SqlSession session = factory.openSession();
        IDeptDao mapper = session.getMapper(IDeptDao.class);
        int id = 5;
        mapper.del(id);
        session.commit();
        System.out.println("del ok");
    }
    @Test
    public void updDept() throws IOException {
        String resouce = "mybatis-config.xml";
        //1.1  将硬盘上一个xml变成一个输入流
        InputStream is = Resources.getResourceAsStream(resouce);
        //1.2   使用流对象作为参数创建一个会话工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //1.3  通过会话工厂创建会话对象 session就是程序员和数据库交互的入口
        SqlSession session = factory.openSession();
        IDeptDao mapper = session.getMapper(IDeptDao.class);
        dept d = new dept();
        d.setId1(3);
        d.setName("第三号2");
        mapper.upd(d);
        session.commit();
        System.out.println("upd ok");
    }
    @Test
    public void findsome(){
        SqlSession session = until.getsession();
        IDeptDao mapper = session.getMapper(IDeptDao.class);
        dept d = new dept();
        d.setName("号");
        List<dept> list =mapper.findsome(d);
        for(dept dept:list){
            System.out.println(dept.getName());
        }
    }
}