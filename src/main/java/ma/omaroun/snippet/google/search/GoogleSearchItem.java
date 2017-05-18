package ma.omaroun.snippet.google.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aboufaris
 *
 */
public class GoogleSearchItem {

	private String title;
	private String resume;
	private String url;
	private List<String> occurences;
	private GoogleSearchResult result;
	private Boolean exacteOccurence = false;

	public GoogleSearchItem(GoogleSearchResult result, String url, String title, String resume) {
		this.title = title;
		this.url = url;
		this.resume = resume;
		this.result = result;
		fetchOccurences();
	}
	
	public Boolean hasOccurenceExacte() {
		return exacteOccurence;
	}

	/**
	 * @return the occurences
	 */
	public List<String> getOccurences() {
		return occurences;
	}

	private void fetchOccurences() {
		String query = result.getQuery().replaceAll("\"", "").toLowerCase();
		occurences = new ArrayList<String>();
		for (String occurence : resume.toLowerCase().replaceAll("[\"/]", " ").split(" ")) {
			if (occurence.contains(query)) {
				occurences.add(occurence);
				if (occurence.equals(query))
					exacteOccurence = true;
			}			
		}
	}

	public void addOccurence(String occurence) {
		occurences.add(occurence);
	}

	/**
	 * @return the resume
	 */
	public String getResume() {
		return resume;
	}

	/**
	 * @param resume
	 *            the resume to set
	 */
	public void setResume(String resume) {
		this.resume = resume;
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
		StringBuilder builder = new StringBuilder("Title : " + title + System.getProperty("line.separator") + "URL : "
				+ url + System.getProperty("line.separator") + "Resume : " + resume
				+ System.getProperty("line.separator") + "Occurences (" + occurences.size() + ") : ");

		for (String occurence : occurences) {
			builder.append(occurence + "; ");
		}
		
		builder.append(System.getProperty("line.separator") + "Has occurence exacte : " + hasOccurenceExacte());

		return builder.toString();
	}

}
