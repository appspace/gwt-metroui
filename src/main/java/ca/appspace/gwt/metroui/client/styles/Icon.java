package ca.appspace.gwt.metroui.client.styles;

public enum Icon {

	GRID_VIEW("icon-grid-view");
	
	private final String _htmlValue;

	private Icon(String val) {
		_htmlValue = val;
	}
	
	public String asHtmlValue() {
		return _htmlValue;
	}
}
