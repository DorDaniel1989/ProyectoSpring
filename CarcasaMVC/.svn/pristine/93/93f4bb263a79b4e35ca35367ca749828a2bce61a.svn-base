<%@ include file="taglibs.jsp" %>

<div id="header">
	<div id="logo">
		<h1>
			<spring:url var="url" value="/inicio"/>
			<a href="${url}">
				<spring:message code="Guia"/> <span><spring:message code="rapida"/></span>
			</a>
		</h1>
		<p><spring:message code="AplicacionEjemploIZFE"/></p>
		<sec:authorize access="isAuthenticated()">
			<p><spring:message code="usuario"/>: <sec:authentication property="principal.username"/> </p>
		</sec:authorize>
	</div>
</div>
<!-- end #header -->


