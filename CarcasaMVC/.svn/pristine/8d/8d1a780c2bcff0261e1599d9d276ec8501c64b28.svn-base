<%@ include file="../../templates/taglibs.jsp" %>
<script src='<spring:url value="/estatico/lib/validate/jquery.validate.js"/>'></script>
<script src='<spring:url value="/estatico/javascript/validate/jquery.validate.extension.js"/>'></script>
<script src='<spring:url value="/estatico/lib/validate/additional-methods.js"/>'></script>
<script src='<spring:url value="/estatico/javascript/validate/localization/messages_es.js"/>'></script>

<form:form action="" method="POST" modelAttribute="cuentaForm">

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
				<label for="cuenta.idUsuario">
					<spring:message code="cuenta.idUsuario"/><em>*</em>
				</label>
				<form:input path="cuenta.idUsuario" cssErrorClass="error"/>
				<form:errors path="cuenta.idUsuario" cssClass="errorTooltip"/>
			</li>
			<li>
				<label for="cuenta.password">
					<spring:message code="cuenta.password"/><em>*</em>
				</label>
				<form:password path="cuenta.password" cssErrorClass="error"/>
				<form:errors path="cuenta.password" cssClass="errorTooltip"/>
			</li>
			<li>
				<label for="repetirPassword">
					<spring:message code="repetirPassword"/><em>*</em>
				</label>
				<form:password path="repetirPassword" cssErrorClass="error"/>
				<form:errors path="repetirPassword" cssClass="errorTooltip"/>
			</li>
		</ol>
	</fieldset>

	<fieldset>
		<legend><spring:message code="informacionCuenta"/></legend>
		<ol>
			<li>
				<label for="cuenta.nombre">
					<spring:message code="cuenta.nombre"/><em>*</em>
				</label>
				<form:input path="cuenta.nombre" cssErrorClass="error"/>
				<form:errors path="cuenta.nombre" cssClass="errorTooltip"/>
			</li>
			<li>
				<label for="cuenta.apellido">
					<spring:message code="cuenta.apellido"/><em>*</em>
				</label>
				<form:input path="cuenta.apellido" cssErrorClass="error"/>
				<form:errors path="cuenta.apellido" cssClass="errorTooltip"/>
			</li>
			<li>
				<label for="cuenta.email">
					<spring:message code="cuenta.email"/><em>*</em>
				</label>
				<form:input path="cuenta.email" cssErrorClass="error"/>
				<form:errors path="cuenta.email" cssClass="errorTooltip"/>
			</li>
			<li>
				<label for="cuenta.telefono">
					<spring:message code="cuenta.telefono"/><em>*</em>
				</label>
				<form:input path="cuenta.telefono" placeholder="987654321" cssErrorClass="error"/>
				<form:errors path="cuenta.telefono" cssClass="errorTooltip"/>
			</li>
			<li>
				<label for="cuenta.fcreacion">
					<spring:message code="cuenta.fcreacion"/><em>*</em>
				</label>
				<form:input path="cuenta.fcreacion" placeholder="dd/mm/yyyy" cssErrorClass="error"/>
				<form:errors path="cuenta.fcreacion" cssClass="errorTooltip"/>
			</li>
		</ol>
	</fieldset>
	
	<fieldset>
		<legend><spring:message code="informacionPerfil"/></legend>
		<ol>
			<li>
				<label for="idioma">
					<spring:message code="idioma"/><em>*</em>
				</label>
				<form:select path="cuenta.perfil.idioma" id="idioma" cssErrorClass="error">
					<c:forEach var="idioma" items="${idiomas}">
						<form:option value="${idioma}" label="${idioma}" />
					</c:forEach>
				</form:select>
			</li>
		</ol>
	</fieldset>
	
	<form:button><spring:message code="CrearCuenta"/></form:button>			

</form:form>
