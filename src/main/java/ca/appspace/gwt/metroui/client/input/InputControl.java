package ca.appspace.gwt.metroui.client.input;

import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TextBoxBase;

public class InputControl extends HTMLPanel {

	public InputControl(TextBoxBase base, IconButton btn) {
		super("");
		getStyleElement().addClassName("input-control text");
		add(base);
		add(btn);
	}

}
