package cn.one.service.impl;

import cn.one.dao.IUserDAO;
import cn.one.entity.User;
import cn.one.entity.UserPage;
import cn.one.service.IUserService;
import cn.one.until.until;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserServiceImpl implements IUserService {
    IUserDAO dao;
    public UserServiceImpl(){
        SqlSession session = until.getsession();
        dao= session.getMapper(IUserDAO.class);
    }
    //用于登录的查询
    public User isLogin(User user) {
        return dao.isLogin(user);
    }
    //分页查询所有
    public List<User> findAllbypage(UserPage up) {
        return dao.findAllbypage(up);
    }
    //查询所有
    public List<User> findAll() {
      return dao.findAll();
    }
    //查询所有条数
    public int findAllCount(UserPage up) {
        return dao.findAllCount(up);
    }
    //删除
    public int delOne(Integer uid) {
        return  dao.delOne(uid);
    }
    //增加
    public int addOne(User user) {
        return dao.addOne(user);
    }
    //修改
    public int updOne(User user){return dao.updOne(user);}
    //根据id查用户信息
    public User findOne(Integer id) {
        return dao.findOne(id);
    }
}