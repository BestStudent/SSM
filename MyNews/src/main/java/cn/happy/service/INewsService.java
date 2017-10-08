package cn.happy.service;

import cn.happy.entity.News;
import cn.happy.entity.Page;
import cn.happy.entity.Talk;

import java.util.List;

public interface INewsService {
    public List<News> findAllbypage(Page page);
    public int findAllCount();
    public News findOne(int id);
    public List<Talk> findTalk(int id);
}