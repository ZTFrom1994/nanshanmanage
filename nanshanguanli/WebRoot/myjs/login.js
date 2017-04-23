$(function(){
	$("#fanhui").click(function(){
	$("#reg-div").css("display","none");
	$("#changepsd-div").css("display","none");
    $("#login-div").css("display","block");
   });
});
function register(){
	$("#login-div").css("display","none");
	$("#changepsd-div2").css("display","none");
	$("#reg-div").css("display","block");
	};
function change(){
	 $("#changepsd-div").css("display","block");
	 $("#login-div").css("display","none");
	};
function back(){
		$("#login-div").css("display","block");
		$("#reg-div").css("display","none");
		$("#changepsd-div").css("display","none");
};

function login(){
		if($("#username").val()==""||$("#password").val()==""){
			 $("#p-tip").text("用户名或密码不能为空!");   
	    }else{
		   $.ajax({
			   url:"userAction!userLoginCheck",
			   data:{ 
				   username:$("#username").val(),
				   password:encryptPwd($("#username").val(),$("#password").val())
			   },
		       success:function(data){
			   if(data==1){
				   window.location="manage.jsp";
			   }
			   else{
				   $("#p-tip").text("用户名或密码错误!");
			   }
		      }
		   });
		}
}
function reg(){
	if($("#reg-div input:eq(0)").val()!=""&&$("#reg-div input:eq(1)").val()!=""&&$("#reg-div input:eq(2)").val()!=""&&$("#reg-div input:eq(3)").val()!=""&&$("#reg-div input:eq(4)").val()!=""){
         if($("#reg-div input:eq(1)").val()!=$("#reg-div input:eq(2)").val()){
        	 window.alert("两次输入的密码不一致");
         }
         else{
     		 var ppattern =/^[a-zA-Z\d]\w{4,10}[a-zA-Z\d]$/; 
        	 if(!ppattern.test($("#reg-div input:eq(1)").val()))
        	 {   
        		 window.alert("用户名或密码格式不正确");
        	 }else{
        		 $.ajax({
        			   url:"userAction!userRegister",
        			   data:{
        				   username:$("#reg-div input:eq(0)").val(),
        				   password:encryptPwd($("#reg-div input:eq(0)").val(),$("#reg-div input:eq(1)").val()),
        				   invno:$("#reg-div input:eq(3)").val()
        			   },
        		       success:function(data){
        			   if(data == 1){
        				  window.alert("注册成功！");
        				$("#reg-div input:eq(0)").val("");
        				$("#reg-div input:eq(1)").val("");
        				$("#reg-div input:eq(2)").val("");
        				$("#reg-div input:eq(3)").val("");
					     back();
        			   }
        			   else if(data == 0){
        				 window.alert("注册失败!用户名已存在!");
        			   }else{
        				   alert("邀请码不正确!");
        			   }
        		      }
        		   });
        	 }
        	 
         }
	}
	else{
		alert("信息不能为空！");
	}
}


function changepsd(){
	if($("#changepsd-div input:eq(0)").val()!=""&&$("#changepsd-div input:eq(1)").val()!=""&&$("#changepsd-div input:eq(2)").val()!=""&&$("#changepsd-div input:eq(3)").val()!=""){
		if($("#changepsd-div input:eq(2)").val()!=$("#changepsd-div input:eq(3)").val())
		{
			alert("两次输入的密码不一致");
		}else{
			 var ppattern =/^[a-zA-Z\d]\w{4,10}[a-zA-Z\d]$/;  
			if(!ppattern.test($("#changepsd-div input:eq(2)").val()))
			{  
				alert("新密码格式不正确！"); 
			}else{
				 $.ajax({
		  			   url:"userAction!changePassword",
		  			   data:{
		  				   username:$("#changepsd-div input:eq(0)").val(),
		  				   password:$("#changepsd-div input:eq(1)").val(),
		  				   changepsd:$("#changepsd-div input:eq(3)").val(),
		  			   },
		  		       success:function(data){
		  			   if(data==1){
		  				  window.alert("修改成功！");
		  				$("#changepsd-div input:eq(0)").val("");
		  				$("#changepsd-div input:eq(1)").val("");
		  				$("#changepsd-div input:eq(2)").val("")
		  				$("#changepsd-div input:eq(3)").val("");
		  				back();
		  			   }
		  			   else{
		  				 window.alert("修改失败！");
		  			   }
		  		      }
		  		   });
			}
			
		}
	}
	else{
		alert("信息不能为空");
	}
}

function encryptPwd(username,password){
	username.toLowerCase();
	return sha256_digest(
		    username + sha256_digest (
		    		sha256_digest(sha256_digest(sha256_digest(password))) + sha256_digest(username)
		    	    )
		    	  );
}













