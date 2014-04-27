package ca.appspace.gwt.metroui.client.layout;

import ca.appspace.gwt.metroui.client.styles.GlobalStyle;
import ca.appspace.gwt.metroui.client.styles.StyleFormatter;
import ca.appspace.gwt.metroui.client.styles.StyledElement;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.Widget;

public class Header extends ComplexPanel implements StyledElement {

	private final static String TAG_NAME = "header";
	private final Element _rootElement;

	public Header() {
		_rootElement = Document.get().createElement(TAG_NAME);
		setElement(_rootElement);
	}

	public Header(GlobalStyle style) {
		this();
		setStyle(style);
	}
	
	@Override
	public void setStyle(GlobalStyle style) {
		if (style!=null) {
			_rootElement.addClassName(StyleFormatter.getHTMLValue(style));
		}
	}
	
	public void add(Widget child) {
		add(child, _rootElement);
	}

}