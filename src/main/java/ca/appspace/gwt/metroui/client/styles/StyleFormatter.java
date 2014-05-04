package ca.appspace.gwt.metroui.client.styles;

public class StyleFormatter {

	public static String getHTMLValue(GlobalStyle style) {
		StringBuilder sb = new StringBuilder();
		if (style.getType()==null) {
			sb.append(style.getScheme().asHtmlValue());
		} else {
			sb.append(style.getType().asHtmlValue()+"-"+style.getScheme().asHtmlValue());
		}
		return sb.toString();
	}
}
