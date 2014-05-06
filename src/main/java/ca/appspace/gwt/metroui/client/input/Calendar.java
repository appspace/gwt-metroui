package ca.appspace.gwt.metroui.client.input;

import java.util.Date;

import ca.appspace.gwt.metroui.client.MetroUI;

import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasValue;

public class Calendar extends HTMLPanel implements HasValue<Date> {

	private Element _rootElement;

	public Calendar(String html) {
		super(html);
		_rootElement = getElement();
		_rootElement.setClassName("calendar");
		_rootElement.setAttribute("data-role", "calendar");
		addAttachHandler(new AttachEvent.Handler() {
			@Override
			public void onAttachOrDetach(AttachEvent event) {
				if (event.isAttached()) {
					MetroUI.init(Calendar.this);
				}
			}
		});
	}
	
	public Calendar() {
		this("");
	}

	@Override
	public HandlerRegistration addValueChangeHandler(
			ValueChangeHandler<Date> handler) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValue(Date value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValue(Date value, boolean fireEvents) {
		// TODO Auto-generated method stub
		
	}

}
