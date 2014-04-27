package ca.appspace.gwt.metroui.client.dom;

import ca.appspace.gwt.metroui.client.styles.GlobalStyle;
import ca.appspace.gwt.metroui.client.styles.StyleFormatter;
import ca.appspace.gwt.metroui.client.styles.StyledElement;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.Widget;

public class NavElement extends ComplexPanel implements StyledElement {
	
	private final static String TAG_NAME = "nav";

	protected final Element _rootElement;
	
	public NavElement() {
		_rootElement = Document.get().createElement(TAG_NAME);
		setElement(_rootElement);
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
