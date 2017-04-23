<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
  <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.6/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.6/themes/icon.css">
	<script type="text/javascript" src="jquery-easyui-1.3.6/jquery.min.js"></script>
	<script type="text/javascript" src="jquery-easyui-1.3.6/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="jquery-easyui-1.3.6/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="myjs/equipment.js"></script>
  </head>
     
  <body>
   <table id="datagrid"> 
		</table> 
		<div id="toolbar" style="padding: 5px">
			<a href="#" class="toolbar-btn" iconCls="icon-add" onclick="addEquipment()">添加器材</a>
			<a href="#" class="toolbar-btn" iconCls="icon-remove" onclick="deleteEquipment()">删除器材</a>
			<input id="equipment-search" disabled="disabled"></input>  
		</div>   
		<form id="addform" name="addform" style="text-align: center;">
			<p class="intext">
				类　　型： 
				<input name="type" width="70px" id="a-type" />
			</p> 
			<p class="intext">
				数　　量： 
				<input name="number"  width="70px" id="a-number">
			</p>
		</form>
  </body>
</html>
