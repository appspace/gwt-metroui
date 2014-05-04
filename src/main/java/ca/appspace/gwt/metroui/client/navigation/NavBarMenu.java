package ca.appspace.gwt.metroui.client.navigation;

import ca.appspace.gwt.metroui.client.dom.ListItemElement;
import ca.appspace.gwt.metroui.client.dom.UnorderedListElement;

import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public class NavBarMenu extends HTMLPanel {

	private static final String TOGGLE_STYLE_NAME = "dropdown-toggle";
	private static final String STYLE_NAME = "element";
	private static final String UL_STYLE = "dropdown-menu";

	private Anchor _toggle;
	private UnorderedListElement _innerContent;

	public NavBarMenu(String title) {
		super("");
		setStyleName(STYLE_NAME);
		_toggle = new Anchor(title);
		_toggle.setStyleName(TOGGLE_STYLE_NAME);
		add(_toggle);
		
		_innerContent = new UnorderedListElement();
		_innerContent.setStyleName(UL_STYLE);
		_innerContent.getElement().setAttribute("data-role", "dropdown");
		add(_innerContent);
	}

	public NavBarMenu addMenuItem(ListItemElement item) {
		_innerContent.add(item);
		return NavBarMenu.this;
	}
	
	@Override
	public void add(Widget widget) {
		if (widget instanceof ListItemElement) {
			addMenuItem((ListItemElement) widget);
		} else {
			super.add(widget);
		}
	}
	
	public NavBarMenu addDivider() {
		ListItemElement divider = new ListItemElement();
		divider.setStyleName("divider");
		_innerContent.add(divider);
		return NavBarMenu.this;
	}
}
