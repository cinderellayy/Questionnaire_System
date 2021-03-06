//初始页面数
var page = 1;
var maxPage = 0;
window.onload = function(){
	getData(1);
};
//instruction表示指定翻页方式
function turnPage(instruction) {
	$("#mybody").html("");
	if(instruction == 0){
		getData(1);
		//alert("首页"+page);
	}
	if(instruction == 1){
		//page 为最小页码数
		if(page <= 1){
			getData(1);
		}
		else {
			page = page - 1;
			getData(page);
		}
		//alert("上一页"+page);
	}
	if(instruction == 2){
		//page已经是最大页码数
		if(page >= maxPage){
			getData(maxPage);
		}
		else{
			page = page + 1;
			getData(page);
		}
		//alert("下一页"+page);
	}
	if(instruction == 3){
		getData(maxPage);
		//alert("尾页"+maxPage);
	}
}
//用于从后台获取数据
function getData(page) {
	//data 是要传递给action的page参数
	var data = "page="+page;
	$.getJSON("finduser.action",data, function(resultData) {
		//还原编码
		var data = base64decode(resultData);
		//data = utf8to16(data);
		//调用eval函数
		var obj = eval("(" +data + ")");
		//遍历list_user数组
		var body = "";
		//each就是遍历
		$.each(obj.list_user,function(i,item){
				var sex = "男";
				if(item.sex == "woman"){
					sex = "女";
				}
				var tr = "<tr>";
				var th1 = "<th>"+item.username+"</th>";
				var th2 = "<th>"+item.account+"</th>";
				var th3 = "<th>"+sex+"</th>";
				var th4 = "<th>"+item.role+"</th>";
				var th5 = "<th>"+item.college+"</th>";
				var th6 = "<th>"+item.professional+"</th>";
				var th7 = "<th>"+item.grade+"</th>";
				var th8 = "<th>"+item.student_class+"</th>";
				var th9 = "<th>"+item.nation+"</th>";
				//var th10 = "<th><button class='btn btn-default' onclick='update("+item.id+")'>修改<button class='btn btn-default' onclick='delete("+item.id+")'>删除</th></tr>";
				var th10 = "<th><button class='btn btn-default' onclick='update("+item.id+")'>修改<button class='btn btn-default' onclick='deleteUser("+item.id+")'>删除</th></tr>";
				body = body + tr + th1 + th2 + th3 + th4 + th5 + th6 + th7 + th8 + th9 + th10;
		});
		$("#mybody").append(body);
		$("#page").html("第"+page+"页/共"+obj.page_number+"页");
		maxPage = obj.page_number;
	});
}
//这个没有用jquery
function update(id) {
	var myForm = document.createElement("form");
    myForm.action = "updateUser.action";
    myForm.method = "post";
    var myInput = document.createElement("input");
    myInput.setAttribute("name","id");
   	myInput.setAttribute("value", id);
    myForm.appendChild(myInput);
    document.body.appendChild(myForm);
    myForm.submit();
    document.body.removeChild(myForm);
}
function deleteUser(id) {
	$.get("deleteuser.action?id="+id,function(data,status){
		window.location.href = "adminUser.action";
		alert(data.substring(1,data.length-1));
	});
}