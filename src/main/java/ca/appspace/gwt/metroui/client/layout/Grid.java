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
		row.setGrid(this);
		Grid.this.add(row);
		return row;
	}
	
	public Grid addRow(Row row) {
		row.setGrid(Grid.this);
		Grid.this.add(row);
		return Grid.this;
	}
	
}
