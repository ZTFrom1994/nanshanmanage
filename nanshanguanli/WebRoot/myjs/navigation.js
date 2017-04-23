$(function(){
	$('#tt').tree({    
	    url:"info/nav.json",
	    onClick:function(node){
		if(node.url)
		{
			if($("#tab").tabs("exists",node.text)){
				$("#tab").tabs("select",node.text);
			}
			else{
				 $.getJSON("userAction!getCurrentAuth", function(data) {
				        $.each(data.auth, function(i, item) {
				        	if(item.deleteAuth=="无"&&(node.text=="用户列表"||node.text=="权限设置")){
								$.messager.defaults = { ok: "确定"};
								$.messager.alert("提示","您没有足够的权限浏览此项","info",function(){
								}); 
							}else{ 
								$("#tab").tabs("add",{
									title:node.text,
									content:createFrame(node.url),
									closable:true
								});
							}
				        });
				});
			}
		}
	}
   }); 
	$('#tab').tabs({ 
		border:false,
		fit:true,
	})
});
function createFrame(url){
	var s = '<iframe scrolling="auto" frameborder="0" src="' + url + '" style="width:100%;height:100%;"></iframe>';
	return s;
}

