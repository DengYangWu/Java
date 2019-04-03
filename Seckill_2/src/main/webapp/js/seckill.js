//$(function() {
//	console.log("123_________________________");
//
//	$(function() {
//		  //$('#doc-prompt-toggle').on('click', function() {
//		    $('#my-prompt').modal({
//		      relatedTarget: this,
//		      onConfirm: function(e) {
//		        alert('你输入的是：' + e.data || '')
//		      },
//		      onCancel: function(e) {
//		        alert('不想说!');
//		      }
//		    });
//		  });
//		//});
//});
var urljoint=$("#upFailed").val();
//javascript 模块化(package.类.方法)
var seckill={
	//封装秒杀相关ajax的url
	URL:{
		now:function(){
			return urljoint+"/seckill/time/now";
		},
		exposer:function(){
			return urljoint+"/seckill"+seckillId+"/exposer";
		},
		execution:function(){
			return urljoint+"/seckill/"+seckillId+"/"+md5+"/execution";
		}
	},
	validatePhone:function(Phone){
		if(Phone && Phone.length==11 && !isNaN(Phone)){
			return true;
		}else{
			return false;
		}
	},
	//秒杀详情逻辑
	delail:{
		//详情页初始化
		init:function(params){
			//手机验证和登陆
            //规划我们的交互流程
            //在cookie中查找手机号
			console.log("_______________");
			var userPhone = $.cookie('userPhone');
			//验证手机号
			if(!seckill.validatePhone(userPhone)){
				//绑定手机号
				var killPhoneModal=$('#my-prompt');
				killPhoneModal.modal({
					relatedTarget: this,
					closeViaDimmer: false,//禁止位置关闭
				});
				$('#killPhoneBtn').click(function(){
					var inputPhone=$('#killPhoneKey').val();
					//alert(123);
					if(seckill.validatePhone(inputPhone)){
						//alert(inputPhone);
						$.cookie('userPhone', inputPhone, {expires: 7, path: '/seckill'});
                        //验证通过　　刷新页面
                        window.location.reload();
					}else{
						//todo 错误文案信息抽取到前端字典里
                        $('#killPhoneMessage').hide().html('<label class="label label-danger">手机号错误!</label>').show(300);
					}
				})
			}
		}
	}
	
}