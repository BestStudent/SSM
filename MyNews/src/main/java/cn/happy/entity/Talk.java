package cn.happy.entity;

import java.util.Date;

public class Talk {
    private Long tid;

    private String content;

    private Date talktime;

    private Long nid;

    private String talktime1;



    public String getTalktime1() {
        return talktime1;
    }

    public void setTalktime1(String talktime1) {
        this.talktime1 = talktime1;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getTalktime() {
        return talktime;
    }

    public void setTalktime(Date talktime) {
        this.talktime = talktime;
    }

    public Long getNid() {
        return nid;
    }

    public void setNid(Long nid) {
        this.nid = nid;
    }
}