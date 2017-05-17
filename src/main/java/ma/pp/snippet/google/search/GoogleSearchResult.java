package ma.omaroun.snippet.google.search;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchResult {

	private String query;
	private Integer fetchedResults;
	private Long size;
	private List<GoogleSearchItem> items;

	public GoogleSearchResult() {
		items = new ArrayList<GoogleSearchItem>();
	}

	/**
	 * @return the size
	 */
	public Long getSize() {
		return size;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public void setSize(Long size) {
		this.size = size;
	}

	/**
	 * @return the query
	 */
	public String getQuery() {
		return query;
	}

	/**
	 * @param query
	 *            the query to set
	 */
	public void setQuery(String query) {
		this.query = query;
	}

	/**
	 * @return the fetchedResults
	 */
	public Integer getFetchedResults() {
		return fetchedResults;
	}

	/**
	 * @param fetchedResults
	 *            the fetchedResults to set
	 */
	public void setFetchedResults(Integer fetchedResults) {
		this.fetchedResults = fetchedResults;
	}

	/**
	 * @return the items
	 */
	public List<GoogleSearchItem> getItems() {
		return items;
	}

	/**
	 * @param items
	 *            the items to set
	 */
	public void setItems(List<GoogleSearchItem> items) {
		this.items = items;
	}

	public void addItem(GoogleSearchItem item) {
		items.add(item);
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		builder.append("query : " + query + System.getProperty("line.separator"));
		builder.append("wanted fetched results : " + fetchedResults + System.getProperty("line.separator"));
		builder.append("fetched results : " + items.size() + System.getProperty("line.separator"));
		builder.append("results size : " + size + System.getProperty("line.separator"));
		for (GoogleSearchItem item : items) {
			builder.append(item.toString() + System.getProperty("line.separator"));
		}

		return builder.toString();
	}

}
