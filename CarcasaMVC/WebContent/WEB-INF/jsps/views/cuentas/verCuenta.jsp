<%@ include file="../../templates/taglibs.jsp" %>

<h3><spring:message code="datosUsuario"/></h3>
<dl class="table-display">
	<dt><spring:message code="cuenta.idUsuario"/></dt>
	<dd><c:out value="${cuenta.idUsuario}"/></dd>
	
	<dt><spring:message code="cuenta.password"/></dt>
	<dd><c:out value="${cuenta.password}"/></dd>
</dl>

<h3><spring:message code="informacionCuenta"/></h3>
<dl class="table-display">
	<dt><spring:message code="cuenta.nombre"/></dt>
	<dd><c:out value="${cuenta.nombre}"/></dd>
	
	<dt><spring:message code="cuenta.apellido"/></dt>
	<dd><c:out value="${cuenta.apellido}"/></dd>
	
	<dt><spring:message code="cuenta.email"/></dt>
	<dd><c:out value="${cuenta.email}"/></dd>
	
	<dt><spring:message code="cuenta.telefono"/></dt>
	<dd><c:out value="${cuenta.telefono}"/></dd>
	
	<dt><spring:message code="cuenta.fcreacion"/></dt>
	<spring:message code="format.date.short" var="format"/>
	<dd><fmt:formatDate value="${cuenta.fcreacion}" pattern="${format}"/></dd>
</dl>

<h3><spring:message code="informacionPerfil"/></h3>
<dl class="table-display">
	<dt><spring:message code="idPerfil"/></dt>
	<dd><c:out value="${cuenta.perfil.idPerfil}"/></dd>
	
	<dt><spring:message code="idioma"/></dt>
	<dd><c:out value="${cuenta.perfil.idioma}"/></dd>
</dl>
