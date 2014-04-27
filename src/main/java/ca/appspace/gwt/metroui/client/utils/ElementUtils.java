package ca.appspace.gwt.metroui.client.utils;

import com.google.gwt.user.client.ui.TextBoxBase;

public class ElementUtils {

	public static TextBoxBase setPlaceholder(TextBoxBase element, String value) {
		element.getElement().setAttribute("placeholder", value);
		return element;
	}
}
