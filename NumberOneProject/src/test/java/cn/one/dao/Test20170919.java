package cn.one.dao;

import cn.one.entity.User;
import cn.one.entity.UserPage;
import cn.one.until.until;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class Test20170919 {
    @Test
    public void isLogin(){
        SqlSession session = until.getsession();
        IUserDAO mapper = session.getMapper(IUserDAO.class);
        UserPage userPage = new UserPage();
        Integer count = mapper.findAllCount(userPage);
        System.out.println(count);
    }
    @Test
    public void findAll(){
        SqlSession session = until.getsession();
        IUserDAO mapper = session.getMapper(IUserDAO.class);
        List<User> list = mapper.findAll();
        for (User user : list){
            System.out.println(user.getUgender());
        }
    };
}