<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>进入秒杀</title>
</head>
<body>
<div class="page-header text-center">
  <h1>Home <small>秒杀开始页</small></h1>
  <h1><small>进入</small></h1>
  <a href="http://localhost:8010/seckill_2/seckill/list">
  	<button id="np-s" class="am-btn am-btn-primary">
  		<a href="./seckill/list" style='color:white;'>进入秒杀</a>
  	</button>
  </a>
</div>
</body>

<script src="https://code.jquery.com/jquery.js"></script>
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
<!-- AmazeUI加载进度插件 -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/amazeui/2.7.2/css/amazeui.css" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/amazeui/2.7.2/js/amazeui.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/amazeui/2.7.2/js/amazeui.widgets.helper.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/amazeui/2.7.2/js/amazeui.ie8polyfill.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/amazeui/2.7.2/css/amazeui.flat.css" />

<script>
$(function(){
  var progress = $.AMUI.progress;
  $('#np-s').on('click', function() {
	  progress.start();
  });
});

</script>
</html>
