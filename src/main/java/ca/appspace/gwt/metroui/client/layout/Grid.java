package ca.appspace.gwt.metroui.client.layout;

import com.google.gwt.user.client.ui.HTMLPanel;

public class Grid extends HTMLPanel {

	public Grid() {
		this("");
	}

	public Grid(String html) {
		super(html);
		addStyleName("grid");
		addStyleName("fluid");
	}

	public Row startRow() {
		Row row = new Row();
		return row;
	}
	
	public Grid addRow(Row row) {
		add(row);
		return Grid.this;
	}
	
}
