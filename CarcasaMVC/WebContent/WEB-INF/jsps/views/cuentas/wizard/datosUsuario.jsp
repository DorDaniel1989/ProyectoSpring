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
		<legend><spring:message code="datosUsuario"/></legend>
		<ol>
			<li>
				<label for="idUsuario">
					<spring:message code="cuenta.idUsuario"/><em>*</em>
				</label>
				<form:input path="idUsuario" cssErrorClass="error"/>
				<form:errors path="idUsuario" cssClass="errorTooltip"/>
			</li>
			<li>
				<label for="password">
					<spring:message code="cuenta.password"/><em>*</em>
				</label>
				<form:password path="password" cssErrorClass="error"/>
				<form:errors path="password" cssClass="errorTooltip"/>
			</li>
		</ol>
	</fieldset>

	<spring:url value="/cuentas/new/informacionCuenta" var="url" />
	<a href="${url}">
		<spring:message code="anterior" />
	</a>
	<form:button><spring:message code="siguiente"/></form:button>			

</form:form>
