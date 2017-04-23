$(function(){
	 $.ajax({
			url:'userAction!isLogged', 
			type:"post",
			dataType:"json",
		    success:function(data){
		    	if(data==0){
		    		$('#win').dialog({    
		    		    title: '提示',    
		    		    width: 150, 
		    		    closable:false,
		    		    height: 120,    
		    		    closed: false,    
		    		    cache: false,    
		    		    modal: true,
		    		    buttons:[{
		    				text:'确定',
		    				handler:function(){
		    		    	 window.location="index.jsp"; 
		    		    	}
		    			}]
		    		});    
		    	}
			}
		})
})
function logout(){
	
	$.messager.confirm('确认对话框', '您想要退出该系统吗？', function(r){
		if (r){
			$.ajax({
				url:'userAction!logout', 
				type:"post",
			    success:function(data){
			    	   window.location="index.jsp"; 
				}
			});
		}
	});
}

function myAuth(){
	  $('#dd').dialog({    
  	    title: '我的权限',    
  	    width: 200,    
  	    height: 200,    
  	    closed: false,    
  	    cache: false,
  	    modal: true   
  	}); 
}