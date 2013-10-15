<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <c:if  test="${!empty roleList}">
 		<div class="form-group">
		  <label for="inputEmail1" class="col-lg-2 control-label">Name: </label>
		  <div class="col-lg-10">
		  	<input id="userName" type="text" class="form-control" disabled/>
		  </div>
		</div>
		<div class="form-group">
		  <label for="inputEmail1" class="col-lg-2 control-label">Roles: </label>
		  <div class="col-lg-10">
		    <select id="roleId" name="roleId" class="form-control" multiple>

					<c:forEach items="${roleList}" var="role">
						<option id="${role.id}" name="roleId" value="${role.id}">${role.roleName}</option>
					</c:forEach>

			</select>
		  </div>
		 </div>   
</c:if>