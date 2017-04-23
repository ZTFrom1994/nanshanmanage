$(function(){
	$(".toolbar-btn").linkbutton({
        plain:true
    });
	$('#search').searchbox({
        searcher:function(value,name){
    	     if(value!="")
    	     { 
    	    	 $.ajax({
     				url:'garAction!getRecordsByKeyWord',
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
        prompt:'负责人/场地编号/操作人'
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
	    url:"garAction!getRecordsByPage", 
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
	        {field:'id',title:'id',resizable:false,hidden:true,width:fixWidth(0.05),align:"center"}, 
	        {field:'groundName',title:'场地编号',resizable:false,width:fixWidth(0.05),align:"center"}, 
	        {field:'usingUnit',title:'借用单位',resizable:false,width:fixWidth(0.07),align:"center"},
	        {field:'startTime',title:'开始时间',resizable:false,width:fixWidth(0.09),align:"center"},
	        {field:'endTime',title:'结束时间',resizable:false,width:fixWidth(0.09),align:"center"},
	        {field:'petitioner',title:'负责人',resizable:false,width:fixWidth(0.05),align:"center"},
	        {field:'contact',title:'联系电话',resizable:false,width:fixWidth(0.09),align:"center"},
	        {field:'usingFor',title:'用途',resizable:false,width:fixWidth(0.2),align:"center"},
	        {field:'operator',title:'操作人',resizable:false,width:fixWidth(0.09),align:"center"},
	        {field:'operateTime',title:'操作时间',resizable:false,width:fixWidth(0.09),align:"center"},
	    ]],
	    toolbar:"#toolbar"
	});
});

function fixWidth(percent)  
{  
    return document.body.clientWidth * percent ; //这里你可以自己做调整  
} 

