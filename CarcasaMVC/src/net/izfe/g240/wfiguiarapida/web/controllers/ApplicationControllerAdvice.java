package net.izfe.g240.wfiguiarapida.web.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * Contiene la configuración general de conversores y validadores que se aplica a todos los controladores.
 * 
 */
@ControllerAdvice
public class ApplicationControllerAdvice {

	@Autowired
	private MessageSource messageSource;

	@InitBinder
	public void initBinder(WebDataBinder binder, Locale locale) {

		String format = this.messageSource.getMessage("format.date.short", null, locale);
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
