<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags"%>

<custom:template title="Cargos cadastradas">
	<jsp:body>
		<h1 class="text-center">Cargos cadastrados</h1>
		
		<a href="<c:url value='/cargos/form' />" class="btn btn-primary webdriver_btn-novo">Novo</a>
		
		<div class="table-responsive mt-2">
			<table class="table table-stripped table-hover">
				<thead>
					<tr>
						<th>ID</th>
						<th>NOME</th>
						<th>SALÁRIO MÍNIMO</th>
						<th>SALÁRIO MÁXIMO</th>
						<th>AÇÕES</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach items="${listaDeCargosViewModel.cargos}" var="cargo">
						<tr>
							<td>
								<c:out value="${cargo.id}"/>
							</td>
							
							<td>
								<c:out value="${cargo.nome}"/>
							</td>
							
							<td>
								<fmt:formatNumber type="currency" value="${cargo.salarioMinimo}"/>
							</td>
							
							<td>
								<fmt:formatNumber type="currency" value="${cargo.salarioMaximo}"/>
							</td>
							
							<td>
								<form method="post" action="<c:url value='/cargos' />">
									<input type="hidden" name="_method" value="DELETE">
									<input type="hidden" name="id" value="${cargo.id}">
									
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
