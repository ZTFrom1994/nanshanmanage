$(function(){
	$(".toolbar-btn").linkbutton({
        plain:true
    });
	$('#user-search').searchbox({
        searcher:function(value,name){
    	     if(value!="")
    	     { 
    	    	 $.ajax({
     				url:'userAction!getUsersByKeyWord',
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
        prompt:'按姓名搜索'
    });
	//生成数据表格
	$("#datagrid").datagrid({
	    url:"userAction!getUsersByPage", 
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
	        {field:'id',title:'序号',resizable:false,width:50,align:"center"},
	        {field:'username',title:'用户名',resizable:false,width:100,align:"center"},
	        {field:'authName',title:'权限',resizable:false,width:50,align:"center"},
	        {field:'registerDate',title:'注册时间',resizable:false,width:100,align:"center"},
	    ]],
	    toolbar:"#toolbar",
	});
	
	$("#updateform").dialog({
	    	closed:true,
	    	modal:true,
	    	width:400,
	    	height:400,
	    	title:"添加用户",
	    	buttons:[{
	    		text:"提交",
	    		handler:function(){
	    			$.ajax({
	    				url:'userAction!updateUser',
	    				type:"post",
	    				data:{
	    					username:$("#username").val(),
	    					authName:$("#auth").combobox("getText"),
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
	    	},
	    	{
	    		text:"取消",
				handler:function(){
	    		$("#updateform").dialog("close").form("reset");
	    	}
	    	}]
	    });

	 
	 $("#auth").combobox({    
		    url:'authAction!getAuthName',    
		    valueField:'id',
		    editable:false,
		    panelHeight:75,
		    textField:'text',
		    value:'普通'
		});  
	 
});


//添加按钮被点击
function updateUser(){
	var record=$("#datagrid").datagrid("getSelections");
	if(record!="")
	{
		$("#updateform").dialog("open").form("reset");
		$("#username").val(record[0].username);
		$("#registerDate").val(record[0].registerDate);
		$("#auth").combobox('setText',record[0].authName);
	}
};
//删除按钮被点击
function deleteUser(){
	var record=$("#datagrid").datagrid("getSelections");
	if(record!="")
	{
		$.messager.confirm('确认','您确认想要删除此用户吗？',function(r){    
		    if (r){    
				$.ajax({
					url:'userAction!deleteUser',
					type:"post",
					data:{
					    id:record[0].id
				    },
					dataType:"text",
				    success:function(data){
						if (data==1) {
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
