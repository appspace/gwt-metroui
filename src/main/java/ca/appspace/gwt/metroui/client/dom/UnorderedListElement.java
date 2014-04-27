package ca.appspace.gwt.metroui.client.dom;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.Widget;

public class UnorderedListElement extends ComplexPanel {

	private static final String TAG_NAME = "UL";

	public UnorderedListElement() {
		setElement(Document.get().createElement(TAG_NAME));
	}

	public void add(Widget child) {
		add(child, getElement());
	}
}
