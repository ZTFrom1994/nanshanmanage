$(function(){
	$(".toolbarBtn").linkbutton({
        plain:true
    });
// $.getJSON("servlet/AuthCLServlet?flag=getAuth", function(data) {
// $.each(data.auth, function(i, item) {
// if(item.addAuth=="无"){
// $(".toolbarBtn:eq(0)").linkbutton({
// disabled:true
// });
// }
// if(item.deleteAuth=="无"){
// $(".toolbarBtn:eq(2)").linkbutton({
// disabled:true
// });
// }
// if(item.updateAuth=="无"){
// $(".toolbarBtn:eq(1)").linkbutton({
// disabled:true
// });
// }
// if(item.searchAuth=="无"){
// $('#i_datagrid').datagrid('hideColumn','leaderPhoneNum');
// }
// });
// });
	$('#i_club_search').searchbox({
        searcher:function(value,name){
    	     if(value!="")
    	     { 
    	    	 $.ajax({
     				url:'clubAction!getClubByKeyWord',
     				type:"post",
     				data:{
     					key:value,
     			    },
     				dataType:"json",
     			    success:function(data){
     			    	$('#i_datagrid').datagrid('loadData',data);
     				}
     			});
    	     }
        },
        prompt:'社团名称/社长'
    });
	// 生成数据表格
	$("#i_datagrid").datagrid({
// url:"ClubCLServlet?flag=clubList",
		url:"clubAction!getClubsByPage",
	    fit:true,
	    fitColumns:true,
	    border:false, 
	    pagination:true, 
	    pageList:[10,20], 
	    pageSize:10, 
	    pageNumber:1, 
	    singleSelect:true,
	    scrollbarSize :0, 
	    remoteSort:false, 
	    rownumbers:true,
	    loadMsg:"正在加载数据.....",
	    columns:[[
	        {checkbox:true},
	        {field:'clubId',title:'序号',resizable:false,hidden:true,width:30,align:"left"},
	        {field:'clubName',title:'社团名称',resizable:false,width:230,align:"center"},
	        {field:'leaderName',title:'社团负责人',resizable:false,width:130,align:"center"},
	        {field:'leaderStuId',title:'学号',resizable:false,hidden:true,width:130,align:"center"},
	        {field:'leaderPhoneNum',title:'联系电话',resizable:false,width:130,align:"center"},
	        {field:'clubBrief',title:'社团简介',sresizable:false,width:330,halign:"center",align:"center"},
	        {field:'clubType',title:'社团类型',resizable:false,sortable:true,width:260,align:"center"},
	        {field:'teacherName',title:'指导老师',resizable:false,width:100,align:"center"},
	    ]],
	    toolbar:"#i_club_toolbar",
	});
	// 生成addform
	$("#i_add_form").dialog({
	    	closed:true,
	    	modal:true,
	    	width:400,
	    	height:400,
	    	title:"添加社团",
	    	buttons:[{
	    		text:"提交",
	    		handler:function(){
	    		if(checkClubAdd()){
	    			sType=$('#i_add_club_type').combobox('getText');
	    			sType=sType.replace(/[\n\r]/ig,'</br>'); 
	    			$.ajax({
	    				url:'clubAction!addClub',
	    				type:"post",
	    				data:{
	    					clubName:$("#i_add_club_name").val(),
	    					clubType:sType,
	    					leaderName:$("#i_add_leader_name").val(),
	    					leaderStuId:$("#i_add_leader_stu_id").val(),
	    					clubBrief:$("#i_add_club_brief").val(),
	    					teacherName:$("#i_add_teacher_name").val(),
	    					phoneNumber:$("#i_add_phone_number").val(),
	    			    },
	    				dataType:"text",
	    			    success:function(data){
	    					if (data>=0) {
	    						$.messager.alert("提示","操作成功","info",function(){
	    							$("#i_add_form").dialog("close").form("reset");
	    							$("#i_datagrid").datagrid('reload');
	    						});
	    					} else {
	    						// 社长信息不符返回1，社团信息格式错误返回2，社团已存在返回3
	    						$.messager.alert("提示","操作失败\n 可能原因：1.社长信息并未录入系统 2.社团信息重复 3.社团信息不符合格式","error",function(){
	    							
	    						});
	    					}
	    				}
	    			});
	    		}
	    	}
	    	},
	    	{
	    		text:"取消",
				handler:function(){
	    		$("#i_add_form").dialog("close").form("reset");
	    	}
	    	}]
	    });

	 // 生成更新表格
	 $("#i_update_form").dialog({
	    	closed:true,
	    	modal:true,
	    	width:400,
	    	height:400,
	    	title:"更新信息",
	    	buttons:[{
	    		text:"提交",
	    		handler:function(){
	    		if(checkClubUpdate()){
	    			$.ajax({
	    				url:'clubAction!updateClub',
	    				type:"post",
	    				data:{
		    				clubId:$("#i_datagrid").datagrid("getSelections")[0].clubId,
		    				clubName:$("#i_update_club_name").val(),
		    				clubType:$('#i_update_club_type').combobox('getText'),
	    					leaderName:$("#i_update_leader_name").val(),
	    					leaderStuId:$("#i_update_leader_stu_id").val(),
	    					clubBrief:$("#i_update_club_brief").val(),
	    					teacherName:$("#i_update_teacher_name").val(),
	    					phoneNumber:$("#i_update_phone_number").val(),
	    			    },
	    				dataType:"text",
	    			    success:function(data){
	    					if (data>0) {
	    						$.messager.alert("提示","操作成功","info",function(){
	    							$("#i_update_form").dialog("close").form("reset");
	    							$("#i_datagrid").datagrid('reload');
	    						});
	    					} else {
	    							$.messager.alert("提示","操作失败\n 可能原因：1.社长信息并未录入系统 2.社团信息重复 3.社团信息不符合格式","error",function(){
	    						});
	    					}
	    				}
	    			});
	    		}
	    	}
	    	},
	    	{
	    		text:"取消",
				handler:function(){
	    		$("#i_update_form").dialog("close").form("reset");
	    	}
	    	}]
	    });
	 
	 $("input[name='clubType']").combobox({    
		    url:'info/clubtype.json',    
		    valueField:'id',    
		    editable:false,
		    panelHeight:75,
		    textField:'text',
		    value:'公益类'
		});  
	 
});


// 检查能否添加
function checkClubAdd(){
	$("#i_add_club_name").validatebox({
		required:true,
		missingMessage:"请输入社团名称",
	});
	
	$("#i_add_leader_name").validatebox({
		required:true,
		missingMessage:"请输入社长姓名",
	});
	$("#i_add_leader_stu_id").validatebox({
		required:true,
		validType:"length[9,10]",
		missingMessage:"请输入社长学号",
		invalidMessage:"学号为9位",
	});
	if(!$("#i_add_club_name").validatebox("isValid"))
	{
		$("#i_add_club_name").focus();
		return false;
	}else if(!$("#i_add_leader_name").validatebox("isValid"))
	{
		$("#i_add_leader_name").focus();
		return false;
	}else if(!$("#i_add_leader_stu_id").validatebox("isValid")){
		$("#i_add_leader_stu_id").focus();
		return false;
	}else{
		return true;
	}
}
 // 检查是否能更新
 function checkClubUpdate(){
		$("#i_update_club_name").validatebox({
			required:true,
			missingMessage:"请输入社团名称",
		});
		$("#i_update_leader_name").validatebox({
			required:true,
			missingMessage:"请输入社长姓名",
		});
		$("#i_update_leader_stu_id").validatebox({
			required:true,
			validType:"length[9,10]",
			missingMessage:"请输入社长学号",
			invalidMessage:"学号为9位",
		});
		if(!$("#i_update_club_name").validatebox("isValid"))
		{
			$("#i_update_club_name").focus();
			return false;
		}else if(!$("#i_update_leader_name").validatebox("isValid"))
		{
			$("#i_update_leader_name").focus();
			return false;
		}else if(!$("#i_update_leader_stu_id").validatebox("isValid")){
			$("#i_update_leader_stu_id").focus();
			return false;
		}else{
			return true;
		}
	}

// 添加按钮被点击
function addClub(){
   	$("#i_add_form").dialog("open").form("reset");
   	$("input[id='i_add_club_name']").focus();
};
// 更新按钮被点击
function updateClub(){
		var record=$("#i_datagrid").datagrid("getSelections");
		if(record!="")
		{
			$("#i_update_form").dialog("open").form("reset");
			$("#i_update_club_name").val(record[0].clubName);
			$("#i_update_club_type").combobox("setText",record[0].clubType);
			$("#i_update_leader_name").val(record[0].leaderName);
			$("#i_update_leader_stu_id").val(record[0].leaderStuId);
			$("#i_update_club_brief").val(record[0].clubBrief);
			$("#i_update_teacher_name").val(record[0].teacherName);
			$("#i_update_phone_number").val(record[0].leaderPhoneNum);
		}
	};
// 删除按钮被点击
function deleteClub(){
	var record=$("#i_datagrid").datagrid("getSelections");
	if(record!="")
	{
		$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
		    if (r){    
				$.ajax({
					url:'clubAction!deleteClubById',
					type:"post",
					data:{
					    clubId:record[0].clubId,
				    },
					dataType:"text",
				    success:function(data){
						if (data) {
							$.messager.alert("提示","操作成功","info",function(){
								$("#i_datagrid").datagrid('reload');
							});
						} else {
							$.messager.alert("提示","操作失败","error",function(){
							});
						}
					}
				});
		    }    
		});  

	}
}
