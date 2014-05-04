package ca.appspace.gwt.metroui.client.input;

import ca.appspace.gwt.metroui.client.HtmlValueEnum;

import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.ButtonBase;

public class PushButton extends ButtonBase {

	private Size _size;
	private Style _style;

	public PushButton() {
		super(Document.get().createPushButtonElement());
	}

	public PushButton(String html) {
		this();
		setHTML(html);
	}
	
	public PushButton(String html, ClickHandler handler) {
		this(html);
		addClickHandler(handler);
	}
	
	public PushButton setSize(Size size) {
		_size = size;
		setStyleName();
		return this;
	}

	public PushButton setStyle(Style style) {
		_style = style;
		setStyleName();
		return this;
	}

	private void setStyleName() {
		StringBuilder sb = new StringBuilder();
		if (_size!=null) {
			sb.append(_size.asHtmlValue());
		}
		
		if (_style!=null) {
			if (sb.length()>0) {
				sb.append(" ");
			}
			sb.append(_style.asHtmlValue());
		}
		setStyleName(sb.toString());
	}


	public static enum Size {
		LARGE("large"), 
		SMALL("small"), 
		MINI("mini");
		
		private final String _htmlValue;
		
		private Size(String value) {
			_htmlValue = value;
		}
		
		public String asHtmlValue() {
			return _htmlValue;
		}
	}
	
	public static enum Style implements HtmlValueEnum {
		DEFAULT("default"), 
		PRIMARY("primary"),
		INFO("info"),
		SUCCESS("success"),
		WARNING("warning"),
		DANGER("danger"),
		INVERSE("inverse"), 
		LINK("link");
	
		private final String _htmlValue;
		
		private Style(String value) {
			_htmlValue = value;
		}
		@Override
		public String asHtmlValue() {
			return _htmlValue;
		}
	}
}