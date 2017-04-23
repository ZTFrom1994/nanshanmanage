<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="icon" href="img/nanshan.ico" type="image/x-icon" />
	<link rel="shortcut icon" href="img/nanshan.ico">
	<link rel="Bookmark" href="img/nanshan.ico">
  </head>
  
  <body >
   <div id="login-div" class="main-div">
		<!--用户登录文本-->
		<div class="title" >用户登录</div>
		<p id="p-tip" >　</p>
		<div class="typein"  >
			<div class="input-line">
				用户名:<input type="text" class="ainput"  maxlength="12" id="username" />
			</div>
			<div class="input-line">
				密　码:<input type="password" class="ainput"  maxlength="12"id="password"> 
			</div>		
		</div>
			<button  class="button" onclick="login()"><b>登录</b></button>
			          <a  onclick="register()">注册</a><a onclick="change()">修改密码</a>
	</div> 
		
  </body>
</html>
