<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <c:if  test="${!empty systemList}">
	<div class="row">
	 	<div class="panel panel-default">
	  			<div class="panel-heading">
	  				<h3 class="panel-title">Systems</h3>
				</div>
	  			<div class="panel-body">
				    <table class="table table-bordered table-striped">
				        <thead>
					        <tr>
					            <th>Id</th>
					            <th>Name</th>
					            <th>Actions</th>
					        </tr>
				        </thead>
				        <tbody>
					        <c:forEach items="${systemList}" var="system">
					            <tr>
					                <td>${system.systemId}</td>
					                <td>${system.systemName}</td>
					                <td>
					                	<ol class="breadcrumb">
					                		<li><a href="system/${system.systemId}">Edit</a></li>
										  <li><a href="system/${system.systemId}/role">Roles</a></li>
										  <li><a href="system/${system.systemId}/access_level">Access Level</a></li>
										</ol>
					                </td>
					            </tr>
					        </c:forEach>
				        </tbody>
				    </table>
				</div>
		</div>
	</div>
</c:if>