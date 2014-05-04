package ca.appspace.gwt.metroui.client.dom;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class ListItemElement extends ComplexPanel implements HasText {

	private static final String TAG_NAME = "LI";
	private static final String DISABLED_STYLE = "disabled";

	public ListItemElement() {
		setElement(Document.get().createElement(TAG_NAME));
	}
	
	public ListItemElement(String text) {
		this();
		setText(text);
	}
	
	public ListItemElement setDisabled(boolean disabled) {
		if (disabled) {
			addStyleName(DISABLED_STYLE);
		} else {
			removeStyleName(DISABLED_STYLE);
		}
		return this;
	}
	
    public void add(Widget w) {
        super.add(w, getElement());
    }

	@Override
	public String getText() {
		return DOM.getInnerText(getElement()); 
	}

	@Override
	public void setText(String text) {
		DOM.setInnerText(getElement(), (text == null) ? "" : text); 
	}
}
