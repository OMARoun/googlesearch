package ma.omaroun.snippet.google.search;

/**
 * @author aboufaris
 *
 */
public class GoogleSearchItem {

	private String title;
	private String url;

	public GoogleSearchItem(String title, String url) {
		this.title = title;
		this.url = url;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		return title + System.getProperty("line.separator") + "::::::::" + url;
	}

}
