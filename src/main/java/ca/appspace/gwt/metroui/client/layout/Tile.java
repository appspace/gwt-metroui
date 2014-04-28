package ca.appspace.gwt.metroui.client.layout;

import ca.appspace.gwt.metroui.client.styles.GlobalStyle;
import ca.appspace.gwt.metroui.client.styles.StyleFormatter;
import ca.appspace.gwt.metroui.client.styles.StyledElement;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.HTMLPanel;

public class Tile extends HTMLPanel implements StyledElement {

	private final Element _styleElement;
	private final static String SELECTED_STYLE_NAME = "selected";
	private HTMLPanel _contentPanel;
	
	public Tile(TileSize size, GlobalStyle style) {
		this(size);
		setStyle(style);
		_contentPanel = new HTMLPanel("");
		_contentPanel.setStyleName("tile-content");
		add(_contentPanel);
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
	
	public Tile setSelected(boolean selected) {
		if (selected) {
			_styleElement.addClassName(SELECTED_STYLE_NAME);
		} else {
			_styleElement.removeClassName(SELECTED_STYLE_NAME);
		}
		return this;
	}
	
}