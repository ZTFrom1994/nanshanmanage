<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html> 
  <head>
    <base href="<%=basePath%>">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css"
			href="jquery-easyui-1.3.6/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css"
			href="jquery-easyui-1.3.6/themes/icon.css">
		<script type="text/javascript" src="jquery-easyui-1.3.6/jquery.min.js"></script>
		<script type="text/javascript"
			src="jquery-easyui-1.3.6/jquery.easyui.min.js"></script>
		<script type="text/javascript"
			src="jquery-easyui-1.3.6/locale/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript" src="myjs/equipment_application.js"></script>
		<script>  
					 window.onload = function(){
            		    document.getElementById('a-usingfor').addEventListener('keydown',function(e){
				                if(e.keyCode!=13){
				                return;
				                }
				                e.preventDefault();
            			});
        				};
		</script>
  </head> 
  
   <body>
  		 <table id="datagrid"> 
		</table> 
		<div id="toolbar" style="padding: 5px">
			<a href="#" class="toolbar-btn" iconCls="icon-add" onclick="addregistration()">添加记录</a>
			<a href="#" class="toolbar-btn" iconCls="icon-remove" onclick="deleteregistration()">删除记录</a>
			<input id="search" ></input>   
		</div>   
		<form id="addform" name="addform" style="text-align: center;">
			<p class="intext">
				借用物品： 
				<input name="type" width="70px" id="a-type" />
			</p>
			<p class="intext">
				数　　量： 
				<input name="number" width="60px" id="a-number" />
			</p>
			<p class="intext">
				开始时间：
				<input name="starttime" maxlength="9" width="70px"
					id="a-starttime">
			</p>
			<p class="intext">
				结束时间：
				<input name="endtime" maxlength="9" width="70px"
					id="a-endtime">
			</p>
			<p class="intext">
				借用单位：
				<input  width="70px" name="unit" id="a-unit"> 
			</p>
			<p class="intext">
				登记姓名：
				<input name="username" width="70px" id="a-username">
			</p>
			<p class="intext">
				登记电话：
				<input name="phonenumber" width="70px" id="a-phonenumber">
			</p>
			<p class="intext">
				用　　途： 
				<textarea rows="3"  cols="20" style="resize: none;"
					name="usingfor" id="a-usingfor"></textarea>
			</p>
		</form>
  </body>
</html>
