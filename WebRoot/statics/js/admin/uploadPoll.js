var question_count = 0;//记录问题的数目
var option_count = 0;//记录选项数目
function create(obj){
    option_count = 0;
    if(obj.value == "one"){
        createOne(0);
        //alert("单选");
    }
    if(obj.value == "multi"){
        createMulti();
       //  alert("多选");
    }
    //建立下一题的div
    var html = "<br></br><div id='_"+(question_count+1)+"'></div>";
    $("#_"+question_count).after(html);
    question_count ++;
    $("#submit").show();
}
function allow(){
   $("#show").dialog();
}
function submit_show(){
    var count = 0;
    var txt = "";
    for(var i=0;i<16;i++){
        if($('#college_'+i).is(':checked')){
            count ++;
            txt = txt + $('#college_'+i).val()+"+";
        }
    }
    txt = txt.substring(0,txt.length-1);
    if(count == 0){
        //表示全选
        txt = "ALL";
    }
    $("#poll_allow_college").val(txt);
    $("#show").dialog('close');
}
//创建选项
function createOne(num){
    var question_id = "question_"+question_count;
    var option_id = "";
    var html = "请填写题目:<input id='"+question_id+"' name='question_name' type='text' placeholder='题目名' required>";
    html = html + "<input type='button' name='"+question_id+"' onclick='deleteOption(0,0,this)' value='删除'>";
    if(num == 1){
        var select_id = "_select"+question_count;
        html = html + "<div id='"+select_id+"'></div>";
    }
    for(var i =0;i<2;i++){
        option_id = question_id + "_"+option_count;
        option_count++;
         //需要设置宽度
        if(num == 0){
            //选项内容前面的radio的id是option的id+"_"
            html = html + "<div id='"+option_id+"_div'><input type='radio'>";
            html = html + "<input id='"+option_id+"' name='option_name' type='text' placeholder='选项' required>";
            html = html + "<input type='button' name='"+option_id+"' onclick='deleteOption(0,1,this)' value='删除'></div>";
        }
        //多选题
        if(num == 1){
            html = html + "<div id='"+option_id+"_div'><input type='checkbox'>";
            html = html + "<input id='"+option_id+"' name='option_name' type='text' placeholder='选项' required>";
            html = html + "<input type='button' name='"+option_id+"' onclick='deleteOption(1,1,this)' value='删除'></div>";
        }
    }
    if(num == 0){
         $("#auxiliary").html("");
        var auxiliary = "<input type='button' onclick='createOption(0)' value='添加选项'>";
        $("#auxiliary").html(auxiliary);
    }
    var addOption_id = "addOption_"+question_count;
    //在这里可以设置父子div之间距离，我是不会弄了
    $("#_"+question_count).html(html+"<div id='"+addOption_id+"'></div>");
    //辅助div
    if(num == 1){
        $("#auxiliary").html("");
        var auxiliary = "<input type='button' onclick='createOption(1)' value='添加选项'>";
        $("#auxiliary").html(auxiliary); 
        var id = "select_"+(question_count);
        var ht = "<select id='"+id+"'>";
        ht = ht + "<option value='2'>2</option>";
        ht = ht + "</select>";
        $("#_select"+(question_count)).html(ht);
    }
    $("#auxiliary").show();
}
//创建多选题
function createMulti(){
    createOne(1);
}
function createOption(num){
    var question_id = "question_"+(question_count-1);
    var option_id = question_id + "_"+option_count;
    var addOption_id = "addOption_"+(question_count-1);
    var addhtml = "";
    
    if(num == 0){
        //创建单选
        //需要设置宽度
        addhtml = "<div id='"+option_id+"_div'><input id='"+option_id+"_' type='radio'>";
        addhtml = addhtml + "<input id='"+option_id+"' name='option_name' type='text' placeholder='选项' required>";
         addhtml = addhtml+"<input type='button' name='"+option_id+"' onclick='deleteOption(0,1,this)' value='删除'><div>";
    }
    if(num == 1){
        var id = "select_"+(question_count-1);
        var html = "<select id='"+id+"'>";
        for(var i = 0;i<option_count;i++){
            html = html + "<option value='"+(i+2)+"'>"+(i+2)+"</option>";
        }
        html = html + "</select>";
        $("#_select"+(question_count-1)).html(html);
        //创建多选
        addhtml = "<div id='"+option_id+"_div'><input id='"+option_id+"_' type='checkbox'>";
        addhtml = addhtml + "<input id='"+option_id+"' name='option_name' type='text' placeholder='选项' required>";
        addhtml = addhtml+"<input type='button' name='"+option_id+"' onclick='deleteOption(1,1,this)' value='删除'><div>";
    }
  //  var last_option_id = question_id + "_"+option_count;
    $("#"+addOption_id).before(addhtml);
    option_count++;
}
function deleteOption(n,num,obj){
    if(num == 1){
        //删除的是选项
        if(option_count == 2){
            alert("选项数低于两个不可删除");
        }
        else{
        	var id = $(obj).attr('name');
            $("#"+id+"_div").remove();
        }
        //表示删除的多选的选项；
        if(n == 1 && option_count > 2){
            option_count -- ;
            var id = "select_"+(question_count-1);
            var html = "<select id='"+id+"'>";
            for(var i = 0;i<option_count-1;i++){
                html = html + "<option value='"+(i+2)+"'>"+(i+2)+"</option>";
            }
            html = html + "</select>";
            $("#_select"+(question_count-1)).html(html);
        }
    }
    if(num == 0){
        //删除的题目
        var id = $(obj).attr('name');
        id = id.substring(id.indexOf("_")+1,id.length);
        question_count --;
        $("#_"+id).remove();
    }
}
//以上都是生成填写问卷内容的
//下面开始收集数据
//建立对象
function poll(poll_name,poll_description,poll_end_time,poll_author,allowCollege,questionModel){
    this.poll_name = poll_name;
    this.poll_description = poll_description;
    this.poll_end_time = poll_end_time;
    this.poll_author = poll_author;
    this.questionModel = questionModel;
    this.allowCollege = allowCollege;
}
function question(question_id,question_name,question_type,question_can_choise_count,optionModel){
	this.question_id = question_id;//这个只用于传递，不做为数据库中数据
    this.question_name = question_name;
    this.question_type = question_type;
    this.question_can_choise_count = question_can_choise_count;
    this.optionModel = optionModel;
}
function option(option_id,option_name){
	this.option_id = option_id;
    this.option_name = option_name;
}
function allowCollege(allowCollege_id,allowCollegeName){
	this.allowCollege_id = allowCollege_id;
    this.allowCollegeName = allowCollegeName;
}
//收集数据
function check(){
    var allowCollegeArray = new Array();//存放允许学院的数组
    var questionArray = new Array();//存放问题列表的数组
    
    //收集其允许的学院列表
    var allow = $("#poll_allow_college").val();
    $.each(allow.split("+"),function(i,field){
        var myallow = new allowCollege((i+1),field);
        allowCollegeArray.push(myallow);
    });
    //收集question
    for(var i = 0;i<question_count;i++){
        var id = "#question_"+i;
        var s_id = "#select_"+i;
        var optionArray = new Array();//存放选项列表的数组
        //默认最多不超过20个选项
        //收集question对应的option列表
        for(var j = 0;j<20;j++){
            var o_id = id + "_"+j;
            if($(o_id).size() > 0){
                var myoption = new option((j+1),$(o_id).val());
                optionArray.push(myoption);
            }
        }
        var myquestion = null;
        if($(s_id).size()>0){
            myquestion = new question((i+1),$(id).val(),"multi",$(s_id).val(),optionArray);
        }
        else{
            myquestion = new question((i+1),$(id).val(),"radio",1,optionArray);
        }
        questionArray.push(myquestion);
    }
  //收集poll
    var myPoll = new poll($("#poll_name").val(),$("#poll_description").val(),$("#poll_end_time").val(),$("#poll_author").val(),allowCollegeArray,questionArray);
    var jsonData = $.toJSON(myPoll);
    //alert(jsonData);
    //加密
    jsonData = base64encode(jsonData);
    $.ajax({
		cache:false,
		type:"POST",
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		url:"addpoll.action",
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