$(function(){
	$(".toolbar-btn").linkbutton({
        plain:true
    });
	$('#search').searchbox({
        searcher:function(value,name){
    	     if(value!="")
    	     { 
    	    	 $.ajax({
     				url:'authAction!getAuthsByKeyWord',
     				type:"post",
     				data:{
     					key:value
     			    },
     				dataType:"json",
     			    success:function(data){
     			    	$('#datagrid').datagrid('loadData',data);
     				}
     			});
    	     }
        },
        prompt:'权限名称'
    });
	//生成数据表格
	$("#datagrid").datagrid({
	    url:"authAction!getAuthsByPage", 
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
	        {field:'id',title:'id',resizable:false,hidden:true,width:50,align:"center"},
	        {field:'name',title:'权限名称',resizable:false,width:50,align:"center"},
	        {field:'addAuth',title:'添加权限',resizable:false,width:50,align:"center"},
	        {field:'updateAuth',title:'修改权限',resizable:false,width:50,align:"center"},
	        {field:'searchAuth',title:'搜索权限',resizable:false,width:50,align:"center"},
	        {field:'deleteAuth',title:'删除权限',sresizable:false,width:50,align:"center"},
	    ]],
	    toolbar:"#toolbar",
	});
	//生成addform
	$("#addform").dialog({
	    	closed:true,
	    	modal:true,
	    	width:400,
	    	height:400,
	    	title:"添加权限",
	    	buttons:[{
	    		text:"提交",
	    		handler:function(){
	    		if(checkAdd()){
	    			$.ajax({
	    				url:'authAction!addAuth',
	    				type:"post",
	    				data:{
	    					name:$("#a-name").val(),
	    					addAuth:$("#a-add").combobox("getText"),
	    					deleteAuth:$("#a-delete").combobox("getText"),
	    					updateAuth:$("#a-update").combobox("getText"),
	    					searchAuth:$("#a-search").combobox("getText"),
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
	    	title:"修改权限",
	    	buttons:[{
	    		text:"提交",
	    		handler:function(){
	    		if(checkUpdate()){
	    			$.ajax({
	    				url:'authAction!updateAuth',
	    				type:"post",
	    				data:{
	    				    id:$("#datagrid").datagrid("getSelections")[0].id,
		    				name:$("#u-name").val(),
	    					addAuth:$("#u-add").combobox("getText"),
	    					deleteAuth:$("#u-delete").combobox("getText"),
	    					updateAuth:$("#u-update").combobox("getText"),
	    					searchAuth:$("#u-search").combobox("getText")
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
	 
	 $("input[name='add']").combobox({    
		    url:'info/yesorno.json',    
		    valueField:'id',    
		    editable:false,
		    panelHeight:50,
		    textField:'text',
		    value:'无' 
		}); 
	 
	  
	 $("input[name='update']").combobox({    
		    url:'info/yesorno.json',    
		    valueField:'id',    
		    editable:false,
		    panelHeight:50,
		    textField:'text',
		    value:'无'
		}); 
	 $("input[name='delete']").combobox({    
		    url:'info/yesorno.json',    
		    valueField:'id',    
		    editable:false,
		    panelHeight:50,
		    textField:'text',
		    value:'无'
		}); 
	 $("input[name='search']").combobox({    
		    url:'info/yesorno.json',    
		    valueField:'id',    
		    editable:false,
		    panelHeight:50,
		    textField:'text',
		    value:'无'
		}); 
});


//检查能否添加
function checkAdd(){
	$("#a-name").validatebox({
		required:true,
		missingMessage:"请输入社团名称",
	});
	if(!$("#a-name").validatebox("isValid"))
	{
		$("#a-name").focus();
		return false;
	}else{
		return true;
	}
}
 //检查是否能更新
 function checkUpdate(){
		$("#u-name").validatebox({
			required:true,
			missingMessage:"请输入权限名称",
		});
		if(!$("#u-name").validatebox("isValid"))
		{
			$("#u-name").focus();
			return false;
		}else{
			return true;
		}
	}

//添加按钮被点击
function addAuth(){
   	$("#addform").dialog("open").form("reset");
   	$("input[id='a-name']").focus();
};
//更新按钮被点击
function updateAuth(){
		var record=$("#datagrid").datagrid("getSelections");
		if(record!="")
		{
			$("#updateform").dialog("open").form("reset");
			$("#u-name").val(record[0].name);
			$("#u-add").combobox("setText",record[0].addAuth);
			$("#u-delete").combobox("setText",record[0].deleteAuth);
			$("#u-update").combobox("setText",record[0].updateAuth);
			$("#u-search").combobox("setText",record[0].searchAuth);
		}else{
			alert("请选择一条记录！");
		}
};
//删除按钮被点击
function deleteAuth(){
	var record=$("#datagrid").datagrid("getSelections");
	if(record!="")
	{
		$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
		    if (r){    
				$.ajax({
					url:'authAction!deleteAuthById',
					type:"post",
					data:{
					    id:record[0].id
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
