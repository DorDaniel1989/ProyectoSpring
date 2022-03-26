<%@ include file="../taglibs.jsp" %>

<div id="sidebar">
	<ul>
		<li>
			<h2><spring:message code="Pruebas" /></h2>
			<p><spring:message code="GuiaRapidaFrameworkIZFE" />. <spring:message code="Pruebas" />.</p>
		</li>
		<li>
			<h2><spring:message code="Menu"/></h2>
			<ul>
				<li>
					<spring:url var="url" value="/pruebas/rest-tempalte-timeout"/>
					<a href="${url}">
						<spring:message code="RestTample.timeout"/>
					</a>
				</li>
				<li>
					<spring:url var="url" value="/pruebas/rest-tempalte-externa"/>
					<a href="${url}">
						<spring:message code="RestTample.externa"/>
					</a>
				</li>
				<li>
					<spring:url var="url" value="/pruebas/rest-tempalte-interna"/>
					<a href="${url}">
						<spring:message code="RestTample.interna"/>
					</a>
				</li>
				<li>
					<spring:url var="url" value="/pruebas/rest-template-ssl"/>
					<a href="${url}">
						<spring:message code="RestTample.ssl"/>
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