<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="common/head.jsp" %>
<title>秒杀详情页</title>
</head>
<body>
<div class="container text-center">
 <div class="panel panel-default text-center">
  <!-- Default panel contents -->
  <div class="panel-heading">${seckill.name}</div>
		<div class="panel-body">
            <h2 class="text-danger">
                <%--显示time图标--%>
                <span class="glyphicon glyphicon-time"></span>
                <%--展示倒计时--%>
                <span class="glyphicon" id="seckill-box"></span>
            </h2>

        </div>

        <!-- 模态框 
			<button
			  type="button"
			  class="am-btn am-btn-success"
			  id="doc-prompt-toggle">
			  Prompt
			</button>
			-->
			<div class="am-modal am-modal-prompt" tabindex="-1" id="my-prompt">
			  <div class="am-modal-dialog">
			    <div class="am-modal-hd">Amaze UI</div>
			    <div class="am-modal-bd">
			      秒杀手机号
			      <input type="text" name="userPhone" id="killPhoneKey" placeholder="填写手机号" class="am-modal-prompt-input">
			      
			    </div>
			    <div class="am-modal-footer">
			      <!-- <span class="am-modal-btn" data-am-modal-cancel>取消</span> -->
			      <span id="killPhoneMessage" class="glyphicon"> </span>
			      <span class="am-modal-btn"  id="killPhoneBtn" data-am-modal-confirm>提交</span>
			    </div>
			  </div>
			              
                <%--验证信息
                <div class="modal-footer">
                <span id="killPhoneMessage" class="glyphicon"> </span>
                <button type="button" id="killPhoneBtn" class="btn btn-success">
                    <span class="glyphicon glyphicon-phone"></span>
                    Submit
                </button>
                --%>
            </div>
		</div>

 </div>
</div>
<input id="upFailed" type="hidden" name="add" value="<%=request.getContextPath() %>"/>
<!--  <input type="file" name="add1" onchange="geturl()"/> -->
</body>
<%--jQery文件,务必在bootstrap.min.js之前引入--%>
<script src="https://code.jquery.com/jquery.js"></script>
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>

<!-- AmazeUI加载进度插件 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/amazeui/2.7.2/css/amazeui.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/amazeui/2.7.2/js/amazeui.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/amazeui/2.7.2/js/amazeui.widgets.helper.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/amazeui/2.7.2/js/amazeui.ie8polyfill.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/amazeui/2.7.2/css/amazeui.flat.css" />
<%--使用CDN 获取公共js http://www.bootcdn.cn/--%>
<%--jQuery Cookie操作插件--%>
<%--jQuery countDown倒计时插件--%>
<script src="http://cdn.bootcss.com/jquery.countdown/2.1.0/jquery.countdown.min.js"></script>
<script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script src="<%=request.getContextPath() %>/js/seckill.js"></script>

<script type="text/javascript">
$(function () {
    seckill.detail.init({
        seckillId:${seckill.seckillId},
        startTime:${seckill.startTime.time},
        endTime:${seckill.endTime.time}
    });
});
</script>
</html>