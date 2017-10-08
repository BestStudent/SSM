<%@ page language="java" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>超市账单管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <script type="text/javascript" src="js/jquery-1.8.2.min.js">
    </script>
    <script type="text/javascript">
        //公共变量
        var delId=0;
        function delIdClick(id) {
            delId=id;
        }
        function yesClick() {
            var paths="UserServlet?action=del&id="+delId;
            location.href=paths;
        }
        function check() {
            var paths="UserServlet?action=list&name="+$("[name=inputname]").val();
            location.href=paths;
        }
        function excle() {
            var statu = confirm("确定导出吗?");
            if(!statu){
                return false;
            }
            var paths="UserServlet?action=excle&thepage=${up.thePage}&name="+$("[name=inputname]").val();
            location.href=paths;
        }
        function addpage() {
            var paths="UserServlet?action=list&thepage=${up.thePage-1}&name="+$("[name=inputname]").val();
            location.href=paths;
        }
        function minuspage() {
            var paths="UserServlet?action=list&thepage=${up.thePage+1}&name="+$("[name=inputname]").val();
            location.href=paths;
        }
    </script>
</head>
<body>
<!--头部-->
    <header class="publicHeader">
        <h1>超市账单管理系统</h1>
        <div class="publicHeaderR">
            <p><span>下午好！</span><span style="color: #fff21b"> Admin</span> , 欢迎你！</p>
            <a href="login.jsp">退出</a>
        </div>
    </header>
<!--时间-->
    <section class="publicTime">
        <span id="time">2015年1月1日 11:11  星期一</span>
        <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
    </section>
<!--主体内容-->
    <section class="publicMian ">
        <div class="left">
            <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
            <nav>
                <ul class="list">
                    <li><a href="billList.html">账单管理</a></li>
                    <li><a href="providerList.html">供应商管理</a></li>
                    <li  id="active"><a href="userList.html">用户管理</a></li>
                    <li><a href="password.html">密码修改</a></li>
                    <li><a href="login.jsp">退出系统</a></li>
                </ul>
            </nav>
        </div>
        <div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>用户管理页面</span>
            </div>

                <div class="search">
                    <span>用户名：</span>
                    <input type="text" placeholder="请输入用户名" name="inputname" value="${up.inputname}"/>
                    <input type="button" value="查询" onclick="check()"/>
                    <input type="button" value="导出本页" onclick="excle()"/>
                    <input type="file" value="选择路径"/>
                    <a href="userAdd.jsp">添加用户</a>
                </div>

            <!--用户-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="10%">用户编码</th>
                    <th width="20%">用户名称</th>
                    <th width="10%">性别</th>
                    <th width="10%">年龄</th>
                    <th width="10%">电话</th>
                    <th width="10%">用户类型</th>
                    <th width="30%">操作</th>
                </tr>
                <c:forEach items="${list1}" var="item">
                <tr>
                    <td>${item.ucode}</td>
                    <td>${item.uname}</td>
                    <td>${item.gender}</td>
                    <td>${item.age}</td>
                    <td>${item.uphone}</td>
                    <td>${item.role}</td>
                    <td>
                        <a href="UserServlet?action=view&id=${item.uid}"><img src="img/read.png" alt="查看" title="查看"/></a>
                        <a href="UserServlet?action=show&id=${item.uid}"><img src="img/xiugai.png" alt="修改" title="修改"/></a>
                        <a href="#" class="removeUser"><img src="img/schu.png" alt="删除" title="删除" onclick="delIdClick(${item.uid})"/></a>
                    </td>
                </tr>
                </c:forEach>
            </table>
            <a onclick="addpage()" href="#">上一页</a>${up.thePage}/${up.sumPage}<a onclick="minuspage()" href="#">下一页</a>

        </div>
    </section>
<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该用户吗？</p>
            <a href="#" id="yes" onclick="yesClick()">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

    <footer class="footer">
        版权归北大青鸟
    </footer>

<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/time.js"></script>

</body>
</html>