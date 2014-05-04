package ca.appspace.gwt.metroui.client.input;


import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.dom.client.LabelElement;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.dom.client.Text;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasName;
import com.google.gwt.user.client.ui.HasValue;

public class CheckBox extends HTMLPanel implements HasName, HasValue<Boolean> {
	
	private final Text _labelTextElement;
	private final InputElement _inputElement;
	
	public CheckBox() {
		this(CheckboxType.CHECKBOX);
	}
	
	public CheckBox(CheckboxType type) {
		super("");
		setType(type);
		getElement().setAttribute("data-role", "input-control");
		
		LabelElement labelElem = Document.get().createLabelElement();
		_inputElement = Document.get().createCheckInputElement();
		labelElem.appendChild(_inputElement);
		
		SpanElement spanElem = Document.get().createSpanElement();
		spanElem.setClassName("check");
		labelElem.appendChild(spanElem);

		_labelTextElement = Document.get().createTextNode("");
		labelElem.appendChild(_labelTextElement);
		getElement().appendChild(labelElem);
	}

	public CheckBox(String label) {
		this(CheckboxType.CHECKBOX);
		setText(label);
	}

	public CheckBox setType(CheckboxType type) {
		setStyleName("input-control "+type.asHtmlValue());
		return this;
	}
	
	@Override
	public void setName(String name) {
		this.setName(name);
	}

	@Override
	public String getName() {
		return this.getName();
	}

	@Override
	public HandlerRegistration addValueChangeHandler(final ValueChangeHandler<Boolean> handler) {
		return super.addDomHandler(new ClickHandler() {
			private Boolean oldValue = null;
			@Override
			public void onClick(ClickEvent event) {
				Boolean newValue = getValue();
				if (oldValue!=null && !oldValue.equals(newValue)) {
					handler.onValueChange(new CheckboxValueChangeEvent(getValue()));
				}
				oldValue = newValue;
			}
		}, ClickEvent.getType());
	}

	@Override
	public Boolean getValue() {
		if (!isAttached()) {
			return false;
		}
		return _inputElement.isChecked();
	}

	@Override
	public void setValue(Boolean value) {
		setValue(value, false);
	}

	@Override
	public void setValue(Boolean value, boolean fireEvents) {
		if (value == null) {
			value = Boolean.FALSE;
		}

		Boolean oldValue = getValue();
		_inputElement.setChecked(value);
		_inputElement.setDefaultChecked(value);
		if (value.equals(oldValue)) {
			return;
		}
		if (fireEvents) {
			ValueChangeEvent.fire(this, value);
		}
	}

	public void setText(String label) {
		_labelTextElement.setData(label);
	}
	
	private static class CheckboxValueChangeEvent extends ValueChangeEvent<Boolean> {
		protected CheckboxValueChangeEvent(Boolean value) {
			super(value);
		}
	}
}
