<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags"%>

<custom:template title="Cadastrar novo Cargo">
	<jsp:body>
		<h1 class="text-center">Cadastrar novo Cargo</h1>
		
		<form method="post" action="<c:url value='/cargos' />">
			<div class="form-group">
				<label for="nome">Nome</label>
				<input id="nome" name="nome" class="form-control webdriver_campo-nome" required="required" value="${cargoForm.nome}">
			</div>
			
			<div class="form-group">
				<label for="salarioMinimo">Salário Mínimo</label>
				<input id="salarioMinimo" name="salarioMinimo" class="form-control webdriver_campo-salario-minimo" required="required" value="${cargoForm.salarioMinimo}">
			</div>
			
			<div class="form-group">
				<label for="salarioMaximo">Salário Máximo</label>
				<input id="salarioMaximo" name="salarioMaximo" class="form-control webdriver_campo-salario-maximo" required="required" value="${cargoForm.salarioMaximo}">
			</div>
			
			<input type="submit" value="Gravar" class="btn btn-primary webdriver_btn-gravar">
			<a href="<c:url value='/cargos' />" class="btn btn-light">Cancelar</a>
		</form>
	</jsp:body>
</custom:template>