<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/5/31
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>signup</title>
    <meta name="viewport" content="width=device-width,maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <link rel="icon" href="img/favicon.ico" />
    <script src="<%=request.getContextPath()%>/js/jquery-3.1.1.min.js"></script>
</head>
<style>
    /*整体*/
    div{ word-wrap: break-word; word-break: normal; }
    html{font-size:62.5%;}
    body {font:normal 100% Arial,sans-serif;font-size:14px; font-size:1.4rem;overflow-x: hidden; }
    body{margin:0;padding:0;}
    *{margin:0;padding:0;}
    #bg{
        background-color: rgba(0, 0, 0, 0.3);
    }
    #center_div{
        background-color: rgba(255,255,255,1.00);


        width: 480px;
        height: 500px;
        overflow-x: hidden;
        overflow-y: hidden;
        border-radius: 14px;
        margin: 0 auto;
        margin-top: 50px;

    }

    .signtext{
        line-height: 1.3125;
        font-size: 19px;
        color: rgb(20, 23, 26);
        margin: 30px 15px 20px 15px;
        font-weight: bold;
    }
    .button_sign{
        display: inline-block;
        background-color: rgb(29, 161, 242);
        width: 80px;
        height: 35px;
        margin-left: 290px;
        border-radius: 15px;
        text-align: center;
        line-height: 2.5em;
        color: #f5f8fa;
        opacity: 0.5;
        border:0;
    }
    #top_div{
        margin-top: 20px;
    }
    #createtext{
        width: 100%;
        display: flex;
        font-size: 19px;
        font-weight: bold;
        margin: 30px 15px 20px 15px;
    }
    .nameinput{
        margin-bottom: 40px;
        margin-left: 35px;
        width: 400px;
        height: 56px;
        line-height: 5px;
        padding-bottom: 10px;
        padding-top: 15px;
        padding-left: 0px;
        padding-right: 0px;
        border-bottom-color: rgb(101, 119, 134);
        border-left-color: rgb(101, 119, 134);
        border-right-color: rgb(101, 119, 134);
        border-top-color: rgb(101, 119, 134);
        background-color: rgb(245, 248, 250);
        border-bottom-width: 2px;
        border-bottom-style: solid;
        border-bottom-left-radius: 2px;
        border-bottom-right-radius: 2px;
        border-top-left-radius: 2px;
        border-top-right-radius: 2px;
    }
    .nameinput>div>input{
        width: 400px;
        height: 30px;
        margin-top: 20px;
        border:0;
    }
    #verify{
        margin-top: 20px;
    }
</style>
<body id="bg">
<div>
    <form action="<%=request.getContextPath()%>/signup" method="post">
        <div id="center_div">
            <div id="top_div">
                <span class="signtext">sign up</span><button type="submit" class="button_sign">注册</button>
            </div>
            <div id="createtext">创建你的账号</div>
            <div class="nameinput">
                <div>名字:</div>
                <div><input type="text" name="aname" id="fouc"></div>
                <div id="verify"></div>
            </div>

            <div class="nameinput">
                <div>密码：</div>
                <div><input type="password" name="apwd" id="foucpwd"></div>
                <div id="verifypwd"></div>
            </div>
        </div>
    </form>
</div>
<input type="hidden" value="<%=request.getContextPath()%>" id="url">
</body>
<script>


    var url=$("#url").val();
    var tr=false;
    $(".button_sign").attr("disabled", true);
    $(this).keyup(function(){
        var name=$("#fouc").val();
        var pwd=$("#foucpwd").val();

        $.ajax({
            type: "POST",
            url: url+"/examine",
            data: {username:$("#fouc").val()},
            dataType: "json",
            success: function(data) {
                if (name != "") {
                    if (data['result'] == "存在") {
                        $("#verify").html('<div id="verify" style="color:red">用户存在</div>');

                    } else {
                        $("#verify").html('<div id="verify" style="color:deepskyblue">OK</div>');
                        tr=true;
                    }
                }else{
                    $("#verify").html('<div id="verify" style="color:red">不能为空！</div>');
                 }
                if (pwd != "") {
                    if(pwd.length>3){
                        $("#verifypwd").html('<div id="verifypwd" style="color:deepskyblue">OK</div>');
                        tr=true;
                    }else{
                        $("#verifypwd").html('<div id="verifypwd" style="color:red">密码为3位以上！</div>');
                    }

                }else{
                    $("#verifypwd").html('<div id="verifypwd" style="color:red">密码不能为空！</div>');
                }
                if(tr==true){
                    $(".button_sign").attr("disabled", false);
                }else{
                    $(".button_sign").attr("disabled", true);
                }

            }//发生错误调用的函数
            ,error: function (errmsg) {
                alert(errmsg);
            }

        });

    })


</script>
</html>
