<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags"%>

<custom:template title="Reajustes do funcionário">
	<jsp:body>
		<div class="container">
			<h1 class="text-center">Reajustes do funcionário</h1>
			
			<dl class="text-center row">
				<div class="col-sm">
					<dt>Nome</dt>
					<dd>${listaDeReajustesViewModel.funcionario.nome}</dd>
				</div>
				
				<div class="col-sm">
					<dt>Admissão</dt>
					<fmt:parseDate value="${listaDeReajustesViewModel.funcionario.dataDeAdmissao}" pattern="yyyy-MM-dd" var="parse" />
					<fmt:formatDate value="${parse}" pattern="dd/MM/yyyy" var="formatada" />
					<dd>${formatada}</dd>
				</div>
			
				<div class="col-sm">
					<dt>Cargo</dt>
					<dd>${listaDeReajustesViewModel.funcionario.cargo.nome}</dd>
				</div>
			
				<div class="col-sm">
					<dt>Salário</dt>
					<dd>
						<fmt:formatNumber value="${listaDeReajustesViewModel.funcionario.salario}" type="currency" />
					</dd>
				</div>
			</dl>

			<form method="post" action="<c:url value='/funcionarios/${listaDeReajustesViewModel.funcionario.id}/reajustes' />">
				<div class="form-group">
					<label for="motivo">Motivo</label>
					<input id="motivo" name="motivo" class="form-control" required="required" value="${reajusteForm.motivo}">
				</div>
				
				<div class="form-group">
					<label for="valor">Valor</label>
					<input id="valor" name="valor" class="form-control" required="required" value="${reajusteForm.valor}">
				</div>
				
				<div class="form-group">
					<label for="data">Data</label>
					<input id="data" name="data" class="form-control" required="required" value="${reajusteForm.data}">
				</div>
				
				<input type="submit" value="Gravar" class="btn btn-primary">
			</form>

			<div class="table-responsive mt-2">
				<table class="table table-stripped table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>DATA</th>
							<th>VALOR</th>
							<th>MOTIVO</th>
						</tr>
					</thead>
					
					<tbody>
						<c:forEach items="${listaDeReajustesViewModel.reajustes}" var="reajuste">
							<tr>
								<td>
									<c:out value="${reajuste.id}"/>
								</td>
								
								<td>
									<fmt:parseDate value="${reajuste.data}" pattern="yyyy-MM-dd" var="parse" />
									<fmt:formatDate value="${parse}" pattern="dd/MM/yyyy" var="formatada" />
									<c:out value="${formatada}"/>
								</td>
								
								<td>
									<c:out value="${reajuste.valor}"/>
								</td>
								
								<td>
									<c:out value="${reajuste.motivo}"/>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</jsp:body>
</custom:template>
