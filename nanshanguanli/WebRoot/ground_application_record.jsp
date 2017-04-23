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
		<script type="text/javascript" src="myjs/ground_applicatiion_record.js"></script>
  </head> 
  
   <body>
  		 <table id="datagrid"> 
		</table> 
		<div id="toolbar" style="padding: 5px">
			<input id="search" ></input>   
		</div>   
  </body>
</html>
