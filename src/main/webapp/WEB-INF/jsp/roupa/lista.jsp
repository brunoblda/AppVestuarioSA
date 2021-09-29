<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Roupas</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">

		<form action="/roupa" method="get">
			<button type="submit" class="btn btn-link">Incluir</button>
		</form>
		
		<hr>
		
		<c:if test="${not empty msg}">
			<div class="alert alert-warning">
			  ${msg}
			</div>
		</c:if>

		<c:if test="${not empty roupas}">
			<h4>Quantidade de roupas existentes: ${roupas.size()}!!!</h4>
			
			<hr>
	
			<table class="table table-striped">
		    <thead>
		      <tr>
		      	<th>Id</th>
		        <th>Descrição</th>
		        <th>Valor</th>
		        <th>Tipo de Roupa</th>
		        <th>cor</th>
		        <th>tecido</th>
		        <th>tamanho</th>
		        <th>Infantil</th>
		        <th></th>
		      </tr>
		    </thead>
		    <tbody>		    
		    	<c:forEach var="r" items="${roupas}">
			      <tr>
			        <td>${r.id}</td>
			        <td>${r.descricao}</td>
			        <td>${r.valor}</td>
			        <td>${r.tipoDeRoupa}</td>
			        <td>${r.cor}</td>
			        <td>${r.tecido}</td>
			        <td>${r.tamanho}</td>
			        <td>${r.infantil}</td>
			        <td><a href="/roupa/${r.id}/excluir">Excluir</a></td>
			      </tr>
		    	</c:forEach>
		    </tbody>
		  	</table>
	  	</c:if>
	  	
	  	<c:if test="${empty roupas}">
			<h4>Não existem roupas cadastradas!!!</h4>	  	
	  	</c:if>
	</div>
</body>
</html>