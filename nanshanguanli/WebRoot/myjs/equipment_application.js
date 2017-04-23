$(function(){
	$(".toolbar-btn").linkbutton({
        plain:true
    });
	$('#search').searchbox({
        searcher:function(value,name){
    	     if(value!="")
    	     { 
    	    	 $.ajax({
     				url:'erAction!getEquipmentRecordsBykeyWord',
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
        prompt:'使用者姓名/使用单位'
    });  
//	$.getJSON("servlet/AuthCLServlet?flag=getauth", function(data) {
//        $.each(data.auth, function(i, item) {
//            if(item.add=="无"){
//            	$("#toolbar>.toolbar-btn:eq(0)").linkbutton({
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
	    url:"erAction!getEquipmentRecordsByPage", 
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
	    loadMsg:"正在加载数据.....",
	    columns:[[  
	        {checkbox:true}, 
	        {field:'id',title:'编号',resizable:false,width:fixWidth(0.05),align:"center"}, 
	        {field:'borrowedType',title:'物品类型',resizable:false,width:fixWidth(0.1),align:"center"},
	        {field:'number',title:'数量',resizable:false,width:fixWidth(0.05),align:"center"},
	        {field:'unit',title:'借用单位',resizable:false,width:fixWidth(0.1),align:"center"},
	        {field:'startTime',title:'开始时间',resizable:false,width:fixWidth(0.1),align:"center"},
	        {field:'endTime',title:'结束时间',resizable:false,width:fixWidth(0.1),align:"center"},
	        {field:'username',title:'负责人',resizable:false,width:fixWidth(0.05),align:"center"},
	        {field:'contact',title:'联系电话',resizable:false,width:fixWidth(0.1),align:"center"},
	        {field:'usingFor',title:'用途',resizable:false,width:fixWidth(0.2),align:"center"}, 
	        {field:'isOvertime',title:'超时未还',resizable:false,width:fixWidth(0.05),align:"center"},
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
	    	title:"器材申请记录",
	    	buttons:[{
	    		text:"提交",
	    		handler:function(){
	    		if(checkRecordAdd()){
	    			$.ajax({
	    				url:'erAction!addRecord',
	    				type:"post",
	    				data:{
	    					borrowedType:$("#a-type").combobox('getText'),
	    				    startTime:$("#a-starttime").datebox('getText'),
	    					endTime:$("#a-endtime").datebox('getText'), 
	    					number:$("#a-number").numberspinner("getValue"), 
	    					contact:$("#a-phonenumber").val(), 
	    					unit:$("#a-unit").val(),
	    					petitioner:$("#a-username").val(),
	    					usingFor:$("#a-usingfor").val(), 
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

	 
	 $("input[name='type']").combobox({    
		    url:'info/equipments.json',    
		    valueField:'id',    
		    editable:false, 
		    panelHeight:75,
		    textField:'text',
		    value:'两人木桌' 
		});
	 $("input[name='number']").numberspinner({   
		    value:0,
		    min:1,
		    max:10,
		    width:155
		});
	 
	 $("input[name='starttime']").datebox({
		 required:true,
		 invalidMessage:"请选择开始日期",
		 missingMessage: "请选择开始日期",
		 formatter:function(date){
			var y = date.getFullYear();
			var m = date.getMonth()+1;
			var d = date.getDate();
			return y+'-'+m+'-'+d;
			}
		}); 
	 
	 $("input[name='endtime']").datebox({
		 required:true,
		 missingMessage: "请选择结束日期",
		 invalidMessage:"请选择结束日期",
		 formatter:function(date){
			var y = date.getFullYear();
			var m = date.getMonth()+1;
			var d = date.getDate();
			return y+'-'+m+'-'+d;
			}  
		}); 
});

function fixWidth(percent)  
{  
    return document.body.clientWidth * percent ; //这里你可以自己做调整  
} 

//检查能否添加
function checkRecordAdd(){
	$("#a-unit").validatebox({
		required:true,
		missingMessage:"请输入借用单位",
	});
	$("#a-username").validatebox({
		required:true,
		missingMessage:"请输入登记人姓名",
	});
	$("#a-phonenumber").validatebox({
		required:true,
		validType:"length[6,15]",
		invalidMessage:"电话号码格式不正确",
		missingMessage:"请输入联系电话",
	});
	$("#a-usingfor").validatebox({
		required:true,
		missingMessage:"请输入用途",
	});
	if(!$("#a-unit").validatebox("isValid"))
	{
		$("#a-unit").focus();
		return false;
	}else if(!$("#a-username").validatebox("isValid")){
		$("#a-username").focus();
		return false;
	}else if(!$("#a-phonenumber").validatebox("isValid")){
		$("#a-phonenumber").focus();
		return false;
	}
	else if(!$("#a-usingfor").validatebox("isValid")){
		$("#a-usingfor").focus();
		return false;
	}
	else{
		return true;
	}
}


//添加按钮被点击
function addregistration(){
   	$("#addform").dialog("open").form("reset");
};
//删除按钮被点击
function deleteregistration(){
	var record=$("#datagrid").datagrid("getSelections");
	if(record!="")
	{
		$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
		    if (r){    
				$.ajax({
					url:'erAction!deleteRecordById',
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
