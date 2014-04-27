package ca.appspace.gwt.metroui.client.styles;

public class GlobalStyle {
	
	private final StyleType _type;
	private final ColorScheme _scheme;
	
	public GlobalStyle(StyleType type, ColorScheme scheme) {
		_type = type;
		_scheme = scheme;
	}
	
	public GlobalStyle(ColorScheme scheme) {
		_type = null;
		_scheme = scheme;
	}

	public StyleType getType() {
		return _type;
	}

	public ColorScheme getScheme() {
		return _scheme;
	}

}
