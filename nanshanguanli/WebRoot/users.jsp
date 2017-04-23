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
		<script type="text/javascript" src="myjs/users.js"></script>
	</head>
	<body>
		<table id="datagrid">
		</table>
		<div id="toolbar" style="padding: 5px">
			<a href="#" class="toolbar-btn" iconCls="icon-edit" onclick="updateUser()">修改用户权限</a>
			<a href="#" class="toolbar-btn" iconCls="icon-remove" onclick="deleteUser()">删除用户</a>
			<input id="user-search" ></input> 
		</div>
		<form id="updateform" name="updateform" style="text-align: center;">
			<p class="intext">
				账户名称：
				<input width="70px" id="username" disabled="disabled" />
			</p>
			<p class="intext">
				注册时间：
				<input  width="70px" id="registerDate" disabled="disabled">
			</p>
			<p class="intext">
				权　　限：
				<input  width="70px" id="auth">
			</p>
		</form>
	</body>
</html>
