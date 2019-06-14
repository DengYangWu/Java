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

    body {font:normal 100% Arial,sans-serif;font-size:14px; font-size:1.4rem;overflow-x: hidden; }
    body{margin:0;padding:0;}
    *{margin:0;padding:0;}
    body{background-color: #e6ecf0;height: 100%;
        color: #14171a;
        font-size: 14px;
    overflow-y: scroll}
    .topbar{
        border-bottom: 1px solid rgba(0,0,0,0.05);
        top: 0;
        bottom: 0;
        right: 0;
        left: 0;
        z-index: 1000;
        height: 49px;
        width: 100%;
        height: 100%;

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
        padding: 0px;
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


        right: 149px;
        top: 16px;
        width: 20px;
    }
    .icon-med{
        background-color: transparent;
        height: 10px;
        width: 50px;
        display: inline-block;
        font-style: normal;
        vertical-align: baseline;
        position: relative;
        border: 0px;
        margin-top: -25px;
        margin-left: 165px;
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

    }


    .timeline{
        border-top-left-radius: inherit;
        border-top-right-radius: inherit;
        border: 1px solid #e6ecf0;
    }
    .home-tweet{
        border-radius: 0;
        position: relative;
        background-color: #E8F5FD;
        padding: 30px 15px;
        color: #14171a;
        font-size: 14px;
        line-height: 20px;
    }
    .top-timeline{
        left: 28px;
        position: absolute;
        top: 13px;
        width: 32px;
        height: 32px;
        border-radius: 50%;
        border: 0;
    }
    .t1-form{
        margin-left: 56px;
        margin-bottom: 0;
        display: block;
        margin-top: 0em;
        color: #14171a;
        font-size: 14px;
        line-height: 20px;
    }
    .rich{
        border-color: #C6E7FB;
        background: #fff;
        border: 1px solid #e6ecf0;
        border-radius: 8px;
        line-height: 20px;
    }
    .richeditor{
        position: relative;
        border-radius: inherit!important;
        line-height: 20px;
    }
    .richeditor-scr{
        max-height: none;
        position: relative;
        overflow-y: auto;
        margin: -20px 0;
        border-radius: inherit!important;
    }
    .tweet-box-rich{
        color: #1DA1F2;
        padding-right: 31px;
        overflow-y: hidden;
        word-wrap: normal;
        overflow: hidden;
        white-space: nowrap;
        text-overflow: ellipsis;
        max-height: 36px;
        min-height: 36px;
        border: 0;
        border-radius: 0;
        box-shadow: none;
        font-size: 14px;
        padding: 8px;
        box-sizing: border-box;
        vertical-align: top;
        width: auto;
        margin: 0;
        outline: 0;
        background-color: #fff;
    }
    .tweet-box-rich>div{
        color: #1DA1F2;
        white-space: nowrap;
    }
    .stream-container{
        position: relative;
        margin-left: 0;
        list-style: none;
    }
    .new-tweets-bar{
        background: #fff;
        border: 1px silver solid;
        background-clip: padding-box;
        position: relative;
        top: -1px;
    }
    .new-tweets-bar-j{
        background-color: #f5f8fa;
        border-bottom: 1px solid #e6ecf0;
        border-top: 1px solid #e6ecf0;
        color: #1da1f2;
        cursor: pointer;
        display: block;
        font-size: 14px;
        font-weight: normal;
        padding: 10px 1px;
        text-align: center;
        width: 100%;
        z-index: 2;
        color: #1DA1F2;
        border: 0;
        background: transparent;
        text-transform: none;
        overflow: visible;
        transition: box-shadow .15s ease-in-out;
    }
    .stream-1{
        position: relative;
        top: -1px;
        margin-left: 0;
        list-style: none;

    }
    .stream-items{
        text-decoration: none;
        position: relative;
        margin-left: 0;
        list-style: none;


    }
    .js-stream{
        background: #fff;
        border-left: 1px solid #e6ecf0;
        border-right: 1px solid #e6ecf0;
        background-clip: padding-box;
        position: relative;
        text-align: inherit;
        content: " ";
        display: table;
        clear: both;
    }
    .tweet-js{
        border-bottom: 1px solid #e6ecf0;
        cursor: pointer;
        position: relative;
        min-height: 51px;
        padding: 9px 12px;
    }
    .context-1{
        margin-left: 58px;
        cursor: pointer;
    }
    .stream-item-header{

        display: flex;
        color: #14171a;
        font-size: 14px;
        line-height: 20px;
    }
    .account{
        color: #14171a;
        display: inline-flex;
        flex-shrink: 1;
        overflow: hidden;
        margin-right: 5px;
        background: transparent;
        cursor: pointer;
    }
    .avatar2{
        float: left;
        margin-top: 3px;
        margin-left: -58px;
        position: absolute;
        width: 48px;
        height: 48px;
        border-radius: 50%;
        border: 0;
        list-style: none;
    }
    .fullname-u{
        font-size: 14px;
        line-height: 20px;
        display: flex;
        max-width: 100%;
        color: #14171a;
    }
    .fullname-u{
        float: left;
        word-break: break-all;
        color: #14171a;
        font-size: 14px;
        font-weight: bold;
        max-width: 100%;
        overflow: hidden!important;
        text-overflow: ellipsis!important;
        white-space: nowrap!important;
        word-wrap: normal!important;
    }
    .userbad{
        font-size: .9em;
        color: #14171a;
    }
    .icon-ver{
        font-size: 1.2em;
        padding-left: 2px;
        color: #1da1f2;
        background: transparent;
        display: inline-block;
        font-style: normal;
        vertical-align: baseline;
        position: relative;
    }
    .u-hidden{
        border: 0!important;
        clip: rect(1px,1px,1px,1px)!important;
        font-size: 1px!important;
        height: 1px!important;
        overflow: hidden!important;
        padding: 0!important;
        position: absolute!important;
        width: 1px!important;
        color: #1da1f2;
    }
    .username-u{
        font-size: 14px;
        color: #14171a;
    }
    .profile{
        margin: -2px -9px 0 auto;
        min-width: inherit;
        display: inline-block;
    }
    .dropdown{
        position: relative;    display: block;
    }
    .profiletweet{
        padding: 2px 9px;
        color: #657786;
        display: inline-block;
        font-size: 16px;
        line-height: 1;
        padding: 0 16px;
        position: relative;
        background: transparent;
        -webkit-appearance: button;
        cursor: pointer;
        text-transform: none;
        overflow: visible;
        transition: box-shadow .15s ease-in-out;
        border:0px;
        margin-left: 300px;
    }
    .js-tool{
        display: inline-block;
        line-height: 0;
        position: relative;
        vertical-align: middle;
        color: #657786;
        display: inline-block;
        font-size: 16px;
        text-transform: none;
        text-align: center;
    }

    .js-tw{
        cursor: pointer;
        text-align: inherit;
    }
    .tweettext{
        white-space: pre-wrap;
        word-wrap: break-word;
        font-size: 14px;
        line-height: 20px;
        margin-block-start: 1em;
        margin-block-end: 1em;
        margin-inline-start: 0px;
        margin-inline-end: 0px;
    }
    .btn-link{
        color: #657786;
        font-size: 12px;
        margin: 6px -2px -2px 0;
        text-align: left;
        padding: 0;
        background-color: transparent;
        background-image: none;
        border: 0;
        color: #1c94e0;
        cursor: pointer;
        border-radius: 0;
        box-shadow: none;
    }
    .tweet-translation{
        margin-top: 10px;
        padding-bottom: 2px;
        margin: 20px 0 0;
        padding: 0 0 20px;
        font-size: 14px;
        line-height: 1.2858;
    }
    .js-macaw{
        min-height: 130px;
        font-size: 14px;
        line-height: 1.2858;
    }
    .stream-item-footer{
        font-size: 12px;
        padding-top: 1px;
    }
    .profiletweet-action{
        font-size: 0;
        height: 18px;
        line-height: 1;
        margin-bottom: 2px;
        margin-top: 10px;

    }
    .profiletweet-action-revert{
        display: inline-block;
        min-width: 80px;
    }
    .actionrevert{
        color: #aab8c2;
        background-color: white;
        display: inline-block;
        font-size: 16px;
        line-height: 1;
        padding: 0 2px;
        position: relative;
        border: 0;
    }
    .iconContainer{
        display: inline-block;
        line-height: 0;
        position: relative;
        vertical-align: middle;
    }
    .actionCount{
        color: #657786;
        display: inline-block;
        font-size: 12px;
        font-weight: bold;
        line-height: 1;
        margin-left: 6px;
        position: relative;
        vertical-align: text-bottom;
    }
    .presentation{
        color: #657786;
        display: inline-block;
        font-size: 12px;
        font-weight: bold;
        line-height: 1;
    }
    .profiletweet-action-refresh,.profiletweet-action-love,.profiletweet-action-message{
        display: inline-block;
        min-width: 80px;
    }
    /*最右边模板*/
    .dashboard-right{

        border: 0px red solid;
        float: left;

        width: 260px;
    }
    .roaming-module{
        align-items: center;
        background-color: #fff;
        border: 1px solid #e6ecf0;
        display: flex;
        flex-direction: column;
        padding: 15px 20px;
        text-align: center;
        background-clip: padding-box;
        position: relative;
        margin-bottom: 10px;
    }
    .delight-title{
        color: #14171a;
        font-weight: bold;
        font-size: 18px;
        line-height: 24px;
    }
    .delight-body{
        color: #657786;
        margin: 10px 0 15px;
    }
    .delight-button{
        width: 90%;
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
        background-color: #1da1f2;
    }
    .module-wtf{
        display: block;
        background-clip: padding-box;
        border: 0;
        position: relative;
        margin-bottom: 10px;
        color: #14171a;
        font-size: 14px;
        line-height: 20px;
    }
    .flex-module{
        border-top-left-radius: inherit;
        border-top-right-radius: inherit;
        background-color: #fff;
        border: 1px solid #e6ecf0;
        padding: 15px;
        line-height: 16px;
    }
    .flex-module-header{
        margin-bottom: 10px;
        line-height: 16px;
    }
    .flex-module-header>h3{
        font-size: 18px;
        font-weight: bold;
        color: #14171a;
        display: inline;
    }
    .btn-link{
        padding: 0;
        background-color: transparent;
        background-image: none;
        border: 0;
        color: #1c94e0;
        cursor: pointer;
        border-radius: 0;
        box-shadow: none;
    }
    .view-all{
        line-height: 1;
        font-size: 12px;
    }
    .js-view-all-link{
        color: #1DA1F2;
    }
    .wtf{
        color: #657786;
        font-size: 12px;
    }
    .js-account-summary{
        border-bottom: 1px solid #e6ecf0;
        padding-bottom: 8px;
        position: relative;
        display: block;
        min-height: 48px;
        color: #657786;
        font-size: 12px;
    }
    .content-gz{
        min-height: 48px;
        margin-left: 58px;
        margin-right: 20px;
        color: #657786;
        font-size: 12px;
    }
    .account-group{
        font-size: 14px;
        display: block;
        line-height: 16px;
    }
    .avatar-gz{
        position: absolute;
        top: 0;
        left: 0;
        width: 48px;
        height: 48px;
        border-radius: 50%;
    }
    .account-group-inner{
        font-size: 10px;

    }
    .username-u-dir{
        font-size: 8px;
        color: #657786;
        direction: ltr!important;
        text-align: left!important;
        unicode-bidi: embed;
        max-width: 100%;
        overflow: hidden!important;
        text-overflow: ellipsis!important;
        white-space: nowrap!important;
        word-wrap: normal!important;

    }
    .user-actions{
        align-items: flex-start;
        flex-direction: column;
        display: flex;
        margin-top: 4px;
        position: relative;
        color: #657786;
        font-size: 12px;
        line-height: 16px;
    }
    .user-actions-not{
        white-space: nowrap;
        color: #657786;
        font-size: 12px;
        line-height: 16px;
    }
    .edge{
        display: block;
        min-width: 89px;
        text-align: center;
        border-color: #1DA1F2;
        color: #1DA1F2;
        background-color: #fff;
        border: 1px solid #1da1f2;
        font-size: 12px;
        line-height: 16px;
        padding: 4px 12px;
        border-radius: 100px;
        box-shadow: none;
        cursor: pointer;
        font-size: 14px;
        font-weight: bold;
        line-height: 20px;
        padding: 6px 16px;
        position: relative;
    }
    .flex-module-b{
        border-top-left-radius: inherit;
        border-top-right-radius: inherit;
        background-color: #fff;
        border: 1px solid #e6ecf0;
        padding: 15px;
        line-height: 16px;
        padding-bottom: 90px;
    }
    .flex-module-inner{
        color: #657786;
        font-size: 12px;
        line-height: 16px;
    }
    .u-cf{
        line-height: 18px;
        color: #14171a;
        list-style: none;
        display: block;
        font-size: 12px;
        text-decoration: none;
    }
    .u-cf>li{

        float: left;
        padding-right: 8px;
        color: #657786;
        display: inline;
        line-height: 18px;
        list-style: none;
        font-size: 12px;
    }

</style>
<body>
<%--顶部--%>
<div class="topbar">
    <div class="global">
        <div class="global-nav">
            <div class="container">
                <h1 class="icon" style="width: 50px; height: 50px;"></h1>
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
<%--                            <span class="searche-icon glyphicon glyphicon-search">--%>
                                <button type="submit" class="icon-med">搜索</button>
<%--                            </span>--%>
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
                        <div class="timeline">
                            <div class="home-tweet">
                                <img class="top-timeline">
                                <form class="t1-form">
                                    <div class="rich">
                                        <div class="richeditor">
                                            <div class="richeditor-scr">
                                                <div class="tweet-box-rich">
                                                    <div>有什么新鲜事?</div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="stream-container">
                                <div class="new-tweets-bar">
                                    <button class="new-tweets-bar-j">查看新推文</button>
                                </div>
                                <div class="stream-1">
<%--                                    推文--%>
                                    <ol class="stream-items">
                                        <li class="js-stream">
                                            <div class="tweet-js">
                                                <div class="context-1">
                                                    <div class="stream-item-header">
                                                        <a class="account" href="/">
                                                            <img class="avatar2" src="/">
                                                            <span class="fullname">
                                                                <strong class="fullname-u">123</strong>
                                                                <span>&rlm;</span>
                                                                <span class="userbad">
                                                                    <span class="icon-ver">
                                                                        <i class="glyphicon glyphicon-ok-sign"></i>
                                                                        <span class="u-hidden">认证账号</span>
                                                                    </span>
                                                                </span>
                                                                <span class="UserNameBreak">&nbsp;</span>
                                                            </span>
                                                            <span class="username-u" style="font-size: 14px;color: #657786;">@<b>JKCorden</b></span>
                                                        </a>
                                                        .
                                                        <small class="time">
                                                            <a style="font-size: 14px;color: #657786;">
                                                                <span style="font-size: 14px;color: #657786;">4天</span>
<%--                                                                <span>4天前</span>--%>
                                                            </a>
                                                        </small>
                                                        <div class="profile">
                                                            <div class="dropdown">
                                                                <button class="profiletweet">
                                                                    <div class="js-tool">
                                                                        <span class="gspan glyphicon glyphicon-chevron-down"></span>
                                                                    </div>
                                                                </button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="js-tw">
                                                        <p class="tweettext">I will never ever forget this. Our #TonyAwards opening tonight x</p>
                                                    </div>
<%--                                                    翻译--%>
                                                    <button type="button" class="btn-link">
                                                        <span class="glyphicon glyphicon-globe"></span>
                                                        翻译推文
                                                    </button>
<%--                                                    图片或者视频--%>
                                                    <div class="tweet-translation">
                                                        <div class="js-macaw">图片or视频</div>
                                                    </div>
                                                    <div class="stream-item-footer">
                                                        <div class="profiletweet-action">
                                                            <div class="profiletweet-action-revert">
                                                                <button class="actionrevert">
                                                                    <div class="iconContainer">
                                                                        <span class="glyphicon glyphicon-comment"></span>
                                                                    </div>
                                                                    <span class="actionCount">
                                                                        <span class="presentation">94</span>
                                                                    </span>
                                                                </button>
                                                            </div>
                                                            <div class="profiletweet-action-refresh">
                                                                <button class="actionrevert">
                                                                    <div class="iconContainer">
                                                                        <span class="glyphicon glyphicon-refresh"></span>
                                                                    </div>
                                                                    <span class="actionCount">
                                                                        <span class="presentation">94</span>
                                                                    </span>
                                                                </button>
                                                            </div>
                                                            <div class="profiletweet-action-love">
                                                                <button class="actionrevert">
                                                                    <div class="iconContainer">
                                                                        <span class="glyphicon glyphicon-heart"></span>
                                                                    </div>
                                                                    <span class="actionCount">
                                                                        <span class="presentation">94</span>
                                                                    </span>
                                                                </button>
                                                            </div>
                                                            <div class="profiletweet-action-message">
                                                                <button class="actionrevert">
                                                                    <div class="iconContainer">
                                                                        <span class="glyphicon glyphicon-envelope"></span>
                                                                    </div>
<%--                                                                    <span class="actionCount">--%>
<%--                                                                        <span class="presentation">94</span>--%>
<%--                                                                    </span>--%>
                                                                </button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                    </ol>
                                </div>
                            </div>
                        </div>

                    </div>
                    <%--            右边面板--%>
                    <div class="dashboard-right">
                        <div class="roaming-module">
                            <img style="width: 170px;" src="https://abs.twimg.com/a/1559783714/img/delight/delight_prompt_2.png">
                            <div class="delight-title">抢先了解新Twitter</div>
                            <div class="delight-body">书签、夜间模式、流量节省程序等——了解网页版增加的所有新功能。</div>
                            <button type="button" class="delight-button">看一看</button>
                        </div>
                        <div class="module-wtf">
                            <div class="flex-module">
                                <div class="flex-module-header">
                                    <h3>推荐关注</h3>
                                    <small>.</small>
                                    <button type="button" class="btn-link">
                                        <small>刷新</small>
                                    </button>
                                    <small class="view-all">
                                        .
                                        <a class="js-view-all-link" href="/">查看q全部</a>
                                    </small>
                                </div>
                                <div class="wtf">
                                    <div class="js-account-summary">
                                        <div class="content-gz">
                                            <a class="account-group">
                                                <img class="avatar-gz" src="">
                                                <span class="account-group-inner" style="cursor: pointer;">
                                                    <strong>CGTN</strong>
                                                    <span class="glyphicon glyphicon-ok-sign"></span>
                                                    <span style="float: left;">&nbsp;</span>
                                                    <span style=" display: inline-block;width:90px; overflow:hidden; white-space:nowrap; text-overflow:ellipsis;" class="username-u-dir">
                                                        @
                                                        <b>CGTNOfficial111111111111111111111111</b>
                                                    </span>
                                                </span>
                                            </a>
                                            <div class="user-actions">
                                                <span class="user-actions-not">
                                                    <button type="button" class="edge">
                                                        <span>关注</span>
<%--                                                        <span>正在关注</span>--%>
                                                    </button>
                                                </span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="flex-module-b">
                            <div class="flex-module-inner">
                                <ul class="u-cf">
                                    <li>@ 2019 Twitter</li>
                                    <li>关于</li>
                                    <li>帮助中心</li>
                                    <li>条款</li>
                                    <li>隐藏政策</li>
                                    <li>Cookis</li>
                                    <li>广告信息</li>
                                    <li>商标</li>
                                    <li>博客</li>
                                    <li>状态</li>
                                    <li>应用</li>
                                    <li>工作机会</li>
                                    <li>市场营销</li>
                                    <li>企业</li>
                                    <li>开发者</li>
                                </ul>
                            </div>
                        </div>
                    </div>
            </div>
        </div>

    </div>
</div>
</body>

<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>

</html>
