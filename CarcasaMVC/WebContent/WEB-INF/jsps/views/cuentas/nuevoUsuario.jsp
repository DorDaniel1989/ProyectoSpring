<%@ include file="../../templates/taglibs.jsp" %>
<script src='<spring:url value="/estatico/lib/validate/jquery.validate.js"/>'></script>
<script src='<spring:url value="/estatico/javascript/validate/jquery.validate.extension.js"/>'></script>
<script src='<spring:url value="/estatico/lib/validate/additional-methods.js"/>'></script>
<script src='<spring:url value="/estatico/javascript/validate/localization/messages_es.js"/>'></script>

<form:form action="" method="POST" modelAttribute="usuario">

	
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
	

	<fieldset>
		<legend><spring:message code="datosUsuario"/></legend>
		<ol>
			<li>
				<label for="usuario.usuarioId">
					<spring:message code="usuario.usuarioId"/><em>*</em>
				</label>
				<form:input path="usuarioId" cssErrorClass="error"/>
				<form:errors path="usuarioId" cssClass="errorTooltip"/>
			</li>
			<li>
				<label for="usuario.password">
					<spring:message code="usuario.password"/><em>*</em>
				</label>
				<form:password path="password" cssErrorClass="error"/>
				<form:errors path="password" cssClass="errorTooltip"/>
			</li>
			
		</ol>
	</fieldset>

	<fieldset>
		<legend><spring:message code="informacionCuenta"/></legend>
		<ol>
			<li>
				<label for="nombre">
					<spring:message code="usuario.nombre"/><em>*</em>
				</label>
				<form:input path="nombre" cssErrorClass="error"/>
				<form:errors path="nombre" cssClass="errorTooltip"/>
			</li>
			<li>
				<label for="apellido">
					<spring:message code="usuario.apellido"/><em>*</em>
				</label>
				<form:input path="apellido" cssErrorClass="error"/>
				<form:errors path="apellido" cssClass="errorTooltip"/>
			</li>
			<li>
				<label for="email">
					<spring:message code="usuario.email"/><em>*</em>
				</label>
				<form:input path="email" cssErrorClass="error"/>
				<form:errors path="email" cssClass="errorTooltip"/>
			</li>
			<li>
				<label for="usuario.telefono">
					<spring:message code="usuario.telefono"/><em>*</em>
				</label>
				<form:input path="telefono" placeholder="987654321" cssErrorClass="error"/>
				<form:errors path="telefono" cssClass="errorTooltip"/>
			</li>
			
			<li>
				<label for="usuario.direccion">
					<spring:message code="usuario.direccion"/><em>*</em>
				</label>
				<form:input path="direccion" placeholder="987654321" cssErrorClass="error"/>
				<form:errors path="direccion" cssClass="errorTooltip"/>
			</li>
			
		</ol>
	</fieldset>

	
	<form:button><spring:message code="CrearCuenta"/></form:button>			

</form:form>
