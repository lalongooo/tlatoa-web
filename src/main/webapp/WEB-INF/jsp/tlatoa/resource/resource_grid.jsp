<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <c:if  test="${!empty resourceList}">
	<div class="row">
		<form action="${baseURL}/manager/sentence/${sentenceId}/sort_resource" method="post">
	 	<div class="panel panel-default">
	 		
	  			<div class="panel-heading">
	  				<h3 class="panel-title">Resource Sorting</h3>
				</div>
	  			<div class="panel-body">
			        <c:forEach items="${resourceList}" var="resrouce">
			        	<div class="draggable">
			        		<img src="${resrouce.resourceURL}" alt="${resrouce.resourceId}" class="img-thumbnail" style="width:100px">
			        		<input type="hidden" name="resourceId" value="${resrouce.resourceId}">
			        	</div>
			        </c:forEach>
				</div>
				<div class="panel-footer">
		        	<button type="submit" class="btn btn-primary">Save changes</button>
		        </div>
		</div>
		</form>
	</div>
</c:if>