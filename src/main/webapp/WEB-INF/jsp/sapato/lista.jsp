<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sapatos</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">

		<form action="/sapato" method="get">
			<button type="submit" class="btn btn-link">Incluir</button>
		</form>
		
		<hr>
		
		<c:if test="${not empty msg}">
			<div class="alert alert-warning">
			  ${msg}
			</div>
		</c:if>

		<c:if test="${not empty sapatos}">
			<h4>Quantidade de sapatos existentes: ${sapatos.size()}!!!</h4>
			
			<hr>
	
			<table class="table table-striped">
		    <thead>
		      <tr>
		      	<th>Id</th>
		        <th>Descrição</th>
		        <th>Valor</th>
		        <th>material</th>
		        <th>cor</th>
		        <th>tamanho</th>
		        <th>ecologico</th>
		        <th></th>
		      </tr>
		    </thead>
		    <tbody>		    
		    	<c:forEach var="s" items="${sapatos}">
			      <tr>
			        <td>${s.id}</td>
			        <td>${s.descricao}</td>
			        <td>${s.valor}</td>
			        <td>${s.materialSapato}</td>
			        <td>${s.cor}</td>
			        <td>${s.tamanho}</td>
			        <td>${s.ecologico}</td>
			        <td><a href="/sapato/${s.id}/excluir">Excluir</a></td>
			      </tr>
		    	</c:forEach>
		    </tbody>
		  	</table>
	  	</c:if>
	  	
	  	<c:if test="${empty sapatos}">
			<h4>Não existem sapatos cadastrados!!!</h4>	  	
	  	</c:if>
	</div>
</body>
</html>