package ca.appspace.gwt.metroui.client.dom;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.ComplexPanel;

public class BreadCrumb extends ComplexPanel {

	private final static String TAG_NAME = "nav";

	private static final String BR_CLASS_NAME = "breadcrumbs";

	private final Element _rootElement;
	private UnorderedListElement _content;

	public BreadCrumb() {
		_rootElement = Document.get().createElement(TAG_NAME);
		_rootElement.setClassName(BR_CLASS_NAME);
		setElement(_rootElement);
		_content = new UnorderedListElement();
		add(_content, _rootElement);
	}

	public BreadCrumb addHomeItem(ClickHandler clickHandler) {
		ClickableListItem item = new ClickableListItem(
				new SafeHtmlBuilder().appendHtmlConstant("<i class='icon-home'>").appendHtmlConstant("</i>").toSafeHtml()
				);
		item.addClickHandler(clickHandler);
		_content.add(item);
		return this;
	}
	
	public BreadCrumb addItem(String text) {
		_content.add(new ClickableListItem(text));
		return this;
	}
	
	public BreadCrumb addItem(String text, ClickHandler clickHandler) {
		ClickableListItem item = new ClickableListItem(text);
		item.addClickHandler(clickHandler);
		_content.add(item);
		return this;
	}
}