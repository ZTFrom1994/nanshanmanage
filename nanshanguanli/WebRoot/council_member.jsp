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
    <link rel="stylesheet" type="text/css"href="jquery-easyui-1.3.6/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css"	href="jquery-easyui-1.3.6/themes/icon.css">
	<script type="text/javascript" src="jquery-easyui-1.3.6/jquery.min.js"></script>
	<script type="text/javascript" src="jquery-easyui-1.3.6/jquery.easyui.min.js"></script>
	<script type="text/javascript"src="jquery-easyui-1.3.6/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="myjs/council_member.js"></script>
  </head>
  <body>
   <table id="datagrid"> 
		</table> 
		<div id="toolbar" style="padding: 5px">
			<a href="#" class="toolbar-btn" iconCls="icon-add" onclick="addMember()">添加人员</a>
			<a href="#" class="toolbar-btn" iconCls="icon-edit" onclick="updateMember()">更新人员</a>
			<a href="#" class="toolbar-btn" iconCls="icon-remove" onclick="deleteMember()">删除人员</a>
			<input id="member-search" ></input>  
		</div>   
		<form id="addform" name="addform" style="text-align: center;">
			<p class="intext">
				姓　　名： 
				<input name="membername" width="70px" id="a-membername" />
			</p>
			<p class="intext">
				学　　号：
				<input name="memberstuid" maxlength="9" width="70px"
					id="a-memberstuid" >
			</p>
			<p class="intext">
				性　　别：
				<input name="sex" maxlength="9" width="70px"
					id="a-sex">
			</p>
			<p class="intext">
				学　　院：
				<input  width="70px" name="fromacademy" id="a-fromacademy">
			</p>
			<p class="intext">
				所属部门：
				<input name="fromdepartment" width="70px" id="a-fromdepartment">
			</p>
			<p class="intext">
				职　　位：
				<input name="position" width="70px" id="a-position">
			</p>
			<p class="intext">
				联系电话：
				<input name="phonenumber" width="70px" id="a-phonenumber">
			</p>
			
		</form>
		<form id="updateform" style="text-align: center;">
			<p class="intext">
				姓　　名：
				<input name="membername" width="70px" id="u-membername" />
			</p>
			<p class="intext">
				学　　号：
				<input name="memberstuid" maxlength="9" width="70px"
					id="u-memberstuid" disabled="disabled">
			</p>
			<p class="intext">
				性　　别：
				<input name="sex" maxlength="9" width="70px"
					id="u-sex">
			</p>
			<p class="intext">
				学　　院：
				<input  width="70px" name="fromacademy" id="u-fromacademy">
			</p>
			
			<p class="intext"> 
				所属部门：
				<input name="fromdepartment" width="70px" id="u-fromdepartment">
			</p>
			<p class="intext">
				职　　位：
				<input name="position" width="70px" id="u-position">
			</p>
			<p class="intext">
				联系电话：
				<input name="phonenumber" width="70px" id="u-phonenumber">
			</p>
		</form>
  </body>
</html>
