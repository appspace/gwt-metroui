package ca.appspace.gwt.metroui.client.layout;

import ca.appspace.gwt.metroui.client.styles.GlobalStyle;
import ca.appspace.gwt.metroui.client.styles.StyleFormatter;
import ca.appspace.gwt.metroui.client.styles.StyledElement;

import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public class Grid extends HTMLPanel {

	public Grid() {
		super("");
		addStyleName("grid");
		addStyleName("fluid");
	}

	public Row startRow() {
		Row row = new Row();
		return row;
	}
	
	public class Row extends HTMLPanel implements StyledElement {

		private Row() {
			super("");
			setStyleName("row");
		}
		
		public Row addCell(Widget content, int span) {
			if (span<0) {
				throw new IllegalArgumentException("Weight should be greater then 0");
			}
			HTMLPanel cell = new HTMLPanel("");
			cell.setStyleName("span"+span);
			cell.add(content);
			Row.this.add(cell);
			return Row.this;
		}

		public Row addCell(Widget content, int weight, GlobalStyle style) {
			if (weight<0) {
				throw new IllegalArgumentException("Weight should be greater then 0");
			}
			HTMLPanel cell = new HTMLPanel("");
			cell.addStyleName("span"+weight);
			cell.add(content);
			cell.addStyleName(StyleFormatter.getHTMLValue(style));
			Row.this.add(cell);
			return Row.this;
		}
		
		public Grid endRow() {
			Grid.this.add(Row.this);
			return Grid.this;
		}

		@Override
		public void setStyle(GlobalStyle style) {
			getStyleElement().addClassName(StyleFormatter.getHTMLValue(style));
		}
	}
}
