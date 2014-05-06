package ca.appspace.gwt.metroui.client;

import ca.appspace.gwt.metroui.client.input.Calendar;
import ca.appspace.gwt.metroui.client.navigation.NavBar;
import ca.appspace.gwt.metroui.client.navigation.TabControl;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

public class MetroUI {

	public static void prepareHTML() {
		RootPanel body = RootPanel.get();
		if (body==null) {
			Window.alert("Please include <body> element in html");
			return;
		}
		if (!body.getElement().hasClassName("metro")) {
			GWT.log("Adding class='metro' annotation to <body> element");
			body.addStyleName("metro");
		}
	}

	public static void init(Calendar widget) {
		try {
			initCalendar(widget.getElement().getParentElement());
		} catch (Exception e) {
			GWT.log("Unable to initialize Calendar. Are you sure /js/metro.min.js is included in your HTML?", e);
		}
	}
	
	public static void init(TabControl widget) {
		try {
			initTabControl(widget.getElement().getParentElement());
		} catch (Exception e) {
			GWT.log("Unable to initialize Calendar. Are you sure /js/metro.min.js is included in your HTML?", e);
		}
	}
	
	public static void init(NavBar navBar) {
		try {
			initNavBar(navBar.getElement().getParentElement());
		} catch (Exception e) {
			GWT.log("Unable to initialize NavBar. Are you sure /js/metro.min.js is included in your HTML?", e);
		}
	}
	
	private static native void initTabControl(Element elem) /*-{
		$wnd.$.Metro.initTabs(elem);
	}-*/;

	private static native void initNavBar(Element elem) /*-{
		$wnd.$.Metro.initDropdowns(elem);
	}-*/;

	private static native void initCalendar(Element elem) /*-{
		$wnd.$.Metro.initCalendars(elem);
	}-*/;
	public static native void initAll() /*-{
		$wnd.$.Metro.initAll();
	}-*/;
}
