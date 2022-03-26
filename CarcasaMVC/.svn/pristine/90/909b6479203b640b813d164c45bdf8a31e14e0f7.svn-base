package net.izfe.g240.wfiguiarapida.web.conversores;

import java.beans.PropertyEditorSupport;

public class ConversorPrefijo extends PropertyEditorSupport {

	private String prefijo = "(+34)";

	public ConversorPrefijo() {
		super.setValue("");
	}

	public String getAsText() {
		Integer tel = (Integer) super.getValue();
		if (tel == null) {
			return "";
		}
		return prefijo + tel.toString();
	}

	public void setAsText(String text) {
		if (text == null || text.length() == 0) {
			return;
		}

		try {
			String telValue = text;
	
			if (text.startsWith(prefijo)) {
				telValue = text.substring(this.prefijo.length());
			}
	
			super.setValue(Integer.valueOf(telValue));
		} catch (RuntimeException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}

}
