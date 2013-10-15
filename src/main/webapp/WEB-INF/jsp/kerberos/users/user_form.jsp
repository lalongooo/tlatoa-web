<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<div class="form-group">
		  <label for="inputEmail1" class="col-lg-2 control-label">Name</label>
		  <div class="col-lg-10">
		    <form:input type="text" class="form-control" placeholder="last name, first name" path="name"/>
		  </div>
		 </div>   
		 <div class="form-group">
			  <label for="inputEmail1" class="col-lg-2 control-label">Gender</label>
			  <div class="col-lg-10">
			    <form:input type="text" class="form-control" placeholder="gender" path="gender"/>
			  </div>
		 </div>
		 <div class="form-group">
			  <label for="inputEmail1" class="col-lg-2 control-label">email</label>
			  <div class="col-lg-10">
			    <form:input type="email" class="form-control" placeholder="Email" path="email"/>
			  </div>
		 </div>     
		 <div class="form-group">
			  <label for="inputEmail1" class="col-lg-2 control-label">Location</label>
			  <div class="col-lg-10">
			    <form:input type="text" class="form-control" placeholder="Location" path="locationName"/>
			  </div>
		 </div>
