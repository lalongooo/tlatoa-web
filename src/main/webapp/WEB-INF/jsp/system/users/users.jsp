<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Users</title>
		
		<link href="./resources/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
	</head>
	<body>
		<div class="navbar navbar-inverse navbar-fixed-top">
	      <div class="container">
	        <div class="navbar-header">
	          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	            <span class="icon-bar"></span>
	          </button>
	          <a class="navbar-brand" href="#">Kerberos</a>
	        </div>
	        <div class="collapse navbar-collapse">
	          <ul class="nav navbar-nav">
	            <li class="active"><a href="#">Home</a></li>
	            <li><a href="#about">About</a></li>
	            <li><a href="#contact">Contact</a></li>
	          </ul>
	        </div><!--/.nav-collapse -->
	      </div>
	    </div>
	    
	    <div class="container" style="padding-top: 100px;">
			<div class="row">
				<ul class="nav nav-tabs">
				  <li class="${users_nav_class}"><a href="#">Users</a></li>
				  <li class="${roles_nav_class}"><a href="./roles">Roles</a></li>
				  <li class="${access_level_nav_class}"><a href="./access_level">Access Level</a></li>
				</ul>
			</div>
	      	
			<c:choose>
				<c:when test="${users_nav_class == 'active'}">
					<%@include file="user_table.jsp" %>
				</c:when>
			</c:choose>
			
			<div class="row">
				<a data-toggle="modal" href="#userModal" class="btn btn-primary btn-lg">Add User</a>
	      	</div>
	      	
	      	<%@include file="user_modal.jsp" %>      	
	
	    </div>
	    
	    <script src="./resources/jquery/jquery.js"></script>
	    <script src="./resources/bootstrap/dist/js/bootstrap.min.js"></script>
	</body>
</html>