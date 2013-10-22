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
					            <th>&nbsp;</th>
					            <th>&nbsp;</th>
					            <th>&nbsp;</th>
					        </tr>
				        </thead>
				        <tbody>
					        <c:forEach items="${systemList}" var="system">
					            <tr>
					                <td>${system.systemId}</td>
					                <td>${system.systemName}</td>
					                <td><form action="system/${system.systemId}/delete" method="post"><input type="submit" class="btn btn-danger btn-mini" value="Delete"/></form></td>
					                <td><form action="system/${system.systemId}/role" method="get"><input type="submit" class="btn btn-danger btn-mini" value="Roles"/></form></td>
					                <td><form action="system/${system.systemId}/access_level" method="get"><input type="submit" class="btn btn-danger btn-mini" value="Access Level"/></form></td>
					            </tr>
					        </c:forEach>
				        </tbody>
				    </table>
				</div>
		</div>
	</div>
</c:if>