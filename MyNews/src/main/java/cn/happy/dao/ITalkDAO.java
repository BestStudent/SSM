package cn.happy.dao;

import cn.happy.entity.Talk;

public interface ITalkDAO {
    public int addTalk(Talk talk);
    public int findcishu(int nid);
}