package ca.appspace.gwt.metroui.client.navigation;

import ca.appspace.gwt.metroui.client.MetroUI;
import ca.appspace.gwt.metroui.client.dom.ClickableListItem;
import ca.appspace.gwt.metroui.client.dom.UnorderedListElement;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public class TabControl extends HTMLPanel {
	
	private static final String MAIN_STYLE_CLASS = "tab-control";
	private static final String TAB_PANEL_STYLE_CLASS = "tabs";
	private static final String FRAMES_PANEL_STYLE_CLASS = "frames";
	private static final String FRAME_STYLE_NAME = "frame";
	private static final String ACTIVE_CLASS = "active";
	private static final String EFFECT_ATTR_NAME = "data-effect";

	private final UnorderedListElement _tabPanel;
	private final HTMLPanel _framesPanel;
	
	public TabControl() {
		this(null);
	}
	
	public TabControl(Effect effect) {
		super("");
		Element styleElement = getElement();
		styleElement.setClassName(MAIN_STYLE_CLASS);
		styleElement.setAttribute("data-role", "tab-control");
		if (effect!=null) {
			styleElement.setAttribute(EFFECT_ATTR_NAME, effect.asHtmlVal());
		}
		_tabPanel = new UnorderedListElement();
		_tabPanel.setStyleName(TAB_PANEL_STYLE_CLASS);
		add(_tabPanel);
		
		_framesPanel = new HTMLPanel("");
		_framesPanel.setStyleName(FRAMES_PANEL_STYLE_CLASS);
		add(_framesPanel);
		
		this.addAttachHandler(new AttachEvent.Handler() {
			@Override
			public void onAttachOrDetach(AttachEvent event) {
				if (event.isAttached()) {
					MetroUI.init(TabControl.this);
				}
			}
		});
	}
	
	public int addPanel(String tabName, Widget tabContent, final TabActivatedHandler handler) {
		final int myIndex = _framesPanel.getWidgetCount() + 1;
		ClickableListItem tabHeader = new ClickableListItem(tabName);
		tabHeader.setHref("#_page_"+myIndex);
		tabHeader.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (handler!=null) handler.onTabActivated(myIndex);
			}
		});
		if (myIndex==1) {
			tabHeader.setStyleName(ACTIVE_CLASS);
		}
		_tabPanel.add(tabHeader);

		ComplexPanel tabWrapper = null;
		tabWrapper = new HTMLPanel("");
		tabWrapper.getElement().setId("_page_"+myIndex);
		tabWrapper.add(tabContent);
		tabWrapper.addStyleName(FRAME_STYLE_NAME);
		_framesPanel.add(tabWrapper);
		
		if (TabControl.this.isAttached()) {	//If the tab control is already in DOM, reinitialize
			GWT.log("Tab added to TabControl after it has already been attached to DOM. Currently, this does not work well");
		}
		
		return myIndex;
	}

	public static interface TabActivatedHandler {
		void onTabActivated(int myIndex);	
	}
	
	public static enum Effect {
		SLIDE("slide"),
		FADE("fade");
		
		private final String _htmlVal;
		
		private Effect(String val) {
			_htmlVal = val;
		}
		
		public  String asHtmlVal() {
			return _htmlVal;
		}
	}
}
