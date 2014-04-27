package ca.appspace.gwt.metroui.client.styles;

public enum StyleType {

	BACKGROUND("bg"), 
	FOREGROUND("fg"), 
	OUTLINE("ol"), 
	BORDER("bd");
	
	private final String _htmlValue;

	private StyleType(String val) {
		_htmlValue = val;
	}
	
	public String asHTMLValue() {
		return _htmlValue;
	}
}
