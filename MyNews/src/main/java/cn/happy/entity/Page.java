package cn.happy.entity;

public class Page
{
    private Integer Count;//用户总计入条数
    private Integer thePage;//当前页
    private Integer pageRow;//每页显示的条数
    private Integer sumPage;//总共多少页
    private Integer thePageFirst;//当前页的首条数据索引

    public Integer getCount() {
        return Count;
    }

    public void setCount(Integer count) {
        Count = count;
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

    public Integer getThePageFirst() {
        return thePageFirst;
    }

    public void setThePageFirst(Integer thePageFirst) {
        this.thePageFirst = thePageFirst;
    }
}