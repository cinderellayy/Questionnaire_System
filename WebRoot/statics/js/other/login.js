function newpicture() {
	document.getElementById("verify").src = "VerificServlet?timestamp="+new Date().getTime();
}
function check() {
	 var htmlobj=$.ajax({url:"msg.action",async:false});
	 alert(htmlobj.responseText);
	 return true;  
}
