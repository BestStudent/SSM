package cn.happy.service.impl;

import cn.happy.dao.INewsDAO;
import cn.happy.entity.News;
import cn.happy.entity.Page;
import cn.happy.entity.Talk;
import cn.happy.service.INewsService;
import cn.happy.until.until;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class NewsServiceImpl implements INewsService{
    INewsDAO dao;
    public NewsServiceImpl(){
        SqlSession session = until.getsession();
        dao= session.getMapper(INewsDAO.class);
    }
    public List<News> findAllbypage(Page page) {
        return dao.findAllbypage(page);
    }

    public int findAllCount() {
        return dao.findAllCount();
    }

    public News findOne(int id) {
        return dao.findOne(id);
    }

    public List<Talk> findTalk(int id) {
        return dao.findTalk(id);
    }
}