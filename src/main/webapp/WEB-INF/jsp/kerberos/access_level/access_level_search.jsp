<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	 	<div class="panel panel-default">
	  			<div class="panel-heading">
	  				<h3 class="panel-title">Search</h3>
				</div>
	  			<div class="panel-body">
	  				<form:form method="get" action="access_level" class="form-inline" role="form">
	  					<div class="form-group">
						  	<label class="sr-only" for="exampleInputEmail2">Name: </label>
    						<input type="text" class="form-control" id="name" name="name" placeholder="Enter name" value="${name}"/>
						 </div> 
	  					<button type="submit" class="btn btn-primary">Search</button>
	  				</form:form>
	  			</div>
	  	</div>
</div>