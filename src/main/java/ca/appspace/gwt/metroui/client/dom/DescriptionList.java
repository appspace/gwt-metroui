package ca.appspace.gwt.metroui.client.dom;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.ComplexPanel;

public class DescriptionList extends ComplexPanel {
	
	private final static String ROOT_TAG_NAME = "dl";
	private final static String TERM_TAG_NAME = "dt";
	private final static String DESCRIPTION_TAG_NAME = "dd";
	private final static String CLASS_NAME = "horizontal";

	private final Element _rootElement;
	
	public DescriptionList() {
		this(false);
	}
	
	public DescriptionList(boolean horizontal) {
		_rootElement = Document.get().createElement(ROOT_TAG_NAME);
		if (horizontal) {
			_rootElement.setClassName(CLASS_NAME);
		}
		setElement(_rootElement);
	}
	
	public void addTerm(String term, String description) {
		Element termElem = Document.get().createElement(TERM_TAG_NAME);
		termElem.setInnerHTML(term);
		_rootElement.appendChild(termElem);

		Element descrElem = Document.get().createElement(DESCRIPTION_TAG_NAME);
		descrElem.setInnerHTML(description);
		_rootElement.appendChild(descrElem);
	}
}
