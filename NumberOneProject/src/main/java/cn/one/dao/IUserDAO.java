package cn.one.dao;

import cn.one.entity.User;
import cn.one.entity.UserPage;

import java.util.List;

public interface IUserDAO {
    //用于登录的查询
    public User isLogin(User user);
    //分页查询所有
    public List<User> findAllbypage(UserPage up);
    //查询所有
    public List<User> findAll();
    //查询所有条数
    public int findAllCount(UserPage up);
    //删除
    public int delOne(Integer uid);
    //增加
    public int addOne(User user);
    //修改
    public int updOne(User user);
    //根据id查用户信息
    public User findOne(Integer id);

}