<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/5/24
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login on Twitter</title>
    <meta name="viewport" content="width=device-width,maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <link rel="icon" href="img/favicon.ico" />
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
            line-height: 20px;
            overflow-y: scroll; }
        /*顶部*/
        #doc{
            height: 100%;
        }
        .topbar{
            backface-visibility: hidden;
            border-bottom: 1px solid #e6ecf0;
            border-bottom: 1px solid rgba(0,0,0,0.05);
            position: fixed;
            top: 0;
            right: 0;
            left: 0;

            border-bottom: 1px solid rgba(0,0,0,0.25);
            height: 46px;

            width: 100%;

            background: #fff;
            height: 46px;
        }
        #page-outer{
            height: 100%;

        }
        #page-container{
            width: 1190px;
            max-width: 837px;
            margin:0 auto;
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
        .Icon-bird{
            width: 40px;
            height: 40px;
            background: url("img/favicon.ico")no-repeat 4px 5px;

        }
        ul{
            margin: 0;
            list-style: none;
            padding: 0;
            margin-inline-start: 0px;
            margin-inline-end: 0px;

        }

        .global-actions>li {
            height: 46px;

            position: relative;
        }
        .js-nav{
            float: left;
            border-bottom: 2px solid #1c94e0;
            transition: all .15s ease-in-out;

            color: inherit;
            display: block;
            font-size: 13px;
            font-weight: bold;
            height: 46px;
            line-height: 1;
            padding: 0 14px 0 4px;
            position: relative;

            text-decoration: none;
        }
        .js-nav>span{
            float: left;
        }
        #text{

            margin-left: 3px;
            margin-top: 17px;
            padding: 0;
            color: inherit;
            display: block;
            font-size: 13px;
            font-weight: bold;
            cursor: pointer;
        }
        .about{
            float: left;
            margin-left: 3px;
            margin-top: 17px;
            padding: 0;
            color: inherit;
            display: block;
            font-size: 13px;
            font-weight: bold;
            cursor: pointer;

        }
        #paged-canvas{
            margin-top: 10px;
            display: block;
            clear: none;
            width: auto;
            max-width: 835px;
            background-color: #fff;
            margin-bottom: 15px;
            border: 1px solid rgba(0,0,0,0.1);
        }
        .signin-wrapper{
            display: block;
            width: auto;
            max-width: 585px;
            padding: 0 10px;
            margin: 0 auto 10px;
            clear: both;
        }
        h1{
            display: block;
            font-size: 1.5em;
            margin-block-start: 0.67em;
            margin-block-end: 0.67em;
            margin-inline-start: 0px;
            margin-inline-end: 0px;
            font-weight: bold;
            padding: 30px 0 5px 0;
            clear: both;

        }
        .field{
            width: 210px;
            padding: 4px;
            outline: 0;
            background-color: #fff;
            border: 1px solid #e6ecf0;
            border-radius: 3px;
            margin-top: 5px;
            font-size: 14px;
            line-height: 20px;
            background-color: rgb(232, 240, 254) !important;
            background-image: none !important;
            color: rgb(0, 0, 0) !important;
        }
        input{

            text-rendering: auto;
            color: initial;
            letter-spacing: normal;
            word-spacing: normal;
            text-transform: none;
            text-indent: 0px;
            text-shadow: none;
            display: inline-block;
            width: 210px;
            padding: 4px;
            outline: 0;
            background-color: #fff;
            border: 1px solid #e6ecf0;
            border-radius: 3px;
        }
    </style>
<body>
<%--顶部--%>
<div id="doc">
    <div class="topbar js-topbar">
        <div id="page-outer">
            <div id="page-container">
                <ul class="global-actions">
                    <li>
                        <a class="js-nav">
                        <span class="Icon Icon-bird"></span>
                        <span id="text">Home</span>
                        </a>
                        <a class="js-nav">
                        <span class="about">About</span>
                        </a>
                    </li>
                </ul>
                <div id="paged-canvas">
                    <div class="signin-wrapper">
                        <h1>Log in to Twitter</h1>
                        <form action="" method="post">
                            <div class="field">
                                <input type="text" placeholder="Please ,email or username">
                            </div>
                            <div class="field">
                                <input type="password" placeholder="Password">
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
