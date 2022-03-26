<%@ include file="../../templates/taglibs.jsp" %>

<c:if test="${successMessage != null}">
	<div class="successMessage">
		<spring:message code="${successMessage}"/>
	</div>
</c:if>

<c:choose>
	<c:when test="${fn:length(cuentasUsuario) > 0}">
	
		<table>
			<thead>
				<tr>
				    <th>UsuarioID</th>
					<th>NOMBRE</th>
					<th>APELLIDO</th>
					<th>PASSWORD</th>
					<th>EMAIL</th>
					<th>DIRECCION</th>
					<th>TELEFONO</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="usuario" items="${cuentasUsuario}">
					<tr>
						
						<td><c:out value="${usuario.usuarioId}"/></td>
						<td><c:out value="${usuario.nombre}"/></td>
						<td><c:out value="${usuario.apellido}"/></td>
						<td><c:out value="${usuario.password}"/></td>
						<td><c:out value="${usuario.email}"/></td>
						<td><c:out value="${usuario.direccion}"/></td>
						<td><c:out value="(+34) ${usuario.telefono}"/></td>
						
					</tr>
				</c:forEach>
			</tbody>
	
	</table>
	</c:when>
	<c:otherwise>
		<spring:message code="listaVacia"/>
	</c:otherwise>
</c:choose>


