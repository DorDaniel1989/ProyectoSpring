(function($,undefined) {
	/**
	 * Inicializamos el objeto donde se guardaran los mensajes
	 */
	jQuery.validator.labeledMessages = {};
	/**
	 * Hace una copia de un array javascript sin modificar el original
	 */
	function cloneArray(array){
		var newObj = [];
		for (i in array) {
			if (i == 'clone') continue;
		    if (array[i] && typeof array[i] == "object") {
		    	newObj[i] = array[i].clone();
		    }else{
		    	newObj[i] = array[i];
		    } 
		}
		return newObj;
	}
	
	/**
	 * Partiendo de un elemento Html obtiene el texto de su label.
	 * Este texto se usar‡ para generar el texto de error.
	 */
	$.validator.prototype.getLabelText = function (element){
		
		var labelValue;
		var labelElem;
		
		if(this.checkable(element)){
			labelElem = $("label[for='" + element.name + "']:not([generated], .error)").clone();
			$(labelElem).children().remove();
			var labelValue = $(labelElem).text();
		}else{
			labelElem = $("label[for='" + element.id + "']:not([generated], .error)").clone();
			$(labelElem).children().remove();
			var labelValue = $(labelElem).text();
		}
		if(labelValue===null || labelValue===''){
			labelValue = 'NO LABEL';
		}
		if(labelValue.indexOf(':') > 0){
			labelValue = labelValue.substring(0, labelValue.indexOf(':'));
		}
		labelValue = jQuery.trim(labelValue)/*.toLowerCase()*/;
		return labelValue;
	};
	
	$.validator.prototype.elements = function() {
			var validator = this,
			rulesCache = {};
	
		// select all valid inputs inside the form (no submit or reset buttons)
		return $(this.currentForm)
		.find("input, select, textarea")
		.not(":submit, :reset, :image, [disabled]")
		.not( this.settings.ignore + ":not(:file)" )
		.filter(function() {
			!this.name && validator.settings.debug && window.console && console.error( "%o has no name assigned", this);
	
			// select only the first element for each name, and only those with rules specified
			if ( this.name in rulesCache || !validator.objectLength($(this).rules()) )
				return false;
	
			rulesCache[this.name] = true;
			return true;
		});
	},
	
	
	/**
	 * Obtiene el mensaje para el elemento y metodo del los mensajes con label
	 */
	$.validator.prototype.defaultLabeledMessage = function(element, method) {
		return this.findDefined(
				this.customMessage( element.name, method ),
				this.customMetaMessage( element, method ),
				// title is never undefined, so handle empty string as undefined
				!this.settings.ignoreTitle && element.title || undefined,
				$.validator.labeledMessages[method],
				"<strong>Warning: No message defined for " + element.name + "</strong>"
			);
	};
	
	$.validator.prototype.oldFormatAndAdd = $.validator.prototype.formatAndAdd;
	$.validator.prototype.formatAndAdd = function( element, rule ) {
		var inbox = this.settings.errorLabelContainer.length > 0;
		if(!inbox) {
			return this.oldFormatAndAdd(element, rule);
		}
		var message = this.defaultLabeledMessage( element, rule.method),
			labelValue = this.getLabelText(element);
			theregex = /\$?\{(\d+)\}/g;
		
		if ( typeof message == "function" ) {
			var params = null;
			if ( rule.parameters.constructor === Array ) {
				params = cloneArray(rule.parameters);
				params.unshift(labelValue);
			}else{
				params = [labelValue, rule.parameters];
			}
			message = message.call(this, params, element);
		} else if (theregex.test(message)) {
			message = jQuery.format(labeledMessage.replace(theregex, '{$1}'), rule.parameters);
		}
		
		this.errorList.push({
			message: message,
			element: element
		});
	
		this.errorMap[element.name] = message;
		this.submitted[element.name] = message;
	};
	$.fn.oldValidate = $.fn.validate;
	$.extend($.validator.defaults, {
		errorElement: "a",
		wrapper: "li",
		allContainer: null
	});
	
	$.fn.validate = function(options) {
		if(!options) {
			options = {};
		}
		if(!options.errorLabelContainer) {
			var $listadoErrores = $(".listadoErrores");
			if($listadoErrores.length == 0) {
				$listadoErrores = $("<ul id='listadoErrores' class='listadoErrores'></ul>");
				$(this[0]).prepend($listadoErrores);
			}
			options.errorLabelContainer = $listadoErrores;
		}
		this.oldValidate(options);
	};
	
	$.validator.prototype.oldShowLabel = $.validator.prototype.showLabel;
	$.validator.prototype.showLabel = function(element, message) {
		this.oldShowLabel(element, message);
		var label = this.errorsFor( element );
		if(label.length) {
			if(this.settings.tituloErrores) {
				this.settings.tituloErrores.show();
			}
			if(!label.attr("href")) {
				label.attr("href","#"+this.idOrName(element));
				label.click(function() {
					var $element = $(element);
					if($element.is(":hidden")) {
						var elementNameOrId = $element.attr("name") || $element.attr("id");
						var $focusedElement = $("[name='"+elementNameOrId+"_selector']") 
						$focusedElement.focus();
					} else {
						$element.focus();
					}
					return false;
				});
			}
		}
	};
	
	$.validator.prototype.oldDefaultShowErrors = $.validator.prototype.defaultShowErrors;
	$.validator.prototype.defaultShowErrors = function() {
		this.oldDefaultShowErrors();
		
	};
	
	$.validator.prototype.oldInit = $.validator.prototype.init;
	$.validator.prototype.init = function() {
		this.oldInit();
		var $listadoErrores = this.settings.errorLabelContainer;
		var $tituloErrores = $("p.tituloErrores");
		if($tituloErrores.length == 0) {
			$tituloErrores = $("<p class='tituloErrores'><a href='#tituloErrores' name='tituloErrores' class='negrita'>"+jQuery.validator.messages.tituloErrores+"</a></p>");
			$listadoErrores.before($tituloErrores);
		}
		this.settings.tituloErrores = $tituloErrores;
		$tituloErrores.hide();
		$listadoErrores.hide();
		this.containers = this.containers.add(this.settings.tituloErrores);
	};
	
	$.validator.prototype.focusInvalid = function() {
		var $tituloErroresLink = $("p.tituloErrores a");
		$tituloErroresLink.focus();
	};
	
})(jQuery);
