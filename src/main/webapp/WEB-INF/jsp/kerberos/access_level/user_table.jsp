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
					            <th>Roles</th>
					            <th>&nbsp;</th>
					        </tr>
				        </thead>
				        <tbody>
					        <c:forEach items="${userList}" var="user">
					            <tr id="${user.id}" class="accessLevel">
					                <td>${user.id}</td>
					                <td>${user.name}</td>
					                <td>
					                	
						                	 <c:forEach items="${user.roles}" var="role">
						                	   ${role.roleName}, 
						                	 </c:forEach>
					                	
					                </td>
					                <td>
				                		<input type="hidden" id="userId" name="userName" value="${user.id}"/>
				                		<input type="hidden" id="userName" name="userName" value="${user.name}"/>
				                		<c:if  test="${!empty user.roles}">
					                		<c:forEach items="${user.roles}" var="role">
					                			<input type="hidden" class="role" name="roleId" value="${role.id}"/>
					                	 	</c:forEach>
					                	 </c:if>
					                	 <input type="hidden" id="target" name="target" value="${baseURL}/system/${systemId}/access_level/${user.id}"/>
				                		 <input type="button" class="btn btn-warning editButton" value="Edit"/>
					                </td>
					            </tr>
					        </c:forEach>
				        </tbody>
				    </table>
				</div>
		</div>
	</div>
</c:if>