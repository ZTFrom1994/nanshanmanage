<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>西建大·南山社联管理系统</title>
		<!--引入必要的文件-->
	<link rel="stylesheet"  href="css/welcome.css" />
	<link rel="icon" href="img/nanshan.ico" type="image/x-icon" />
	<link rel="shortcut icon" href="img/nanshan.ico">
	<link rel="Bookmark" href="img/nanshan.ico">
	<script type="text/javascript" src="jquery-easyui-1.3.6/jquery.min.js"></script>
	<script type="text/javascript" src="myjs/login.js" ></script> 
	<script type="text/javascript" src="myjs/sha256.js"></script>
	</head>  
	<body >
		<div class="tips">
			<img src="img/title.png" alt="南山社联管理系统" height="25%" width="25%"/>
		</div>
		 <div class="center-frame"> 
		     <div class="img-frame"><img src="img/logo.jpg" class="logo-img"/></div>
		     <div class="right-frame">
		     <jsp:include page="login.jsp"></jsp:include>
		     <jsp:include page="register.jsp"></jsp:include> 
		     <jsp:include page="changepsd.jsp"></jsp:include> 
             </div>
			
		</div>
		
		<div  class="tips" style="color:white;margin-top:30px;">
				<p>技术支持：西建大IT服务队</p>
				<p>联系邮箱：605288028@qq.com</p>  
		</div>
	</body>
</html>
