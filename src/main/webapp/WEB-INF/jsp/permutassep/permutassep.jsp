<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Tlatoa</title>
		<c:set var="req" value="${pageContext.request}" />
		<c:set var="baseURL" value="${req.scheme}://${req.serverName}:${req.serverPort}${req.contextPath}" />
		
		<link href="${baseURL}/system/resources/bootstrap/dist/css/bootstrap.css" rel="stylesheet">
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
	          <a class="navbar-brand" href="#">Permutas SEP</a>
	        </div>
	        <div class="collapse navbar-collapse">
	          <ul class="nav navbar-nav">
	            <li class="active"><a href="#">Home</a></li>
	            <li><a href="#about">About</a></li>
	            <li><a href="#contact">Contact</a></li>
	          </ul>
	          <form name='f' action="${baseURL}/j_spring_security_logout" method='POST' class="navbar-form navbar-right">
	            <button type="submit" class="btn btn-success">Logout</button>
	          </form>
	        </div><!--/.nav-collapse -->
	      </div>
	    </div>
	    
	    <div class="container" style="padding-top: 100px;">
			<div class="row">
				<ul class="nav nav-tabs">
				  <li class="${post_nav_class}"><a href="${baseURL}/manager/post">Post</a></li>
				</ul>
			</div>
	      	
			<c:choose>
				<c:when test="${post_nav_class == 'active'}">
					<%@include file="post/post_table.jsp" %>
					<div class="row">
						<a data-toggle="modal" href="#postModal" class="btn btn-primary btn-lg">Add Post</a>
			      	</div>
			      	<%@include file="post/post_modal.jsp" %>
				</c:when>
			</c:choose>
	    </div>
	    
	    <script src="${baseURL}/system/resources/jquery/jquery.js"></script>
	    <script src="${baseURL}/system/resources/bootstrap/dist/js/bootstrap.min.js"></script>
	    <script src="${baseURL}/system/system-resources/system.js"></script>
	    <script src="${baseURL}/system/system-resources/util/dragndrop.js"></script>
	    
	    <style>
		    .over {
			  border: 2px dashed #000;
			}
			.draggable {
				display: inline-block;
			}
	    </style>
	</body>
</html>