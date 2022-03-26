<%@ include file="../../../templates/taglibs.jsp" %>
<script src='<spring:url value="/estatico/lib/validate/jquery.validate.js"/>'></script>
<script src='<spring:url value="/estatico/javascript/validate/jquery.validate.extension.js"/>'></script>
<script src='<spring:url value="/estatico/lib/validate/additional-methods.js"/>'></script>
<script src='<spring:url value="/estatico/javascript/validate/localization/messages_es.js"/>'></script>

<form:form action="" method="POST" modelAttribute="cuentaWizard">

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
		<legend><spring:message code="informacionPerfil"/></legend>
		<ol>
			<li>
				<label for="email">
					<spring:message code="cuenta.email"/><em>*</em>
				</label>
				<form:input path="email" cssErrorClass="error"/>
				<form:errors path="email" cssClass="errorTooltip"/>
			</li>
			<li>
				<label for="fcreacion">
					<spring:message code="cuenta.fcreacion"/><em>*</em>
				</label>
				<form:input path="fcreacion" placeholder="dd/mm/yyyy" cssErrorClass="error"/>
				<form:errors path="fcreacion" cssClass="errorTooltip"/>
			</li>
		</ol>
	</fieldset>
	
	<spring:url value="/cuentas/new/datosUsuario" var="url" />
	<a href="${url}">
		<spring:message code="anterior" />
	</a>
	<form:button><spring:message code="CrearCuenta"/></form:button>			

</form:form>
