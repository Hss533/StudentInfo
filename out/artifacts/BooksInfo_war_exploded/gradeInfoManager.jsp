<%--
  Created by IntelliJ IDEA.
  User: hu
  Date: 2018/3/19
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!--使用ajax-->
    <title>班级管理系统</title>
    <<script type="text/javascript" src="jquery/jquery-3.2.1/jquery-3.2.1.min.js"></script>
    <script>
        function listFun()
        {
            var xmlHttp;
            if(window.XMLHttpRequest)
            {
                xmlHttp=new XMLHttpRequest();

            }else{
                xmlHttp=new ActiveXObject();
            }
            xmlHttp.onreadystatechange=function()
            {
                if(xmlHttp.readyState==4&&xmlHttp.status==200)
                {


                    document.getElementById("list").innerHTML=xmlHttp.responseText;

                }
            };
            xmlHttp.open("post","GradeList",true);
            xmlHttp.setRequestHeader( "Content-Type", "text/html;charset=UTF-8" );
//          xmlHttp.setRequest Header("Content-type","application/x-www-form-urlencoded");
            xmlHttp.send();
        }
        function deleteNum()
        {
            var num=document.getElementById("deleteNum").value;

            var xmlHttp;
            if(window.XMLHttpRequest)
            {
                xmlHttp=new XMLHttpRequest();
            }
            else{
                xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlHttp.onreadystatechange=function (){
                if(xmlHttp.readyState==4&&xmlHttp.status==200)
                {
                    if(xmlHttp.responseText=="succeed")
                    {
                        /*删除成功*/
                        document.getElementById("delete").innerHTML="删除成功";
                    }
                    else{
                        /*删除失败*/
                        document.getElementById("delete").innerHTML="删除失败";
                    }
                }

            };
            xmlHttp.open("post","GradeDelete",true);
            xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
            xmlHttp.send("num="+num);
        }
        function addGrade()
        {
            if(document.getElementById("addGradeName").value=="")
            {
                alert("班级名称不能为空");
                return;
            }
            var gradeName=document.getElementById("addGradeName").value;
            var gradeDesc=document.getElementById("addGradeDesc").value;
            var xmlHttp;
            if(window.XMLHttpRequest)
            {
                xmlHttp=new XMLHttpRequest();
            }
            else{
                xmlHttp=new ActiveXObject("microsoft.XMLHTTP");
            }
            xmlHttp.onreadystatechange=function ()
            {
                if(xmlHttp.readyState==4&&xmlHttp.status==200)
                {
                    if(xmlHttp.responseText=="succeed")
                    {
                        document.getElementById("addText").innerHTML="添加成功";
                    }
                    else{
                        document.getElementById("addText").innerHTML="添加失败";
                    }

                }
            }
            xmlHttp.open("post","GradeAdd",true);
            xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
            xmlHttp.send("gradeName="+gradeName+"&gradeDesc="+gradeDesc);
        }
        //鼠标点击数事件
       function modifyGrade() {
           alert("hss");
           var num=document.getElementById("modifyID").value;
           var xmlHttp;
           if(window.XMLHttpRequest)
           {
               xmlHttp=new XMLHttpRequest();
           }else{
               xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
           }
           xmlHttp.onreadystatechange=function () {
               if(xmlHttp.readyState==4&&xmlHttp.status==200)
               {
                   document.getElementById("gradeModifyName").value=xmlHttp.responseText;
                   document.getElementById("gradeModifyDesc").val
               }
           }
           xmlHttp.open("post","GetAjaxName",true);
           xmlHttp.getResponseHeader("Content-type","application/x-www-form-urlencoded");
           xmlHttp.send("num="+num);
        }
    </script>
</head>
<body>
<div>
    <input type="button" value="点击此出现b班级清单" onclick="listFun()">
    <div id="list" style="color: #000000;">
    </div>
</div>
<div>
    <input type="button" value="点击此删除班级" onclick="deleteNum()">
    <input type="text" id="deleteNum">
    <div id="delete" style="color: brown;"></div>
</div>
<div>
    <br>
    <input type="button" value="点击此添加学生" onclick="addGrade()">
    <br>
    添加班级的姓名<input type="text" id="addGradeName">
    <br>
    添加班级的简介<textarea id="addGradeDesc" rows="10" cols="30"></textarea>
    <div id="addText" style="color: red;"></div>
</div>
<div style="padding: 20px;">
    <table border="1px">
        <tr>
            <td width="30px">
                请填写要修改的班级序号
            </td>
            <td>
                <input type="text" id="modifyID">
            </td>
        </tr>
        <tr >
            <td colspan="2">
                <input type="button" value="点击此修改" onclick="modifyGrade()" id="modify">
            </td>
        </tr>
        <tr>
            <td>
                班级名称
            </td>
            <td>
                <input type="text" id="gradeModifyName">
            </td>
        </tr>
        <tr>
            <td valign="top">
                 班级简介
            </td>
            <td>
                 <textarea id="gradeModifyDesc" rows="10" cols="50"></textarea>
            </td>
        </tr>
        <tr>
            <td>
                <input type="button" onclick="modifyGradeOk()" value="确认" >
            </td>
        </tr>
    </table>
</div>
</body>
</html>
