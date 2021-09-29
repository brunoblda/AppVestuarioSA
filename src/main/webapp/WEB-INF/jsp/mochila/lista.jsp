<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mochilas</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">

		<form action="/mochila" method="get">
			<button type="submit" class="btn btn-link">Incluir</button>
		</form>
		
		<hr>
		
		<c:if test="${not empty msg}">
			<div class="alert alert-warning">
			  ${msg}
			</div>
		</c:if>

		<c:if test="${not empty mochilas}">
			<h4>Quantidade de mochilas existentes: ${mochilas.size()}!!!</h4>
			
			<hr>
	
			<table class="table table-striped">
		    <thead>
		      <tr>
		      	<th>Id</th>
		        <th>Descrição</th>
		        <th>Valor</th>
		        <th>material</th>
		        <th>cor</th>
		        <th>Quantidade de particoes</th>
		        <th>tipo de atividade</th>
		        <th></th>
		      </tr>
		    </thead>
		    <tbody>		    
		    	<c:forEach var="m" items="${mochilas}">
			      <tr>
			        <td>${m.id}</td>
			        <td>${m.descricao}</td>
			        <td>${m.valor}</td>
			        <td>${m.materialMochila}</td>
			        <td>${m.cor}</td>
			        <td>${m.quantidadeDeParticoes}</td>
			        <td>${m.tipoDeAtividade}</td>
			        <td><a href="/mochila/${m.id}/excluir">Excluir</a></td>
			      </tr>
		    	</c:forEach>
		    </tbody>
		  	</table>
	  	</c:if>
	  	
	  	<c:if test="${empty mochilas}">
			<h4>Não existem mochilas cadastradas!!!</h4>	  	
	  	</c:if>
	</div>
</body>
</html>