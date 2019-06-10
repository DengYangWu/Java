<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 5/25/2019
  Time: 9:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Twitter</title>
    <meta name="viewport" content="width=device-width,maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <link rel="icon" href="img/favicon.ico" />
    <link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-3.1.1.min.js"></script>
</head>
<style>
    html{font-size:62.5%;}
    body {font:normal 100% Arial,sans-serif;font-size:14px; font-size:1.4rem;overflow-x: hidden; }
    body{margin:0;padding:0;}
    *{margin:0;padding:0;}
    body{background-color: #e6ecf0;height: 100%;    background: #e6ecf0;
        color: #14171a;
        font-size: 14px;

        overflow-y: scroll; }
    .topbar{
        border-bottom: 1px solid rgba(0,0,0,0.05);
        position: fixed;
        top: 0;
        right: 0;
        left: 0;
        z-index: 1000;
        height: 49px;
    }
    .global{
        border-bottom: 1px solid rgba(0,0,0,0.25);
        height: 46px;
        position: relative;
        width: 100%;
    }
    .global-nav{
        background: #fff;
        height: 46px;
    }
    .container{
        max-width:1190px;
        height: 100%;

        width: auto;
        position: relative;
        margin:0 auto;
    }
    .icon{
        width: 25px;
        height: 20px;

        position: absolute;
        left: 50%;


        color: #1da1f2;
        cursor: pointer;

        margin-top: -1px;
        margin-left: -20px;
        display: inline-block;
        transition: all .25s ease-in-out;

        background: url("img/favicon.png")no-repeat 10px;
    }
    .pushstate{
        position: absolute;
        left: 50%;


        display: none;
        height: 26px;
        margin: 11px 0 0 -26px;
        vertical-align: top;
        width: 26px;
    }
    .nav1{
        display: inline-block;


    }
    .nav1>li{
        padding: 8px;
        padding-top: 10px;
        text-align: center;
        float: left;
        list-style: none;

        display: inline-block;

        cursor:pointer;
    }
    .nav1>li>a{
        text-decoration:none;
    }
    #global-nav-home{

        height: 46px;
        overflow: hidden;
        color: #66757f;
        position: relative;
        border-bottom-color: #1DA1F2;
        border-bottom: 4px solid #1c94e0;
    }
    .js-nav{
        font-size: 18px;
        font-weight: bold;
        transition: all .15s ease-in-out;
        color: inherit;
        background-color: transparent;
        padding: 8px;
    }
    #moments{
        height: 30px;
        overflow: hidden;
    }
    #searchOut{
        float: right;
        text-align: left;

    }
    .form-search{
        float: left;
        height: 33px;
        margin: 7px 15px 0 0;
        font-size: 12px;
        width: 221px;
    }
    .vis{
        border: 0;
        clip: rect(0 0 0 0);
        height: 1px;
        margin: -1px;
        overflow: hidden;
        padding: 0;
        position: absolute;
        width: 1px;
    }
    .search-input{
        background-color: #f5f8fa;
        border-radius: 21px;
        border: 1px solid #e6ecf0;
        -moz-box-sizing: border-box;
        box-sizing: border-box;
        color: #14171a;
        display: block;
        font-size: 12px;
        height: 32px;
        line-height: 16px;
        padding: 8px 32px 8px 12px;
        transition: all .2s ease-in-out;
        width: 100%;
        float: left;
    }
    .searche-icon{
        cursor: pointer;
        display: block;
        height: 26px;
        position: absolute;
        right: 149px;
        top: 16px;
        width: 20px;
    }
    .icon-med{
        background-color: transparent;
        color: #66757f;
        height: auto;
        width: auto;
        background: transparent;
        display: inline-block;
        font-style: normal;
        vertical-align: baseline;
        position: relative;
        border: 0;
    }
    .nav-right{
        align-items: center;
        display: -moz-inline-box;
        display: -ms-inline-flexbox;
        display: inline-flex;
        height: 100%;
        position: relative;
        z-index: 5;
        margin: 0;
        list-style: none;
        padding: 0;


    }
    .nav-right>li{

        float: left;
        position: relative;
    }
    .medropdown{

    }
    .btn-heatimg{
        border: 1px slategrey solid;
        border-radius:50%;
        opacity: 1;
        overflow: hidden;
        padding: 0;
        color: inherit;
        display: block;
        font-size: 13px;
        font-weight: bold;
        width: 35px;
        height: 35px;
        line-height: 1;
    }
    .com{
        margin-left: 16px;
    }
    #global-new-tweet{
        background-color: #4AB3F4;
        border-color: transparent;
        border: 1px solid #1da1f2;
        color: #fff;
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

    }
/*面板*/
    .me{
        float: left;
        border: 0;
        text-align: left;
        clear:both;
        width: 290px;
        margin-top: 10px;
    }
    .module{
        border: 1px solid #e6ecf0;
        background: #fff;
        position: relative;
        margin-bottom: 10px;
    }
    .u-bg{
        background-color: #1DA1F2 !important;
        background-size: 100%;
        height: 95px;
        border-top-left-radius: inherit;
        border-top-right-radius: inherit;
        background-position: 0 50%;
        width: 100%;
        padding: 0;
        margin-top: -1px;
        display: block!important;
    }
    .content-t{

    }
    .u-inline{
        background-color: #fff;
        border-radius: 50%;
        margin: -30px 0 0 8px;
        padding: 1px;
        vertical-align: bottom;
        display: inline-block!important;
        max-width: 100%;
    }
    .ava{
        transition: box-shadow .15s ease-in-out;
        border-radius: 50%;
        height: 72px;
        width: 72px;
        border: 2px solid #fff;
        -moz-box-sizing: border-box;
        box-sizing: border-box;
        color: #fff;
    }
    .acc-group{
        position: absolute;
        top: 103px;
        left: 90px;
        width: 185px;
    }
    .u-text{
        font-weight: bold;
        font-size: 18px;
        line-height: 25px;
        margin: -1px 0 -2px 0;
        max-width: 100%;
        overflow: hidden!important;
        text-overflow: ellipsis!important;
        white-space: nowrap!important;
        word-wrap: normal!important;
    }
    .u-dir{

        text-align: left!important;
        unicode-bidi: embed;
        display: inline-block!important;
        max-width: 100%;
    }
    .js-nav{
        font-size: 12px;
        padding-right: 5px;
        color: #66757f;
    }
    .P-stats{
        padding-top: 16px;
        padding-bottom: 16px;
        padding-left: 16px;
        padding-right: 16px;
    }
    .equal {
        table-layout: fixed;
        box-sizing: border-box;
        display: table;
        margin: 0;
        min-width: 100%;
        padding: 0;

        text-decoration: none;
    }

    .sizeFit{
        vertical-align: bottom;
        display: table-cell;
        padding: 0;
        box-sizing: border-box;
        line-height: 1;
        overflow: hidden;
        transition: all .15s ease-in-out;
        width: 50px;
    }
    .sizeFit>li{
        display: inline-block;
    }
    .u-textUserColor{
        text-decoration: none;
        color: #1DA1F2 !important;
        display: block!important;
    }
    .u-textUserColor>span{
        display:block;
    }

    .tw{

        color: #657786;
        font-size: 12px;
        font-weight: bold;
        letter-spacing: .02em;
        line-height: 16px;
        overflow: hidden;
        transition: color .15s ease-in-out;
    }
    .sv{
        display: block;
        font-size: 18px;
        font-weight: bold;
        padding-top: 3px;
        transition: color .15s ease-in-out;
    }
    /*模板2*/
    .module1{
        float: left;
        width: 290px;
        background-color: #fff;
        background-clip: inherit;
        border: 1px solid #e6ecf0;
        line-height: inherit;
        padding: 15px;
        clear:both;
    }
    .inner{
        border-bottom-right-radius: inherit;
        border-bottom-left-radius: inherit;
        border-top-left-radius: inherit;
        border-top-right-radius: inherit;
    }
    #flex{
        color: #657786;
        font-size: 12px;
    }
    .trend>li{
        display: block;
        list-style-type: disc;
        margin-block-start: 1em;
        margin-block-end: 1em;
        margin-inline-start: 0px;
        margin-inline-end: 0px;
        padding-inline-start: 0px;
        margin-top: -4px;
        display: block;
        line-height: 17px;
        margin-bottom: 10px;
        font-size: 14px;

        word-wrap: break-word;
    }
    /*中间模板*/
    #center-mo{
        margin: 0 10px;
        float: left;
        width: 590px;
        border: 1px red solid;
    }
    .tweet-box{

        border: 1px solid #e6ecf0;
    }
    .dashboard-right{

        border: 1px red solid;
        float: left;

        width: 240px;
    }
</style>
<body>
<%--顶部--%>
<div class="topbar">
    <div class="global">
        <div class="global-nav">
            <div class="container">
                <h1 class="icon" style=" text-align:center;width: 50px; height: 50px;"></h1>
                <div class="pushstate"></div>
                <div style="display: inline-block;">
                    <ul class="nav1">
                        <li id="global-nav-home">
                            <i class="glyphicon glyphicon-home"></i><a class="js-nav">主页</a>
                        </li>
                        <li id="moments">
                            <i class="glyphicon glyphicon-flash"></i><a class="js-nav">瞬间</a>
                        </li>
                        <li>
                            <i class="glyphicon glyphicon-bell"></i><a class="js-nav">通知</a>
                        </li>
                        <li>
                            <i class="glyphicon glyphicon-comment"></i><a class="js-nav">私信</a>
                        </li>
                    </ul>
                </div>
                <div id="searchOut">
                    <div role="search_bu">
                        <form action="searchAction" class="form-search">
                            <label class="vis">搜索询问</label>
                            <input class="search-input" type="text" placeholder="搜索 Twitter">
                            <span class="searche-icon glyphicon glyphicon-search">
                                <button type="submit" class="icon-med"></button>
                            </span>
                        </form>
                        <ul class="nav-right">
                            <li class="medropdown">
                                <a href="/settings" class="btn-heatimg">
                                    <img class="avatar" src="img/favicon.png">
                                </a>
                            </li>
                            <li class="com">
                                <button id="global-new-tweet">发推</button>
                            </li>
                        </ul>
                    </div>
                </div>
<%--                中间面板--%>
                <div class="me">
                    <div class="module">
                        <a class="u-bg">
                        </a>
                        <div class="content-t">
                            <a href="/" title="" class="u-inline">
                                <img class="ava">
                            </a>
                            <div class="acc-group">
                                <div class="u-text">
                                    <a class="u-name" href="/">username</a>
                                    <span class="user"></span>
                                </div>
                                <span class="u-dir">
                                    <a class="js-nav">
                                        <span class="u-dir">@username</span>
                                    </a>
                                </span>
                            </div>
                            <div class="P-stats">
                                <ul class="equal">
                                    <li class="sizeFit">
                                        <a class="u-textUserColor" href="/">
                                            <span class="tw">推文</span>
                                            <span class="sv">0</span>
                                        </a>
                                    </li>
                                    <li  class="sizeFit">
                                        <a class="u-textUserColor" href="/">
                                            <span class="tw">正在关注</span>
                                            <span class="sv">0</span>
                                        </a>
                                    </li>
                                    <li  class="sizeFit">
                                        <a class="u-textUserColor" href="/">
                                            <span class="tw">关注者</span>
                                            <span class="sv">0</span>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>

<%--                模板2--%>
                <div class="module1">
                    <div class="inner">
                        <div>
                            <h3 style="display: inline-block;"><span>你的趋势</span></h3>·
                            <a href="/">更改</a>
                        </div>
                        <div id="flex">
                            <ul class="trend">
                                <li>
                                    <a>1</a>
                                </li>
                                <li>2</li>
                                <li>3</li>
                                <li>4</li>
                                <li>5</li>
                            </ul>
                        </div>
                    </div>
                </div>
                </div>
                    <div id="center-mo">
                        <div class="tweet-box">123</div>
                        <div class="tweet-box">123</div>
                        <div class="tweet-box">123</div>
                        <div class="tweet-box">123</div>

                    </div>
                    <%--            右边面板--%>
                    <div class="dashboard-right">
                        <div>333</div>
                        <div>333</div>
                        <div>333</div>
                    </div>
            </div>
        </div>

    </div>
</div>
</body>

<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>

</html>
