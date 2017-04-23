<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>社团活动</title> 
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
	<script type="text/javascript" src="myjs/club_activity.js"></script>
	<script>  
					 window.onload = function(){
            		    document.getElementById('a-introduction').addEventListener('keydown',function(e){
				                if(e.keyCode!=13){
				                return;
				                }
				                e.preventDefault();
            			});
            			document.getElementById('u-introduction').addEventListener('keydown',function(e){
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
			<a href="#" class="toolbar-btn" iconCls="icon-add" onclick="addActivity()">添加活动</a>
			<a href="#" class="toolbar-btn" iconCls="icon-edit" onclick="updateActivity()">更新活动</a>
			<a href="#" class="toolbar-btn" iconCls="icon-remove" onclick="deleteActivity()">删除活动</a>
			<input id="activity-search" ></input> 
		</div> 
		<form id="addform" name="addform" style="text-align: center;">
			<p class="intext">
				活动名称：
				<input name="activity-name" width="70px" id="a-activity-name" />
			</p>
			<p class="intext">
				开始时间：
				<input name="start-time" width="70px" id="a-start-time">
			</p>
			<p class="intext">
				结束时间：
				<input name="end-time" width="70px" id="a-end-time">
			</p>
			<p class="intext">
				举办社团：
				<input name="from-club" maxlength="9" width="70px"
					id="a-from-club">
			</p>
			<p class="intext">
				联系方式：
				<input name="contact" id="a-contact">
			</p>
			<p >
				负责人员：
				<input name="leadername" width="70px" id="a-leadername" />
			</p>
			<p class="intext">
				借用器材：
				<input name="borrowed" width="70px" id="a-borrowed">
			</p>
			<p class="intext">
				活动场地：
				<input name="hold-place" width="70px" id="a-hold-place">
			</p>
			<p class="intext">
				活动形式：
				<input name="form" maxlength="9" width="70px"
					id="a-form">
			</p>
			<p class="intext">
				活动简介： 
				<textarea rows="3"  cols="22" style="resize: none;"
					name="introducion" id="a-introduction"></textarea>
			</p>
		</form>
		<form id="updateform" style="text-align: center;">
			<p class="intext">
				活动名称：
				<input name="activity-name" width="70px" id="u-activity-name" />
			</p>
			<p class="intext">
				开始时间：
				<input name="start-time" width="70px" id="u-start-time">
			</p>
			<p class="intext">
				结束时间：
				<input name="end-time" width="70px" id="u-end-time">
			</p>
			<p class="intext">
				举办社团：
				<input name="from-club" maxlength="9" width="70px"
					id="u-from-club">
			</p>
			<p class="intext">
				联系方式：
				<input name="contact" id="u-contact">
			</p>
			<p >
				负责人员：
				<input name="leadername" width="70px" id="u-leadername" />
			</p>
			<p class="intext">
				借用器材：
				<input name="borrowed" width="70px" id="u-borrowed">
			</p>
			<p class="intext">
				活动场地：
				<input name="hold-place" width="70px" id="u-hold-place">
			</p>
			<p class="intext">
				活动形式：
				<input name="form" maxlength="9" width="70px"
					id="u-form">
			</p>
			<p class="intext">
				活动简介：
				<textarea rows="3"  cols="22" style="resize: none;"
					name="introducion" id="u-introduction"></textarea>
			</p>
		</form>
  </body>
</html>
