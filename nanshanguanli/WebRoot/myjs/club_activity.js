$(function(){
	$(".toolbar-btn").linkbutton({
        plain:true
    });
	$('#activity-search').searchbox({
        searcher:function(value,name){
    	     if(value!="")
    	     { 
    	    	 $.ajax({
     				url:'clubActivityAction!getClubActivityByKeyWord',
     				type:"post",
     				data:{
     					key:value,
     			    },
     				dataType:"json",
     			    success:function(data){
     			    	$('#datagrid').datagrid('loadData',data);
     				}
     			});
    	     }
        },
        prompt:'活动名称/举办社团'
    });
	
	//生成数据表格
	$("#datagrid").datagrid({
	    url:"clubActivityAction!getClubActivitiesByPage", 
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
	        {field:'id',title:'id',resizable:false,hidden:true,width:70,align:"center"},
	        {field:'name',title:'活动名称',resizable:false,width:120,align:"center"},
	        {field:'form',title:'活动形式',resizable:false,hidden:true,sortable:true,width:70,align:"center"},
	        {field:'fromclub',title:'举办社团',resizable:false,sortable:true,width:120,align:"center"},
	        {field:'leadername',title:'负责人',resizable:false,width:70,align:"center"},
	        {field:'contact',title:'联系电话',resizable:false,width:80,align:"center"},
	        {field:'holdplace',title:'举办地点',resizable:false,width:130,align:"center"},
	        {field:'starttime',title:'开始时间',resizable:false,sortable:true,width:70,align:"center"},
	        {field:'endtime',title:'结束时间',resizable:false,sortable:true,width:70,align:"center"},
	        {field:'borrowed',title:'器材借用',resizable:false,width:50,align:"center"},
	        {field:'introduction',title:'活动简介',resizable:false,width:230,align:"center"},
	    ]],  
	    toolbar:"#toolbar"   
	});
	//生成addform
	$("#addform").dialog({
	    	closed:true,
	    	modal:true,
	    	top:0,
	    	width:400,
	    	height:600,
	    	title:"添加活动",
	    	buttons:[{
	    		text:"提交",
	    		handler:function(){
	    		if(checkActivityAdd()){
	    			$.ajax({
	    				url:'clubActivityAction!addClubActivity',
	    				type:"post",
	    				data:{
	    				    name:$("#a-activity-name").val(),
	    				    startTime:$("#a-start-time").datebox('getText'),
	    					endTime:$("#a-end-time").datebox('getText'), 
	    					fromClub:$("#a-from-club").val(), 
	    					contact:$("#a-contact").val(), 
	    					leaderName:$("#a-leadername").val(),
	    					isBorrowed:$("#a-borrowed").combobox('getText'),
	    					holdPlace:$("#a-hold-place").val(),
	    					form:$("#a-form").combobox('getText'),
	    					introduction:$("#a-introduction").val(),
	    			    },
	    				dataType:"text",
	    			    success:function(data){
	    					if (data>0) {
	    						$.messager.alert("提示","操作成功","info",function(){
	    							$("#addform").dialog("close").form("reset");
	    							$("#datagrid").datagrid('reload');
	    						});
	    					} else {
	    						$.messager.alert("提示","操作失败","error",function(){
	    							$("#addform").dialog("close").form("reset");
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
	    		$("#addform").dialog("close").form("reset");
	    	}
	    	}]
	    });

	 //生成更新表格
	 $("#updateform").dialog({
	    	closed:true,
	    	modal:true,
	    	top:0,
	    	width:400,
	    	height:600,
	    	title:"更新信息",
	    	buttons:[{
	    		text:"提交",
	    		handler:function(){
	    		if(checkActivityUpdate()){
	    			$.ajax({
	    				url:'clubActivityAction!updateClubActivity',
	    				type:"post",
	    				data:{
		    				name:$("#u-activity-name").val(),
	    					starttime:$("#u-start-time").datebox('getText'),
	    					endtime:$("#u-end-time").datebox('getText'),
	    					fromclub:$("#u-from-club").val(),
	    					contact:$("#u-contact").val(),
	    					leadername:$("#u-leadername").val(),
	    					borrowed:$("#u-borrowed").combobox('getText'),
	    					holdplace:$("#u-hold-place").val(),
	    					form:$("#u-form").combobox('getText'),
	    					introduction:$("#u-introduction").val(),
	    					id:$("#datagrid").datagrid("getSelections")[0].id,
	    			    },
	    				dataType:"text",
	    			    success:function(data){
	    					if (data>0) {
	    						$.messager.alert("提示","操作成功","info",function(){
	    							$("#updateform").dialog("close").form("reset");
	    							$("#datagrid").datagrid('reload');
	    						});
	    					} else {
	    						$.messager.alert("提示","操作失败","error",function(){
	    							$("#updateform").dialog("close").form("reset");
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
	    		$("#updateform").dialog("close").form("reset");
	    	}
	    	}]
	    });
	 
	 $("input[name='form']").combobox({    
		    url:'clubActivityAction!getActivityForm',    
		    valueField:'id',    
		    editable:false,
		    panelHeight:75,
		    textField:'text',
		    value:'比赛' 
		});
	 $("input[name='borrowed']").combobox({   
		    url:'info/yesorno.json', 
		    valueField:'id',    
		    editable:false,
		    panelHeight:50, 
		    textField:'text',
		    value:'否' 
		});
	 $("input[name='start-time']").datebox({
		 missingMessage: "请选择开始日期",
		 required:true,
		 formatter:function(date){
			var y = date.getFullYear();
			var m = date.getMonth()+1;
			var d = date.getDate();
			return y+'-'+m+'-'+d;
			}
		}); 
	 $("input[name='end-time']").datebox({
		 missingMessage: "请选择结束日期",
		 required:true,
		 formatter:function(date){
			var y = date.getFullYear();
			var m = date.getMonth()+1;
			var d = date.getDate();
			return y+'-'+m+'-'+d;
			}  
		}); 
});

//检查能否添加
function checkActivityAdd(){
	$("#a-activity-name").validatebox({
		required:true,
		missingMessage:"请输入活动名称",
	});
	$("#a-contact").validatebox({
		required:true,
		missingMessage:"请输入负责人联系方式",
	});
	$("#a-leadername").validatebox({
		required:true,
		missingMessage:"请输入负责人姓名",
	});
	$("#a-from-club").validatebox({
		required:true,
		missingMessage:"请输入举办社团完整名称",
	});
	$("#a-hold-place").validatebox({
		required:true,
		missingMessage:"请输入活动举办地点",
	});
	$("#a-introduction").validatebox({
		required:true,
		missingMessage:"请输入活动简介",
	});
	
	if(!$("#a-activity-name").validatebox("isValid"))
	{
		$("#a-activity-name").focus();
		return false;
	}else if(!$("#a-contact").validatebox("isValid")){
		$("#a-contact").focus();
		return false;
	}else if(!$("#a-leadername").validatebox("isValid")){
		$("#a-leadername").focus();
		return false;
	}
	else if(!$("#a-from-club").validatebox("isValid")){
		$("#a-from-club").focus();
		return false;
	}
	else if(!$("#a-hold-place").validatebox("isValid")){
		$("#a-hold-place").focus();
		return false;
	}
	else if(!$("#a-introduction").validatebox("isValid")){
		$("#a-introduction").focus();
		return false;
	}else{
		return true;
	}
}
 //检查是否能更新
 function checkActivityUpdate(){
	 $("#u-activity-name").validatebox({
			required:true,
			missingMessage:"请输入活动名称",
		});
	 $("#u-contact").validatebox({
			required:true,
			missingMessage:"请输入负责人联系方式",
		});
	 $("#u-leadername").validatebox({
			required:true,
			missingMessage:"请输入负责人姓名",
		});
		$("#u-from-club").validatebox({
			required:true,
			missingMessage:"请输入举办社团完整名称",
		});
		$("#u-hold-place").validatebox({
			required:true,
			missingMessage:"请输入活动举办地点",
		});
		$("#u-introduction").validatebox({
			required:true,
			missingMessage:"请输入活动简介",
		});
		
		if(!$("#u-activity-name").validatebox("isValid"))
		{
			$("#u-activity-name").focus();
			return false;
		}else if(!$("#u-contact").validatebox("isValid")){
			$("#u-contact").focus();
			return false;
		}else if(!$("#u-leadername").validatebox("isValid")){
			$("#u-leadername").focus();
			return false;
		}
		else if(!$("#u-from-club").validatebox("isValid")){
			$("#u-from-club").focus();
			return false;
		}
		else if(!$("#u-hold-place").validatebox("isValid")){
			$("#u-hold-place").focus();
			return false;
		}
		else if(!$("#u-introduction").validatebox("isValid")){
			$("#u-introduction").focus();
			return false;
		}else{
			return true;
		}
	}

//添加按钮被点击
function addActivity(){
   	$("#addform").dialog("open").form("reset");
   	$("input[id='a-membername']").focus();
};
//更新按钮被点击
function updateActivity(){
		var record=$("#datagrid").datagrid("getSelections");
		if(record!="")
		{
			$("#updateform").dialog("open").form("reset");
		 	$("#u-activity-name").focus();
			$("#u-activity-name").val(record[0].name);
			$("#u-start-time").datebox('setText',(record[0].starttime));
			$("#u-end-time").datebox('setText',record[0].endtime);
			$("#u-from-club").val(record[0].fromclub);
			$("#u-contact").val(record[0].contact);
			$("#u-leadername").val(record[0].leadername);
			$("#u-borrowed").combobox("setText",record[0].borrowed);
			$("#u-hold-place").val(record[0].holdplace);
			$("#u-form").combobox("setText",record[0].form);
			$("#u-introduction").val(record[0].introduction);
		}
	};
//删除按钮被点击
function deleteActivity(){
	var record=$("#datagrid").datagrid("getSelections");
	if(record!="")
	{
		$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
		    if (r){    
				$.ajax({
					url:'clubActivityAction!deleteClubActivityById',
					type:"post",
					data:{
					    id:record[0].id,
						flag:"delete",
				    },
					dataType:"text",
				    success:function(data){
						if (data) {
							$.messager.alert("提示","操作成功","info",function(){
								$("#datagrid").datagrid('reload');
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
