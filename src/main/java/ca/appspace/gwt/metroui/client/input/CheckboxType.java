package ca.appspace.gwt.metroui.client.input;

import ca.appspace.gwt.metroui.client.HtmlValueEnum;

public enum CheckboxType implements HtmlValueEnum {

	CHECKBOX("checkbox"), 
	SWITCH("switch");
	private final String _htmlVal;
	private CheckboxType(String val) {
		_htmlVal = val;
	}
	@Override
	public String asHtmlValue() {
		return _htmlVal;
	}

}