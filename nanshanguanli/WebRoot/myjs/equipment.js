$(function(){
	$(".toolbar-btn").linkbutton({
        plain:true
    });
//	$.getJSON("servlet/AuthCLServlet?flag=getauth", function(data) {
//        $.each(data.auth, function(i, item) {
//            if(item.add=="无"){
//            	$("#toolbar>.toolbar-btn:eq(0)").linkbutton({
//            		disabled:true
//                });
//            }
//            if(item.deleteauth=="否"){
//            	$(".toolbar-btn:eq(1)").linkbutton({
//            		disabled:true
//                });
//            }
//        });
//	});
	
	//生成数据表格
	$("#datagrid").datagrid({
	    url:"equipmentAction!getEquipmentsByPage", 
	    fit:true,
	    fitColumns:true,
	    border:false, 
	    pagination:true, 
	    pageList:[30,60], 
	    pageSize:30, 
	    pageNumber:1, 
	    singleSelect:true,
	    scrollbarSize :0, 
	    remoteSort:false, 
	    rownumbers:true,
	    loadMsg:"正在加载数据.....",
	    columns:[[
	        {checkbox:true},
	        {field:'id',title:'编号',resizable:false,sortable:true,width:130,align:"center"},
	        {field:'type',title:'类型',resizable:false,width:230,sortable:true,align:"center"},
	        {field:'addTime',title:'添加时间',sresizable:false,width:200,sortable:true,halign:"center",align:"center"},
	        {field:'status',title:'状态',resizable:false,width:130,sortable:true,align:"center"},
	        {field:'usingUnit',title:'使用单位',sresizable:false,width:130,sortable:true,halign:"center",align:"center"},
	    ]],
	    toolbar:"#toolbar",
	});
	$("#addform").dialog({
	    	closed:true,
	    	modal:true,
	    	width:400,
	    	height:400,
	    	title:"添加器材", 
	    	buttons:[{
	    		text:"提交",
	    		handler:function(){
	    			$.ajax({
	    				url:'equipmentAction!addEquipment',
	    				type:"post",
	    				data:{
		    				type:$("#a-type").combobox("getText"),
		    				num:$("#a-number").numberspinner("getValue"),  
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

	 $("input[name='type']").combobox({    
		    url:'info/equipments.json',    
		    valueField:'id',    
		    editable:false, 
		    panelHeight:75,
		    textField:'text',
		    value:'两人木桌' 
		});
	 $('#a-number').numberspinner({    
		    min:1,
		    width:155,
		    value:0
	});
	 
});


//添加按钮被点击
function addEquipment(){
   	$("#addform").dialog("open").form("reset");
};

//删除按钮被点击
function deleteEquipment(){
	var record=$("#datagrid").datagrid("getSelections");
	if(record!="")
	{
		$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
		    if (r){    
				$.ajax({
					url:'equipmentAction!deleteEquipmentById',
					type:"post",
					data:{
					    id:record[0].id,
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
