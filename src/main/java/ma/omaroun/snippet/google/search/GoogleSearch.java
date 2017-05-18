/**
 * 
 */
package ma.omaroun.snippet.google.search;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.StringTokenizer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author aboufaris
 *
 */
public class GoogleSearch {

	private static final String GOOGLE_SEARCH_URL = "https://www.google.com/search?q=";

	private static String composeSearchUrl(String search, Integer fetchedResults) throws UnsupportedEncodingException {
		return GoogleSearch.GOOGLE_SEARCH_URL + search + "&num=" + fetchedResults;
	}

	/**
	 * @param query
	 * @param fetchedResults
	 * @return
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 */
	public static GoogleSearchResult search(String query, Integer fetchedResults)
			throws UnsupportedEncodingException, IOException {
		GoogleSearchResult result = new GoogleSearchResult();
		result.setQuery(query);
		result.setFetchedResults(fetchedResults);

		try {
			
			Document document = Jsoup.connect(composeSearchUrl(query, fetchedResults))
					.userAgent("Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)").get();
	
			StringTokenizer tokenizer = new StringTokenizer(document.getElementById("resultStats").text(), " ");
			tokenizer.nextToken();
			result.setSize(Long.parseLong(tokenizer.nextToken()));
			
			Elements links = document.select(".g");
	
			for (Element link : links) {
	
				try {
	
					String title = link.select(".r>a").text();
					// Google returns URLs in format "http://www.google.com/url?q=<url>&sa=U&ei=<someKey>".
					String url = link.select(".r>a").get(0).absUrl("href");
					url = URLDecoder.decode(url.substring(url.indexOf('=') + 1, url.indexOf('&')), "UTF-8");
	
					String resume = link.select(".s").text();
	
					if (!url.startsWith("http")) {
						continue; // Ads/news/etc.
					}
	
					result.addItem(new GoogleSearchItem(result, url, title, resume));
				} catch (Exception e) {
				}
			}
			
		} catch (NullPointerException e) {
		} catch (IndexOutOfBoundsException e) {
		} catch (NumberFormatException e) {
		}

		return result;

	}

}
