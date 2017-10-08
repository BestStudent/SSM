package cn.happy.dao;

import cn.happy.entity.dept;
import cn.happy.until.until;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class Test20170917 {
    @Test
    public void add(){
        SqlSession session = until.getsession();
        IDeptDao mapper = session.getMapper(IDeptDao.class);
        dept d = new dept();
        d.setName("laosi");
        mapper.add(d);
        session.commit();
        System.out.println(d.getId());
    }
    @Test
    public void find(){
        SqlSession session = until.getsession();
        IDeptDao mapper = session.getMapper(IDeptDao.class);
        String name = "laosi";
        List<dept> list = mapper.finddeptByManyConditionByIndex(name);
        for (dept dept : list){
            System.out.println(dept.getId());
        }
    }
    //不定条件查询
    @Test
    public void findsomebymanycondition(){
        SqlSession session = until.getsession();
        IDeptDao mapper = session.getMapper(IDeptDao.class);
        dept dept = new dept();
        dept.setName("lao");
        dept.setId1(7);
        List<dept> list = mapper.findsomebymanycondition(dept);
        for (dept d : list){
            System.out.println(d.getId());
        }
    }

}