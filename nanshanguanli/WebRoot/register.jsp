<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
   <div id="reg-div" class="main-div" style="display:none">
		<div class="title"> 用户注册</div>
		 <div class="typein">
		       <div class="input-line">
				用户名:<input type="text"  maxlength="12" class="ainput" placeholder="最多10位中英文组成">
				</div> 
				<div class="input-line">
				密　码:<input type="password" maxlength="12" placeholder="8-12位数字/字母组成" class="ainput">
				</div>
				<div class="input-line">
				重　复:<input type="password" maxlength="12" class="ainput" placeholder="重复密码">
				</div>
				<div class="input-line">
				注册码:<input type="text" maxlength="12" class="ainput" placeholder="由开发商提供的注册码">
				</div>
		  </div>	
		    <button class="button"  onclick="reg()"><b>注册</b></button>
		    <a onclick="back()">返回</a>
	</div>
  </body>
</html>
