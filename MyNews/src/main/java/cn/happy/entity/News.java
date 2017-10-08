package cn.happy.entity;

public class News {
    private Long newsid;

    private String newstitle;

    private String newscontent;

    private Long clickcount;

    private int pingluncishu;

    public int getPingluncishu() {
        return pingluncishu;
    }

    public void setPingluncishu(int pingluncishu) {
        this.pingluncishu = pingluncishu;
    }

    public Long getNewsid() {
        return newsid;
    }

    public void setNewsid(Long newsid) {
        this.newsid = newsid;
    }

    public String getNewstitle() {
        return newstitle;
    }

    public void setNewstitle(String newstitle) {
        this.newstitle = newstitle == null ? null : newstitle.trim();
    }

    public String getNewscontent() {
        return newscontent;
    }

    public void setNewscontent(String newscontent) {
        this.newscontent = newscontent == null ? null : newscontent.trim();
    }

    public Long getClickcount() {
        return clickcount;
    }

    public void setClickcount(Long clickcount) {
        this.clickcount = clickcount;
    }
}