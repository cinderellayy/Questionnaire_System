
function check() {
	var data = $("#addUser").serializeArray();
	var jsonData = "{";
	alert(data.length);
	$.each(data,function(i,filed){
		if(i == data.length - 1){
			jsonData = jsonData+"\""+filed.name+"\""+":"+"\""+filed.value+"\"";
			alert("hahhah");
		}
		else{
			jsonData = jsonData+"\""+filed.name+"\""+":"+"\""+filed.value+"\""+",";
		}
	});
	jsonData = jsonData+"}";
	alert(jsonData);
	$.ajax({
		cache:false,
		type:"POST",
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		url:"adduser.action",
		data:{jsonData:jsonData},
		dataType: 'json',
		async: false,
		error: function(request) {
			alert("添加失败！");
			},
		success: function(data) {
			$("#msg").html(data);
		}
	});
	return false;
}