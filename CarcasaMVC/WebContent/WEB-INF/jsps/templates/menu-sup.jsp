<%@ include file="taglibs.jsp" %>

<div id="menu">
	<ul>
		<li class='
			<%-- Si en la url de la petici�n aparece inicio.do estamos en el inicio y ponemos el estilo --%>
			<c:if test="${fn:contains(requestScope['javax.servlet.forward.request_uri'], '/inicio')}">
				current_page_item
			</c:if>
		'>
			<spring:url var="url" value="/"/>
			<a href="${url}">
				<spring:message code="Inicio"/>
			</a>
		</li>
		<li class='
			<%-- Si en la url de la petici�n aparece /gestionCuentas/ estamos en el inicio y ponemos el estilo --%>
			<c:if test="${fn:contains(requestScope['javax.servlet.forward.request_uri'], '/cuentas')}">
				current_page_item
			</c:if>
		'>
			<spring:url var="url" value="/cuentas"/>
			<a href="${url}">
				<spring:message code="GestionCuentas"/>
			</a>
		</li>
		<li class='
			<%-- Si en la url de la petici�n aparece /gestionCuentas/ estamos en el inicio y ponemos el estilo --%>
			<c:if test="${fn:contains(requestScope['javax.servlet.forward.request_uri'], '/pruebas')}">
				current_page_item
			</c:if>
		'>
			<spring:url var="url" value="/pruebas"/>
			<a href="${url}">
				<spring:message code="Pruebas"/>
			</a>
		</li>
	</ul>
</div>
<!-- end #menu -->