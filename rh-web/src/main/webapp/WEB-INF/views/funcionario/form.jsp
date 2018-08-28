<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags"%>

<custom:template title="Admissão de Funcionário">
	<jsp:body>
		<h1 class="text-center">Admissão de Funcionário</h1>
		
		<form method="post" action="<c:url value='/funcionarios' />">
			<div class="form-group">
				<label for="nome">Nome</label>
				<input id="nome" name="nome" class="form-control" required="required" value="${funcionarioForm.nome}">
			</div>
			
			<div class="form-group">
				<label for="cargo">Cargo</label>
				<select id="cargo" name="idCargo" class="form-control" required="required">
					<c:forEach items="${cargos}" var="cargo">
						<option value="${cargo.id}" ${cargo.id eq funcionarioForm.idCargo ? 'selected' : ''}>${cargo.nome}</option>
					</c:forEach>
				</select>
			</div>
			
			<div class="form-group">
				<label for="salario">Salário</label>
				<input id="salario" name="salario" class="form-control" required="required" value="${funcionarioForm.salario}">
			</div>
			
			<div class="form-group">
				<label for="dataDeAdmissao">Data de Admissão</label>
				<input id="dataDeAdmissao" name="dataDeAdmissao" class="form-control" required="required" value="${funcionarioForm.dataDeAdmissao}">
			</div>
			
			<input type="submit" value="Gravar" class="btn btn-primary">
			<a href="<c:url value='/funcionarios' />" class="btn btn-light">Cancelar</a>
		</form>
	</jsp:body>
</custom:template>