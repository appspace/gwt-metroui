package ca.appspace.gwt.metroui.client.styles;

import ca.appspace.gwt.metroui.client.HtmlValueEnum;

public enum StyleType implements HtmlValueEnum {

	BACKGROUND("bg"), 
	FOREGROUND("fg"), 
	OUTLINE("ol"), 
	BORDER("bd");
	
	private final String _htmlValue;

	private StyleType(String val) {
		_htmlValue = val;
	}
	@Override
	public String asHtmlValue() {
		return _htmlValue;
	}
}
