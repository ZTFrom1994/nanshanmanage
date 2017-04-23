$(function(){
	$(".toolbar-btn").linkbutton({
        plain:true
    });
	$('#ground-search').searchbox({
        searcher:function(value,name){
    	     if(value!="")
    	     { 
    	    	 $.ajax({
     				url:'groundAction!getGroundByKeyWord', 
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
        prompt:'按编号搜索' 
    });
//	$.getJSON("servlet/AuthCLServlet?flag=getauth", function(data) {
//        $.each(data.auth, function(i, item) {
//            if(item.add=="无"){
//            	$(".toolbar-btn:eq(0)").linkbutton({
//            		disabled:true
//                });
//            } 
//            if(item.deleteauth=="无"){
//            	$(".toolbar-btn:eq(1)").linkbutton({
//            		disabled:true
//                });
//            }
//        });
//	});
	//生成数据表格
	$("#datagrid").datagrid({
	    url:"groundAction!getGroundBypage", 
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
	        {field:'name',title:'编号',resizable:false,sortable:true,width:130,align:"center"},
	        {field:'id',title:'id',resizable:false,hidden:true,sortable:true,width:130,align:"center"},
	        {field:'status',title:'状态',resizable:false,width:130,sortable:true,align:"center"},
	        {field:'addTime',title:'添加时间',sresizable:false,width:330,sortable:true,align:"center"},
	        {field:'usingUnit',title:'使用单位',resizable:false,width:230,sortable:true,align:"center"},
	       ]],
	    toolbar:"#toolbar",
	});
	$("#addform").dialog({
	    	closed:true,
	    	modal:true,
	    	width:400,
	    	height:400,
	    	top:150,
	    	title:"添加场地", 
	    	buttons:[{
	    		text:"提交",
	    		handler:function(){
	    			$.ajax({
	    				url:'groundAction!addGround',
	    				type:"post",
	    				data:{
	    				    groundName:$("#a-name").val()
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
	    	},
	    	{
	    		text:"取消",
				handler:function(){
	    		$("#addform").dialog("close").form("reset");
	    	}
	    	}]
	    });
});


//添加按钮被点击
function addGround(){
   	$("#addform").dialog("open").form("reset");
};

//删除按钮被点击
function deleteGround(){
	var record=$("#datagrid").datagrid("getSelections");
	if(record!="")
	{
		$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
		    if (r){    
				$.ajax({
					url:'groundAction!deleteGround',
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
