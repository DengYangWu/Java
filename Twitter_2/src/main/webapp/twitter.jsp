<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Twitter 一一 聚焦当下。</title>
    <meta name="viewport" content="width=device-width,maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <link rel="icon" href="img/favicon.ico" />
    <script src="js/jquery-3.1.1.min.js"></script>
</head>
<style>
    /*整体*/
    html{font-size:62.5%;}
    body {font:normal 100% Arial,sans-serif;font-size:14px; font-size:1.4rem;overflow-x: hidden; }
    body{margin:0;padding:0;}
    *{margin:0;padding:0;}
    div{
        display: block;
    }
    .bigdiv{
        margin: auto;
    }
    .bigdiv>div{
        flex-direction: row-reverse;
        flex-grow: 1;
        width: 55rem;
        height: 50rem;
        flex-direction: column;
        display: flex;
        height: 100%;
        overflow:auto; zoom:1;
        text-align: center;

    }
    #onediv{

        position: relative;
        background: #1da1f2;
        align-items: center;
        overflow: hidden;
        justify-content: center;
        align-items: center;

    }
    #twodiv{
        margin-left: auto;
        margin-right: auto;
        position: relative;
        justify-content: center;
        align-items: center;
        overflow: hidden;
        min-height: 100%;
        float: right;
        text-decoration: none;
    }
    /*大图标*/
    g{
        transform: translate(-286, -117);
        fill-rule: nonzero;
        fill: rgb(27, 149, 224);
        transform-origin: 0px 0px;
    }
    .twitterIcon-bird{
        max-width: none;
        position: absolute;
        height: 140vh;
        right: -80vh;
        top: -20vh;
    }
    svg:not(:root){
        position: absolute;
        overflow: hidden;
    }
    .Icon{
        background: transparent;
        display: inline-block;
        font-style: normal;
        vertical-align: baseline;
        position: relative;
    }
    .Icon:before{
        display: block;
        font-family: "edgeicons";
        font-weight: normal;
        font-style: normal;
        text-align: center;
        -webkit-font-smoothing: antialiased;
    }
    #bird-text{
        max-width: 440px;
    }
    #bird-text>ul{

        text-align: left;
        list-style: none;
        justify-content: center;
        align-items: center;
        color: #fff;
        position: relative;
        font-size: 18px;
        font-weight: bold;
        line-height: 24px;
        margin: 48px auto;


    }
    #bird-text>ul>li{
        margin-top: 48px;
    }
    /*登陆*/
    .Icon-bird{
        width: 40px;
        height: 40px;
        background: url("img/favicon.ico")no-repeat 4px 5px;
    }
    #button-login{
        border-radius: 100px;
        box-shadow: none;
        cursor: pointer;
        font-size: 14px;
        font-weight: bold;
        line-height: 20px;
        padding: 6px 16px;
        position: relative;
        text-align: center;
        white-space: nowrap;
        background-color: #fff;
        border: 1px solid #1da1f2;
        color: #1da1f2;
        text-decoration: none;
    }
    #button-login:hover{
        border:2px solid #1da1f2;
    }
    #login-div{
        max-width: 350px;
    }
    #login-div-icon{
        justify-content: space-between;
        margin: 16px auto;
        display: flex;
        align-items: center;
    }
    h2{
        display: block;
        font-size: 1.5em;
        margin-block-start: 0.83em;
        margin-block-end: 0.83em;
        margin-inline-start: 0px;
        margin-inline-end: 0px;
        font-weight: bold;
        text-rendering: optimizeLegibility;
        color: #14171a;
        font-size: 18px;
        line-height: 24px;
        margin: 16px auto;
        text-align: left;
    }
    #input-style>div>input{
        border-radius: 100px;
        box-shadow: none;
        cursor: pointer;
        font-size: 14px;
        font-weight: bold;
        line-height: 20px;
        padding: 6px 16px;
        position: relative;
        text-align: center;
        white-space: nowrap;

        width: 250px;
        margin-bottom: 16px;


    }
    #input-style>div>#input_sign{
        background-color: #1da1f2;
        border: 1px solid #1da1f2;
        color: #fff;
    }
    #input-style>div>#input_login{
        background-color: #fff;
        border: 1px solid #1da1f2;
        color: #1da1f2;

    }
</style>
<body>
<div class="bigdiv">
<%--    登陆注册面--%>
    <div id="twodiv">
        <div id="login-div">
            <div id="login-div-icon">
                <span class="Icon Icon-bird"></span>
                <a id="button-login" href="login.jsp">登陆</a>
            </div>
            <div>
                <h1>看看世界上的新鲜事</h1>
                <h2>现在就加入 Twitter。</h2>
            </div>
            <div id="input-style">
                <div><input id="input_sign" type="button" value="注册"></div>
                <div><input id="input_login" type="button" value="登陆"></div>
            </div>
        </div>
    </div>
<%--    蓝色面--%>
    <div id="onediv">
        <!--bird-->
        <svg class="twitterIcon-bird" viewBox="0 0 1208 982" version="1.1" xmlns="http://www.w3.org/2000/svg">
            <g transform="translate(-286.000000, -117.000000)"  fill-rule="nonzero" fill="#1B95E0">
            <path id="bird" d="M1493.75308,233.195911 C1449.31783,252.922544 1401.56126,266.207828 1351.43951,272.19627 C1402.61804,241.549536 1441.92034,192.987798 1460.3889,135.116296 C1412.53168,163.498493 1359.49119,184.130942 1303.02874,195.252335 C1257.88897,147.093181 1193.42514,117 1122.16771,117 C962.190754,117 844.636121,266.258151 880.768067,421.202806 C674.896491,410.886582 492.324484,312.253414 370.089808,162.341063 C305.17308,273.705962 336.423691,419.391176 446.731805,493.16476 C406.171431,491.856361 367.925917,480.734968 334.561738,462.165765 C331.844294,576.95263 414.122472,684.342008 533.287442,708.245454 C498.413572,717.706186 460.218381,719.9204 421.368991,712.47259 C452.871217,810.904465 544.358512,882.514158 652.854997,884.52708 C548.686294,966.201382 417.443793,1002.68559 286,987.186091 C395.653915,1057.48739 525.940278,1098.50067 665.838342,1098.50067 C1125.89162,1098.50067 1385.81015,709.956437 1370.10936,361.469352 C1418.52012,326.494836 1460.53987,282.864756 1493.75308,233.195911 Z"></path>
            </g>
        </svg>
        <div id="bird-text">
            <ul>
                <li><span class="Icon Icon--search"></span>关注你的兴趣所在。</li>
                <li>听听大家在谈论什么。</li>
                <li>加入对话。</li>
            </ul>
        </div>
    </div>
</div>
<div>
    <div style="text-align: center; width: 100%;
    bottom: 0;    display: inline-block;
    padding: 0 9px 0 9px;    color: #aab8c2;
    font-size: 12px;">
        关于
        帮助中心
        博客
        状态
        工作机会
        条款
        隐私政策
        Cookies
        广告信息
        商标
        应用
        广告
        市场营销
        企业
        开发者
        目录
        设置
        © 2019 Twitter
    </div>
</div>
</body>
</html>