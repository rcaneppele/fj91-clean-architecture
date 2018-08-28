<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags"%>

<custom:template title="Funcionários cadastradas">
	<jsp:body>
		<h1 class="text-center">Funcionários cadastrados</h1>
		
		<a href="<c:url value='/funcionarios/form' />" class="btn btn-primary">Novo</a>
		
		<div class="table-responsive mt-2">
			<table class="table table-stripped table-hover">
				<thead>
					<tr>
						<th>ID</th>
						<th>NOME</th>
						<th>CARGO</th>
						<th>SALÁRIO</th>
						<th>ADMITIDO EM</th>
						<th>AÇÕES</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${listaDeFuncionariosViewModel.funcionarios}" var="funcionario">
						<tr>
							<td>
								<c:out value="${funcionario.id}"/>
							</td>
							
							<td>
								<c:out value="${funcionario.nome}"/>
							</td>
							
							<td>
								<c:out value="${funcionario.cargo.nome}"/>
							</td>
							
							<td>
								<fmt:formatNumber type="currency" value="${funcionario.salario}"/>
							</td>
							
							<td>
								<fmt:parseDate value="${funcionario.dataDeAdmissao}" pattern="yyyy-MM-dd" var="parse" />
								<fmt:formatDate value="${parse}" pattern="dd/MM/yyyy" var="formatada" />
								<c:out value="${formatada}"/>
							</td>
							
							<td>
								<a class="btn btn-info" href="<c:url value="/funcionarios/${funcionario.id}/reajustes"/>">Reajustes</a>
								
								<form class="d-inline" method="post" action="<c:url value='/funcionarios' />">
									<input type="hidden" name="_method" value="DELETE">
									<input type="hidden" name="id" value="${funcionario.id}">
									
									<button type="submit" class="btn btn-danger">Remover</button>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</jsp:body>
</custom:template>
