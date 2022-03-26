<%@ include file="../taglibs.jsp" %>

<div id="sidebar">
	<ul>
		<li>
			<h2><spring:message code="GestionCuentas" /></h2>
			<p><spring:message code="GuiaRapidaFrameworkIZFE" />. <spring:message code="GestionCuentas" />.</p>
		</li>
		<li>
			<h2><spring:message code="Menu"/></h2>
			<ul>
				
				<li>
					<spring:url var="url" value="/cuentas2"/>
					<a href="${url}">
						<spring:message code="listadoUsuarios"/>
					</a>
				</li>
				<li>
					<spring:url var="url" value="/cuentas/new" />
					<a href="${url}">
						<spring:message code="registrar" />
					</a>
				</li>
				<li>
					<spring:url var="url" value="/cuentas2/newUsuario" />
					<a href="${url}">
						<spring:message code="registrarUsuario" />
					</a>
				</li>
				<li>
					<spring:url var="url" value="/cuentas/new/init" />
					<a href="${url}">
						<spring:message code="registrar.wizard" />
					</a>
				</li>
				<li>
					<spring:url var="url" value="/cuentas">
						<spring:param name="locale" value="${springRequestContext.locale == 'eu_ES'? 'es_ES' : 'eu_ES'}"/>
					</spring:url>
					<a href="${url}"> 
						<spring:message code="cambiarLocale" />
					</a>
				</li>
			
				<li>
					<spring:url var="url" value="/ajax/ver">
					</spring:url>
					<a href="${url}"> 
						Ejemplo Ajax
					</a>
				</li>
				<sec:authorize access="isAuthenticated()">
					<li>
						<spring:url var="url" value="/logout" />
						<a href="${url}"> 
							<spring:message code="logout" />
						</a>
					</li>
				</sec:authorize>
			</ul>
		</li>
	</ul>
</div>