<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	  <link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.6/themes/default/easyui.css">
	  <link rel="stylesheet" type="text/css" href="jquery-easyui-1.3.6/themes/icon.css">
	  <link rel="stylesheet" type="text/css" href="css/manage.css">
	  <script type="text/javascript" src="jquery-easyui-1.3.6/jquery.min.js"></script>
	  <script type="text/javascript" src="jquery-easyui-1.3.6/jquery.easyui.min.js"></script>
	  <script type="text/javascript" src="jquery-easyui-1.3.6/locale/easyui-lang-zh_CN.js"></script>
	  <script type="text/javascript" src="myjs/navigation.js" ></script> 
	  <script type="text/javascript" src="myjs/manage.js" ></script>  
		</head> 
	<body class="easyui-layout" > 
    <div data-options="region:'north',split:false" id="north" style="background-image:url('img/top.jpg');">
        <img src="img/title2.png" style="margin-left:80px"/>
        <div id="show-info">
        		<label>欢迎您：${currentUser.username}</label>
        		<a  id="myauth" onclick="myAuth()">查看权限</a>
        		<a  id="logout" onclick="logout()">退出</a>
        </div>
    </div>   
    <div data-options="region:'west',title:'导航栏',split:false" id="west" >
       <ul id="tt"  ></ul> 
    </div>   
    <div data-options="region:'center',"  id="center">
       <div id="tab">
           <div title="信息统计" style=" disply: block">
           		<jsp:include page="statistics.jsp"></jsp:include>
           </div>       
       </div>
    </div>
    <div data-options="region:'south',split:false" id="south" style="background-image:url('img/top.jpg');">
                                                  版权:西安建筑科技大学IT服务队
    </div>  
    <div id="win">
     	您已退出，请重新登录！
    </div>
	<div id="dd" style="padding-left:30px;">
	<p><lable>当前用户：</lable>${currentUser.username}</p>
	<p><lable>添加权限：</lable>${currentUser.auth.addAuth}<lable></lable></p>
	<p><lable>删除权限：</lable>${currentUser.auth.deleteAuth}<lable></lable></p>
	<p><lable>修改权限：</lable>${currentUser.auth.updateAuth}<lable></lable></p>
	<p><lable>查看权限：</lable>${currentUser.auth.searchAuth}<lable></lable></p>
    </div>      
    
   </body>  
	</html>