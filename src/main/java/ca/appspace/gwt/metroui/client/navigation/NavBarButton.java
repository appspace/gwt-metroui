package ca.appspace.gwt.metroui.client.navigation;

import com.google.gwt.user.client.ui.Anchor;

public class NavBarButton extends Anchor {

	public NavBarButton(String iconClass) {
		setStyleName("element brand");
		setHTML("<span class='"+iconClass+"'></span>");
		setHref("#");
	}
	
}
