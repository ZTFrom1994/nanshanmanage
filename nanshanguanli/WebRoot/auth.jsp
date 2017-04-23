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
		<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.6/themes/icon.css">
		<script type="text/javascript" src="jquery-easyui-1.3.6/jquery.min.js"></script>
		<script type="text/javascript" src="jquery-easyui-1.3.6/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="jquery-easyui-1.3.6/locale/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript" src="myjs/auth.js"></script>
	</head>
	<body>
		<table id="datagrid">
		</table>
		<div id="toolbar" style="padding: 5px">
			<a href="#" class="toolbar-btn" iconCls="icon-add" onclick="addAuth()">添加权限</a>
			<a href="#" class="toolbar-btn" iconCls="icon-edit" onclick="updateAuth()">修改权限</a>
			<a href="#" class="toolbar-btn" iconCls="icon-remove" onclick="deleteAuth()">删除权限</a>
			<input id="search" ></input> 
		</div>
		<form id="addform" name="addform" style="text-align: center;">
			<p class="intext">
				权限名称：
				<input width="70px" name="name"  id="a-name" />
			</p>
			<p class="intext">
				添加权限：
				<input  width="70px" name="add" id="a-add">
			</p>
			<p class="intext">
				修改权限：
				<input  width="70px" name="update" id="a-update">
			</p>
			<p class="intext">
				删除权限：
				<input  width="70px" name="delete" id="a-delete">
			</p>
			<p class="intext">
				搜索权限：
				<input  width="70px" name="search" id="a-search">
			</p>
		</form>
		
		<form id="updateform" style="text-align: center;">
			<p class="intext">
				权限名称：
				<input width="70px" name="name"  id="u-name" />
			</p>
			<p class="intext">
				添加权限：
				<input  width="70px" name="add" id="u-add">
			</p>
			<p class="intext">
				修改权限：
				<input  width="70px" name="update" id="u-update">
			</p>
			<p class="intext">
				删除权限：
				<input  width="70px" name="delete" id="u-delete">
			</p>
			<p class="intext">
				搜索权限：
				<input  width="70px" name="search" id="u-search">
			</p>
		</form>
	</body>
</html>
