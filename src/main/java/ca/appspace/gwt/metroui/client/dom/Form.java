package ca.appspace.gwt.metroui.client.dom;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBoxBase;
import com.google.gwt.user.client.ui.Widget;

public class Form extends ComplexPanel {

	private final static String TAG_NAME = "form";
	private final static String FS_TAG_NAME = "fieldset";
	private final static String LEGEND_TAG_NAME = "legend";
	private final static String LABEL_TAG_NAME = "label";

	private final Element _rootElement;
	private FieldSet _currentFieldset;

	public Form() {
		_rootElement = Document.get().createElement(TAG_NAME);
		_rootElement.setAttribute("action", "#");
		setElement(_rootElement);
	}

	public FieldSet startFieldset(String title) {
		if (_currentFieldset!=null) {
			this.add(_currentFieldset, _rootElement);
		}
		_currentFieldset = new FieldSet(title);
		return _currentFieldset;
	}
	
	public void endFieldset() {
		if (_currentFieldset!=null) {
			this.add(_currentFieldset, _rootElement);
		}
		_currentFieldset = null;
	}

	public void addField(String label, TextBoxBase textBox) {
		Element labelElem = Document.get().createElement(LABEL_TAG_NAME);
		labelElem.setInnerHTML(label);
		if (_currentFieldset==null) {
			_rootElement.appendChild(labelElem);
		} else {
			_currentFieldset.getElement().appendChild(labelElem);
		}
		HTMLPanel panel = new HTMLPanel("");
		if (textBox instanceof PasswordTextBox) {
			panel.setStyleName("input-control password");
		} else {
			panel.setStyleName("input-control text");
		}
		panel.getElement().setAttribute("data-role", "input-control");
		panel.add(textBox);
		
		Button clearBtn = new Button();
		clearBtn.setStyleName("btn-clear");
		clearBtn.setTabIndex(-1);
		panel.add(clearBtn);
		
		if (_currentFieldset==null) {
			add(panel, _rootElement);
		} else {
			_currentFieldset.add(panel);
		}
	}

	class FieldSet extends ComplexPanel {

		private final Element _fsElement;
		
		private FieldSet(String title) {
			_fsElement = Document.get().createElement(FS_TAG_NAME);
			setElement(_fsElement);
			if (title!=null) {
				Element legend = Document.get().createElement(LEGEND_TAG_NAME);
				legend.setInnerHTML(title);
				_fsElement.appendChild(legend);
			}
		}

		@Override
		public void add(Widget child) {
			this.add(child, _fsElement);
		}
		
	}
}
