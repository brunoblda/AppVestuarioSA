<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp" />

	<div class="container">

		<c:if test="${not empty mensagem}">
			<div class="alert alert-danger">
				<strong>Problema!</strong> ${mensagem}
			</div>
		</c:if>

		<h2>Cadastramento de usuários</h2>


		<form action="/usuario" method="post">
			
				
				<div class="form-group col-md-5">
					<label>Nome:</label> <input type="text" value="Teste"
						class="form-control" placeholder="Entre com o seu nome"
						name="nome">
				</div>

				
				<div class="form-group col-md-5">
					<label>E-mail:</label> <input type="email" value="teste@email.com"
						class="form-control" placeholder="Entre com o seu e-mail"
						name="email">
				</div>
				

				
				<div class="form-group col-md-5">
					<label>Senha:</label> <input type="password" value="123"
						class="form-control" placeholder="Entre com a seu senha"
						name="senha">
				</div>
			
			
			<div class="form-group col-md-5">
					<label>Endereço:</label> <input type="text" value="Rua Conceição 70 - Sao Paulo"
						class="form-control" placeholder="Entre com o seu endereço"
						name="endereco">
				</div>

			<div class="form-group">
				<div class="radio">
					<label>O usuário é administrador?</label> 
					<label> </label> 
					<label> <input type="radio" name="admin" checked="checked" value="true">Sim</label> 
					<label> <input type="radio" name="admin" value="false">Não</label>
				</div>
			</div>


			<div class="form-row">
				<div class="form-group col-md-12">
					<button type="submit" class="btn btn-default">Cadastrar</button>
				</div>
			</div>
		</form>

	</div>

</body>
</html>