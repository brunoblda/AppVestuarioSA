<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sapatos - Cadastro</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">
	  <h2>Cadastro de Sapatos</h2>
	  <form action="/sapato/incluir" method="post">

	    <div class="form-group">
	      <label>Descrição:</label>
	      <input type="text" value="Sapato social" class="form-control" placeholder="Entre com a descrição" name="descricao">
	    </div>

	    <div class="form-group">
	      <label>Valor:</label>
	      <input type="text" value="50" class="form-control" placeholder="Entre com o valor" name="valor">
	    </div>
		
	    <div class="form-group">
	      <label>Material:</label>
	      <input type="text" value="Couro" class="form-control" placeholder="Entre com o material" name="materialSapato">
	    </div>

	    <div class="form-group">
	      <label>Cor:</label>
	      <input type="text" value="marrom" class="form-control" placeholder="Entre com a cor" name="cor">
	    </div>
	    
	    <div class="form-group">
	      <label>tamanho:</label>
	      <input type="text" value="43" class="form-control" placeholder="Entre com o tamanho" name="tamanho">
	    </div>

	    <div class="form-group">
	      <label>Ecológico:</label>
			<label class="checkbox-inline"><input type="checkbox" name="ecologico" checked></label>
	    </div>

	    <button type="submit" class="btn btn-default">Cadastrar</button>
	  </form>
	</div>

</body>
</html>