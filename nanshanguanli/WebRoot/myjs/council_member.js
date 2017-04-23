$(function(){
	$(".toolbar-btn").linkbutton({
        plain:true
    }); 
	
	$('#member-search').searchbox({
        searcher:function(value,name){
    	     if(value!="")
    	     { 
    	    	 $.ajax({
     				url:'councilMemberAction!getCoucilMembersByKeyWord',
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
        prompt:'姓名/学号/社团'
    });
	//生成数据表格
	$("#datagrid").datagrid({
	    url:"councilMemberAction!getCouncilMembersByPage", 
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
	        {field:'name',title:'姓名',resizable:false,width:130,align:"center"},
	        {field:'stuId',title:'学号',resizable:false,sortable:true,width:130,align:"center"},
	        {field:'sex',title:'性别',resizable:false,sortable:true,width:30,align:"center"},
	        {field:'fromAcademy',title:'学院',resizable:false,sortable:true,width:130,align:"center"},
	        {field:'fromDepartment',title:'所属部门',resizable:false,sortable:true,width:130,align:"center"},
	        {field:'position',title:'职位',resizable:false,width:130,align:"center"},
	        {field:'phoneNumber',title:'联系电话',resizable:false,width:130,align:"center"},
	    ]], 
	    toolbar:"#toolbar"
	});
	//生成addform
	$("#addform").dialog({
	    	closed:true,
	    	modal:true,
	    	width:400,
	    	height:400,
	    	title:"添加人员",
	    	buttons:[{
	    		text:"提交",
	    		handler:function(){
	    		if(checkMemberAdd()){
	    			$.ajax({
	    				url:'councilMemberAction!addCouncilMember',
	    				type:"post",
	    				data:{
	    					name:$("#a-membername").val(),
	    					stuId:$("#a-memberstuid").val(),
	    					fromAcademy:$("#a-fromacademy").combobox('getText'),
	    					positionName:$("#a-position").combobox('getText'),
	    					departmentName:$("#a-fromdepartment").combobox('getText'),
	    					phoneNumber:$("#a-phonenumber").val(),
	    					sex:$("#a-sex").combobox('getText'),
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
	    	width:400,
	    	height:400,
	    	title:"更新信息",
	    	buttons:[{
	    		text:"提交",
	    		handler:function(){
	    		if(checkMemberUpdate()){
	    			$.ajax({
	    				url:'councilMemberAction!updateCouncilMember',
	    				type:"post",
	    				data:{
	    				stuId:$("#u-memberstuid").val(),
	    				name:$("#u-membername").val(), 
    					fromAcademy:$("#u-fromacademy").combobox('getText'),
    					positionName:$("#u-position").combobox('getText'),
    					departmentName:$("#u-fromdepartment").combobox('getText'),
    					phoneNumber:$("#u-phonenumber").val(),
    					sex:$("#u-sex").combobox('getText'),
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
	 
	 $("input[name='fromacademy']").combobox({    
		    url:'info/academys.json',      
		    valueField:'id', 
		    editable:false, 
		    panelHeight:130,
		    textField:'text',
		    value:'理学院'  
		});
	 $("input[name='fromdepartment']").combobox({    
		    url:'info/departments.json',      
		    valueField:'id',
		    editable:false, 
		    panelHeight:130,
		    textField:'text',
		    value:'秘书部',
		    required:true,
		});
	 
	 $("input[name='sex']").combobox({   
		    url:'info/sex.json',
		    valueField:'id',    
		    editable:false,
		    panelHeight:50, 
		    textField:'text',
		    value:'男' 
		});
	 $("input[name='position']").combobox({   
		    url:'info/position.json',
		    valueField:'id',    
		    editable:false, 
		    panelHeight:100, 
		    textField:'text',
		    value:'部员' 
		});
});

//检查能否添加
function checkMemberAdd(){
	$("#a-membername").validatebox({
		required:true,
		missingMessage:"请输入姓名",
	});
	
	$("#a-memberstuid").validatebox({
		required:true,
		validType:"length[9,10]",
		missingMessage:"请输入学号",
		invalidMessage:"学号为9位",
	});
	$("#a-phonenumber").validatebox({
		required:true,
		validType:"length[10,14]",
		missingMessage:"请输入联系电话",
		invalidMessage:"联系电话为10-14位",
	});
	if(!$("#a-membername").validatebox("isValid"))
	{
		$("#a-membername").focus();
		return false;
	}else if(!$("#a-memberstuid").validatebox("isValid")){
		$("#a-memberstuid").focus();
		return false;
	}else if(!$("#a-phonenumber").validatebox("isValid")){
		$("#a-phonenumber").focus();
		return false;
	}else{
		return true;
	}
}
 //检查是否能更新
 function checkMemberUpdate(){
	 	$("#u-membername").validatebox({
			required:true,
			missingMessage:"请输入姓名",
		});
		$("#u-memberstuid").validatebox({
			required:true,
			validType:"length[9,10]",
			missingMessage:"请输入学号",
			invalidMessage:"学号为9位",
		});
		$("#u-phonenumber").validatebox({
			required:true,
			validType:"length[10,14]",
			missingMessage:"请输入联系电话",
			invalidMessage:"联系电话为10-14位",
		});
		
		if(!$("#u-membername").validatebox("isValid"))
		{
			$("#u-membername").focus();
			return false;
		}else if(!$("#u-memberstuid").validatebox("isValid")){
			$("#u-memberstuid").focus();
			return false;
		}else if(!$("#u-phonenumber").validatebox("isValid")){
			$("#u-phonenumber").focus();
			return false;
		}else{
			return true;
		}
	}

//添加按钮被点击
function addMember(){
   	$("#addform").dialog("open").form("reset");
   	$("input[id='a-membername']").focus();
};
//更新按钮被点击
function updateMember(){
		var record=$("#datagrid").datagrid("getSelections");
		if(record!="")
		{
			$("#updateform").dialog("open").form("reset");
			$("#u-membername").val(record[0].name);
			$("#u-memberstuid").val(record[0].stuId);
			$("#u-sex").combobox("setText",record[0].sex);
			$("#u-fromacademy").combobox("setText",record[0].fromAcademy);
			$("#u-fromdepartment").combobox("setText",record[0].fromDepartment);
			$("#u-position").combobox("setText",record[0].position);
			$("#u-phonenumber").val(record[0].phoneNumber);
		}
	};
//删除按钮被点击
function deleteMember(){
	var record=$("#datagrid").datagrid("getSelections");
	if(record!="")
	{
		$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
		    if (r){    
				$.ajax({
					url:'councilMemberAction!deleteCouncilMember',
					type:"post",
					data:{
						stuId:record[0].stuId,
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
