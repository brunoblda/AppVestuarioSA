<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/">AppVestuarioSA</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/">Home</a></li>
      <c:if test="${not empty user}">
      	  <c:if test="${user.admin}">
      	  
      	  	<li><a href="/solicitante/lista">Solicitante</a></li>
      	  	<li><a href="/usuario/lista">Usuário</a></li>
      	  	<li><a href="/sapato/lista">Sapato</a></li>
      	  	<li><a href="/mochila/lista">Mochila</a></li>
      	  	<li><a href="/roupa/lista">Roupa</a></li>
      	  	<li><a href="/produto/lista">Produto</a></li>
      	  	<li><a href="/pedido/lista">Pedido</a></li>
      	  	
      	  </c:if>
      	  
      	  <c:if test="${not user.admin}">
      	  
      	  	<li><a href="/solicitante/lista">Solicitante</a></li>
      	  	<li><a href="/sapato/lista">Sapato</a></li>
      	  	<li><a href="/mochila/lista">Mochila</a></li>
      	  	<li><a href="/roupa/lista">Roupa</a></li>
      	  	<li><a href="/produto/lista">Produto</a></li>
      	  	<li><a href="/pedido/lista">Pedido</a></li>
      	  </c:if>
      	  
      	  
      </c:if>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <c:if test="${empty user}">
	      <li><a href="/usuario"><span class="glyphicon glyphicon-user"></span> Se Cadastrar</a></li>
	      <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Logar</a></li>
      </c:if>
      <c:if test="${not empty user}">
      	  <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Deslogar, ${user.nome}</a></li>
      </c:if>
    </ul>
  </div>
</nav>