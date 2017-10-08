<%@ page language="java" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<script type="text/javascript" src="js/jquery-1.8.2.min.js">
</script>
<script type="text/javascript">
     function submit() {
         var path = "TalkServlet?id=${news.newsid}&content="+$("[name=pinglun]").val();
         location.href=path;
     }
</script>
<body>
     <h1>${news.newscontent}</h1>
     <table border="">
          <c:forEach items="${talk}" var="list">
               <tr>
                    <td>
                    ${list.talktime1}
                    </td>
               </tr>
               <tr>
                    <td>${list.content}</td>
               </tr>
          </c:forEach>
     </table>
     <textarea rows="20" cols="50" name="pinglun">

     </textarea>
     <input type="button" value="提交" onclick="submit()">
</body>
</html>
