package ca.appspace.gwt.metroui.client;

import ca.appspace.gwt.metroui.client.navigation.TabControl;

import com.google.gwt.dom.client.Element;

public class MetroUI {

	public static native void initAll() /*-{
		$wnd.$.Metro.initAll();
	}-*/;

	public static void initTabControl(TabControl widget) {
		initTabControl(widget.getElement().getParentElement());
	}
	
	private static native void initTabControl(Element elem) /*-{
		$wnd.$.Metro.initTabs(elem);
	}-*/;

}
