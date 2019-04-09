

var urljoint=$("input[name='add']").val();
//var Sys = {};
//var ua = navigator.userAgent.toLowerCase();
//var s;
//(s = ua.match(/msie ([\d.]+)/)) ? Sys.ie = s[1] :
//(s = ua.match(/firefox\/([\d.]+)/)) ? Sys.firefox = s[1] :
//(s = ua.match(/chrome\/([\d.]+)/)) ? Sys.chrome = s[1] :
//(s = ua.match(/opera.([\d.]+)/)) ? Sys.opera = s[1] :
//(s = ua.match(/version\/([\d.]+).*safari/)) ? Sys.safari = s[1] : 0;
////以下进行测试
//if (Sys.ie) document.write('IE: ' + Sys.ie);
//if (Sys.firefox) document.write('Firefox: ' + Sys.firefox);
//if (Sys.chrome) document.write('Chrome: ' + Sys.chrome);
//if (Sys.opera) document.write('Opera: ' + Sys.opera);
//if (Sys.safari) document.write('Safari: ' + Sys.safari);
//function geturl(){
//	var a=$("input[name='add1']").val();
//	alert(a);
//}

//javascript 模块化(package.类.方法)
var seckill={
	//封装秒杀相关ajax的url
	URL:{
		now:function(){
			return urljoint+"/seckill_2/time/now";
		},
		exposer:function(seckillId){
			return urljoint+"/seckill_2/"+seckillId+"/exposer";
		},
		execution:function(seckillId,md5){
			return urljoint+"/seckill_2/"+seckillId+"/"+md5+"/execution";
		}
	},
	funcolor:function(state){
		console.log(state);
		if(state=="系统异常"||state=="未登陆"){
			return "am-btn am-btn-danger";
		}else if(state=="秒杀成功"){
			return "am-btn am-btn-success";
		}else{
			return "am-btn am-btn-secondary";
		}
		
	},
	handlerSeckill:function(seckillId,node){
		//获取秒杀地址，控制显示逻辑，执行秒杀
		node.hide()
		.html('<button id="np-s" class="am-btn am-btn-secondary">开始秒杀</button>');
		$.post(seckill.URL.exposer(seckillId),{},function(result){
			if(result && result['success']){
				var exposer = result['data'];
				//alert(exposer);
				if(exposer['exposed']){
					//开启秒杀
					//获取秒杀地址
					var md5=exposer['md5'];
					var killUrl=seckill.URL.execution(seckillId,md5);
					//console.log("killUrl:"+killUrl);
					//绑定一次点击事件
					$('#np-s').one('click',function(){
						
						//执行秒杀请求
						//禁用按钮
						$(this).addClass('disabled');
						$.post(killUrl,{},function(result){
							if(result && result['success']){
							var killresult = result['data'];
							var stateinfo = killresult['stateinfo'];
							//console.log(result);
							//3.显示秒杀结果
							node.html('<span id="np-s" class="'+seckill.funcolor(stateinfo)+'">'+stateinfo+'</span>');
							}
						});
					});
					node.show();
				}else{
					//未开启秒杀
					var now = exposer['now'];
					var start = exposer['start'];
					var end = exposer['end'];
					//重新计算计时逻辑
					seckill.countDown(seckillId,now,start,end);
				}
			}else{
				//console.log('result:'+result);
			}
		});
	},
	//验证手机号
    validatePhone: function (phone) {
        if (phone && phone.length == 11 && !isNaN(phone)) {
            return true;//直接判断对象会看对象是否为空,空就是undefine就是false; isNaN 非数字返回true
        } else {
            return false;
        }
    },
	countDown:function(seckillId,nowTime,startTime,endTime){
		var seckillBox = $('#seckill-box');
		if(nowTime > endTime){
			//秒杀结束
			seckillBox.html('秒杀结束');
		}else if(nowTime < startTime){
			//秒杀未开始，显示时间
			var killTime = new Date(startTime);
			
			seckillBox.countdown(killTime,function(event){
				//alert(321);
				var format = event.strftime('秒杀倒计时: %D天 %H时 %M分 %S秒');
				
				seckillBox.html(format);
			}).on('finish.countdown',function(){
				//获取秒杀地址，控制实现逻辑，执行秒杀
				//console.log("____________finish.countdown");
				seckill.handlerSeckill(seckillId,seckillBox);
			});
		}else{
    		//秒杀开始
    		seckill.handlerSeckill(seckillId,seckillBox);
		}
	},
	//秒杀详情逻辑
	//详情页初始化
	  detail: {
		   init: function (params) {
			//手机验证和登陆
            //规划我们的交互流程
            //在cookie中查找手机号
			console.log("_______________");
			var userPhone = $.cookie('userPhone');
			//alert(userPhone);
			//alert(userPhone);
			//验证手机号
			if(!seckill.validatePhone(userPhone)){
				//绑定手机号
				 var killPhoneModal = $('#my-prompt');
				killPhoneModal.modal({
					relatedTarget: this,
					closeViaDimmer: false,//禁止位置关闭
					closeOnConfirm:false,//默认点击提交不关闭
				});
				$('#killPhoneBtn').click(function(){
					var inputPhone=$('#killPhoneKey').val();
					//alert(123);
					if(seckill.validatePhone(inputPhone)){
						//alert(inputPhone);
						$.cookie('userPhone', inputPhone, {expires: 7, path: '/seckill_2'});
                        //验证通过　　刷新页面
                        window.location.reload();
					}else{
						//todo 错误文案信息抽取到前端字典里
                        $('#killPhoneMessage').hide().html('<label class="label label-danger">手机号错误!</label>').show(300);
					}
				})
			}
			//已经登录
			//计时交互
			var startTime = params['startTime'];
			var endTime = params['endTime'];
			var seckillId = params['seckillId'];
			//console.log(startTime);
			//Ajax 请求Controller
			$.get(seckill.URL.now(),{},function(result){
				
				if(result && result['success']){
					//时间判断 计时交互
					var nowTime = result['data'];
					seckill.countDown(seckillId,nowTime,startTime,endTime);
				}else{
                    //console.log('result: ' + result);
                    //alert('result: ' + result);
					alert(123);
				}
			})
			
		}
	}	
	
}