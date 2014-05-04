package ca.appspace.gwt.metroui.client.styles;

import ca.appspace.gwt.metroui.client.HtmlValueEnum;

public enum Icon implements HtmlValueEnum {

	GRID_VIEW("icon-grid-view");
	
	private final String _htmlValue;

	private Icon(String val) {
		_htmlValue = val;
	}
	@Override
	public String asHtmlValue() {
		return _htmlValue;
	}
}
