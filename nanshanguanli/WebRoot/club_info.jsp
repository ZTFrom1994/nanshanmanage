<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setCharacterEncoding("utf-8");
response.setContentType("text/html;charset=utf-8");
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
		<script type="text/javascript" src="myjs/club_info.js"></script>
		<script>  
					 window.onload = function(){
            		    document.getElementById('i_add_club_brief').addEventListener('keydown',function(e){
				                if(e.keyCode!=13){
				                return;
				                }
				                e.preventDefault();
            			});
            			document.getElementById('i_update_club_brief').addEventListener('keydown',function(e){
				                if(e.keyCode!=13){
				                return;
				                }
				                e.preventDefault();
            			});
        				};
		</script>
	</head>
	<body>
		<table id="i_datagrid">
		</table>
		<div id="i_club_toolbar" style="padding: 5px">
			<a href="#" class="toolbarBtn" iconCls="icon-add" onclick="addClub()">添加社团</a>
			<a href="#" class="toolbarBtn" iconCls="icon-edit" onclick="updateClub()">更新社团</a>
			<a href="#" class="toolbarBtn" iconCls="icon-remove" onclick="deleteClub()">删除社团</a>
			<input id="i_club_search" ></input>  
		</div>
		<form id="i_add_form" name="addForm" style="text-align: center;">
			<p class="intext">
				社团名称：
				<input name="clubName" width="70px" id="i_add_club_name" />
			</p>
			<p class="intext">
				社团类型：
				<input name="clubType" width="70px" id="i_add_club_type">
			</p>
			<p class="intext">
				社长姓名：
				<input name="leaderName" width="70px" id="i_add_leader_name">
			</p>
			<p class="intext">
				社长学号：
				<input name="leaderStuId" maxlength="9" width="70px"
					id="i_add_leader_stu_id">
			</p>
			<p class="intext">
				联系电话：
				<input name="phoneNumber" maxlength="13" width="70px"
					id="i_add_phone_number">
			</p>
			<p class="intext">
				指导老师：
				<input name="teacherName" maxlength="9" width="70px"
					id="i_add_teacher_name">
			</p>
			<p class="intext">
				社团简介：
				<textarea rows="3"  cols="20" style="resize: none;"
					name="clubBrief" id="i_add_club_brief"></textarea>
			</p>

		</form>
		<form id="i_update_form" style="text-align: center;">
			<p class="intext">
				社团名称：
				<input name="clubName" width="70px" id="i_update_club_name" />
			</p>
			<p class="intext">
				社团类型：
				<input name="clubType" width="70px" id="i_update_club_type">
			</p>
			<p class="intext">
				社长姓名：
				<input name="leaderName" width="70px" id="i_update_leader_name">
			</p>
			<p class="intext">
				社长学号：
				<input name="leaderStuId" maxlength="9" width="70px"
					id="i_update_leader_stu_id">
			</p>
			<p class="intext">
				联系电话：
				<input name="phoneNumber" maxlength="13" width="70px"
					id="i_update_phone_number">
			</p>
			<p class="intext">
				指导老师：
				<input name="teacherName" maxlength="9" width="70px"
					id="i_update_teacher_name">
			</p>
			<p >
				<label>社团简介：</label>
				<textarea rows="3" cols="20" style="resize: none;" name="clubBrief"
					id="i_update_club_brief"></textarea>
			</p>
		</form>
	</body>
</html>
