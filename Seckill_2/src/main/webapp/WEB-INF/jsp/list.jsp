<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>秒杀列表类</title>
    <%@include file="common/head.jsp" %>
</head>
<body>
<div class="container">
 <div class="panel-heading text-center">
  <div class="panel panel-primary">
  <!-- Default panel contents -->
  <div class="panel-heading"  >秒杀列表</div>

  <!-- Table -->
   <div class="panel-body">
    <table class="table">
     <tr>
    	<td>#</td>
    	<td>ID</td>
    	<td>名字</td>
    	<td>数量</td>
    	<td>开始时间</td>
    	<td>结束时间</td>
    	<td>创建时间</td>
    	<td></td>
     </tr>
     <c:forEach var="s" items="${list}">
     <tr>
    	<td>#</td>
    	<td>${s.seckillId }</td>
    	<td>${s.name }</td>
    	<td>${s.number }</td>
    	<fmt:setLocale value="zh_CN"/>
    	<td>
    		<fmt:formatDate value="${s.startTime}" pattern="yyyy-MM-dd hh:mm:ss"/>
        </td>
    	<td>
    		<fmt:formatDate value="${s.endTime}" pattern="yyyy-MM-dd hh:mm:ss"/>
    	</td>
    	<td>
    		<fmt:formatDate value="${s.createTime}" pattern="yyyy-MM-dd hh:mm:ss"/>
    	</td>
    	<td>
  			
  			  <a id="a" href="<%=request.getContextPath()%>/seckill/${s.seckillId}/detail" class="btn btn-default">点击秒杀</a>
  			
        </td>
     </tr>
     </c:forEach>
    </table>
   </div>
  </div>
 </div>
</div>
</body>
<script src="https://code.jquery.com/jquery.js"></script>
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<!-- AmazeUI加载进度插件 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/amazeui/2.7.2/css/amazeui.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/amazeui/2.7.2/js/amazeui.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/amazeui/2.7.2/js/amazeui.widgets.helper.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/amazeui/2.7.2/js/amazeui.ie8polyfill.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/amazeui/2.7.2/css/amazeui.flat.css" />
<script type="text/javascript">
$(function(){
	  $('#a').on('click', function() {
		  progress.start();
	  });
	});
</script>
</html>