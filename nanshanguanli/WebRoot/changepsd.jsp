<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'changepsd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <div id="changepsd-div"  class="main-div" style="display:none;">
			  <div class="title " >修改密码 </div>
			     <div class="typein" id="typein" >
			     		<div class="input-line" >
							用户名<input type="text" class="ainput" placeholder="请输入用户名" maxlength="12"/>
						</div> 
						<div class="input-line" >
							旧密码<input type="password" class="ainput" placeholder="请输入旧密码"  maxlength="12"/>
						</div>
					    <div class="input-line">
						  	新密码<input type="password" class="ainput" placeholder="8-12位数字/字母/下划线组成" maxlength="12" />
					    </div>
					    <div class="input-line">
						  重　复<input type="password" class="ainput" placeholder="重复密码"  maxlength="12"/>
					    </div>
				</div> 
				<button class="button"  onclick="changepsd()"><b>修改</b></button>
				<a onclick="back()">返回</a> 
  </div>
  </body>
</html>
