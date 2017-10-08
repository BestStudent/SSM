package cn.happy.service.impl;

import cn.happy.dao.INewsDAO;
import cn.happy.dao.ITalkDAO;
import cn.happy.entity.Talk;
import cn.happy.service.ITalkService;
import cn.happy.until.until;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.apache.ibatis.session.SqlSession;

public class TalkServiceImpl implements ITalkService {
    ITalkDAO dao;
    public TalkServiceImpl(){
        SqlSession session = until.getsession();
        dao= session.getMapper(ITalkDAO.class);
    }

    public int addTalk(Talk talk) {
        return dao.addTalk(talk);
    }

    public int findcishu(int nid) {
        return dao.findcishu(nid);
    }
}