<%@ include file="../../templates/taglibs.jsp" %>

<c:if test="${successMessage != null}">
	<div class="successMessage">
		<spring:message code="${successMessage}"/>
	</div>
</c:if>

<c:choose>
	<c:when test="${fn:length(cuentaList) > 0}">
	
		<table summary='<spring:message code="listadoCuentasDec"/>.' id="tablaCuentas">
			<caption><spring:message code="listadoCuentas"/></caption>
			<thead>
				<tr>
					<th><spring:message code="usuario"/></th>
					<th><spring:message code="cuenta.nombre"/></th>
					<th><spring:message code="cuenta.apellido"/></th>
					<th><spring:message code="cuenta.telefono"/></th>
					<th><spring:message code="cuenta.fcreacion"/></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="cuenta" items="${cuentaList}">
					<tr>
						<td>
							<spring:url var="url" value="/cuentas/${cuenta.idUsuario}"/>
							<a href="${url}">
								<c:out value="${cuenta.idUsuario}"/>
							</a>
						</td>
						<td><c:out value="${cuenta.nombre}"/></td>
						<td><c:out value="${cuenta.apellido}"/></td>
						<td><c:out value="(+34) ${cuenta.telefono}"/></td>
						<td>
							<spring:message code="format.date.short" var="format"/>
							<fmt:formatDate value="${cuenta.fcreacion}" pattern="${format}"/>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<div class="paginacion">
			<c:if test="${!cuentasPaginacionHandler.primeraPagina}">
				<spring:url var="url" value="/cuentas">
					<spring:param name="page" value="${cuentasPaginacionHandler.cursorDePagina - 1}"/>
				</spring:url>
				<a href="${url}">
					<spring:message code="previo"/>
				</a>
			</c:if>
			<span class="paginacionIndice">
				<c:out value="${cuentasPaginacionHandler.cursorDePagina}"/>
			</span>
			<c:if test="${!cuentasPaginacionHandler.ultimaPagina}">
				<spring:url var="url" value="/cuentas">
					<spring:param name="page" value="${cuentasPaginacionHandler.cursorDePagina + 1}"/>
				</spring:url>
				<a href="${url}">
					<spring:message code="siguiente"/>
				</a>
			</c:if>
		</div>
	
	</c:when>
	<c:otherwise>
		<spring:message code="listaVacia"/>
	</c:otherwise>
</c:choose>

<h3><spring:message code="Acciones"/></h3>
<ul>
	<li>
		<spring:url var="url" value="/cuentas/pdf"/>
		<a href="${url}">
			<spring:message code="DescargaPdf"/>
		</a>
	</li>
	<li>
		<spring:url var="url" value="/api/cuentas"/>
		<a href="${url}">
			<spring:message code="DescargaXml"/>
		</a>
	</li>
</ul>
