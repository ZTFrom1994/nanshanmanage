$(function(){
	
	$(".toolbar-btn").linkbutton({
        plain:true
    }); 
	$('#member-search').searchbox({
        searcher:function(value,name){
    	     if(value!="")
    	     { 
    	    	 $.ajax({
     				url:'clubMemberAction!getClubMembersByKey',
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
	
//	$.getJSON("servlet/AuthCLServlet?flag=getauth", function(data) {
//        $.each(data.auth, function(i, item) { 
//            if(item.add=="无"){
//            	$(".toolbar-btn:eq(0)").linkbutton({
//            		disabled:true
//                });
//            }
//            if(item.deleteauth=="无"){
//            	$(".toolbar-btn:eq(2)").linkbutton({
//            		disabled:true
//                });
//            }
//            if(item.update=="无"){
//            	$(".toolbar-btn:eq(1)").linkbutton({
//            		disabled:true
//                });
//            }
//            if(item.search=="无"){
//            	 $('#datagrid').datagrid('hideColumn','phonenumber');
//            }
//        });
//	});
	
	//生成数据表格
	$("#datagrid").datagrid({
	    url:"clubMemberAction!getClubMembersByPage", 
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
	        {field:'fromClubName',title:'所属社团',resizable:false,sortable:true,width:130,align:"center"},
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
	    	title:"添加社员",
	    	buttons:[{
	    		text:"提交",
	    		handler:function(){
	    		if(checkMemberAdd()){
	    			$.ajax({
	    				url:'clubMemberAction!addClubMember',
	    				type:"post",
	    				data:{
	    					name:$("#a-membername").val(),
	    					id:$("#a-memberstuid").val(),
	    					fromAcademy:$("#a-fromacademy").combobox('getText'),
	    					fromClubName:$("#a-fromclubname").val(),
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
	    				url:'clubMemberAction!updateClubMember',
	    				type:"post",
	    				data:{
		    				name:$("#u-membername").val(),
	    					fromAcademy:$("#u-fromacademy").combobox('getText'),
	    					fromClubName:$("#u-fromclubname").val(),
	    					phoneNumber:$("#u-phonenumber").val(),
	    					sex:$("#u-sex").combobox('getText'),
	    					id:$("#datagrid").datagrid("getSelections")[0].stuId,
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
		    panelHeight:75,
		    textField:'text',
		    value:'理学院'  
		});
	 
	 $("input[name='sex']").combobox({   
		    url:'info/sex.json',
		    valueField:'id',    
		    editable:false,
		    panelHeight:50, 
		    textField:'text',
		    value:'男' 
		});
});

//检查能否添加
function checkMemberAdd(){
	$("#a-membername").validatebox({
		required:true,
		missingMessage:"请输入姓名",
	});
	
	$("#a-fromclubname").validatebox({
		required:true,
		missingMessage:"请输入所属社团完整名称",
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
	}else if(!$("#a-fromclubname").validatebox("isValid"))
	{
		$("#a-fromclubname").focus();
		return false;
	}else if(!$("#a-memberstuid").validatebox("isValid")){
		$("#a-memberstuId").focus();
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
		
		$("#u-fromclubname").validatebox({
			required:true,
			missingMessage:"请输入所属社团完整名称",
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
		}else if(!$("#u-fromclubname").validatebox("isValid"))
		{
			$("#u-fromclubname").focus();
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
			$("#u-fromclubname").val(record[0].fromClubName);
			$("#u-phonenumber").val(record[0].phoneNumber);
		}
	};
	
function deleteMember(){
		var record=$("#datagrid").datagrid("getSelections");
		if(record!="")
		{
			$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
			    if (r){    
					$.ajax({
						url:'clubMemberAction!deleteClubMemberById',
						type:"post",
						data:{ 
						   id:record[0].stuId,
					    },
						dataType:"text",
					    success:function(data){
							if (data>0) {
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
