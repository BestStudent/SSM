package cn.one.dao;

import cn.one.entity.User;
import cn.one.until.until;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class Test20170918 {
    @Test
    public void isLogin(){
        SqlSession session = until.getsession();
        IUserDAO mapper = session.getMapper(IUserDAO.class);
        User user = new User();
        user.setUname("admin");
        user.setUpwd("admin");
        User u = mapper.isLogin(user);
        System.out.println(u.getUid());
    }
}