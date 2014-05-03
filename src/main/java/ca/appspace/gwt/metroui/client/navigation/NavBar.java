package ca.appspace.gwt.metroui.client.navigation;

import ca.appspace.gwt.metroui.client.MetroUI;
import ca.appspace.gwt.metroui.client.dom.NavElement;
import ca.appspace.gwt.metroui.client.input.InputControl;
import ca.appspace.gwt.metroui.client.styles.GlobalStyle;
import ca.appspace.gwt.metroui.client.styles.Icon;

import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineHTML;
import com.google.gwt.user.client.ui.Widget;

/**
 * navbar element
 * @see <a href='http://metroui.org.ua/navbar.html'>Navbar Widget</link> 
 * at MetroUI website 
 * @author eugene
 *
 */
public class NavBar extends NavElement {

	private static final String MAIN_CLASS_NAME = "navigation-bar";
	private static final String CONTENT_CLASS_NAME = "navigation-bar-content container";
	private static final String DIVIDER_CLASS_NAME = "element-divider";
	private static final String ELEMENT_STYLE_NAME = "element";
	
	private NavElement _content;
	
	public NavBar() {
		super();
		_rootElement.addClassName(MAIN_CLASS_NAME);
		_content = new NavElement();
		_content.setStyleName(CONTENT_CLASS_NAME);
		super.add(_content);
		this.addAttachHandler(new AttachEvent.Handler() {
			@Override
			public void onAttachOrDetach(AttachEvent event) {
				MetroUI.init(NavBar.this);
			}
		});
	}

	public NavBar(GlobalStyle style) {
		this();
		setStyle(style);
	}

	public NavBar(GlobalStyle style, SafeHtml title) {
		this(style);
		Anchor titleHref = new Anchor(title);
		titleHref.setStyleName("element");
		_content.add(titleHref);
	}
	
	public NavBar(GlobalStyle style, Icon icon, SafeHtml title) {
		this(style);
		Anchor titleHref = new Anchor(title);
		titleHref.getElement().setInnerSafeHtml(
				new SafeHtmlBuilder().appendHtmlConstant("<span class='"+icon.asHtmlValue()+"'>")
					.appendHtmlConstant("</span>")
					.appendHtmlConstant("&nbsp;")
					.append(title)
					.toSafeHtml());
		titleHref.setStyleName(ELEMENT_STYLE_NAME);
		_content.add(titleHref);
	}
	
	public void add(Widget item, Position pos) {
		if (Position.RIGHT==pos) {
			item.addStyleName("place-right");
		}
		if (item instanceof NavBarMenu) {
			addMenuItem((NavBarMenu)item);
		} else if (item instanceof InputControl) {
			addInput((InputControl)item);
		} else {
			_content.add(item);
		}
	}

	private void addInput(InputControl item) {
		HTMLPanel panel = new HTMLPanel("");
		panel.setStyleName(ELEMENT_STYLE_NAME);
		panel.add(item);
		_content.add(panel);
	}

	private void addMenuItem(NavBarMenu item) {
		_content.add(item);
	}

	@Override
	public void add(Widget item) {
		this.add(item, Position.DEFAULT);
	}

	public void addDivider() {
		InlineHTML divider = new InlineHTML();
		divider.setStyleName(DIVIDER_CLASS_NAME);
		_content.add(divider);
	}
}