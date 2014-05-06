package ca.appspace.gwt.metroui.client;

import ca.appspace.gwt.metroui.client.input.Calendar;
import ca.appspace.gwt.metroui.client.navigation.NavBar;
import ca.appspace.gwt.metroui.client.navigation.TabControl;

import com.google.gwt.dom.client.Element;

public class MetroUI {

	public static native void initAll() /*-{
		$wnd.$.Metro.initAll();
	}-*/;

	public static void init(Calendar widget) {
		initCalendar(widget.getElement().getParentElement());
	}
	
	public static void init(TabControl widget) {
		initTabControl(widget.getElement().getParentElement());
	}
	
	public static void init(NavBar navBar) {
		initNavBar(navBar.getElement().getParentElement());
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
	
}
