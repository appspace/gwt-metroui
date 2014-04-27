package ca.appspace.gwt.metroui.client.navigation;

import ca.appspace.gwt.metroui.client.styles.Icon;

import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public class NavBarMenu extends HTMLPanel {

	private static final String TOGGLE_STYLE_NAME = "dropdown-toggle";
	private static final String STYLE_NAME = "element";

	private Anchor _toggle;

	public NavBarMenu(String title) {
		super("");
		setStyleName(STYLE_NAME);
		_toggle = new Anchor(title);
		_toggle.setStyleName(TOGGLE_STYLE_NAME);
		add(_toggle);
		
		add(new HTML("<ul class='dropdown-menu' data-role='dropdown'>"
				+ "<li><a href='#'>Main</a></li>"
				+ "<li><a href='#'>File Open</a></li>"
				+ "<li class='divider'></li>"
				+ "<li><a href='#'>Print...</a></li>"
				+ "<li class='divider'></li>"
				+ "<li><a href='#'>Exit</a></li>"
				+ "</ul>"));
	}

	public NavBarMenu(Icon icon, String title) {
		this(new HTML("<span class='"+icon.asHtmlValue()+"'></span>"+title));
	}
	
	private NavBarMenu(Widget widget) {
		super("");
		
		
		
	}
}
