<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<div class="form-group">
		  <label for="inputEmail1" class="col-lg-2 control-label">URL</label>
		  <div class="col-lg-10">
		    <form:input type="text" class="form-control" placeholder="URL" path="resourceURL"/>
		  </div>
		 </div>   
		 <form:input type="hidden" path="sequenceOrder" value="0"/>