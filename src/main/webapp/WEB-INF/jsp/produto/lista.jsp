<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Produtos</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">

		<c:if test="${not empty msg}">
			<div class="alert alert-warning">
			   ${msg}
			</div>
		</c:if>

		<c:if test="${not empty produtos}">
			<h4>Quantidade de produtos existentes: ${produtos.size()}!!!</h4>
			
			<hr>
	
			<table class="table table-striped">
		    <thead>
		      <tr>
		      	<th>Id</th>
		        <th>Descrição</th>
		        <th>Valor</th>
		        <th>Valor Promocional</th>
		        <th></th>
		      </tr>
		    </thead>
		    <tbody>		    
		    	<c:forEach var="p" items="${produtos}">
			      <tr>
			        <td>${p.id}</td>
			        <td>${p.descricao}</td>
			        <td>${p.valor}</td>
			        <td>${p.calcularValorPromocional()}</td>		        
			        <td><a href="/produto/${p.id}/excluir">Excluir</a></td>
			      </tr>
		    	</c:forEach>
		    </tbody>
		  	</table>
	  	</c:if>
	  	
	  	<c:if test="${empty produtos}">
			<h4>Não existem produtos cadastrados!!!</h4>	  	
	  	</c:if>
	</div>
</body>
</html>