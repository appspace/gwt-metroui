package ca.appspace.gwt.metroui.client.layout;

import ca.appspace.gwt.metroui.client.styles.GlobalStyle;
import ca.appspace.gwt.metroui.client.styles.StyleFormatter;
import ca.appspace.gwt.metroui.client.styles.StyledElement;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.HTMLPanel;

public class Tile extends HTMLPanel implements StyledElement {

	private final Element _styleElement;

	public Tile(TileSize size, GlobalStyle style) {
		this(size);
		setStyle(style);
	}
	
	public Tile(TileSize size) {
		super("");
		addStyleName("tile");
		addStyleName(size.asHtmlValue());
		_styleElement = getStyleElement();
	}
	
	public Tile() {
		this(TileSize.DEFAULT);
	}

	@Override
	public void setStyle(GlobalStyle style) {
		_styleElement.addClassName(StyleFormatter.getHTMLValue(style));
	}
	
	
}