<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="../css/login.css" />
		<script type="text/javascript" src="../js/jquery-2.1.0.min.js"></script>
		
        <!--(指定编码方式，防止出现乱码)引入EasyUI中使用的Jquery版本-->
		<script type="text/javascript" src="../js/jquery-easyui-1.5/jquery.min.js" charset="utf-8"></script>  
       
	    <!--(指定编码方式，防止出现乱码)引入EasyUi文件-->	
	    <script type="text/javascript" src="../js/jquery-easyui-1.5/jquery.easyui.min.js" charset="utf-8"></script> 
	    
	    <link rel="stylesheet" type="text/css" href="../js/jquery-easyui-1.5/themes/default/easyui.css">   <!--引入CSS样式-->
	    <link rel="stylesheet" type="text/css" href="../js/jquery-easyui-1.5/themes/icon.css">   <!--Icon引入-->
	  
	    <script type="text/javascript" src="../js/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js"></script>  <!--汉化-->
		
		<style type="text/css">
		 
		  
		</style>
		
	</head>
	<body>
	
	 <div class="homeIndex">
	    <ul class="easyui-tree">
	        <!-- <li>
	            <span>权限管理</span>
	            <ul>
	                <li><span>二级菜单</span></li>
	                <li><span>二级菜单</span></li>
	                <li><span>二级菜单</span></li>
	            </ul>
	        </li>
	        <li>
	            <span>业绩管理</span>
	            <ul>
	                <li><span>二级菜单</span></li>
	                <li><span>二级菜单</span></li>
	                <li><span>二级菜单</span></li>
	            </ul>
	         </li>
	         
	         <li>
	            <span>业绩查询</span>
	            <ul>
	                <li><span>二级菜单</span></li>
	                <li><span>二级菜单</span></li>
	                <li><span>二级菜单</span></li>
	            </ul>
	         </li> -->
	         
	         
	         
	      <c:forEach items="${functions}" var="function" varStatus="id">     	     
     	     <li>
	            <span>${function.name}</span>
	            <ul>
	                <li><span>二级菜单</span></li>
	                <li><span>二级菜单</span></li>
	                <li><span>二级菜单</span></li>
	            </ul>
	         </li>
          </c:forEach>

	    </ul>
	     
	 </div>
		
	 
	    
	    
	    
	   
	    
	</body>
</html>
