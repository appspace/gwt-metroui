package ca.appspace.gwt.metroui.client.layout;

public enum TileSize {
	HALF("half"), 
	DEFAULT("default"), 
	DOUBLE("double"), 
	TRIPLE("triple"), 
	QUADRO("quadro");
	
	private final String _htmlValue;

	private TileSize(String val) {
		_htmlValue = val;
	}
	
	public String asHtmlValue() {
		return _htmlValue;
	}
}
