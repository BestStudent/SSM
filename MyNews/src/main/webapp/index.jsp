<%@ page language="java" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<table border="">
    <tr>
        <td>编号</td>
        <td>标题</td>
        <td>访问量</td>
        <td>评论次数</td>
    </tr>
    <c:forEach items="${list}" var="news">
        <tr>
            <td>${news.newsid}</td>
            <td><a href="NewsServlet?action=show&id=${news.newsid}">${news.newstitle}</a></td>
            <td>${news.clickcount}</td>
            <td>${news.pingluncishu}</td>
        </tr>
    </c:forEach>
</table>
<input type="text" value="${page.thePage}" width="10px" readonly="readonly">
<a href="NewsServlet?action=null&thepage=${page.thePage-1}">上一页</a>
<a href="NewsServlet?action=null&thepage=${page.thePage+1}">下一页</a>
</body>
</html>
