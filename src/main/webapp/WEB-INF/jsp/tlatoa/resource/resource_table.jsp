<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <c:if  test="${!empty resourceList}">
	<div class="row">
	 	<div class="panel panel-default">
	  			<div class="panel-heading">
	  				<h3 class="panel-title">Resource</h3>
				</div>
	  			<div class="panel-body">
				    <table class="table table-bordered table-striped">
				        <thead>
					        <tr>
					            <th>Id</th>
					            <th>URL</th>
					            <th>Order</th>
					            <th>Actions</th>
					        </tr>
				        </thead>
				        <tbody>
					        <c:forEach items="${resourceList}" var="resource">
					            <tr>
					                <td>${resource.resourceId}</td>
					                <td>${resource.resourceURL}</td>
					                <td>${resource.sequenceOrder}</td>
					                <td>
					                	<ol class="breadcrumb">
										  <li><a href="${baseURL}/manager/sentence/${sentenceId}/resource/${resource.resourceId}/delete">Remove</a></li>
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