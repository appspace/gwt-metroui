package ca.appspace.gwt.metroui.client.dom;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.user.client.ui.Anchor;

public class ClickableListItem extends ListItemElement {
	
	private Anchor _anchor;
	
	public ClickableListItem(String text) {
		_anchor = new Anchor(text);
		_anchor.setHref("javascript:;");
		_anchor.setTabIndex(-1);
		add(_anchor);
	}

	public ClickableListItem(SafeHtml safeHtml) {
		_anchor = new Anchor(safeHtml);
		_anchor.setHref("javascript:;");
		_anchor.setTabIndex(-1);
		add(_anchor);
	}

	
	public void addClickHandler(ClickHandler clickHandler) {
		_anchor.addClickHandler(clickHandler);
	}

	@Override
	public void setText(String text) {
		_anchor.setText(text == null ? "" : text); 
	}

	public void setHref(String href) {
		_anchor.setHref(href);
	}
}
