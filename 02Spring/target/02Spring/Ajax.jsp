<%@ page language="java" pageEncoding="utf-8" isELIgnored="false" %>
<html>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
    var  data = {"name":"微冷的雨","age":"20","address":"河南安阳"};
    var data2 =  [{"name":"微冷的雨","age":"20","address":"北京上地"},
                   {"name":"微热的翔","age":"22","address":"河南郑州"}]
    $(function () {
        $("[name=uname]").blur(function () {
            /*oldAjax();*/
            /*newAjax();*/
            /*alerttt();*/
            /*alerttt2();*/
        })
    })
    function alerttt() {
        alert(data.name+"\r\n"+data.age+"\r\n"+data.address);
    }
    function alerttt2() {
        var $table=$("<table border='1'></table>").append("<tr><td>姓名</td><td>年龄</td><td>地址</td></tr>");
        $("#objectArrayDiv").append($table);
        $.each(data2,function (i,dom) {
          $table.append("<tr><td>"+dom.name+"</td><td>"+dom.age+"</td><td>"+dom.address+"</td></tr>");
        });
    }
    function oldAjax() {
        var xhr = null;
        if(window.XMLHttpRequest){
            xhr = new XMLHttpRequest();
        }else{
            xhr = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xhr.open("post","AjaxServlet",true);
        xhr.onreadystatechange=function () {
            if (xhr.readyState==4&&xhr.status==200){
                var data = xhr.responseText;
                $("#msg").html(data);
            }
        };
        xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
        xhr.send("uname="+$("[name=uname]").val());
    }
    function newAjax() {
        $.ajax({
            url:"AjaxServlet",
            type:"POST",
            data:{"uname":$("[name=uname]").val()},
            async:true,
            success:function (data) {
                $("#msg").html(data);
            }
        });
    }
</script>

<body>
<input name="uname">
<a id="msg"></a>
<div id="objectArrayDiv"></div>
</body>
</html>
