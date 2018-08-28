<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand-lg navbar-light navbar-light bg-light">
	<a class="navbar-brand" href="<c:url value="/"/>">RH</a>
	
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div id="navbarNavDropdown" class="navbar-collapse collapse">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item">
				<a class="nav-link" href="<c:url value="/cargos" />">Cargos</a>
			</li>
			
			<li class="nav-item">
				<a class="nav-link" href="<c:url value="/funcionarios" />">Funcionários</a>
			</li>
		</ul>
	</div>
</nav>
