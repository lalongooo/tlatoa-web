<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <c:if  test="${!empty userList}">
	<div class="row">
	 	<div class="panel panel-default">
	  			<div class="panel-heading">
	  				<h3 class="panel-title">Users</h3>
				</div>
	  			<div class="panel-body">
				    <table class="table table-bordered table-striped">
				        <thead>
					        <tr>
					            <th>Id</th>
					            <th>Name</th>
					            <th>Gender</th>
					            <th>email</th>
					            <th>Location</th>
					            <th>&nbsp;</th>
					        </tr>
				        </thead>
				        <tbody>
					        <c:forEach items="${userList}" var="user">
					            <tr>
					                <td>${user.id}</td>
					                <td>${user.name}</td>
					                <td>${user.gender}</td>
					                <td>${user.email}</td>
					                <td>${user.locationName}</td>
					                <td><form action="user/${user.id}/delete" method="post"><input type="submit" class="btn btn-danger btn-mini" value="Delete"/></form></td>
					            </tr>
					        </c:forEach>
				        </tbody>
				    </table>
				</div>
		</div>
	</div>
</c:if>