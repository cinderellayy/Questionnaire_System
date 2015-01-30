//异步获取后台验证码图片
function newpicture() {
	document.getElementById("verify").src = "VerificServlet?timestamp="+new Date().getTime();
}

//获取后台登陆错误提示信息
//对于错误提示出现的方式，可以旋转弹出框，也可选择在input中直接显示
window.onload = function(){
	 var urlReg=new RegExp(/(\/*.action)/);//编写正则规则
	 var url = document.URL;
	 var flag=!!url.match(urlReg);//这个是啥意思
	// alert("我执行了");
	 if(flag){
			var htmlmsg = $.ajax({url:"msg.action",async:false});
			//alert(htmlmsg.responseText);
			if(htmlmsg.responseText == "\"验证码错误\""){
				alert("验证码错误");
				document.getElementById("password").value = "";
				document.getElementById("account").value = "";
				newpicture();
				//window.top.back(-1);
				return false;
			}
			if(htmlmsg.responseText == "\"密码错误\""){
				alert("密码错误");
				document.getElementById("password").value = "";
				newpicture();
				return false;
			}
			if(htmlmsg.responseText == "\"用户名错误\""){
				alert("用户名错误");
				document.getElementById("password").value = "";
				document.getElementById("account").value = "";
				newpicture();
				return false;
			}
			if(htmlmsg.responseText == "\"没有登陆\""){
				alert("没有登陆");
				return false;
			}
		 }
	 return true;
};