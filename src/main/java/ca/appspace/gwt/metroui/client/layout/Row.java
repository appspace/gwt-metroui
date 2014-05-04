package ca.appspace.gwt.metroui.client.layout;

import ca.appspace.gwt.metroui.client.styles.GlobalStyle;
import ca.appspace.gwt.metroui.client.styles.StyleFormatter;
import ca.appspace.gwt.metroui.client.styles.StyledElement;

import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public class Row extends HTMLPanel implements StyledElement {

	private Grid _grid;

	public Row(String html) {
		super(html);
		setStyleName("row");
	}
	
	public Row() {
		this("");
	}
	
	public Row addCell(Widget content, int span) {
		if (span<0) {
			throw new IllegalArgumentException("Weight should be greater then 0");
		}
		Cell cell = new Cell(span);
		cell.add(content);
		Row.this.add(cell);
		return Row.this;
	}

	public Row addCell(Widget content, int span, GlobalStyle style) {
		if (span<0) {
			throw new IllegalArgumentException("Weight should be greater then 0");
		}
		Cell cell = new Cell(span);
		cell.setStyle(style);
		cell.add(content);
		Row.this.add(cell);
		return Row.this;
	}
	
	public Grid endRow() {
		if (_grid!=null) {
			return _grid;
		}
		Widget parent = this.getParent();
		return (Grid) parent;
	}

	@Override
	public void setStyle(GlobalStyle style) {
		getStyleElement().addClassName(StyleFormatter.getHTMLValue(style));
	}

	public void setGrid(Grid grid) {
		_grid = grid;
	}
}
