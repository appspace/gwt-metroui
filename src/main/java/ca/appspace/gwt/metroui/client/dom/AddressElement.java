package ca.appspace.gwt.metroui.client.dom;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.InlineHTML;

public class AddressElement extends ComplexPanel {

	private final static String TAG_NAME = "address";

	private final Element _rootElement;
	
	public AddressElement() {
		_rootElement = Document.get().createElement(TAG_NAME);
		setElement(_rootElement);
	}

	public void addText(String text) {
		add(new InlineHTML(new SafeHtmlBuilder().appendEscaped(text).appendHtmlConstant("<br/>").toSafeHtml()), _rootElement);
	}

	public void addTextStrong(String text) {
		add(new InlineHTML(new SafeHtmlBuilder()
			.appendHtmlConstant("<strong>")
			.appendEscaped(text)
			.appendHtmlConstant("</strong>")
			.appendHtmlConstant("<br/>").toSafeHtml())
		, _rootElement);
		
	}
}
