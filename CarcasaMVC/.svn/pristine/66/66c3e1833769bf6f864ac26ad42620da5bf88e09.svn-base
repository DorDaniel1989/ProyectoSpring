<%@ include file="../../../templates/taglibs.jsp" %>
<script src='<spring:url value="/estatico/lib/validate/jquery.validate.js"/>'></script>
<script src='<spring:url value="/estatico/javascript/validate/jquery.validate.extension.js"/>'></script>
<script src='<spring:url value="/estatico/lib/validate/additional-methods.js"/>'></script>
<script src='<spring:url value="/estatico/javascript/validate/localization/messages_es.js"/>'></script>

<form:form action="${pageContext.request.contextPath}/cuentas/new/informacionCuenta" method="POST" modelAttribute="cuentaWizard">

	<spring:bind path="*">
	<c:if test="${not empty status.errorMessages}">
		<p class="tituloErrores" style="display: block;">
			<a href="#" class="negrita error"><spring:message code="erroresValidacion" /></a>
		</p>
		<ul class="listadoErrores">
 			<c:forEach items="${status.errorMessages}" var="errorMsg">
				<li>
					<a class="error" href="#" style="display: inline;"><c:out value="${errorMsg}" />.</a>
				</li>
			</c:forEach>
		</ul>
	</c:if>
	</spring:bind>

	<fieldset>
		<legend><spring:message code="informacionCuenta"/></legend>
		<ol>
			<li>
				<label for="nombre">
					<spring:message code="cuenta.nombre"/><em>*</em>
				</label>
				<form:input path="nombre" cssErrorClass="error"/>
				<form:errors path="nombre" cssClass="errorTooltip"/>
			</li>
			<li>
				<label for="apellido">
					<spring:message code="cuenta.apellido"/><em>*</em>
				</label>
				<form:input path="apellido" cssErrorClass="error"/>
				<form:errors path="apellido" cssClass="errorTooltip"/>
			</li>
			<li>
				<label for="telefono">
					<spring:message code="cuenta.telefono"/><em>*</em>
				</label>
				<form:input path="telefono" placeholder="987654321" cssErrorClass="error"/>
				<form:errors path="telefono" cssClass="errorTooltip"/>
			</li>
		</ol>
	</fieldset>
	
	<spring:url value="/cuentas" var="url" />
	<a href="${url}">
		<spring:message code="volver" />
	</a>
	<form:button><spring:message code="siguiente"/></form:button>			

</form:form>
