/**
 * 
 */
package ma.omaroun.snippet.google.search;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

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
		return GoogleSearch.GOOGLE_SEARCH_URL + URLEncoder.encode(search, "UTF-8") + "&num=" + fetchedResults;
	}
	
	/**
	 * @param query
	 * @param fetchedResults
	 * @return
	 * @throws IOException 
	 * @throws UnsupportedEncodingException 
	 */
	public static GoogleSearchResult search(String query, Integer fetchedResults) throws UnsupportedEncodingException, IOException {
		
		GoogleSearchResult result = new GoogleSearchResult();
		result.setQuery(query);
		result.setFetchedResults(fetchedResults);

		Document document = Jsoup.connect(composeSearchUrl(query, fetchedResults)).userAgent("PPBot 1.0 (+http://rcar.mar/bot)").get();
		
		result.setSize(Long.parseLong(document.getElementById("resultStats").text().replaceAll("\\D+","")));

		Elements links = document.select(".g>.r>a");

		for (Element link : links) {
		    String title = link.text();
		    String url = link.absUrl("href"); // Google returns URLs in format "http://www.google.com/url?q=<url>&sa=U&ei=<someKey>".
		    url = URLDecoder.decode(url.substring(url.indexOf('=') + 1, url.indexOf('&')), "UTF-8");

		    if (!url.startsWith("http")) {
		        continue; // Ads/news/etc.
		    }
		    
		    result.addItem(new GoogleSearchItem(title, url));
		}

		return result;


	}

}
