package cn.one.entity;

import java.util.List;

public class UserPage {
    private Integer userCount;//用户总计入条数
    private Integer thePage;//当前页
    private Integer pageRow;//每页显示的条数
    private Integer sumPage;//总共多少页
    private Integer thePageFirst;//当前页的首条数据索引
    private String inputname;//输入的名字

    public String getInputname() {
        return inputname;
    }

    public void setInputname(String inputname) {
        this.inputname = inputname;
    }

    public Integer getThePageFirst() {
        return thePageFirst;
    }

    public void setThePageFirst(Integer thePageFirst) {
        this.thePageFirst = (thePage-1)*pageRow;
    }

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }

    public Integer getThePage() {
        return thePage;
    }

    public void setThePage(Integer thePage) {
        this.thePage = thePage;
    }

    public Integer getPageRow() {
        return pageRow;
    }

    public void setPageRow(Integer pageRow) {
        this.pageRow = pageRow;
    }

    public Integer getSumPage() {
        return sumPage;
    }

    public void setSumPage(Integer sumPage) {
        this.sumPage = sumPage;
    }
}