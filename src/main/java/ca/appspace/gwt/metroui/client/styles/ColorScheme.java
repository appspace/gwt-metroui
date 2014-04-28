package ca.appspace.gwt.metroui.client.styles;

public enum ColorScheme {
	BLACK("black"),
	WHITE("white"), 
	LIME("lime"), 
	GREEN("green"), 
	EMERALD("emerald"), 
	TEAL("teal"),
	CYAN("cyan"), 
	COBALT("cobalt"),
	INDIGO("indigo"), 
	VIOLET("violet"),
	PINK("pink"),
	MAGENTA("magenta"),
	CRIMSON("crimson"),
	RED("red"),
	ORANGE("orange"), 
	AMBER("amber"),
	DARK("dark"), 
	TRANSPARENT("transparent");
	
	private final String _htmlValue;

	private ColorScheme(String val) {
		_htmlValue = val;
	}
	
	public String asHtmlValue() {
		return _htmlValue;
	}
}
