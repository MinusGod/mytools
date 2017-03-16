<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="../css/login.css" />
		<script type="text/javascript" src="../js/jquery-2.1.0.min.js"></script>
	</head>
	<body class="bodyLogin">
		<div class="loginbg"> 
			<form class="formbg" action="loginVertify" method="get" >
				<div>
					<label class="label1">用户名 :</label><input type="text" class="username" name="username" /><span class="label2">${userInfo}</span>
				</div>
				<div>
					<label class="label1">密&nbsp;&nbsp;&nbsp; 码 :</label><input type="password" class="pwd" name="password"/><span class="label2">${pwdInfo}</span>
					
				</div>	
				 
				<div>
					<label class="label1">&nbsp;</label><input type="submit" value="登 录" class="btn_sub"/>
				</div>
			</form>
		</div>
	</body>
</html>
