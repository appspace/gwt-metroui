package ca.appspace.gwt.metroui.client.layout;

import ca.appspace.gwt.metroui.client.styles.GlobalStyle;
import ca.appspace.gwt.metroui.client.styles.StyleFormatter;
import ca.appspace.gwt.metroui.client.styles.StyledElement;

import com.google.gwt.user.client.ui.HTMLPanel;

public class Cell extends HTMLPanel implements StyledElement {

	public Cell(int span) {
		this("");
		setSpan(span);
	}
	
	public Cell() {
		this(1);
	}

	public Cell(String html) {
		super(html);
	}

	public void setSpan(int span) {
		setStyleName("span"+span);
	}

	public void setStyle(GlobalStyle style) {
		setStyleName(StyleFormatter.getHTMLValue(style));
	}

}
