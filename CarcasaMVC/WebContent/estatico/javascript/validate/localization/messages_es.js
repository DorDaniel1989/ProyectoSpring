/*
 * Translated default messages for the jQuery validation plugin.
 * Locale: ES
 */
jQuery.extend(jQuery.validator.messages, {
  tituloErrores: "Hay errores de validación",
  required: "Este campo es obligatorio.",
  remote: "Por favor, rellena este campo.",
  email: "Por favor, escribe una dirección de correo válida",
  url: "Por favor, escribe una URL válida.",
  date: "Por favor, escribe una fecha válida.",
  dateISO: "Por favor, escribe una fecha (ISO) válida.",
  number: "Por favor, escribe un número entero válido.",
  digits: "Por favor, escribe sólo dígitos.",
  creditcard: "Por favor, escribe un número de tarjeta válido.",
  equalTo: "Por favor, escribe el mismo valor de nuevo.",
  accept: "Por favor, escribe un valor con una extensión aceptada.",
  maxlength: jQuery.validator.format("Por favor, no escribas más de {0} caracteres."),
  minlength: jQuery.validator.format("Por favor, no escribas menos de {0} caracteres."),
  rangelength: jQuery.validator.format("Por favor, escribe un valor entre {0} y {1} caracteres."),
  range: jQuery.validator.format("Por favor, escribe un valor entre {0} y {1}."),
  max: jQuery.validator.format("Por favor, escribe un valor menor o igual a {0}."),
  min: jQuery.validator.format("Por favor, escribe un valor mayor o igual a {0}."),
  filesLimit: jQuery.validator.format("Por favor, adjunta un número de archivos menor a {0}"),
  maxFileSize: jQuery.validator.format("Por favor, adjunta un archivo menor a {0} bytes")
});

jQuery.extend(jQuery.validator.labeledMessages, {
  required: jQuery.validator.format("{0} es obligatorio."),
  remote: jQuery.validator.format("Rellene el campo {0}."),
  email: jQuery.validator.format("{0} no contiene una direcci\u00F3n de correo v\u00E1lida."),
  url: jQuery.validator.format("{0} no contiene una URL v\u00E1lida."),
  date: jQuery.validator.format("{0} no contiene una fecha v\u00E1lida."),
  dateISO: jQuery.validator.format("{0} no contiene una fecha (ISO) v\u00E1lida."),
  number: jQuery.validator.format("{0} no contiene un importe v\u00E1lido."),
  digits: jQuery.validator.format("{0} s\u00F3lo puede contener d\u00EDgitos."),
  creditcard: jQuery.validator.format("{0} no contiene un n\u00FAmero de tarjeta v\u00E1lido."),
  equalTo: jQuery.validator.format("{0} no contiene el mismo valor de nuevo."),
  accept: jQuery.validator.format("{0} no contiene un valor con una extensi\u00F3n aceptada."),
  maxlength: jQuery.validator.format("{0} no puede contener m\u00E1s de {1} caracteres."),
  minlength: jQuery.validator.format("{0} no puede contener menos de {1} caracteres."),
  rangelength: jQuery.validator.format("{0} s\u00F3lo puede contener un valor entre {1} y {2} caracteres."),
  range: jQuery.validator.format("{0} s\u00F3lo puede contener un valor entre {1} y {2}."),
  max: jQuery.validator.format("{0} s\u00F3lo puede contener un valor menor o igual a {1}."),
  min: jQuery.validator.format("{0} s\u00F3lo puede contener un valor mayor o igual a {1}."),
  filesLimit: jQuery.validator.format("{0} no puede contener m\u00E1s de {1} archivos."),
  maxFileSize: jQuery.validator.format("{0} no puede contener archivos mayores a {1} bytes.")
});