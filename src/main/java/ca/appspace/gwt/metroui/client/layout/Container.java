package ca.appspace.gwt.metroui.client.layout;

import ca.appspace.gwt.metroui.client.styles.GlobalStyle;
import ca.appspace.gwt.metroui.client.styles.StyleFormatter;
import ca.appspace.gwt.metroui.client.styles.StyledElement;

import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.HTMLPanel;

public class Container extends HTMLPanel implements StyledElement {

	private Element _rootElement;

	public Container() {
		super("");
		_rootElement = super.getStyleElement();
		_rootElement.addClassName("container");
	}

	@Override
	public void setStyle(GlobalStyle style) {
		if (style!=null) {
			_rootElement.addClassName(StyleFormatter.getHTMLValue(style));
		}
	}
	
}