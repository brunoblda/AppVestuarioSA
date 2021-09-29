<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mochila - Cadastro</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">
	  <h2>Cadastro de Mochilas</h2>
	  <form action="/mochila/incluir" method="post">

	    <div class="form-group">
	      <label>Descrição:</label>
	      <input type="text" value="Mochila escolar" class="form-control" placeholder="Entre com a descrição" name="descricao">
	    </div>

	    <div class="form-group">
	      <label>Valor:</label>
	      <input type="text" value="150" class="form-control" placeholder="Entre com o valor" name="valor">
	    </div>
		
	    <div class="form-group">
	      <label>Material:</label>
	      <input type="text" value="Nylon" class="form-control" placeholder="Entre com o material" name="materialMochila">
	    </div>

	    <div class="form-group">
	      <label>Cor:</label>
	      <input type="text" value="Verde" class="form-control" placeholder="Entre com a cor" name="cor">
	    </div>
	    
	    <div class="form-group">
	      <label>Quantidade de Partições::</label>
	      <input type="text" value="5" class="form-control" placeholder="Entre com a quantidade de partições" name="quantidadeDeParticoes">
	    </div>
	    
	    <div class="form-group">
	      <label>Tipo de Atividade:</label>
	      <input type="text" value="Estudante" class="form-control" placeholder="Entre com o tipo de atividade" name="tipoDeAtividade">
	    </div>

	    <button type="submit" class="btn btn-default">Cadastrar</button>
	  </form>
	</div>

</body>
</html>