<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Roupa - Cadastro</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">
	  <h2>Cadastro de Roupas</h2>
	  <form action="/roupa/incluir" method="post">

	    <div class="form-group">
	      <label>Descrição:</label>
	      <input type="text" value="Bermuda de Praia" class="form-control" placeholder="Entre com a descrição" name="descricao">
	    </div>

	    <div class="form-group">
	      <label>Valor:</label>
	      <input type="text" value="75" class="form-control" placeholder="Entre com o valor" name="valor">
	    </div>
		
	    <div class="form-group">
	      <label>Tipo de Roupa:</label>
	      <input type="text" value="Bermuda" class="form-control" placeholder="Entre com o material" name="tipoDeRoupa">
	    </div>

	    <div class="form-group">
	      <label>Cor:</label>
	      <input type="text" value="Azul" class="form-control" placeholder="Entre com a cor" name="cor">
	    </div>
	    
	    <div class="form-group">
	      <label>Tecido:</label>
	      <input type="text" value="Algodão" class="form-control" placeholder="Entre com a cor" name="tecido">
	    </div>
	    
	      <div class="form-group">
	      <label>Tamanho:</label>
	      <input type="text" value="M" class="form-control" placeholder="Entre com a cor" name="tamanho">
	    </div>
	    

	    <div class="form-group">
	      <label>Infantil:</label>
			<label class="checkbox-inline"><input type="checkbox" name="infantil" checked></label>
	    </div>

	    <button type="submit" class="btn btn-default">Cadastrar</button>
	  </form>
	</div>

</body>
</html>