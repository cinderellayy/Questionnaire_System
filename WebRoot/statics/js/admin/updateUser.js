//怎么感觉jquery是异步执行的呢，就好像是多线程
var user = new Object();
window.onload = function(){
	$.post("updateFinduser.action",function(resultData,status){
		var data = decodeURIComponent(resultData);
		data = data.substring(1, data.length-1);
		user =  $.parseJSON(data); 
		$("#username").val(user.username);
		$("#sex").val(user.sex);
		$("#account").val(user.account);
		$("#nation").val(user.nation);
		$.post("collegeinformation.action",function(resultData,status){
			var data = decodeURIComponent(resultData);
			data = data.substring(1, data.length-1);
			var college = eval("("+data+")");
			var select = "<select id='college' onchange='jump(0)' style='width:150px;'>";
			var option = "<option value='"+user.college+"' selected='selected'>"+user.college+"</option>";
			$.each(college,function(i,filed){
				if(filed != user.college){
					option = option + "<option value='"+filed+"'>"+filed+"</option>";
				}
			});
			select = select + option + "</select>";
			$("#college_f").append(select);
			jump(0);
		});
		
	});
};
function jump(type) {
	if(type == 0){
		professional();
	}
	if(type == 1){
		studentClass();
	}
}
function professional() {
	var data1 = "data="+$("#college").val();
	$.post("professionalinformation.action",data1,function(responseData,status){
		var data = decodeURIComponent(responseData);
		data = data.substring(1, data.length-1);
		var professional = $.parseJSON(data);
		var select = "<select id='professional' onchange='jump(1)' style='width:150px;'>";
		var option = "";
		if($("#college").val() == user.college){
			option = "<option value='"+user.professional+"' selected='selected'>"+user.professional+"</option>";
			$.each(professional,function(i,filed){
				if(filed != user.professional){
					option = option + "<option value='"+filed+"'>"+filed+"</option>";
				}
			});
		}
		else{
			$.each(professional,function(i,filed){
					option = option + "<option value='"+filed+"'>"+filed+"</option>";
			});
		}
		
		select = select + option + "</select>";
		$("#professional_f").html("");
		$("#professional_f").html(select);
		jump(1);
	});
}
function studentClass() {
	var data1 = "data="+$("#professional").val();
	$.post("studentClassinformation.action",data1,function(responseData,status){
		var data = decodeURI(responseData);
		data = data.substring(2, data.length-2);
		var select = "<select id='studentClass' style='width:150px;'>";
		var option = "";
		var length = parseInt(data);
		
		if($("#professional").val() == user.professional){
			option = "<option value='"+user.student_class+"' selected='selected'>"+user.student_class+"</option>";
			for(var i = 0;i<length;i++){
				if((i+1) != user.student_class){
					option = option + "<option value='"+(i+1)+"'>"+(i+1)+"</option>";
				}
			}
		}
		else{
			for(var i = 0;i<length;i++){
				option = option + "<option value='"+(i+1)+"'>"+(i+1)+"</option>";
			}
		}
		select = select + option + "</select>";
		$("#class_f").html("");
		$("#class_f").html(select);
	});
}

function updatePassword() {
	$("#password").attr("type","password");
}
function userModel(id,username,account,password,role,college,professional,grade,student_class,nation,sex) {
	this.id = id;
	this.username = username;
	this.account = account;
	this.password = password;
	this.role = role;
	this.college = college;
	this.professional = professional;
	this.grade = grade;
	this.student_class = student_class;
	this.nation = nation;
	this.sex = sex;
}
function check() {
	var password = "";
	if($("#password").val() == ""){
		password = user.password;
	}
	else {
		password = $("#password").val();
	}
	var updateUser = new userModel(user.id,$("#username").val(),user.account,password,user.role,$("#college").val(),$("#professional").val(),user.grade,$("#studentClass").val(),$("#nation").val(), $("#sex").val());
	var jsonData =  $.toJSON(updateUser);
	jsonData = encodeURI(jsonData);
	$.ajax({
		cache:false,
		type:"POST",
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		url:"updateuser.action",
		data:{jsonData:jsonData},
		dataType: 'json',
		async: false,
		error: function(request) {
			alert("更新失败！");
			},
		success: function(data) {
			alert(data);
			if(data != "输入的数据不合法");{
				window.location.href = "adminUser.action";
			}
		}
	});
	return false;
}






